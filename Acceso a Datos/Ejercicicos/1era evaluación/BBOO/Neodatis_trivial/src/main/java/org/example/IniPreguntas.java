package org.example;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Clase para grabar preguntas en BBDD Neodatis
 */
public class IniPreguntas {

    public static void main( String[] args ) throws Exception {

        ArrayList <Pregunta> preguntas = new ArrayList<Pregunta>();


        // Ciencia
        preguntas.add(new Pregunta(1,"¿Cuál es la unidad básica de la estructura de los ácidos nucleicos?","Ciencia",new ArrayList<>(Arrays.asList(new Respuesta("a)","Aminoácido",false),new Respuesta("b)","Nucleótido",true), new Respuesta("c)","Monosacárido",false),new Respuesta("d)","Péptido",false)))));
        preguntas.add(new Pregunta(2,"¿Cuál es la fuerza que mantiene unidos los átomos en una molécula?","Ciencia",new ArrayList<>(Arrays.asList(new Respuesta("a)","Fuerza electromagnética",true),new Respuesta("b)","Fuerza nuclear",false), new Respuesta("c)","Fuerza gravitacional",false),new Respuesta("d)","Fuerza centrífuga",false)))));
        preguntas.add(new Pregunta(3,"¿Qué nombre recibe el cambio de estado de líquido a gas?","Ciencia",new ArrayList<>(Arrays.asList(new Respuesta("a)","Sublimación",false),new Respuesta("b)","Solidificación",false), new Respuesta("c)","Evaporación",true),new Respuesta("d)","Fusión",false)))));
        preguntas.add(new Pregunta(4,"¿Cuál es el proceso por el cual las plantas fabrican su propio alimento?","Ciencia",new ArrayList<>(Arrays.asList(new Respuesta("a)","Fotosíntesis",true),new Respuesta("b)","Respiración",false), new Respuesta("c)","Fermentación",false),new Respuesta("d)","Absorción",false)))));
        preguntas.add(new Pregunta(5,"¿Qué elemento químico es el más abundante en la corteza terrestre?","Ciencia",new ArrayList<>(Arrays.asList(new Respuesta("a)","Hierro",false),new Respuesta("b)","Oxígeno",true), new Respuesta("c)","Silicio",false),new Respuesta("d)","Carbono",false)))));


        // Cine
        preguntas.add(new Pregunta(6,"¿Quién dirigió la película \"El Padrino\"?","Cine",new ArrayList<>(Arrays.asList(new Respuesta("a)","Martin Scorsese",false),new Respuesta("b)","Francis Ford Coppola",true), new Respuesta("c)","Quentin Tarantino",false),new Respuesta("d)","Steven Spielberg",false)))));
        preguntas.add(new Pregunta(7,"¿Cuál es la película ganadora del Oscar a la Mejor Película en 2020?","Cine",new ArrayList<>(Arrays.asList(new Respuesta("a)","1917",false),new Respuesta("b)", "Parásitos",true), new Respuesta("c)", "Green Book",false),new Respuesta("d)","Nomadland",false)))));
        preguntas.add(new Pregunta(8,"¿Cuál es el título de la primera película, por orden de estreno, de la saga \"Star Wars\"?","Cine",new ArrayList<>(Arrays.asList(new Respuesta("a)","El Despertar de la Fuerza",false),new Respuesta("b)", "La Amenaza Fantasma",false), new Respuesta("c)", "Una Nueva Esperanza",true),new Respuesta("d)","El Imperio Contraataca",false)))));
        preguntas.add(new Pregunta(9,"¿Quién interpretó a Batman en la trilogía dirigida por Christopher Nolan?","Cine",new ArrayList<>(Arrays.asList(new Respuesta("a)","Christian Bale",true),new Respuesta("b)", "Ben Affleck",false), new Respuesta("c)", "George Clooney",false),new Respuesta("d)","Michael Keaton",false)))));
        preguntas.add(new Pregunta(10,"¿Quién dirigió la película \"El Resplandor\"?","Cine",new ArrayList<>(Arrays.asList(new Respuesta("a)","Stanley Kubrick",true),new Respuesta("b)", "Alfred Hitchcock",false), new Respuesta("c)", "Tim Burton",false),new Respuesta("d)","David Lynch",false)))));


        // Historia
        preguntas.add(new Pregunta(11,"¿En qué año comenzó la Primera Guerra Mundial?","Historia",new ArrayList<>(Arrays.asList(new Respuesta("a)","1918",false),new Respuesta("b)", "1914",true), new Respuesta("c)", "1939",false),new Respuesta("d)","1945",false)))));
        preguntas.add(new Pregunta(12,"¿Cuál fue el primer presidente de Estados Unidos?","Historia",new ArrayList<>(Arrays.asList(new Respuesta("a)","Thomas Jefferson",false),new Respuesta("b)", "George Washington",true), new Respuesta("c)", "John Adams",false),new Respuesta("d)","Abraham Lincoln",false)))));
        preguntas.add(new Pregunta(13,"¿Quién fue el líder de la Revolución Rusa de 1917?","Historia",new ArrayList<>(Arrays.asList(new Respuesta("a)","Vladimir Lenin",true),new Respuesta("b)", "Joseph Stalin",false), new Respuesta("c)", "León Trotsky",false),new Respuesta("d)","Nicolás II",false)))));
        preguntas.add(new Pregunta(14,"¿Cuál fue el nombre del primer hombre en pisar la Luna?","Historia",new ArrayList<>(Arrays.asList(new Respuesta("a)","Alan Shepard",false),new Respuesta("b)", "Buzz Aldrin",false), new Respuesta("c)", "John Glenn",false),new Respuesta("d)","Neil Armstrong",true)))));
        preguntas.add(new Pregunta(15,"¿Qué imperio fue gobernado por Justiniano I?","Historia",new ArrayList<>(Arrays.asList(new Respuesta("a)","Imperio Romano",false),new Respuesta("b)", "Imperio Persa",false), new Respuesta("c)", "Imperio Bizantino",true),new Respuesta("d)","Imperio Mongol",false)))));





        crearPreguntas(preguntas);

    }

    public static void crearPreguntas(ArrayList <Pregunta> preguntas) throws Exception{

        ODB odb = null;

        try{
            odb = ODBFactory.open("C:\\BBOO\\NeodatisTrivial.db");

            for (Pregunta pregunta:preguntas
                 ) {
                odb.store(pregunta);
            }

        }finally{
            if(odb!=null){
                odb.close();
            }

        }
    }

}
