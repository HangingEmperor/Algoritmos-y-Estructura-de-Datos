package Laboratorio.Practica_1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Data data = new Data();
        Scanner teclado = new Scanner(System.in);

        while (true) {
            Interfaz.mostrarMenu();
            int nombre = teclado.nextInt();

            switch (nombre) {
                case 0:
                    System.exit(0);
                case 1:
                    data.add(Interfaz.crearPais(teclado));
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
}