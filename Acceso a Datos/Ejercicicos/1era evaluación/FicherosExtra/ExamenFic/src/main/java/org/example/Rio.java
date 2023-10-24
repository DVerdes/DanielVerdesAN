package org.example;

/**
 * Clase para guardar objetos Rio usados en el Ejercicio 2
 */
public class Rio {
    private String nombre;

    private int longitud;

    private String vertiente;

    private String cuenca;

    public Rio() {
    }

    public Rio(String nombre, int longitud, String vertiente, String cuenca) {
        this.nombre = nombre;
        this.longitud = longitud;
        this.vertiente = vertiente;
        this.cuenca = cuenca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public String getVertiente() {
        return vertiente;
    }

    public void setVertiente(String vertiente) {
        this.vertiente = vertiente;
    }

    public String getCuenca() {
        return cuenca;
    }

    public void setCuenca(String cuenca) {
        this.cuenca = cuenca;
    }

    @Override
    public String toString() {
        return "Rio{" +
                "nombre='" + nombre + '\'' +
                ", longitud=" + longitud +
                ", vertiente='" + vertiente + '\'' +
                ", cuenca='" + cuenca + '\'' +
                '}';
    }
}
