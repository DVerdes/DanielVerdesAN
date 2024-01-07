package org.example;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class test2 implements ActionListener, Runnable {

    static JProgressBar jpb;
    static test2 _this;

    public test2 (){
        _this = this;
    }

    private static void createAndShowGUI(){
        JFrame aFrame = new JFrame("Swing Thread Example:  Fixed Threading");
        JButton aButton = new JButton("Do Something");
        aFrame.getContentPane().add(aButton, BorderLayout.SOUTH);
        aButton.addActionListener(_this);
        JPanel aPanel = new JPanel();
        aPanel.add(new JLabel("Progress:"));
        jpb = new JProgressBar(0,100);
        aPanel.add(jpb);
        aFrame.getContentPane().add(aPanel);
        aFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aFrame.pack();
        aFrame.setVisible(true);
    }

    public static void main(String args[]){
        test2 t = new test2();
        new Thread(t).start();
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    public void actionPerformed(ActionEvent ae){
        // signal the worker thread to get crackin
        synchronized(this){notifyAll();}
    }

    // worker thread
    public void run(){
        while(true){
            // wait for the signal from the GUI
            try{synchronized(this){wait();}}
            catch (InterruptedException e){}
            // simulate some long-running process like parsing a large file
            for (int i = 0; i <= 100; i++){
                jpb.setValue(i);
                System.out.println("actionPerformed sets jpb value to: "+i);
                try{Thread.sleep(50);} // make the process last a while
                catch (InterruptedException e){}
            }
        }
    }
}