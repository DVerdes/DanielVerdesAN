package org.example;

/**
 * Clase motocicleta, extendida de vehículo
 */
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

    /**
     * Método para arrancar la motocicleta
     */
    @Override
    public void arrancar() {
        System.out.println("Arranca la motocicleta");
    }

    /**
     * Convierte un número en String a int
     * @param numeroEnString aqui pasamos el número en formato String
     * @return devolvemos en formato int el número pasado por parámetro
     */
    public int devolverInt(String numeroEnString){
        return 0;
    }
}
