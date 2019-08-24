package Clase.Tareas.Biblioteca;

public class Main {

    public static void main(String[] args) {
        Libro mex = new Libro("John Katzenbach", "Psicoanalista", "10101010201");
        Libro mex1 = new Libro("Stephen King", "La tormenta del siglo", "1201010201");
        Libro mex2 = new Libro("Paulo Coelho", "Veronika decide morir", "101020120");

        Biblioteca biblioteca = new Biblioteca();
        biblioteca.addLibro(mex);
        biblioteca.addLibro(mex1);
        biblioteca.addLibro(mex2);

        System.out.println(biblioteca.ordenarAlfabeticoAutores(biblioteca.getEjemplares()));
        System.out.println(biblioteca.ordenarAlfabeticoTitulo(biblioteca.getEjemplares()));
    }
}
