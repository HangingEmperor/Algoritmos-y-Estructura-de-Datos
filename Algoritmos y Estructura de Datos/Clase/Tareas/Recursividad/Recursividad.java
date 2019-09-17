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

    /* 3.- Hacer un método que regrese el valor de elevar n a la x potencia. n^x*/
    public static int potencia(int n, int x) {
        if (x == 0)
            return 1;
        else
            return n * potencia(n, x - 1);
    }

    /* 4.- Hacer un método que calcule la suma de los valores de un arreglo de n números.*/
    public static int sumaDeElementos(int vec[], int n) {
        if (n == 0)
            return vec[0];
        n--;
        return vec[n + 1] + sumaDeElementos(vec, n);
    }

    /* 5.- Hacer un método que calcule la serie 1/n^2+1/(n-1)^2*/
    public static double serie(int n) {
        if (n == 1)
            return n;
        return ((1 / Math.pow(n, 2)) + 1) / ((Math.pow(n - 1, 2)) + serie(n - 1));
    }

    /* Hacer un método que identifique si el número de entrada es un número primo o no*/
    public static boolean esPrimo(int num, int divisor) {
        if (num / 2 < divisor) {
            return true;
        } else {
            if (num % divisor == 0) {
                return false;
            } else {
                return esPrimo(num, divisor + 1);
            }
        }
    }

    /* 2. Hacer un método que reciba un número y regrese una cadena con los n valores de la serie de Fibonacci,*/
    public static int funcionFibonacci(int num) {
        if (num == 0 || num == 1)
            return num;
        else
            return funcionFibonacci(num - 1) + funcionFibonacci(num - 2);
    }
}
