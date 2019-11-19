package Laboratorio.Practica_5;

public class Test {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.addFirst("Hola");
        linkedList.addFirst("Que tal");
        linkedList.addFinal("Heeey");
        linkedList.addFinal("xd Bro");

        System.out.println(linkedList.getLast());
    }
}
