package org.example;

import javax.swing.*;

import static org.example.EvInicial.*;

public class HiloCarrera extends Thread{

    private int valorDormido;
    private int prioridad;
    private int caballo;

    private int progress;

    HiloCarrera(int valorDormido, int prioridad, int caballo){
        this.valorDormido = valorDormido;
        this.prioridad = prioridad;
        this.caballo = caballo;
    }// Constructor

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



                    break;
                case 2:
                    try {
                        sleep(valorDormido);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    test3.jbPB2.setValue(i);


                    break;
                case 3:
                    try {
                        sleep(valorDormido);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    test3.jbPB3.setValue(i);



                    break;
            }
        }
        System.out.println(this.getPriority());

        test3.carreraEnCurso = false;
        test3.caballo = this.caballo;


    }//Run

}
