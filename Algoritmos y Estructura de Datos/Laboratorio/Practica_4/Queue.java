package Laboratorio.Practica_4;

/**
 * Clase que hace funcion de cola como en una estructura de datos dinamica.
 *
 * @param <T>
 * @author Omar
 */
public class Queue<T> {

    private Node<T> start = null;
    private Node<T> end = null;
    private int size = 0;

    /**
     * @param data
     */
    public void insert(T data) {
        Node<T> node = new Node<T>();
        node.setInfo(data);
        node.setRef(null);

        if (start == null)
            start = node;
        else
            end.setRef(node);
        size++;
        end = node;
    }

    /**
     * @return
     */
    public Node<T> remove() {
        Node<T> node = start;

        if (start != end) {
            start = start.getRef();
        } else {
            start = null;
            end = null;
        }
        size--;
        return node;
    }

    /**
     * @return
     */
    public Node<T> front() {
        Node<T> datoAuxiliar = null;
        if (start != null) {
            datoAuxiliar = start;
        }
        return datoAuxiliar;
    }

    /**
     * @return
     */
    public int size() {
        return size;
    }
}
