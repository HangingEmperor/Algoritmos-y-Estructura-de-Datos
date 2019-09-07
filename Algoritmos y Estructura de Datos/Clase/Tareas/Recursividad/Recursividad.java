package Clase.Tareas.Recursividad;

public class Recursividad {

    /* 1.- Hacer un método que regrese una cadena con la serie de números de N a 0*/
    public static int verSerie(int n) {
        System.out.println(n);
        if (n == 0)
            return 0;
        else
            return verSerie(n - 1);
    }

    /* 2.- Hacer un método que regrese el cálculo de la multiplicación de dos números con sumas sucesivas*/
    public static int multiplicacionSucesiva(int n1, int n2) {
        if (n2 == 1)
            return n1;
        else
            return n1 + multiplicacionSucesiva(n1, n2 - 1);
    }
}
