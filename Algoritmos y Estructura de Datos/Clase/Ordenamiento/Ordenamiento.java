package Clase.Ordenamiento;

public class Ordenamiento {

    /* Insercion y seleccion directa */
    void insercion(int a[], int n) {
        int aux;
        int k;

        for (int i = 1; i < n; i++) {
            aux = a[i];
            k = i - 1;

            while (k >= 0 && aux < a[k]) {
                a[k + 1] = a[k];
                k--;
            }
            a[k + 1] = aux;
        }
    }

    void seleccion(int a[], int n) {
        int menor;
        int pos;
        int tmp;
        int k;

        for (int i = 0; i < n - 1; i++) {
            menor = a[i];
            k = i;

            for (int j = i + 1; j < n; j++) {
                if (a[k] < menor) {
                    menor = a[j];
                    k = j;
                }
            }
            a[k] = a[i];
            a[i] = menor;
        }
    }

    /* Metodo Shell*/
    void shell(int a[], int n) {
        int inter;
        int band;
        int i;
        int aux;

        inter = n + 1;
        while (inter > 1) {
            inter = (int) inter / 2;
            band = 1;

            while (band == 1) {
                band = 0;
                i = 1;

                while ((i + inter) <= n) {
                    if (a[i] > a[i + inter]) {
                        aux = a[i];
                        a[i] = a[i + inter];
                        a[i + inter] = aux;
                        band = 1;
                    }
                    i++;
                }
            }
        }
    }

    /* Metodo Quicksort*/
    void quicksort(int A[], int izq, int der) {
        int pivote = A[izq];
        int i = izq;
        int j = der;
        int aux;

        while (i < j) {
            while (A[i] <= pivote && i < j) i++;
            while (A[j] > pivote) j--;
            if (i < j) {
                aux = A[i];
                A[i] = A[j];
                A[j] = aux;
            }
        }
        A[izq] = A[j];
        A[j] = pivote;
        if (izq < j - 1)
            quicksort(A, izq, j - 1);
        if (j + 1 < der)
            quicksort(A, j + 1, der);
    }
}
