package Clase.Ejemplos;

public class FactorialITerativo {
    public static void main(String[] args) {
        int n = 2;
        int result = 1;

        for (int i = 0; i < n; i++) {
            result *= (i + 1);
        }
        System.out.println(result);
    }
}
