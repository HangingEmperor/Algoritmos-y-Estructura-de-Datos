package Laboratorio.Practica_5;

public class LinkedList<T> {

    private Node first;
    private int size;

    /**
     *
     */
    public LinkedList() {
        first = null;
    }

    /**
     * @param data
     */
    public void addFirst(T data) {
        Node n = new Node();
        n.setInfo(data);
        n.setSig(first);
        first = n;
        size++;
    }

    /**
     * @return
     */
    public Node removeStart() {
        Node n;
        if (first == null) {
            return null;
        } else {
            n = first;
            first = first.getSig();
        }
        size--;
        return n;
    }

    /**
     * @param data
     */
    public void addFinal(T data) {
        Node n = new Node();
        n.setInfo(data);

        if (first == null) {
            n.setSig(first);
            first = n;
        } else {
            Node r;
            r = first;
            while (r.getSig() != null) {
                r = r.getSig();
            }
            r.setSig(n);
            n.setSig(null);
        }
        size++;
    }

    /**
     * @return
     */
    public Node removeFinal() {
        Node n;
        Node r = new Node();
        if (first == null) {
            return null;
        } else {
            if (first.getSig() == null) {
                n = first;
                first = null;
                size--;
                return n;
            } else {
                r = first;
            }
            Node a = new Node();
            a = r;
            while (r.getSig() != null) {
                a = r;
                r = r.getSig();
            }
            a.setSig(null);
            n = a;
        }
        size--;
        return n;
    }

    /**
     * @param data
     * @return
     */
    public Node search(T data) {
        Node aux = first;
        while (aux != null && !aux.getInfo().equals(data)) {
            aux = aux.getSig();
        }
        return aux;
    }

    /**
     * @param data
     * @return
     */
    public Node remove(T data) {
        Node act = first;
        Node ant = null;

        while (act != null && !act.getInfo().equals(data)) {
            ant = act;
            act = act.getSig();
        }

        if (act != null && ant == null) {
            Node ret = act;
            first = act.getSig();
            size--;
            return ret;
        }

        if (act != null && ant != null) {
            ant.setSig(act.getSig());
        }
        return null;
    }

    public Node getFirst() {
        return first;
    }

    public void setFirst(Node first) {
        this.first = first;
    }

    public int size() {
        return size;
    }

    public String toString() {
        String x = "";

        Node aux = first;
        while (aux != null) {
            x += "" + aux.getInfo() + (aux.getSig() != null ? ", " : "");
            aux = aux.getSig();
        }
        return x;
    }
}
