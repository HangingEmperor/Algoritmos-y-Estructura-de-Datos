package Laboratorio.Practica_5;

/**
 * Clase que crea un nodo de referencia con su nodo siguiente y su informacion.
 *
 * @param <T> Parametro para recibir cualquier tipo de Objeto.
 * @author Omar Flores Salazar
 */
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
