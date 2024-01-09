package org.example;

import javax.swing.*;

import static org.example.EvInicial.*;

public class HiloCaballo extends Thread{


   public void run(){
       System.out.println("hola");
       for (int i = 0; i<100; i++){
           test3.jbPB1.setValue(i);
           try {
               sleep(100);
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
       }
   }


}
