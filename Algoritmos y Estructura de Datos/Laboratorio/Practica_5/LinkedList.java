/*package Laboratorio.Practica_5;

public class LinkedList<T> {

    private Node first;

    public LinkedList() {
        first = null;
    }

    public void insert(T o) {
        Node tmp = new Node(o, null);

        tmp.setSig(first);
        first = tmp;
    }

    public T remove() {
        Node out = null;

        if (!isEmpty()) {
            out = (Node) first.getInfo();
            first = first.getSig();
        }

        return (T) out;
    }

    public Object extract(int n) {
        if (n <= 0 ||
                isEmpty() ||
                first.getSig() == null) { // only one element
        return extract();
        }

        Node prev;
        {
            prev = first;
            Node current = first.getSig();
            int i = 1;

            while (current.getSig() != null && i != n) {
                prev = current;
                current = current.getSig();
                i++;
            }
        }

        Object info = prev.getSig().getInfo();
        prev.setSig(prev.getSig().getSig());
        return info;
    }

    public boolean isEmpty() {
        if (first == null)
            return true;
        else
            return false;
    }

    public void insert(T o, int n) {
        if (isEmpty() || n <= 0) {
            insert(o);
        } else {
            Node iterator = first;

            for (int i = 1; i < n; i++) {
                if (iterator.getSig() == null)
                    break;
                iterator = iterator.getSig();
            }

            Node tmp = new Node(o, iterator.getSig());
            iterator.setSig(tmp);
        }
    }


}
*/