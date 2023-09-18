package org.example;

public class Motocicleta extends Vehiculo implements Arrancable{

    private int cilindrada;
    public Motocicleta(String marca, String modelo, int year) {
        super(marca, modelo, year);
    }

    public Motocicleta(String marca, String modelo, int year, int cilindrada) {
        super(marca, modelo, year);
        this.cilindrada = cilindrada;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    @Override
    public void arrancar() {
        System.out.println("Arranca la motocicleta");
    }
}
