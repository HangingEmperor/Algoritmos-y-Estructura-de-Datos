package Laboratorio.Practica_5;

public class LinkedList<T> {

    private Node<T> first;
    private int size = 0;

    public LinkedList() {
        first = null;
        size = 0;
    }

    public void addFirst(T data) {
        Node<T> n = new Node<>();
        n.setInfo(data);
        n.setSig(first);
        first = n;
        size++;
    }

    public void removeStart() {
        if (first == null) {
            System.out.println("La lista esta vacia");
        } else {
            this.first = this.first.getSig();
            size--;
        }
    }

    public void addFinal(T data) {
        Node<T> n = new Node<>();
        n.setInfo(data);

        if (first == null) {
            n.setSig(first);
            first = n;
        } else {
            Node<T> r;
            r = first;
            while (r.getSig() != null) {
                r = r.getSig();
            }
            r.setSig(n);
            n.setSig(null);
        }
        size++;
    }

    public void removeFinal() {
        Node<T> r = new Node<>();
        if (first == null) {
            System.out.println("La lista esta vacia");
        } else {
            if (first.getSig() == null) {
                first = null;
                size--;
            } else {
                r = first;
            }
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

    public Node<T> search(T data) {
        Node<T> aux = first;
        while (aux != null && !aux.getInfo().equals(data)) {
            aux = aux.getSig();
        }
        return aux;
    }

    public T get(int index) {
        T elem = null;
        if (index == 0) {
            elem = this.getFirst();
        } else if (index > this.size() | index < 0) {
            System.out.println("El indice esta fuera de alcance");
        } else {
            LinkedList<T> newList = new LinkedList<T>();
            int cont = 0;

            while (this.first == null) {
                if (index == cont) {
                    elem = this.getFirst();
                    newList.addFinal(this.getFirst());
                    this.removeStart();
                    cont++;
                } else {
                    newList.addFinal(this.getFirst());
                    this.removeStart();
                    cont++;
                }
            }
            this.first = newList.first;
            this.size = newList.size;
        }
        return elem;
    }

    public void add(T e, int index) {
        if (index == 0) {
            this.addFirst(e);
        } else if (index == this.size) {
            this.addFinal(e);
        } else if (index > this.size() | index < 0) {
            System.out.println("El indice esta fuera de alcance");
        } else {
            LinkedList<T> newList = new LinkedList<T>();
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
            this.size = newList.size;
        }
    }

    public Node<T> remove(Node<T> data) {
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

        if (act != null && ant != null) {
            ant.setSig(act.getSig());
        }
        return null;
    }

    public T getFirst() {
        return first.getInfo();
    }

    public T getLast() {
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
        String x = "";

        Node aux = first;
        while (aux != null) {
            x += "" + aux.getInfo() + (aux.getSig() != null ? ", " : "");
            aux = aux.getSig();
        }
        return x;
    }
}
