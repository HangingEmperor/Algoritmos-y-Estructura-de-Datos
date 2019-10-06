package Laboratorio.Practica_4;

public class Pruebas {

    public static void main(String[] args) {
        Queue<String> queue = new Queue<String>();
        queue.encolar("hola");
        queue.encolar("que");
        queue.encolar("haces");
        queue.encolar("crack");

        System.out.println(3 % 3);

        System.out.println(queue.desencolar().getInfo());
    }
}
