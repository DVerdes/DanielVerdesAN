package org.example;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class test3 implements ActionListener, Runnable {


    static JProgressBar jbPB1;
    static JProgressBar jbPB2;
    static JProgressBar jbPB3;

    static JSlider jbSli1;
    static JSlider jbSli2;
    static JSlider jbSli3;



    static JTextField jbtf1;
    static  JTextField jbtf2;
    static JTextField jbtf3;

    static JTextField jbtf4;

    static test3 _this;



    static int caballo;


    public test3 (){
        _this = this;

    }

    private static void createAndShowGUI(){
        JFrame aFrame = new JFrame("Swing Thread Example:  Fixed Threading");

        aFrame.setTitle("PSP02P02");
        aFrame.setBounds(100, 100, 700, 600);
        aFrame.setResizable(false);




        JButton jbInicio;





        jbInicio = new JButton();
        jbInicio.setBounds(250, 30, 200, 30);
        jbInicio.setText("Comenzar carrera");
        aFrame.add(jbInicio);
        jbInicio.addActionListener(_this);

        jbSli1 = new JSlider();
        jbSli1.setBounds(250,100,200,30);
        jbSli1.setMaximum(10);
        jbSli1.setMinimum(1);
        jbSli1.setValue(5);
        aFrame.add(jbSli1);

        jbPB1 = new JProgressBar();
        jbPB1.setBounds(20,140,650,20);
        jbPB1.setStringPainted(true);
        jbPB1.setMaximum(100);
        aFrame.add(jbPB1);

        jbSli2 = new JSlider();
        jbSli2.setBounds(250,200,200,30);
        jbSli2.setMaximum(10);
        jbSli2.setMinimum(1);
        jbSli2.setValue(5);
        aFrame.add(jbSli2);

        jbPB2 = new JProgressBar();
        jbPB2.setBounds(20,240,650,20);
        jbPB2.setStringPainted(true);
        jbPB2.setMaximum(100);
        aFrame.add(jbPB2);

        jbSli3 = new JSlider();
        jbSli3.setBounds(250,300,200,30);
        jbSli3.setMaximum(10);
        jbSli3.setMinimum(1);
        jbSli3.setValue(5);
        aFrame.add(jbSli3);

        jbPB3 = new JProgressBar();
        jbPB3.setBounds(20,340,650,20);
        jbPB3.setStringPainted(true);
        jbPB3.setMaximum(100);
        aFrame.add(jbPB3);

        jbtf1 = new JTextField();
        jbtf1.setBounds(100,450,100,30);
        aFrame.add(jbtf1);

        jbtf2 = new JTextField();
        jbtf2.setBounds(300,450,100,30);
        aFrame.add(jbtf2);

        jbtf3 = new JTextField();
        jbtf3.setBounds(500,450,100,30);
        aFrame.add(jbtf3);

        jbtf4 = new JTextField();
        jbtf4.setBounds(300,450,100,30);
        aFrame.add(jbtf4);




        aFrame.setVisible(true);


    }

    public static void main(String args[]){


        test3 t2 = new test3();
        Thread hilo2 = new Thread(t2);



        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {

                createAndShowGUI();
                hilo2.start();

            }
        });
    }

    public void actionPerformed(ActionEvent ae){

        // signal the worker thread to get crackin
        synchronized(this){notifyAll();}
    }

    // worker thread
    public void run(){

        HiloCarrera hc = new HiloCarrera(50,5,1);
        HiloCarrera hc2 = new HiloCarrera(70,5,2);
        HiloCarrera hc3 = new HiloCarrera(40,5,3);





            // wait for the signal from the GUI
            try{synchronized(this){wait();}}
            catch (InterruptedException e){}
            // simulate some long-running process like parsing a large file
            hc.setPrioridad(jbSli1.getValue());
            hc2.setPrioridad(jbSli2.getValue());
            hc3.setPrioridad(jbSli3.getValue());

            hc.start();
            hc2.start();
            hc3.start();

            while (hc.isAlive() && hc2.isAlive() && hc3.isAlive()){
            }

            if(!hc.isAlive()){
                caballo = 1;
            }else if(!hc2.isAlive()){
                caballo = 2;
            }else{
                caballo = 3;
            }

        JOptionPane.showMessageDialog(null,
                "El caballo ganador es el número "+caballo,
                "FIN CARRERA",
                JOptionPane.PLAIN_MESSAGE);

    }
}