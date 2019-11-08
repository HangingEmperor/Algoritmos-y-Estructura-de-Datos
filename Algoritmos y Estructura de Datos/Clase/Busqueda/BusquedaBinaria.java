package Clase.Busqueda;

public class BusquedaBinaria {
    // Busca el elemento x en el vector v de n componentes
    int binaria(int v[], int n, int x) {
        int izq = 0;
        int der = n;
        int b = 0;
        int cen = 0;

        while (izq <= der && b == 0) {
            cen = (int) ((izq + der) / 2);
            if (x == v[cen]) {
                b = 1;
            } else { // Se redefine el intervalo de busqueda
                if (x > v[cen]) {
                    izq = cen + 1;
                } else {
                    der = cen - 1;
                }
            }
        }
        if (b == 1) {
            return v[cen];
        }
        return -1;
    }
}