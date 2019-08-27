package Laboratorio.Practica_1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Data data = new Data();
        Scanner teclado = new Scanner(System.in);

        while (true) {
            mostrarMenu();
            int nombre = teclado.nextInt();

            switch (nombre) {
                case 0:
                    System.exit(0);
                case 1:
                    data.add(crearPais(teclado));
                    break;
                case 2:
                    for (int i = 0; i < data.getSize(); i++)
                        System.out.println("Pais No." + (i + 1) + data.mostrarPais(i));
                    break;
                case 3:
                    for (int i = data.getSize() - 1; i >= 0; i--)
                        System.out.println("Pais No." + (i + 1) + data.mostrarPais(i));
                    break;
                case 4:
                    for (int i = data.getSize() / 2; i < data.getSize(); i++)
                        System.out.println("Pais No." + (i + 1) + data.mostrarPais(i));
                    break;
                case 5:
                    for (int i = data.getSize() / 2; i >= 0; i--)
                        System.out.println("Pais No." + (i + 1) + data.mostrarPais(i));
                    break;
                case 6:
                    System.out.println("Ingrese el nombre de la ciudad que desea buscar:");
                    String name = teclado.nextLine();
                    name = teclado.nextLine();

                    for (int i = 0; i < data.getSize(); i++) {
                        if (data.getData().get(i).getCity().toLowerCase().equals(name.toLowerCase())) {
                            System.out.println("Pais No." + (i + 1) + data.mostrarPais(i));
                            break;
                        } else if (i == data.getSize() - 1) {
                            System.out.println("No se encontro.");
                        }
                    }
                    break;
                default:
                    System.out.println("Ingrese los datos correctos.");
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println(" --- Menu --- ");
        System.out.println(" 1 .- Añadir ciudad.");
        System.out.println(" 2 .- Mostrar la informacion de inicio a fin.");
        System.out.println(" 3 .- Mostrar la informacion de fin a inicio.");
        System.out.println(" 4 .- Mostrar la informacion a partir de la mitad hasta el final.");
        System.out.println(" 5 .- Mostrar la informacion a partir de la mitad hasta el inicio.");
        System.out.println(" 6 .- Buscar ciudad.");
        System.out.println(" 0 .- Salir.");
    }

    private static Pais crearPais(Scanner teclado) {
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