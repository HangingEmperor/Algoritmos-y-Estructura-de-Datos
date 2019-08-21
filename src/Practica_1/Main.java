package Practica_1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Pais> pais = new ArrayList<Pais>();
        boolean exit = false;
        Scanner teclado = new Scanner(System.in);

        while (!exit) {
            System.out.println(" --- Menu --- ");
            System.out.println(" 1 .- Añadir pais.");
            System.out.println(" 2 .- Mostrar la informacion de inicio a fin.");
            System.out.println(" 3 .- Mostrar la informacion de fin a inicio.");
            System.out.println(" 4 .- Mostrar la informacion a partir de la mitad hasta el final.");
            System.out.println(" 5 .- Mostrar la informacion a partir de la mitad hasta el inicio.");
            System.out.println(" 6 .- Buscar pais.");
            System.out.println(" 0 .- Salir.");
            int nombre = teclado.nextInt();
            //String country, String city, String continent, float latitudeDecimals, float longitudeDecimals, String latitude, String longitude
            switch (nombre) {
                case 0:
                    exit = true;
                    break;
                case 1:
                    System.out.println("Nombre de la ciudad:");
                    String nombreCiudad = teclado.nextLine();
                    //
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
                    Pais newPais = new Pais(nombrePais, nombreCiudad,
                            nombreContinente, latitudDecimales,
                            longitudDecimales, latitudGMS,
                            longitudGMS);
                    pais.add(newPais);
                    break;
                case 2:
                    for (int i = 0; i < pais.size(); i++) {
                        System.out.println("Pais No." + (i + 1));
                        System.out.println(pais.get(i).toString());
                    }
                    break;
                case 3:
                    for (int i = pais.size() - 1; i >= 0; i--) {
                        System.out.println("Pais No." + (i + 1));
                        System.out.println(pais.get(i).toString());
                    }
                    break;
                case 4:
                    for (int i = pais.size() / 2; i < pais.size(); i++) {
                        System.out.println("Pais No." + (i + 1));
                        System.out.println(pais.get(i).toString());
                    }
                    break;
                case 5:
                    for (int i = pais.size() / 2; i >= 0; i--) {
                        System.out.println("Pais No." + (i + 1));
                        System.out.println(pais.get(i).toString());
                    }
                    break;
                case 6:
                    System.out.println("Ingrese el nombre de la ciudad que desea buscar:");
                    String name = teclado.nextLine();
                    name = teclado.nextLine();

                    for (int i = 0; i < pais.size(); i++) {
                        if (pais.get(i).getCity().toLowerCase().equals(name.toLowerCase())) {
                            System.out.println("Pais No. " + (i + 1));
                            System.out.println(pais.get(i).toString());
                            break;
                        } else if (i == pais.size() - 1) {
                            System.out.println("No se encontro.");
                        }
                    }
                    break;
                default:
                    System.out.println("Ingrese los datos correctos.");
            }
        }
    }

}
/*
a. La información debe ser insertada en al ArrayList.
b. Mostrar la información de inicio a fin con que cuenta el ArrayList.
c. Mostrar la información fin a inicio con que cuenta el ArrayList.
d. Mostrar la información a partir de la mitad del ArrayList hasta el final.
e. Mostrar la información a partir de la mitad del ArrayList hasta el inicio.
f. Capturar desde el teclado el nombre de una ciudad y mostrar la información
de ella y si no se encuentra que muestre un msg. Indicándolo.*/