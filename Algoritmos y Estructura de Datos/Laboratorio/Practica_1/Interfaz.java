package Laboratorio.Practica_1;

import java.util.Scanner;

public class Interfaz {

    public static void mostrarMenu() {
        System.out.println(" --- Menu --- ");
        System.out.println(" 1 .- Añadir ciudad.");
        System.out.println(" 2 .- Mostrar la informacion de inicio a fin.");
        System.out.println(" 3 .- Mostrar la informacion de fin a inicio.");
        System.out.println(" 4 .- Mostrar la informacion a partir de la mitad hasta el final.");
        System.out.println(" 5 .- Mostrar la informacion a partir de la mitad hasta el inicio.");
        System.out.println(" 6 .- Buscar ciudad.");
        System.out.println(" 0 .- Salir.");
    }

    public static Pais crearPais(Scanner teclado) {
        System.out.println("Nombre de la ciudad:");
        String nombreCiudad = teclado.nextLine();
        nombreCiudad = teclado.nextLine();
        System.out.println("Nombre del pais:");
        String nombrePais = teclado.nextLine();
        System.out.println("Nombre del continente:");
        String nombreContinente = teclado.nextLine();
        System.out.println("Latitud en Decimales:");
        float latitudDecimales = teclado.nextFloat();
        System.out.println("Longitud en Decimales:");
        float longitudDecimales = teclado.nextFloat();
        System.out.println("Latitud en Grados, Minutos y Segundos"
                + "\n Ejemplo: Norte 320° 37’ 29.504 '' ");
        String latitudGMS = teclado.nextLine();
        latitudGMS = teclado.nextLine();
        System.out.println("Longitud en Grados, Minutos y Segundos"
                + "\n Ejemplo: Oeste 1150° 26' 53.969 ''");
        String longitudGMS = teclado.nextLine();
        return new Pais(nombrePais, nombreCiudad,
                nombreContinente, latitudDecimales,
                longitudDecimales, latitudGMS,
                longitudGMS);
    }
}
