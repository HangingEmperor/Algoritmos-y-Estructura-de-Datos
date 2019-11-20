package Laboratorio.Practica_5;

public class LinkedList<T> {

    private Node<T> first;
    private int size;

    LinkedList() {
        first = null;
        size = 0;
    }

    void addFirst(T data) {
        Node<T> n = new Node<>();
        n.setInfo(data);
        n.setSig(first);
        this.first = n;
        size++;
    }

    void removeStart() {
        if (first == null)
            System.out.println("La lista esta vacia");
        else {
            this.first = this.first.getSig();
            size--;
        }
    }

    void addFinal(T data) {
        Node<T> n = new Node<>();
        n.setInfo(data);

        if (first == null) {
            n.setSig(null);
            this.first = n;
        } else {
            Node<T> r;
            r = first;
            while (r.getSig() != null)
                r = r.getSig();
            r.setSig(n);
            n.setSig(null);
        }
        size++;
    }

    void removeFinal() {
        Node<T> r = new Node<>();
        if (first == null)
            System.out.println("La lista esta vacia");
        else {
            if (first.getSig() == null) {
                first = null;
                size--;
            } else
                r = first;

            Node<T> a;
            a = r;
            while (r.getSig() != null) {
                a = r;
                r = r.getSig();
            }
            a.setSig(null);
        }
        size--;
    }

    T search(T data) {
        Node<T> aux = first;
        while (aux != null && !aux.getInfo().equals(data))
            aux = aux.getSig();
        assert aux != null;
        return aux.getInfo();
    }

    public T get(int index) {
        Node<T> aux = first;
        if (index == 0)
            return first.getInfo();
        else if (index > this.size)
            return null;
        else {
            int x = 0;
            while (x != index) {
                aux = aux.getSig();
                x++;
            }
        }
        return aux.getInfo();
    }

    public void add(T e, int index) {
        if (index == 0)
            this.addFirst(e);
        else if (index == this.size)
            this.addFinal(e);
        else if (index > this.size() | index < 0)
            System.out.println("El indice esta fuera de alcance");
        else {
            LinkedList<T> newList = new LinkedList<>();
            int cont = 0;
            while (this.size == 0) {
                if (index == cont) {
                    newList.addFinal(e);
                    cont++;
                } else {
                    newList.addFinal(this.getFirst());
                    this.removeStart();
                    cont++;
                }
            }
            this.first = newList.first;
            this.size++;
        }
    }

    public Node<T> remove(T data) {
        Node<T> act = first;
        Node<T> ant = null;

        while (act != null && !act.getInfo().equals(data)) {
            ant = act;
            act = act.getSig();
        }

        if (act != null && ant == null) {
            first = act.getSig();
            size--;
            return act;
        }

        if (act != null)
            ant.setSig(act.getSig());
        return null;
    }

    T getFirst() {
        return first.getInfo();
    }

    T getLast() {
        Node<T> last;
        last = first;
        while (last.getSig() != null) {
            last = last.getSig();
        }
        return last.getInfo();
    }

    public int size() {
        return size;
    }

    public String toString() {
        StringBuilder x = new StringBuilder();

        Node aux = first;
        while (aux != null) {
            x.append(aux.getInfo()).append(aux.getSig() != null ? ", " : "");
            aux = aux.getSig();
        }
        return x.toString();
    }
}
