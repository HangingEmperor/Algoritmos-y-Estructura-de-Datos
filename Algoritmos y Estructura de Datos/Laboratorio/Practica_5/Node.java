package Laboratorio.Practica_5;

public class Node<T> {

    private T info;
    private Node sig;

    public Node(T info, Node sig) {
        this.info = info;
        this.sig = sig;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public Node getSig() {
        return sig;
    }

    public void setSig(Node sig) {
        this.sig = sig;
    }
}
