package org.example;

import javax.swing.JFrame;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {



        // ABRIR VENTANA
        Ventana v = new Ventana();

        // CERRAR AL SALIR
        v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
