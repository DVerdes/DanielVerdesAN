package org.example;

/**
 * Main del ejercicio final
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        Vehiculo auto1 = new Automovil("Seat","Leon",2010, 4);
        Vehiculo moto1 = new Motocicleta("Yamaha", "245", 2020, 220);


        auto1.arrancar();

        moto1.arrancar();






    }
}
