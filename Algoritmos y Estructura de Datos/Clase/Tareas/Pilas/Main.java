package Clase.Tareas.Pilas;

public class Main {

    public static void main(String[] args) {
        Persona omar = new Persona("Omar Flores Salazar", 21);
        Persona paola = new Persona("Paola Bastida Pardo", 22);
        Persona andre = new Persona("Andre Fernan", 23);

        Pila pila = new Pila(5);

        pila.push(omar);
        pila.push(paola);
        pila.push(andre);

        System.out.println(pila.pop().toString());
        System.out.println(Pila.inversion("Hola me llamo omar flores salazar"));

        System.out.println(Pila.isValidOperation("(3x[x2{4x}])"));
    }
}
