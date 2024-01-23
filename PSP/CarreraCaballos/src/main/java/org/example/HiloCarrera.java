package org.example;

/**
 * Clase de HiloCarrera
 */
public class HiloCarrera extends Thread{

    //ATRIBUTOS
    // Valor para sleep entre iteraciones
    private int valorDormido;
    // Prioridad del hilo
    private int prioridad;
    // Número del caballo
    private int caballo;


    /**
     * Constructor
     * @param valorDormido Valor para sleep entre iteraciones
     * @param prioridad Prioridad del hilo
     * @param caballo Número del caballo
     */
    HiloCarrera(int valorDormido, int prioridad, int caballo){
        this.valorDormido = valorDormido;
        this.prioridad = prioridad;
        this.caballo = caballo;
    }// Constructor


    /**
     * Método run()
     */
    public void run(){
        // Asigna prioridad al hilo
        this.setPriority(this.prioridad);
        // Iteración de hilo
        for(int i = 0; i<=100; i++){
            // Mensaje por consola
            System.out.println("Hilo" + caballo +
                    " contando "+i+"...");
            // Switch para que el hilo modifique unicamente los elementos de la GUI propios
            switch (this.caballo){
                // CABALLO 1
                case 1:
                    Psp02p02.jbPB1.setValue(i);
                    Psp02p02.jbtf1.setText(String.valueOf(i));
                    break;
                // CABALLO 2
                case 2:
                    Psp02p02.jbPB2.setValue(i);
                    Psp02p02.jbtf2.setText(String.valueOf(i));
                    break;
                // CABALLO 3
                case 3:
                    Psp02p02.jbPB3.setValue(i);
                    Psp02p02.jbtf3.setText(String.valueOf(i));
                    break;
            }
            // Sleep entre iteraciones
            try {
                sleep(valorDormido);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        // Mensaje por consola para control de prioridad
        System.out.println(this.getPriority());
    }//Run
}
