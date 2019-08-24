package Clase.Tareas.Pilas;

public class Pila<T> {

    private int top;
    private T[] pila;

    public Pila() {
        this.top = -1;
        this.pila = (T[]) new Object[10];
    }

    Pila(int size) {
        this.top = -1;
        this.pila = (T[]) new Object[size];
    }

    public static String inversion(String cadena) {
        int size = cadena.length();
        Pila pila = new Pila(size);

        for (int i = 0; i < size; i++)
            pila.push(cadena.substring(i, i + 1));

        cadena = "";

        for (int i = 0; i < size; i++)
            cadena += pila.pop();

        return cadena;
    }

    public static boolean isValidOperation(String ecuacion) {
        Pila pila = new Pila(ecuacion.length());

        for (int i = 0; i < ecuacion.length(); i++) {
            String section = ecuacion.substring(i, i + 1);
            if (section.equals("(") ||
                    section.equals("[") ||
                    section.equals("{")) {
                pila.push(section);
            } else if (section.equals(")")) {
                if (!pila.pop().equals("("))
                    return false;
            } else if (section.equals("]")) {
                if (!pila.pop().equals("["))
                    return false;
            } else if (section.equals("}")) {
                if (!pila.pop().equals("{"))
                    return false;
            }
        }
        if (pila.isEmpty())
            return true;
        else
            return false;
    }

    void push(T object) {
        if (!isFull()) {
            top++;
            pila[top] = object;
        }
    }

    T pop() {
        T x = null;
        if (!isEmpty()) {
            x = pila[top];
            top--;
        }
        return x;
    }

    private boolean isEmpty() {
        return top < 0;
    }

    private boolean isFull() {
        return top == pila.length - 1;
    }
}
