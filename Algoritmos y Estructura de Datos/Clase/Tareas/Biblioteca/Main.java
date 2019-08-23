package Clase.Tareas.Biblioteca;

public class Main {

    public static void main(String[] args) {
        Libro mex = new Libro("john", "miedo", "124");
        Libro mex1 = new Libro("ahrn", "miedo", "124");
        Libro mex2 = new Libro("kann", "miedo", "124");

        Biblioteca biblioteca = new Biblioteca();
        biblioteca.addLibro(mex);
        biblioteca.addLibro(mex1);
        biblioteca.addLibro(mex2);

        System.out.println(biblioteca.ordenarAlfabeticoAutores(biblioteca.getEjemplares()));
        System.out.println(biblioteca.ordenarAlfabeticoTitulo(biblioteca.getEjemplares()));
    }
}
