package Laboratorio.Practica_5;

public class LList<T> {

    Node<T> head;
    int size;

    public LList() {
        this.head = null;
        this.size = 0;
    }

    /* Añade por la cabecera */
    public void addFirst(T e) {
        if (this.isEmpty()) {
            Node<T> newNode = new Node<T>();
            newNode.setInfo(e);
            newNode.setSig(null);
            this.head = newNode;
            this.size = 1;
        } else {
            Node<T> newNode = new Node<T>();
            newNode.setInfo(e);
            newNode.setSig(this.head);
            this.head = newNode;
            this.size++;
        }
    }

    public void addLast(T e) {
        if (this.isEmpty()) {
            Node<T> newNode = new Node<T>();
            newNode.setInfo(e);
            newNode.setSig(null);
            this.head = newNode;
            this.size = 1;
        } else {
            Node<T> newNode = new Node<T>();
            newNode.setInfo(e);
            newNode.setSig(null);
            this.size++;
        }
    }

    public void add(T e, int index) {
        if (index == 0) {
            this.addFirst(e);
        } else if (index == this.size) {
            this.addLast(e);
        } else if (index > this.size() | index < 0) {
            System.out.println("El indice esta fuera de alcance");
        } else {
            LList<T> newList = new LList<T>();
            int cont = 0;
            while (!this.isEmpty()) {
                if (index == cont) {
                    newList.addLast(e);
                    cont++;
                } else {
                    newList.addLast(this.getFirst());
                    this.removeFirst();
                    cont++;
                }
            }
            this.head = newList.head;
            this.size = newList.size;
        }
    }

    public void removeFirst() {
        if (this.isEmpty()) {
            System.out.println("La lista esta vacia");
        } else {
            this.head = this.head.getSig();
            this.size--;
        }
    }

    public void removeLast() {
        if (this.isEmpty()) {
            System.out.println("La lista esta vacia");
        } else {
            this.tail = this.tail.getNext();
            this.size--;
        }
    }

    public void remove(int index) {
        if (index == 0) {
            this.removeFirst();
        } else if (index == this.size - 1) {
            this.removeLast();
        } else if (index >= this.size() | index < 0) {
            System.out.println("El indice esta fuera de alcance");
        } else {
            DoubleLinked<E> newList = new DoubleLinked<E>();
            int cont = 0;
            while (!this.isEmpty()) {
                if (index == cont) {
                    this.removeFirst();
                    cont++;
                } else {
                    newList.addLast(this.getFirst());
                    this.removeFirst();
                    cont++;
                }
            }
            this.head = newList.head;
            this.tail = newList.tail;
            this.size = newList.size;
        }
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public int size() {
        return this.size;
    }

    public T getFirst() {
        if (this.isEmpty()) {
            System.out.println("Lista esta vacia.");
            return null;
        } else {
            return this.head.getElement();
        }
    }

    public T getLast() {
        if (this.isEmpty()) {
            System.out.println("Lista esta vacia.");
            return null;
        } else {
            return this.tail.getElement();
        }
    }

    public T get(int index) {
        E elem = null;
        if (index == 0) {
            elem = this.getFirst();
        } else if (index == this.size) {
            this.getLast();
        } else if (index >= this.size() | index < 0) {
            System.out.println("El indice esta fuera de alcance");
        } else {
            DoubleLinked<E> newList = new DoubleLinked<E>();
            int cont = 0;

            while (!this.isEmpty()) {
                if (index == cont) {
                    elem = this.getFirst();
                    newList.addLast(this.getFirst());
                    this.removeFirst();
                    cont++;
                } else {
                    newList.addLast(this.getFirst());
                    this.removeFirst();
                    cont++;
                }
            }
            this.head = newList.head;
            this.tail = newList.tail;
            this.size = newList.size;
        }
        return elem;
    }
}
