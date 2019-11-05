package Laboratorio.Practica_4;

/**
 * Clase Nodo para apuntador para una estructura de datos dinamica.
 *
 * @param <T>
 * @author Omar
 */
public class Node<T> {

    private T info;
    private Node<T> ref;

    /**
     * Funcion para obtener la informacion de un objeto.
     * @return Objeto con la informacion.
     */
    public T getInfo() {
        return info;
    }

    /**
     * Funcion para colocar la informacion del objeto.
     * @param info Objeto que sustituira al del nodo.
     */
    public void setInfo(T info) {
        this.info = info;
    }

    /**
     * Funcion para obtener la informacion de la referencia del nodo.
     * @return Regresa la referencia del nodo.
     */
    public Node<T> getRef() {
        return ref;
    }

    /**
     * Funcion para colocar la informacion de la referencia del nodo.
     * @param ref Objeto que sustituira a la referencia del nodo.
     */
    public void setRef(Node<T> ref) {
        this.ref = ref;
    }
}
