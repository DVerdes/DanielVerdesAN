package org.example;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        ArrayList<Deportista> deportistas = new ArrayList<Deportista>();

        RandomAccessFile raf = null;

        try {
            // no olvidarse de writeChars(String);
            //  raf.seek(32);

            // para poner un string de un tamaño
            // StringBuffer sb = new StringBuffer(Alumno.getNombre());
            // sb.setLength(10);
            // raf.writeChars(sb.toString());


            raf = new RandomAccessFile("C://Pruebas//deportistas.txt","rw");
        String nombre = "";

        for(int i = 0; i<4; i++){
            deportistas.add(new Deportista());
            for(int j = 0; j<25; j++){
                nombre += raf.readChar();
            }
            deportistas.get(i).setNombre(nombre);
            nombre = "";
            deportistas.get(i).setEdad(raf.readInt());
            deportistas.get(i).setSalario(raf.readDouble());
            deportistas.get(i).setIngresosPublicidad(raf.readDouble());
        }

        Collections.sort(deportistas, new Comparator<Deportista>() {
            @Override
            public int compare(Deportista p1, Deportista p2) {
                return new Double(p1.getIngresosPublicidad()+p1.getSalario()).compareTo(new Double((p2.getIngresosPublicidad())+p2.getSalario()));
            }
        });

        System.out.println(deportistas.get(1).getNombre()+"-"+deportistas.get(1).getEdad()+"-"+deportistas.get(1).getSalario()+"-"+deportistas.get(1).getIngresosPublicidad());

        } catch (Exception e) {
            e.printStackTrace();

        } finally {

            // Cerramos recursos
            try {

                if (raf != null) raf.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
