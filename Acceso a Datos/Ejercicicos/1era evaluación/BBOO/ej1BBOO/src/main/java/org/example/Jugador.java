package org.example;

public class Jugador {

    private String nombre;
    private String deporte;
    private int edad;
    private Pais pais;

    public Jugador(String nombre, String deporte, int edad, Pais pais) {
        this.nombre = nombre;
        this.deporte = deporte;
        this.edad = edad;
        this.pais = pais;
    }

    public Jugador() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "nombre='" + nombre + '\'' +
                ", deporte='" + deporte + '\'' +
                ", edad=" + edad +
                ", pais=" + pais +
                '}';
    }
}
