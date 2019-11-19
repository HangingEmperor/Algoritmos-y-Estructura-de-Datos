package Laboratorio.Practica_5;

public class Test {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        //linkedList.addFinal("4");
        linkedList.add("o", 0);
        linkedList.add("m", 1);
        linkedList.add("a", 2);
        linkedList.addFirst("l");
        linkedList.add("r", 3);

        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println(linkedList.get(i));
        }
    }
}
