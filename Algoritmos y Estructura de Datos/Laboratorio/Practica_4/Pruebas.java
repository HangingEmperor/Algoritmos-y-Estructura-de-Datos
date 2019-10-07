package Laboratorio.Practica_4;

public class Pruebas {

    public static void main(String[] args) {
        Queue<String> queue = new Queue<String>();

        queue.insert("hola");
        queue.insert("como");
        queue.insert("estas");
        queue.insert("xd");

        System.out.println(queue.remove().getInfo());
        System.out.println(queue.remove().getInfo());
        System.out.println(queue.remove().getInfo());
        System.out.println(queue.front().getInfo());
    }
}
