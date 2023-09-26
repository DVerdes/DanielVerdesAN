package org.example;

import java.io.*;
import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, ClassNotFoundException {

        String ruta = "src\\Ficheros\\fichero.txt";

        Persona persona1 = new Persona("Juan Pablo","Vázquez","12/10/1993");
        Persona persona2 = new Persona("Roberto","Martínez","05/05/2001");
        Persona persona3 = new Persona("María","Suárez","23/12/1983");


        FileOutputStream fos = new FileOutputStream(ruta);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(persona1);
        oos.writeObject(persona2);
        oos.writeObject(persona3);
        oos.flush();

        FileInputStream fis = new FileInputStream(ruta);
        ObjectInputStream ois = new ObjectInputStream(fis);


        ArrayList <Persona> personas = new ArrayList<Persona>();


        personas.add((Persona) ois.readObject());
        personas.add((Persona) ois.readObject());
        personas.add((Persona) ois.readObject());



        PersonaMapping pm = new PersonaMapping(personas);



        for(int i = 0; i<pm.getPersonas().size(); i++){
            System.out.println(pm.getPersonas().get(i).toString());
        }




    }
}
