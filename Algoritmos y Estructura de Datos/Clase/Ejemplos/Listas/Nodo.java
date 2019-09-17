package Clase.Ejemplos.Listas;

public class Nodo<T> {

    private T info;
    private Nodo sig;

    Nodo() {
        info = null;
        sig = null;
    }

    Nodo(Nodo sig, T info) {
        this.sig = sig;
        this.info = info;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public Nodo getSig() {
        return sig;
    }

    public void setSig(Nodo sig) {
        this.sig = sig;
    }
}
