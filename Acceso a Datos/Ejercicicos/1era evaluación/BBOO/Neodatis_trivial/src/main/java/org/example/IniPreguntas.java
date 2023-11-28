package org.example;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Clase para grabar preguntas en BBDD Neodatis
 */
public class IniPreguntas {

    public static void main( String[] args ) throws Exception {

        ArrayList <Pregunta> preguntas = new ArrayList<Pregunta>();

        // borrado
        borrarBBDD();

        // Ciencia
        preguntas.add(new Pregunta(1,"¿Cuál es la unidad básica de la estructura de los ácidos nucleicos?","Ciencia",new ArrayList<>(Arrays.asList(new Respuesta("a","Aminoácido",false),new Respuesta("b","Nucleótido",true), new Respuesta("c","Monosacárido",false),new Respuesta("d","Péptido",false)))));
        preguntas.add(new Pregunta(2,"¿Cuál es la fuerza que mantiene unidos los átomos en una molécula?","Ciencia",new ArrayList<>(Arrays.asList(new Respuesta("a","Fuerza electromagnética",true),new Respuesta("b","Fuerza nuclear",false), new Respuesta("c","Fuerza gravitacional",false),new Respuesta("d","Fuerza centrífuga",false)))));
        preguntas.add(new Pregunta(3,"¿Qué nombre recibe el cambio de estado de líquido a gas?","Ciencia",new ArrayList<>(Arrays.asList(new Respuesta("a","Sublimación",false),new Respuesta("b","Solidificación",false), new Respuesta("c","Evaporación",true),new Respuesta("d","Fusión",false)))));
        preguntas.add(new Pregunta(4,"¿Cuál es el proceso por el cual las plantas fabrican su propio alimento?","Ciencia",new ArrayList<>(Arrays.asList(new Respuesta("a","Fotosíntesis",true),new Respuesta("b","Respiración",false), new Respuesta("c","Fermentación",false),new Respuesta("d","Absorción",false)))));
        preguntas.add(new Pregunta(5,"¿Qué elemento químico es el más abundante en la corteza terrestre?","Ciencia",new ArrayList<>(Arrays.asList(new Respuesta("a","Hierro",false),new Respuesta("b","Oxígeno",true), new Respuesta("c","Silicio",false),new Respuesta("d","Carbono",false)))));


        // Cine
        preguntas.add(new Pregunta(6,"¿Quién dirigió la película \"El Padrino\"?","Cine",new ArrayList<>(Arrays.asList(new Respuesta("a","Martin Scorsese",false),new Respuesta("b","Francis Ford Coppola",true), new Respuesta("c","Quentin Tarantino",false),new Respuesta("d","Steven Spielberg",false)))));
        preguntas.add(new Pregunta(7,"¿Cuál es la película ganadora del Oscar a la Mejor Película en 2020?","Cine",new ArrayList<>(Arrays.asList(new Respuesta("a","1917",false),new Respuesta("b", "Parásitos",true), new Respuesta("c", "Green Book",false),new Respuesta("d","Nomadland",false)))));
        preguntas.add(new Pregunta(8,"¿Cuál es el título de la primera película, por orden de estreno, de la saga \"Star Wars\"?","Cine",new ArrayList<>(Arrays.asList(new Respuesta("a","El Despertar de la Fuerza",false),new Respuesta("b", "La Amenaza Fantasma",false), new Respuesta("c", "Una Nueva Esperanza",true),new Respuesta("d","El Imperio Contraataca",false)))));
        preguntas.add(new Pregunta(9,"¿Quién interpretó a Batman en la trilogía dirigida por Christopher Nolan?","Cine",new ArrayList<>(Arrays.asList(new Respuesta("a","Christian Bale",true),new Respuesta("b", "Ben Affleck",false), new Respuesta("c", "George Clooney",false),new Respuesta("d","Michael Keaton",false)))));
        preguntas.add(new Pregunta(10,"¿Quién dirigió la película \"El Resplandor\"?","Cine",new ArrayList<>(Arrays.asList(new Respuesta("a","Stanley Kubrick",true),new Respuesta("b", "Alfred Hitchcock",false), new Respuesta("c", "Tim Burton",false),new Respuesta("d","David Lynch",false)))));


        // Historia
        preguntas.add(new Pregunta(11,"¿En qué año comenzó la Primera Guerra Mundial?","Historia",new ArrayList<>(Arrays.asList(new Respuesta("a","1918",false),new Respuesta("b", "1914",true), new Respuesta("c", "1939",false),new Respuesta("d","1945",false)))));
        preguntas.add(new Pregunta(12,"¿Cuál fue el primer presidente de Estados Unidos?","Historia",new ArrayList<>(Arrays.asList(new Respuesta("a","Thomas Jefferson",false),new Respuesta("b", "George Washington",true), new Respuesta("c", "John Adams",false),new Respuesta("d","Abraham Lincoln",false)))));
        preguntas.add(new Pregunta(13,"¿Quién fue el líder de la Revolución Rusa de 1917?","Historia",new ArrayList<>(Arrays.asList(new Respuesta("a","Vladimir Lenin",true),new Respuesta("b", "Joseph Stalin",false), new Respuesta("c", "León Trotsky",false),new Respuesta("d","Nicolás II",false)))));
        preguntas.add(new Pregunta(14,"¿Cuál fue el nombre del primer hombre en pisar la Luna?","Historia",new ArrayList<>(Arrays.asList(new Respuesta(")","Alan Shepard",false),new Respuesta("b", "Buzz Aldrin",false), new Respuesta("c", "John Glenn",false),new Respuesta("d","Neil Armstrong",true)))));
        preguntas.add(new Pregunta(15,"¿Qué imperio fue gobernado por Justiniano I?","Historia",new ArrayList<>(Arrays.asList(new Respuesta("a","Imperio Romano",false),new Respuesta("b", "Imperio Persa",false), new Respuesta("c", "Imperio Bizantino",true),new Respuesta("d","Imperio Mongol",false)))));


        // Deportes
        preguntas.add(new Pregunta(16,"¿En qué deporte se utiliza un disco de goma vulcanizada?","Deportes",new ArrayList<>(Arrays.asList(new Respuesta("a","Béisbol",false),new Respuesta("b", "Hockey sobre hielo",true), new Respuesta("c", "Balonmano",false),new Respuesta("d","Voleibol",false)))));
        preguntas.add(new Pregunta(17,"¿Cuál de estos deportes no es parte del programa olímpico de verano?","Deportes",new ArrayList<>(Arrays.asList(new Respuesta("a","Baloncesto",false),new Respuesta("b", "Golf",false), new Respuesta("c", "Esgrima",false),new Respuesta("d","Esquí alpino",true)))));
        preguntas.add(new Pregunta(18,"¿Cuántos jugadores conforman un equipo de waterpolo en el agua durante un partido?","Deportes",new ArrayList<>(Arrays.asList(new Respuesta("a","7",false),new Respuesta("b", "5",false), new Respuesta("c", "8",false),new Respuesta("d","6",true)))));
        preguntas.add(new Pregunta(19,"¿En qué deporte se compite por la \"Copa Davis\"?","Deportes",new ArrayList<>(Arrays.asList(new Respuesta("a","Fútbol",false),new Respuesta("b", "Tenis",true), new Respuesta("c", "Baloncesto",false),new Respuesta("d","Golf",false)))));
        preguntas.add(new Pregunta(20,"¿En qué país se originó el deporte del judo?","Deportes",new ArrayList<>(Arrays.asList(new Respuesta("a","China",false),new Respuesta("b", "Japón",true), new Respuesta("c", "Brasil",false),new Respuesta("d","Corea del Sur",false)))));


        // Geografía
        preguntas.add(new Pregunta(21,"¿En qué continente se encuentra el desierto del Gobi?","Geografía",new ArrayList<>(Arrays.asList(new Respuesta("a","África",false),new Respuesta("b", "Asia",true), new Respuesta("c", "América del Norte",false),new Respuesta("d","Europa",false)))));
        preguntas.add(new Pregunta(22,"¿Cuál es la capital de Australia?","Geografía",new ArrayList<>(Arrays.asList(new Respuesta("a","Sídney",false),new Respuesta("b", "Canberra",true), new Respuesta("c", "Melbourne",false),new Respuesta("d","Brisbane",false)))));
        preguntas.add(new Pregunta(23,"¿Cuál de estos países no tiene frontera terrestre con Brasil?","Geografía",new ArrayList<>(Arrays.asList(new Respuesta("a","Uruguay",false),new Respuesta("b", "Perú",false), new Respuesta("c", "Argentina",false),new Respuesta("d","Colombia",true)))));
        preguntas.add(new Pregunta(24,"¿Cuál es la cadena montañosa más larga del mundo?","Geografía",new ArrayList<>(Arrays.asList(new Respuesta("a","Montañas Rocosas",false),new Respuesta("b", "Himalaya",false), new Respuesta("c", "Andes",true),new Respuesta("d","Alpes",false)))));
        preguntas.add(new Pregunta(25,"¿En qué país se encuentra el monte Kilimanjaro?","Geografía",new ArrayList<>(Arrays.asList(new Respuesta("a","Kenia",false),new Respuesta("b", "Tanzania",true), new Respuesta("c", "Sudáfrica",false),new Respuesta("d","Uganda",false)))));


        // Tecnología
        preguntas.add(new Pregunta(26,"¿Qué compañía desarrolló el primer microprocesador comercial en la década de 1970?","Tecnología",new ArrayList<>(Arrays.asList(new Respuesta("a","Intel",true),new Respuesta("b", "IBM",false), new Respuesta("c", "Microsoft",false),new Respuesta("d","Apple",false)))));
        preguntas.add(new Pregunta(27,"¿Cuál de los siguientes sistemas operativos fue desarrollado por Google principalmente para dispositivos móviles?","Tecnología",new ArrayList<>(Arrays.asList(new Respuesta("a","Windows",false),new Respuesta("b", "iOS",false), new Respuesta("c", "Android",true),new Respuesta("d","macOS",false)))));
        preguntas.add(new Pregunta(28,"¿Qué significa la sigla \"HTML\" en términos de tecnología web?","Tecnología",new ArrayList<>(Arrays.asList(new Respuesta("a","HyperText Markup Language",true),new Respuesta("b", "High-Tech Modern Language",false), new Respuesta("c", "Hyper Transfer Markup Language",false),new Respuesta("d","Home Tool Markup Language",false)))));
        preguntas.add(new Pregunta(29,"¿Qué protocolo se utiliza para enviar correos electrónicos?","Tecnología",new ArrayList<>(Arrays.asList(new Respuesta("a","HTTP",false),new Respuesta("b", "FTP",false), new Respuesta("c", "SMTP",true),new Respuesta("d","POP",false)))));
        preguntas.add(new Pregunta(30,"¿Cuál es el nombre del primer navegador web desarrollado por Tim Berners-Lee en 1990?","Tecnología",new ArrayList<>(Arrays.asList(new Respuesta("a","Mozilla",false),new Respuesta("b", "Internet Explorer",false), new Respuesta("c", "WorldWideWeb",true),new Respuesta("d","Netscape Navigator",false)))));


        crearPreguntas(preguntas);
        System.out.println("BBDD generada");

    }

    public static void crearPreguntas(ArrayList <Pregunta> preguntas) throws Exception{

        ODB odb = null;

        try{
            odb = ODBFactory.open("NeodatisTrivial.db");

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


    private static void borrarBBDD() throws Exception{

        ODB odb = null;

        try{
            odb = ODBFactory.open("NeodatisTrivial.db");
            Objects preguntas = odb.getObjects(Pregunta.class);

            for (Object pregunta:preguntas
                 ) {
                odb.delete(pregunta);
            }
        }finally{
            if(odb!=null){
                odb.close();
            }
        }


    }



}
