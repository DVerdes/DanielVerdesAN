package org.example;

public class HiloCarrera extends Thread{

    private int valorDormido;
    private int prioridad;
    private int caballo;

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
                    EvInicial.jbPB1.setValue(i);
                    EvInicial.jbtf1.setText(String.valueOf(i));
                    break;
                case 2:
                    EvInicial.jbPB2.setValue(i);
                    EvInicial.jbtf2.setText(String.valueOf(i));
                    break;
                case 3:
                    EvInicial.jbPB3.setValue(i);
                    EvInicial.jbtf3.setText(String.valueOf(i));
                    break;
            }
        }
        System.out.println(this.getPriority());
        EvInicial.carreraEnCurso = false;
        EvInicial.caballo = this.caballo;
    }//Run

}
