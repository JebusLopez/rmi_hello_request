package rmi_ejemplo;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
public class Cliente {
	private static final String IP = "localhost"; // Puedes cambiar a localhost
	private static final int PUERTO = 1100; //Si cambias aquí el puerto, recuerda cambiarlo en el servidor
	
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry(IP, PUERTO);
        Interfaz interfaz = (Interfaz) registry.lookup("Ejemplo"); //Buscar en el registro...
		String respuesta,nombre="";
		int eleccion;
		do{
                    menu();
                    eleccion = new Scanner(System.in).nextInt();
                    switch(eleccion){
                        case 0:
                            System.out.println("Saliendo...");
                            break;
 
                        case 1:
                            System.out.println("\n¿Cuál es tu nombre?");
                            nombre = new Scanner(System.in).nextLine();
                            respuesta = interfaz.hola(nombre);
                            System.out.println("Respuesta => " + respuesta);
                            System.out.println("Presiona ENTER para continuar\n");
                            break;
                    }
        } while (eleccion != 0);
    }
    public static void menu(){
        System.out.println("0)Salir");
        System.out.println("1)Saludar");
    }
}
