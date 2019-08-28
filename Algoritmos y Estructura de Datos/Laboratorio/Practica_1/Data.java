package Laboratorio.Practica_1;

import java.util.ArrayList;

/**
 * Clase para obtener y almacenar por medio de un ArrayList objetos de tipo Pais
 *
 * @author Omar
 */
public class Data {

    ArrayList<Pais> data = new ArrayList<Pais>();

    /**
     * Funcion para agregar un pais al ArrayList
     *
     * @param pais El parametro pais se almacenara en el ArrayList
     */
    public void add(Pais pais) {
        data.add(pais);
    }

    /**
     * Funcion para visualizar la informacion del objeto almacenada en un ArrayList
     *
     * @param posicion Parametro para localizar el objeto segun su posicion en el ArrayList
     * @return Regresa una cadena con la informacion del objeto
     */
    public String mostrarPais(int posicion) {
        return data.get(posicion).toString();
    }

    /**
     * Funcion para saber el tamaño almacenado total de los datos
     *
     * @return Regresa un entero con el tamaño del ArrayList
     */
    public int getSize() {
        return data.size();
    }

    /**
     * Funcion para obtener un ArrayList de paises almacenado
     *
     * @return Regresa un ArrayList parametrizado a Pais
     */
    public ArrayList<Pais> getData() {
        return data;
    }

    /**
     * Funcion para definir un ArrayList
     *
     * @param data Parametro para sustituir el ArrayList anterior por el que se envia
     */
    public void setData(ArrayList<Pais> data) {
        this.data = data;
    }
}
