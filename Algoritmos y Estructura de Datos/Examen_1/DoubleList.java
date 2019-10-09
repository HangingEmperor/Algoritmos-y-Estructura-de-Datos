package Examen_1;

public class DoubleList<T> {

    private Node<T> start;

    public void insertStart(T data) {
        Node<T> node = new Node<>();
        node.setInfo(data);
        node.setSig(start);
        node.setAnt(null);

        if (start != null) {
            start.setAnt(node);
        }
        start = node;
    }

    public void insertEnd(T data) {
        Node<T> node = new Node<>();
        node.setInfo(data);
        node.setSig(null);
        if (start == null) {
            node.setAnt(start);
            start = node;
        } else {
            Node<T> r = new Node<>();
            r = start;
            while (r.getSig() != null) {
                r = r.getSig();
            }
            r.setSig(node);
            node.setAnt(r);
        }
    }

    public Node<T> removeStart() {
        if (start == null) {
            return null;
        } else {
            if (start.getSig() == null) {
                start = null;
            } else {
                start = start.getSig();
                start.setAnt(null);
            }
        }
        return start;
    }

    public Node<T> removeEnd() {
        Node<T> r = new Node<>();
        if (start == null) {
            return null;
        } else {
            if (start.getSig() == null) {
                start = null;
            } else {
                while (r.getSig() != null) {
                    r = r.getSig();
                }
                r.setAnt(null);
                return r;
            }
        }

        return r;
    }

    public String recorrer() {
        Node<T> r = new Node<>();
        String aux = "";
        if (start == null) {
            return "lista vacia";
        } else {
            r = start;
            while (r != null) {
                aux += r.getInfo();
                r = r.getSig();
            }
        }
        return aux;
    }

}
