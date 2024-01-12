package org.example;

import javax.swing.*;

import static org.example.EvInicial.*;

public class HiloCarrera extends Thread{

    private int valorDormido;
    private int prioridad;
    private int caballo;


    HiloCarrera(int valorDormido, int prioridad, int caballo){
        this.valorDormido = valorDormido;
        this.prioridad = prioridad;
        this.caballo = caballo;
    }// Constructor


    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public void run(){
        this.setPriority(this.prioridad);
        try {
            sleep(valorDormido);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for(int i = 0; i<=100; i++){
            System.out.println("Hilo" + caballo +
                    " contando "+i+"...");
            switch (this.caballo){
                case 1:
                    try {
                        sleep(valorDormido);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    test3.jbPB1.setValue(i);
                    test3.jbtf1.setText(String.valueOf(i));



                    break;
                case 2:
                    try {
                        sleep(valorDormido);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    test3.jbPB2.setValue(i);
                    test3.jbtf2.setText(String.valueOf(i));



                    break;
                case 3:
                    try {
                        sleep(valorDormido);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    test3.jbPB3.setValue(i);
                    test3.jbtf3.setText(String.valueOf(i));




                    break;
            }
        }
        System.out.println(this.getPriority());




    }//Run

}
