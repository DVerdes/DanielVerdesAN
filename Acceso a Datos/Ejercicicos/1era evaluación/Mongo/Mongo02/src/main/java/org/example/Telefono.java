package org.example;

public class Telefono {

    private int telefono;

    public Telefono() {
    }

    public Telefono(int telefono) {
        this.telefono = telefono;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Telefono{" +
                "telefono=" + telefono +
                '}';
    }
}
