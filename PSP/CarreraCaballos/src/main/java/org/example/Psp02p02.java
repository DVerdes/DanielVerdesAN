package org.example;

import java.awt.event.*;
import javax.swing.*;

/**
 * Clase con método main, componentes swing y Runnable
 */
public class Psp02p02 implements ActionListener, Runnable {

    // Componentes
    static JProgressBar jbPB1;
    static JProgressBar jbPB2;
    static JProgressBar jbPB3;

    static JSlider jbSli1;
    static JSlider jbSli2;
    static JSlider jbSli3;

    static JButton jbInicio;

    static JTextField jbtf1;
    static JTextField jbtf2;
    static JTextField jbtf3;

    static JFrame aFrame;

    static Psp02p02 _this;

    //Almacena caballo ganador
    static int caballo;

    //Valores sleep de los hilos (caballos)
    static int sleepc1 = 50;
    static int sleepc2 = 50;
    static int sleepc3 = 50;

    /**
     * Constructor
     */
    public Psp02p02() {
        _this = this;
    }

    /**
     * Inicializa y muestra los componentes de la GUI
     */
    private static void inicializarGUI() {
        aFrame = new JFrame("PSP02P02");

        aFrame.setTitle("PSP02P02");
        aFrame.setBounds(100, 100, 700, 600);
        aFrame.setResizable(false);

        aFrame.setLayout(null);

        jbInicio = new JButton();
        jbInicio.setBounds(250, 30, 200, 30);
        jbInicio.setText("Comenzar carrera");
        aFrame.add(jbInicio);
        jbInicio.addActionListener(_this);

        jbSli1 = new JSlider();
        jbSli1.setBounds(250, 100, 200, 30);
        jbSli1.setMaximum(10);
        jbSli1.setMinimum(1);
        jbSli1.setValue(5);
        aFrame.add(jbSli1);

        jbPB1 = new JProgressBar();
        jbPB1.setBounds(20, 140, 650, 20);
        jbPB1.setStringPainted(true);
        jbPB1.setMaximum(100);
        aFrame.add(jbPB1);

        jbSli2 = new JSlider();
        jbSli2.setBounds(250, 200, 200, 30);
        jbSli2.setMaximum(10);
        jbSli2.setMinimum(1);
        jbSli2.setValue(5);
        aFrame.add(jbSli2);

        jbPB2 = new JProgressBar();
        jbPB2.setBounds(20, 240, 650, 20);
        jbPB2.setStringPainted(true);
        jbPB2.setMaximum(100);
        aFrame.add(jbPB2);

        jbSli3 = new JSlider();
        jbSli3.setBounds(250, 300, 200, 30);
        jbSli3.setMaximum(10);
        jbSli3.setMinimum(1);
        jbSli3.setValue(5);
        aFrame.add(jbSli3);

        jbPB3 = new JProgressBar();
        jbPB3.setBounds(20, 340, 650, 20);
        jbPB3.setStringPainted(true);
        jbPB3.setMaximum(100);
        aFrame.add(jbPB3);

        jbtf1 = new JTextField();
        jbtf1.setBounds(100, 450, 100, 30);
        aFrame.add(jbtf1);

        jbtf2 = new JTextField();
        jbtf2.setBounds(300, 450, 100, 30);
        aFrame.add(jbtf2);

        jbtf3 = new JTextField();
        jbtf3.setBounds(500, 450, 100, 30);
        aFrame.add(jbtf3);

        aFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aFrame.setVisible(true);
    }


    public static void main(String args[]) {

        _this = new Psp02p02();

        /*
           Usamos el método invokeLater para ejecutar de manera asíncrona (respecto al hilo AWT)
               el contenido del método run() presentado a continuación.
               Esto posibilita que la GUI pueda actualizarse y mostrar el progreso de las
                JProgressBar y el contador de los JTextFields
         */
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {

                //Función que inicializa y muestra la GUI
                inicializarGUI();

                //Función que crea un nuevo hilo y lo lanza
                iniciarHilo();
            }
        });


    }

    /**
     * Crea un nuevo hilo a partir de un objeto Psp02p02 (que es runnable) y lo lanza
     */
    public static void iniciarHilo() {
        new Thread(_this).start();
    }

    /**
     * Activación de botón
     *
     * @param ae
     */
    public void actionPerformed(ActionEvent ae) {

        // Bloqueamos botón
        jbInicio.setEnabled(false);

        // Ventana para mostrar la prioridad asignada a los hilos
        JOptionPane.showMessageDialog(null,
                "Caballo 1:     " + jbSli1.getValue() + "\nCaballo 2:     " + jbSli2.getValue() + "\nCaballo 3:     " + jbSli3.getValue(),
                "PRIORIDADES",
                JOptionPane.PLAIN_MESSAGE);

        // Señal para que el hilo de trabajo finalice su espera
        synchronized (this) {
            notifyAll();
        }
    }

    /**
     * Método run de la clase Psp02p02
     */
    public void run() {

        // Esperar a la señal de la GUI
        try {
            synchronized (this) {
                wait();
            }
        } catch (InterruptedException e) {
        }

        // Valores aleatorios para el sleep()
        sleepc1 = (int) (Math.random() * (100 - 1)) + 1;
        sleepc2 = (int) (Math.random() * (100 - 1)) + 1;
        sleepc3 = (int) (Math.random() * (100 - 1)) + 1;



        // Creamos los hilos de la clase HiloCarrera
        HiloCarrera hc = new HiloCarrera(sleepc1, jbSli1.getValue(), 1);
        HiloCarrera hc2 = new HiloCarrera(sleepc2, jbSli2.getValue(), 2);
        HiloCarrera hc3 = new HiloCarrera(sleepc3, jbSli3.getValue(), 3);

        // Lanzamiento de HilosCarrera
        hc.start();
        hc2.start();
        hc3.start();

        // Se espera a la finalización del primer hilo
        while (hc.isAlive() && hc2.isAlive() && hc3.isAlive()) {
        }

        // En función del hilo que no esté vivo, conoceremos al ganador
        if (!hc.isAlive()) {
            caballo = 1;
        } else if (!hc2.isAlive()) {
            caballo = 2;
        } else {
            caballo = 3;
        }

        // Ventana emergente con resultado de la carrera
        JOptionPane.showMessageDialog(null,
                "El caballo ganador es el número " + caballo,
                "FIN CARRERA",
                JOptionPane.PLAIN_MESSAGE);

        // Se reseta GUI
        resetearUI();
        // Creamos y lanzamos un nuevo hilo para poder volver a realizar otra carrera.
        iniciarHilo();
    }

    /**
     * Resetea GUI para presentar valores iniciales
     */
    public void resetearUI() {

        jbPB1.setValue(0);
        jbPB2.setValue(0);
        jbPB3.setValue(0);

        jbtf1.setText("");
        jbtf2.setText("");
        jbtf3.setText("");

        // Desbloquear botón
        jbInicio.setEnabled(true);

    }
}