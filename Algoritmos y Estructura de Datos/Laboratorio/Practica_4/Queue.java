package Laboratorio.Practica_4;

public class Queue<T> {

    private Node<T> start = null;
    private Node<T> end = null;

    public void encolar(T data) {
        Node<T> node = new Node<T>();
        node.setInfo(data);
        node.setRef(null);

        if (start == null)
            start = node;
        else
            end.setRef(node);

        end = node;
    }

    public Node<T> desencolar() {
        Node<T> node = start;

        if (start != end) {
            start = start.getRef();
        } else {
            start = null;
            end = null;
        }
        return node;
    }
}
