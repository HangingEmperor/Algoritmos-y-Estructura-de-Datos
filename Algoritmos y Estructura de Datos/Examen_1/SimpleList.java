package Examen_1;

public class SimpleList<T> {

    private Node<T> start = null;

    public void insertStart(T data) {
        Node<T> node = new Node<>();
        node.setInfo(data);
        node.setRef(start);
        start = node;
    }

    public Node<T> removeStart() {
        if (start == null) {
            return null;
        }
        start = start.getRef();
        return start;
    }

    public void insertEnd(T data) {
        Node<T> node = new Node<>();
        node.setInfo(data);

        if (start == null) {
            node.setRef(start);
            start = node;
        } else {
            Node<T> aux;
            for (aux = start; aux.getRef() != null; aux = aux.getRef()) ;
            aux.setRef(node);
            node.setRef(null);
        }
    }

    public Node<T> removeEnd() {
        Node<T> aux;
        Node<T> node = new Node<>();

        if (start == null) {
            return null;
        } else {
            if (start.getRef() == null) {
                start = null;
                return null;
            } else {
                aux = start;
                node = aux;
                while (aux.getRef() != null) {
                    aux = node;
                    node = aux.getRef();
                }
            }
        }
        return node;
    }

    public Node<T> remove(T data) {
        Node<T> act = start;
        Node<T> ant = null;

        while (act != null && !act.getInfo().equals(data)) {
            ant = act;
            act = act.getRef();
        }
        if (act != null && ant == null) {
            start = act.getRef();
            return act;
        }
        if (act != null && ant != null) {
            ant.setRef(act.getRef());
            return act;
        }
        return null;
    }

    public Node<T> search(T data) {
        Node<T> aux = start;
        while (aux != null && !aux.getInfo().equals(data)) {
            aux = aux.getRef();
        }
        return aux;
    }

    @Override
    public String toString() {
        return "SimpleList{" +
                "start=" + start +
                '}';
    }
}
