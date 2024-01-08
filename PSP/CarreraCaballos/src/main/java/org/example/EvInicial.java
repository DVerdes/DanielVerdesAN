package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EvInicial extends JPanel implements ActionListener {


    private JButton jbInicio;

    private JSlider jbSli1;
    private JSlider jbSli2;
    private JSlider jbSli3;

    public static JProgressBar jbPB1;
    public static JProgressBar jbPB2;
    public static JProgressBar jbPB3;

    public static JTextField jbtf1;
    public static JTextField jbtf2;
    public static JTextField jbtf3;


    public static boolean carreraEnCurso = false;
    public static int caballo = 0;

    public static int contador2 = 0;



    public EvInicial(){


        setLayout(null);


        jbInicio = new JButton();
        jbInicio.setBounds(250, 30, 200, 30);
        jbInicio.setText("Comenzar carrera");
        add(jbInicio);
        jbInicio.addActionListener(this);

        jbSli1 = new JSlider();
        jbSli1.setBounds(250,100,200,30);
        jbSli1.setMaximum(10);
        jbSli1.setMinimum(1);
        jbSli1.setValue(5);
        add(jbSli1);

        jbPB1 = new JProgressBar();
        jbPB1.setBounds(20,140,650,20);
        jbPB1.setStringPainted(true);
        jbPB1.setMaximum(100);
        add(jbPB1);

        jbSli2 = new JSlider();
        jbSli2.setBounds(250,200,200,30);
        jbSli2.setMaximum(10);
        jbSli2.setMinimum(1);
        jbSli2.setValue(5);
        add(jbSli2);

        jbPB2 = new JProgressBar();
        jbPB2.setBounds(20,240,650,20);
        jbPB2.setStringPainted(true);
        jbPB2.setMaximum(100);

        add(jbPB2);

        jbSli3 = new JSlider();
        jbSli3.setBounds(250,300,200,30);
        jbSli3.setMaximum(10);
        jbSli3.setMinimum(1);
        jbSli3.setValue(5);
        add(jbSli3);

        jbPB3 = new JProgressBar();
        jbPB3.setBounds(20,340,650,20);
        jbPB3.setStringPainted(true);
        jbPB3.setMaximum(100);

        add(jbPB3);

        jbtf1 = new JTextField();
        jbtf1.setBounds(100,450,100,30);
        add(jbtf1);

        jbtf2 = new JTextField();
        jbtf2.setBounds(300,450,100,30);
        add(jbtf2);

        jbtf3 = new JTextField();
        jbtf3.setBounds(500,450,100,30);
        add(jbtf3);


    }


    public void actionPerformed(ActionEvent e) {

        carreraEnCurso = true;

        //(int) ((long) Math.random() * 1000 + 1)

        HiloCarrera caballo1 = new HiloCarrera(100,jbSli1.getValue(),1);
        HiloCarrera caballo2 = new HiloCarrera(100,jbSli2.getValue(),2);
        HiloCarrera caballo3 = new HiloCarrera(100,jbSli3.getValue(),3);


        caballo1.start();
        caballo2.start();
        caballo3.start();

        while(carreraEnCurso){

            System.out.println("carrera");

        }

        System.out.println("El caballo ganador es "+caballo);

        JOptionPane.showMessageDialog(null,
                "El caballo ganador es "+caballo,
                "Fin carrera",
                JOptionPane.PLAIN_MESSAGE);




    }

}
