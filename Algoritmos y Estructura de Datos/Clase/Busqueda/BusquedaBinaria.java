public class BusquedaBinaria {
    // Busca el elemento x en el vector v de n componentes
    int binaria(int v[], int n, int x) {
        int izq = 0;
        int der = n;
        boolean b = false;
        int cen;

        while (izq <= der && b) {
            cen = (int) (izq + der0) / 2;
            if (x == v[cen]) {
                b = true;
            } else { // Se redefine el intervalo de busqueda
                if (x > v[cen]) {
                    izq = cen + 1;
                } else {
                    der = cen - 1;
                }
            }
        }
        if (b) {
            return v[cen];
        }
        return -1;
    }
}