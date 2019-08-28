package Laboratorio.Practica_1;

/**
 * Clase para obtener y definir los datos de un pais, incluyendo coordenadas
 *
 * @author Omar
 */
public class Pais {

    private String country;
    private String city;
    private String continent;
    /* Expresados en Grados decimales */
    private float latitudeDecimals;
    private float longitudeDecimals;
    /* Expresado en Grados, Minutos y Segundos. */
    private String latitude;
    private String longitude;

    /**
     * Constructor para realizar un nuevo objeto Pais
     *
     * @param country           Nombre del pais tipo String
     * @param city              Nombre de la ciudad tipo String
     * @param continent         Nombre del continente tipo String
     * @param latitudeDecimals  Latitud en decimales tipo Float
     * @param longitudeDecimals Longitud en decimales tipo Float
     * @param latitude          Latitud en GMS tipo String
     * @param longitude         Longitud en GMS tipo String
     */
    public Pais(String country, String city, String continent, float latitudeDecimals, float longitudeDecimals, String latitude, String longitude) {
        this.country = country;
        this.city = city;
        this.continent = continent;
        this.latitudeDecimals = latitudeDecimals;
        this.longitudeDecimals = longitudeDecimals;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * Funcion para obtener el pais del objeto
     *
     * @return Regresa un String de la variable pais
     */
    public String getCountry() {
        return country;
    }

    /**
     * Funcion para definir el pais del objeto
     *
     * @param country Parametro para sustituir el valor country por el nuevo
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Funcion para obtener la ciudad del objeto
     *
     * @return Regresa un String de la variable city
     */
    public String getCity() {
        return city;
    }

    /**
     * Funcion para definir la ciudad del objeto
     *
     * @param city Parametro para sustituir el valor de city por el nuevo
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Funcion para obtener el continente del objeto
     *
     * @return Regresa un String de la variable continent
     */
    public String getContinent() {
        return continent;
    }

    /**
     * Funcion para definir el continente del objeto
     *
     * @param continent Parametro para sustituir el valor de continent por el nuevo
     */
    public void setContinent(String continent) {
        this.continent = continent;
    }

    /**
     * Funcion para obtener la latitud en decimales del objeto
     *
     * @return Regresa un Float de la variable latitudeDecimals
     */
    public float getLatitudeDecimals() {
        return latitudeDecimals;
    }

    /**
     * Funcion para definir la latitud en decimales del objeto
     *
     * @param latitudeDecimals Parametro para sustituir el valor de latitudeDecimals por el nuevo
     */
    public void setLatitudeDecimals(float latitudeDecimals) {
        this.latitudeDecimals = latitudeDecimals;
    }

    /**
     * Funcion para obtener la longitud en decimales del objeto
     *
     * @return Regresa un Float de la variable longitudeDecimals
     */
    public float getLongitudeDecimals() {
        return longitudeDecimals;
    }

    /**
     * Funcion para definir la longitud en decimales del objeto
     *
     * @param longitudeDecimals Parametro para sustituir el valor de longitudeDecimals por el nuevo
     */
    public void setLongitudeDecimals(float longitudeDecimals) {
        this.longitudeDecimals = longitudeDecimals;
    }

    /**
     * Funcion para obtener la latitud en GMS del objeto
     *
     * @return Regresa un String de la variable latitude
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * Funcion para definir la latitud en GMS del objeto
     *
     * @param latitude Parametro para sustituir el valor de latitude por el nuevo
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    /**
     * Funcion para obtener la longitud en GMS del objeto
     *
     * @return Regresa un String de la variable longitude
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * Funcion para definir la longitud en GMS del objeto
     *
     * @param longitude Parametro para sustituir el valor de longitude por el nuevo
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Pais = " + country + ", Ciudad = " + city +
                ", Continente = " + continent + ", Latitud en Decimales = " +
                latitudeDecimals + ", Longitud en Decimales = " + longitudeDecimals +
                ", Latitud en GMS = " + latitude + ", Longitud en GMS = " + longitude;
    }
}
