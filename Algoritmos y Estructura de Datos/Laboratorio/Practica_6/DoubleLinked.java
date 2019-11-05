package Laboratorio.Practica_6;

import java.util.ArrayList;
import java.util.List;

public class DoubleLinked<E> implements InterfaceDoubleLinkedList<E> {

    private Nodo<E> head;
    private Nodo<E> tail;
    private int size;

    public DoubleLinked() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /* Añade por la cabecera */
    @Override
    public void addFirst(E e) {
        if (this.isEmpty()) {
            Nodo<E> newNode = new Nodo<E>();
            newNode.setElement(e);
            newNode.setNext(null);
            newNode.setPrevious(null);
            this.head = newNode;
            this.tail = newNode;
            this.size = 1;
        } else {
            Nodo<E> newNode = new Nodo<E>();
            newNode.setElement(e);
            newNode.setNext(this.head);
            newNode.setPrevious(null);
            this.head.setPrevious(newNode);
            this.head = newNode;
            this.size++;
        }
    }

    @Override
    public void addLast(E e) {
        if (this.isEmpty()) {
            Nodo<E> newNode = new Nodo<E>();
            newNode.setElement(e);
            newNode.setNext(null);
            newNode.setPrevious(null);
            this.head = newNode;
            this.tail = newNode;
            this.size = 1;
        } else {
            Nodo<E> newNode = new Nodo<E>();
            newNode.setElement(e);
            newNode.setNext(null);
            newNode.setPrevious(this.tail);
            this.tail.setNext(newNode);
            this.tail = newNode;
            this.size++;
        }
    }

    @Override
    public void add(E e, int index) {
        if (index == 0) {
            this.addFirst(e);
        } else if (index == this.size) {
            this.addLast(e);
        } else if (index > this.size() | index < 0) {
            System.out.println("El indice esta fuera de alcance");
        } else {
            DoubleLinked<E> newList = new DoubleLinked<E>();
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
            this.tail = newList.tail;
            this.size = newList.size;
        }
    }

    @Override
    public void removeFirst() {
        if (this.isEmpty()) {
            System.out.println("La lista esta vacia");
        } else {
            this.head = this.head.getNext();
            this.size--;
        }
    }

    @Override
    public void removeLast() {
        if (this.isEmpty()) {
            System.out.println("La lista esta vacia");
        } else {
            this.tail = this.tail.getNext();
            this.size--;
        }
    }

    @Override
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

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public E getFirst() {
        if (this.isEmpty()) {
            System.out.println("Lista esta vacia.");
            return null;
        } else {
            return this.head.getElement();
        }
    }

    @Override
    public E getLast() {
        if (this.isEmpty()) {
            System.out.println("Lista esta vacia.");
            return null;
        } else {
            return this.tail.getElement();
        }
    }

    @Override
    public E get(int index) {
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

    @Override
    public boolean contains(E e) {
        return false;
    }

    public Iterable<Nodo<E>> iterator() {
        List<Nodo<E>> listResult = new ArrayList<Nodo<E>>();
        DoubleLinked<E> dlAux = new DoubleLinked<E>();
        while (!this.isEmpty()) {
            Nodo<E> nodo = new Nodo<E>();
            nodo = this.head;
            listResult.add(nodo);

            dlAux.addLast(this.getFirst());

            this.removeFirst();
        }
        this.head = dlAux.head;
        this.tail = dlAux.tail;
        this.size = dlAux.size;

        return listResult;
    }
}