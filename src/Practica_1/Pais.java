package Practica_1;

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

    public Pais() {
    }

    public Pais(String country, String city, String continent, float latitudeDecimals, float longitudeDecimals, String latitude, String longitude) {
        this.country = country;
        this.city = city;
        this.continent = continent;
        this.latitudeDecimals = latitudeDecimals;
        this.longitudeDecimals = longitudeDecimals;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public float getLatitudeDecimals() {
        return latitudeDecimals;
    }

    public void setLatitudeDecimals(float latitudeDecimals) {
        this.latitudeDecimals = latitudeDecimals;
    }

    public float getLongitudeDecimals() {
        return longitudeDecimals;
    }

    public void setLongitudeDecimals(float longitudeDecimals) {
        this.longitudeDecimals = longitudeDecimals;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

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
