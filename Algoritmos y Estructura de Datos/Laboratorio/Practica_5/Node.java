package Laboratorio.Practica_5;

class Node<T> {

    private T info;
    private Node<T> sig;

    Node() {
        this.info = null;
        this.sig = null;
    }

    T getInfo() {
        return info;
    }

    void setInfo(T info) {
        this.info = info;
    }

    Node<T> getSig() {
        return sig;
    }

    void setSig(Node<T> sig) {
        this.sig = sig;
    }
}
