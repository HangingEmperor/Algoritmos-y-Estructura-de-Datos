package Clase.Tareas.Pilas;

public class Main {

    public static void main(String[] args) {
        Persona omar = new Persona("Omar Flores Salazar", 21);

        Pila pila = new Pila();
        pila.push(omar);

        System.out.println(pila.pop().toString());
        System.out.println(Pila.inversion("Hola me llamo omar flores salazar"));

        System.out.println(Pila.isValidOperation("(3x[22{4x+e}*5]*5+8)"));
        System.out.println(Pila.isValidOperation("{(3x[22{4x+e}*5]*5+8)]"));
    }
}
