package Laboratorio.Practica_6;

public interface InterfaceDoubleLinkedList<E> {

    /*
    - addFirst(E e): Añade elemento al principio.
    - addLast(E e): Añade elemento al final.
    - add(E e, int index): Añade elemento en posicion.
    - removeFirst(): Elimina el primer elemento.
    - removeLast(): Eliminar el ultimo elemento.
    - remove(int index): Elimina el elemento index.
    - isEmpty(): Si esta vacio.
    - size(): Tamaño de la lista.
    - getFirst(): Devuelve el primer elemento.
    - getLast(): Devuelve el ultimo elemento.
    - get(int index): Devuelve el elemento de index.
    - contains(E e): Verificar si contiene un elemento.
    */

    void addFirst(E e);

    void addLast(E e);

    void add(E e, int index);

    void removeFirst();

    void removeLast();

    void remove(int index);

    boolean isEmpty();

    int size();

    E getFirst();

    E getLast();

    E get(int index);

    boolean contains(E e);

}
