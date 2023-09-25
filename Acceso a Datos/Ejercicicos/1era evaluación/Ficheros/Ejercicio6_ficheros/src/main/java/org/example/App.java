package org.example;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {

        String ruta = "C:\\Users\\FP\\Documents\\Ficheros\\EJ6\\fichero.txt";

        ArrayList<Alumno> alumnos = new ArrayList<Alumno>();




        Alumno al1 = new Alumno(new char[]{'A','l','e','j','a','n','d','r','o',' '},23,7);
        Alumno al2 = new Alumno(new char[]{'F','e','r','n','a','n','d','o',' ',' '},29,8);
        Alumno al3 = new Alumno(new char[]{'E','z','e','q','u','i','e','l',' ',' '},20,2);

        alumnos.add(al1);
        alumnos.add(al2);
        alumnos.add(al3);

        RandomAccessFile raf = new RandomAccessFile(ruta, "rw");

        for(int i = 0; i<alumnos.size(); i++){
            for(int j = 0; j<10; j++){
                char [] arrayChar = alumnos.get(i).getNombre();
                char c = arrayChar[j];
                raf.writeChar(c);
            }
            raf.writeInt(alumnos.get(i).getEdad());
            raf.writeDouble(alumnos.get(i).getNotaMedia());
        }



        raf.seek(32);

        for(int i = 0; i<10; i++){
            System.out.print(raf.readChar());
        }



        System.out.print(" "+raf.readInt());

        System.out.print(" "+raf.readDouble());




    }



}
