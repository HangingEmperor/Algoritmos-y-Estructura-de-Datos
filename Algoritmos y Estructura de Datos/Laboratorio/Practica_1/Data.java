package Laboratorio.Practica_1;

import java.util.ArrayList;

public class Data {

    ArrayList<Pais> data = new ArrayList<Pais>();

    public void add(Pais pais) {
        data.add(pais);
    }

    public String mostrarPais(int posicion) {
        return data.get(posicion).toString();
    }

    public int getSize() {
        return data.size();
    }

    public ArrayList<Pais> getData() {
        return data;
    }

    public void setData(ArrayList<Pais> data) {
        this.data = data;
    }
}
