package Laboratorio.Practica_1;

import java.util.Scanner;

/**
 * Clase que hace funcion como controlador
 *
 * @author Omar
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Data data = new Data();
        boolean avaible = false;
        Scanner teclado = new Scanner(System.in);

        // Ciclo indefinido hasta que el usuario desee salir.
        while (true) {
            Interfaz.mostrarMenu();
            int nombre = teclado.nextInt();

            switch (nombre) {
                case 0:
                    System.exit(0);
                    // Crea el pais
                case 1:
                    data.add(Interfaz.crearPais(teclado));
                    avaible = true;
                    break;
                // Muestra la informacion de inicio a fin
                case 2:
                    if (avaible)
                        for (int i = 0; i < data.getSize(); i++)
                            System.out.println("Pais No." + (i + 1) + data.mostrarPais(i));
                    else
                        System.out.println("No existen datos almacenados.");
                    break;
                // Muestra la informacion de fin a inicio
                case 3:
                    if (avaible)
                        for (int i = data.getSize() - 1; i >= 0; i--)
                            System.out.println("Pais No." + (i + 1) + data.mostrarPais(i));
                    else
                        System.out.println("No existen datos almacenados.");
                    break;
                // Muestra la informacion de la mitad al final
                case 4:
                    if (avaible)
                        for (int i = data.getSize() / 2; i < data.getSize(); i++)
                            System.out.println("Pais No." + (i + 1) + data.mostrarPais(i));
                    else
                        System.out.println("No existen datos almacenados.");
                    break;
                // Muestra la informacion de la mitad al principio
                case 5:
                    if (avaible)
                        for (int i = data.getSize() / 2; i >= 0; i--)
                            System.out.println("Pais No." + (i + 1) + data.mostrarPais(i));
                    else
                        System.out.println("No existen datos almacenados.");
                    break;
                // Muestra la informacion de la ciudad basado en una busqueda de texto
                case 6:
                    if (avaible) {
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
                    } else
                        System.out.println("No existen datos almacenados.");
                    break;
                // Si ingresa un digito incorrecto del menu
                default:
                    System.out.println("Ingrese los datos correctos.");
            }
        }
    }

}
