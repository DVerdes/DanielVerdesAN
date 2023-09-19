package org.example;

/**
 * Clase automovil, extendida de vehículo
 */
public class Automovil extends Vehiculo implements Arrancable{

    private int numeroPuertas;


    public Automovil(String marca, String modelo, int year, int numeroPuertas) {
        super(marca, modelo, year);
        this.numeroPuertas = numeroPuertas;
    }

    public Automovil(String marca, String modelo, int year) {
        super(marca, modelo, year);
    }

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }

    /**
     * Método para arrancar el automóvil
     */
    @Override
    public void arrancar() {
        System.out.println("Arranca el automovil");
    }
}
