package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        Automovil auto1 = new Automovil("Seat","Leon",2010, 4);
        Motocicleta moto1 = new Motocicleta("Yamaha", "245", 2020, 220);


        auto1.arrancar();

        moto1.arrancar();






    }
}
