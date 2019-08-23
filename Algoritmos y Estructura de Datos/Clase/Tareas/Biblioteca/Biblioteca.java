package Clase.Tareas.Biblioteca;

import java.util.ArrayList;

public class Biblioteca {

    private ArrayList<Libro> ejemplares;

    public Biblioteca() {
        this.ejemplares = new ArrayList<Libro>();
    }

    public Biblioteca(ArrayList<Libro> ejemplares) {
        this.ejemplares = ejemplares;
    }

    public Libro getLibro(int pos) {
        return ejemplares.get(pos);
    }

    public void addLibro(Libro libro) {
        ejemplares.add(libro);
    }

    public ArrayList<Libro> ordenarAlfabeticoAutores(ArrayList<Libro> libros) {
        libros.sort((obj1, obj2) -> obj1.getAuthor().compareTo(obj2.getAuthor()));

        return libros;
    }

    public ArrayList<Libro> ordenarAlfabeticoTitulo(ArrayList<Libro> libros) {
        libros.sort((obj1, obj2) -> obj1.getTitle().compareTo(obj2.getTitle()));
        return libros;
    }

    public ArrayList<Libro> getEjemplares() {
        return ejemplares;
    }

    public void setEjemplares(ArrayList<Libro> ejemplares) {
        this.ejemplares = ejemplares;
    }
}
