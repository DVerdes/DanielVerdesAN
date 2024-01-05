package org.example;

import javax.swing.JFrame;

public class Ventana extends JFrame{

    // VENTANA/JFRAME

    public Ventana() {

        // TITULO/DIMENSIONES
        setTitle("PSP02P02");
        setBounds(100, 100, 700, 600);
        setResizable(false);


        // INICIAR...
        EvInicial e = new EvInicial();
        add(e);

        setVisible(true);


    }

}