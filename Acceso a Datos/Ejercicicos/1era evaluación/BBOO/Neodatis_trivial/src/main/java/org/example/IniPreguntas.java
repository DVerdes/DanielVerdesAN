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
        preguntas.add(new Pregunta(41, "¿Cuál es la fórmula química del agua?", "Ciencia",
                new ArrayList<>(Arrays.asList(
                        new Respuesta("a", "H2O2", false),
                        new Respuesta("b", "HO", false),
                        new Respuesta("c", "H2O", true),
                        new Respuesta("d", "O2", false)
                ))));
        preguntas.add(new Pregunta(42, "¿Cuál es el hueso más largo del cuerpo humano?", "Ciencia",
                new ArrayList<>(Arrays.asList(
                        new Respuesta("a", "Húmero", false),
                        new Respuesta("b", "Fémur", true),
                        new Respuesta("c", "Tibia", false),
                        new Respuesta("d", "Radio", false)
                ))));
        preguntas.add(new Pregunta(43, "¿Cuál es la unidad de medida de la corriente eléctrica?", "Ciencia",
                new ArrayList<>(Arrays.asList(
                        new Respuesta("a", "Ohm", false),
                        new Respuesta("b", "Ampere", true),
                        new Respuesta("c", "Volt", false),
                        new Respuesta("d", "Watt", false)
                ))));
        preguntas.add(new Pregunta(44, "¿Qué gas es necesario para la combustión?", "Ciencia",
                new ArrayList<>(Arrays.asList(
                        new Respuesta("a", "Nitrógeno", false),
                        new Respuesta("b", "Dióxido de carbono", false),
                        new Respuesta("c", "Oxígeno", true),
                        new Respuesta("d", "Hidrógeno", false)
                ))));
        preguntas.add(new Pregunta(45, "¿Cuál es el proceso de conversión de un gas a un líquido?", "Ciencia",
                new ArrayList<>(Arrays.asList(
                        new Respuesta("a", "Fusión", false),
                        new Respuesta("b", "Solidificación", false),
                        new Respuesta("c", "Condensación", true),
                        new Respuesta("d", "Evaporación", false)
                ))));

        // Cine
        preguntas.add(new Pregunta(6,"¿Quién dirigió la película \"El Padrino\"?","Cine",new ArrayList<>(Arrays.asList(new Respuesta("a","Martin Scorsese",false),new Respuesta("b","Francis Ford Coppola",true), new Respuesta("c","Quentin Tarantino",false),new Respuesta("d","Steven Spielberg",false)))));
        preguntas.add(new Pregunta(7,"¿Cuál es la película ganadora del Oscar a la Mejor Película en 2020?","Cine",new ArrayList<>(Arrays.asList(new Respuesta("a","1917",false),new Respuesta("b", "Parásitos",true), new Respuesta("c", "Green Book",false),new Respuesta("d","Nomadland",false)))));
        preguntas.add(new Pregunta(8,"¿Cuál es el título de la primera película, por orden de estreno, de la saga \"Star Wars\"?","Cine",new ArrayList<>(Arrays.asList(new Respuesta("a","El Despertar de la Fuerza",false),new Respuesta("b", "La Amenaza Fantasma",false), new Respuesta("c", "Una Nueva Esperanza",true),new Respuesta("d","El Imperio Contraataca",false)))));
        preguntas.add(new Pregunta(9,"¿Quién interpretó a Batman en la trilogía dirigida por Christopher Nolan?","Cine",new ArrayList<>(Arrays.asList(new Respuesta("a","Christian Bale",true),new Respuesta("b", "Ben Affleck",false), new Respuesta("c", "George Clooney",false),new Respuesta("d","Michael Keaton",false)))));
        preguntas.add(new Pregunta(10,"¿Quién dirigió la película \"El Resplandor\"?","Cine",new ArrayList<>(Arrays.asList(new Respuesta("a","Stanley Kubrick",true),new Respuesta("b", "Alfred Hitchcock",false), new Respuesta("c", "Tim Burton",false),new Respuesta("d","David Lynch",false)))));
        preguntas.add(new Pregunta(51, "¿Cuál actor interpretó a Tony Stark en la saga de películas de Marvel conocida como 'Iron Man'?", "Cine",
                new ArrayList<>(Arrays.asList(
                        new Respuesta("a", "Robert Downey Jr.", true),
                        new Respuesta("b", "Chris Hemsworth", false),
                        new Respuesta("c", "Chris Evans", false),
                        new Respuesta("d", "Mark Ruffalo", false)
                ))));
        preguntas.add(new Pregunta(52, "¿Cuál fue la primera película animada producida por Pixar?", "Cine",
                new ArrayList<>(Arrays.asList(
                        new Respuesta("a", "Toy Story", true),
                        new Respuesta("b", "Monsters, Inc.", false),
                        new Respuesta("c", "Buscando a Nemo", false),
                        new Respuesta("d", "Los Increíbles", false)
                ))));
        preguntas.add(new Pregunta(53, "¿Cuál es el nombre del director de la película 'El Resplandor'?", "Cine",
                new ArrayList<>(Arrays.asList(
                        new Respuesta("a", "Alfred Hitchcock", false),
                        new Respuesta("b", "Stanley Kubrick", true),
                        new Respuesta("c", "Quentin Tarantino", false),
                        new Respuesta("d", "Martin Scorsese", false)
                ))));
        preguntas.add(new Pregunta(54, "¿Quién dirigió la película 'Interestelar'?", "Cine",
                new ArrayList<>(Arrays.asList(
                        new Respuesta("a", "Steven Spielberg", false),
                        new Respuesta("b", "Christopher Nolan", true),
                        new Respuesta("c", "James Cameron", false),
                        new Respuesta("d", "Ridley Scott", false)
                ))));
        preguntas.add(new Pregunta(55, "¿Cuál es el título original de la película 'El Rey León' de Disney?", "Cine",
                new ArrayList<>(Arrays.asList(
                        new Respuesta("a", "The Lion King", true),
                        new Respuesta("b", "Simba's Pride", false),
                        new Respuesta("c", "Circle of Life", false),
                        new Respuesta("d", "Pride Rock", false)
                ))));

        // Historia
        preguntas.add(new Pregunta(11,"¿En qué año comenzó la Primera Guerra Mundial?","Historia",new ArrayList<>(Arrays.asList(new Respuesta("a","1918",false),new Respuesta("b", "1914",true), new Respuesta("c", "1939",false),new Respuesta("d","1945",false)))));
        preguntas.add(new Pregunta(12,"¿Cuál fue el primer presidente de Estados Unidos?","Historia",new ArrayList<>(Arrays.asList(new Respuesta("a","Thomas Jefferson",false),new Respuesta("b", "George Washington",true), new Respuesta("c", "John Adams",false),new Respuesta("d","Abraham Lincoln",false)))));
        preguntas.add(new Pregunta(13,"¿Quién fue el líder de la Revolución Rusa de 1917?","Historia",new ArrayList<>(Arrays.asList(new Respuesta("a","Vladimir Lenin",true),new Respuesta("b", "Joseph Stalin",false), new Respuesta("c", "León Trotsky",false),new Respuesta("d","Nicolás II",false)))));
        preguntas.add(new Pregunta(14,"¿Cuál fue el nombre del primer hombre en pisar la Luna?","Historia",new ArrayList<>(Arrays.asList(new Respuesta(")","Alan Shepard",false),new Respuesta("b", "Buzz Aldrin",false), new Respuesta("c", "John Glenn",false),new Respuesta("d","Neil Armstrong",true)))));
        preguntas.add(new Pregunta(15,"¿Qué imperio fue gobernado por Justiniano I?","Historia",new ArrayList<>(Arrays.asList(new Respuesta("a","Imperio Romano",false),new Respuesta("b", "Imperio Persa",false), new Respuesta("c", "Imperio Bizantino",true),new Respuesta("d","Imperio Mongol",false)))));
        preguntas.add(new Pregunta(66, "¿Cuál fue la primera civilización mesopotámica conocida por su código legal?", "Historia",
                new ArrayList<>(Arrays.asList(
                        new Respuesta("a", "Asiria", false),
                        new Respuesta("b", "Babilonia", true),
                        new Respuesta("c", "Sumeria", false),
                        new Respuesta("d", "Acadia", false)
                ))));
        preguntas.add(new Pregunta(67, "¿En qué año tuvo lugar la Revolución Francesa?", "Historia",
                new ArrayList<>(Arrays.asList(
                        new Respuesta("a", "1776", false),
                        new Respuesta("b", "1789", true),
                        new Respuesta("c", "1804", false),
                        new Respuesta("d", "1812", false)
                ))));
        preguntas.add(new Pregunta(68, "¿Quién fue el primer emperador romano?", "Historia",
                new ArrayList<>(Arrays.asList(
                        new Respuesta("a", "Julio César", false),
                        new Respuesta("b", "Cicerón", false),
                        new Respuesta("c", "Augusto", true),
                        new Respuesta("d", "Marco Antonio", false)
                ))));
        preguntas.add(new Pregunta(69, "¿Cuál fue el período de gobierno de Napoleón Bonaparte en Francia?", "Historia",
                new ArrayList<>(Arrays.asList(
                        new Respuesta("a", "El Imperio Napoleónico", true),
                        new Respuesta("b", "La Restauración Francesa", false),
                        new Respuesta("c", "La Revolución Francesa", false),
                        new Respuesta("d", "La Monarquía Constitucional", false)
                ))));
        preguntas.add(new Pregunta(70, "¿En qué año se firmó el Tratado de Versalles, poniendo fin a la Primera Guerra Mundial?", "Historia",
                new ArrayList<>(Arrays.asList(
                        new Respuesta("a", "1917", false),
                        new Respuesta("b", "1918", false),
                        new Respuesta("c", "1919", true),
                        new Respuesta("d", "1920", false)
                ))));


        // Deportes
        preguntas.add(new Pregunta(16,"¿En qué deporte se utiliza un disco de goma vulcanizada?","Deportes",new ArrayList<>(Arrays.asList(new Respuesta("a","Béisbol",false),new Respuesta("b", "Hockey sobre hielo",true), new Respuesta("c", "Balonmano",false),new Respuesta("d","Voleibol",false)))));
        preguntas.add(new Pregunta(17,"¿Cuál de estos deportes no es parte del programa olímpico de verano?","Deportes",new ArrayList<>(Arrays.asList(new Respuesta("a","Baloncesto",false),new Respuesta("b", "Golf",false), new Respuesta("c", "Esgrima",false),new Respuesta("d","Esquí alpino",true)))));
        preguntas.add(new Pregunta(18,"¿Cuántos jugadores conforman un equipo de waterpolo en el agua durante un partido?","Deportes",new ArrayList<>(Arrays.asList(new Respuesta("a","7",false),new Respuesta("b", "5",false), new Respuesta("c", "8",false),new Respuesta("d","6",true)))));
        preguntas.add(new Pregunta(19,"¿En qué deporte se compite por la \"Copa Davis\"?","Deportes",new ArrayList<>(Arrays.asList(new Respuesta("a","Fútbol",false),new Respuesta("b", "Tenis",true), new Respuesta("c", "Baloncesto",false),new Respuesta("d","Golf",false)))));
        preguntas.add(new Pregunta(20,"¿En qué país se originó el deporte del judo?","Deportes",new ArrayList<>(Arrays.asList(new Respuesta("a","China",false),new Respuesta("b", "Japón",true), new Respuesta("c", "Brasil",false),new Respuesta("d","Corea del Sur",false)))));
        preguntas.add(new Pregunta(56, "¿En qué deporte se utiliza una raqueta para golpear una pelota sobre una red?", "Deportes",
                new ArrayList<>(Arrays.asList(
                        new Respuesta("a", "Tenis", true),
                        new Respuesta("b", "Béisbol", false),
                        new Respuesta("c", "Golf", false),
                        new Respuesta("d", "Baloncesto", false)
                ))));
        preguntas.add(new Pregunta(57, "¿Cuál es el equipo de fútbol más exitoso en la historia de la Liga de Campeones de la UEFA?", "Deportes",
                new ArrayList<>(Arrays.asList(
                        new Respuesta("a", "Barcelona", false),
                        new Respuesta("b", "Real Madrid", true),
                        new Respuesta("c", "Bayern Múnich", false),
                        new Respuesta("d", "Liverpool", false)
                ))));
        preguntas.add(new Pregunta(58, "¿En qué deporte se utiliza un octógono como área de combate?", "Deportes",
                new ArrayList<>(Arrays.asList(
                        new Respuesta("a", "Baloncesto", false),
                        new Respuesta("b", "Atletismo", false),
                        new Respuesta("c", "MMA (Artes Marciales Mixtas)", true),
                        new Respuesta("d", "Esgrima", false)
                ))));
        preguntas.add(new Pregunta(59, "¿Cuál es el evento deportivo más grande del automovilismo?", "Deportes",
                new ArrayList<>(Arrays.asList(
                        new Respuesta("a", "Rally Dakar", false),
                        new Respuesta("b", "24 Horas de Le Mans", false),
                        new Respuesta("c", "Rally de Carballo", false),
                        new Respuesta("d", "Fórmula 1 (Gran Premio de Mónaco)", true)
                ))));
        preguntas.add(new Pregunta(60, "¿Qué jugador de baloncesto es conocido como 'The King'?", "Deportes",
                new ArrayList<>(Arrays.asList(
                        new Respuesta("a", "Stephen Curry", false),
                        new Respuesta("b", "LeBron James", true),
                        new Respuesta("c", "Kevin Durant", false),
                        new Respuesta("d", "Kobe Bryant", false)
                ))));

        // Geografía
        preguntas.add(new Pregunta(21,"¿En qué continente se encuentra el desierto del Gobi?","Geografía",new ArrayList<>(Arrays.asList(new Respuesta("a","África",false),new Respuesta("b", "Asia",true), new Respuesta("c", "América del Norte",false),new Respuesta("d","Europa",false)))));
        preguntas.add(new Pregunta(22,"¿Cuál es la capital de Australia?","Geografía",new ArrayList<>(Arrays.asList(new Respuesta("a","Sídney",false),new Respuesta("b", "Canberra",true), new Respuesta("c", "Melbourne",false),new Respuesta("d","Brisbane",false)))));
        preguntas.add(new Pregunta(23,"¿Cuál de estos países no tiene frontera terrestre con Brasil?","Geografía",new ArrayList<>(Arrays.asList(new Respuesta("a","Uruguay",false),new Respuesta("b", "Perú",false), new Respuesta("c", "Argentina",false),new Respuesta("d","Colombia",true)))));
        preguntas.add(new Pregunta(24,"¿Cuál es la cadena montañosa más larga del mundo?","Geografía",new ArrayList<>(Arrays.asList(new Respuesta("a","Montañas Rocosas",false),new Respuesta("b", "Himalaya",false), new Respuesta("c", "Andes",true),new Respuesta("d","Alpes",false)))));
        preguntas.add(new Pregunta(25,"¿En qué país se encuentra el monte Kilimanjaro?","Geografía",new ArrayList<>(Arrays.asList(new Respuesta("a","Kenia",false),new Respuesta("b", "Tanzania",true), new Respuesta("c", "Sudáfrica",false),new Respuesta("d","Uganda",false)))));
        preguntas.add(new Pregunta(46, "¿Cuál es la capital de EEUU?", "Geografía",
                new ArrayList<>(Arrays.asList(
                        new Respuesta("a", "Los Ángeles", false),
                        new Respuesta("b", "Seattle", false),
                        new Respuesta("c", "Washington DC", true),
                        new Respuesta("d", "Londres", false)
                ))));
        preguntas.add(new Pregunta(47, "¿Cuál es el río más largo de América del Norte?", "Geografía",
                new ArrayList<>(Arrays.asList(
                        new Respuesta("a", "Río Misisipi", false),
                        new Respuesta("b", "Río Mackenzie", true),
                        new Respuesta("c", "Río Colorado", false),
                        new Respuesta("d", "Río Columbia", false)
                ))));
        preguntas.add(new Pregunta(48, "¿Cuál es la montaña más alta de Europa?", "Geografía",
                new ArrayList<>(Arrays.asList(
                        new Respuesta("a", "Monte Elbrús", true),
                        new Respuesta("b", "Monte Everest", false),
                        new Respuesta("c", "Monte Blanc", false),
                        new Respuesta("d", "Monte Rosa", false)
                ))));
        preguntas.add(new Pregunta(49, "¿Cuál es el país más pequeño del mundo?", "Geografía",
                new ArrayList<>(Arrays.asList(
                        new Respuesta("a", "Mónaco", false),
                        new Respuesta("b", "Vaticano", true),
                        new Respuesta("c", "San Marino", false),
                        new Respuesta("d", "Nauru", false)
                ))));
        preguntas.add(new Pregunta(50, "¿Cuál es el desierto más grande del mundo?", "Geografía",
                new ArrayList<>(Arrays.asList(
                        new Respuesta("a", "Desierto del Sahara", true),
                        new Respuesta("b", "Desierto de Gobi", false),
                        new Respuesta("c", "Desierto de Atacama", false),
                        new Respuesta("d", "Desierto de Kalahari", false)
                ))));

        // Tecnología
        preguntas.add(new Pregunta(26,"¿Qué compañía desarrolló el primer microprocesador comercial en la década de 1970?","Tecnología",new ArrayList<>(Arrays.asList(new Respuesta("a","Intel",true),new Respuesta("b", "IBM",false), new Respuesta("c", "Microsoft",false),new Respuesta("d","Apple",false)))));
        preguntas.add(new Pregunta(27,"¿Cuál de los siguientes sistemas operativos fue desarrollado por Google principalmente para dispositivos móviles?","Tecnología",new ArrayList<>(Arrays.asList(new Respuesta("a","Windows",false),new Respuesta("b", "iOS",false), new Respuesta("c", "Android",true),new Respuesta("d","macOS",false)))));
        preguntas.add(new Pregunta(28,"¿Qué significa la sigla \"HTML\" en términos de tecnología web?","Tecnología",new ArrayList<>(Arrays.asList(new Respuesta("a","HyperText Markup Language",true),new Respuesta("b", "High-Tech Modern Language",false), new Respuesta("c", "Hyper Transfer Markup Language",false),new Respuesta("d","Home Tool Markup Language",false)))));
        preguntas.add(new Pregunta(29,"¿Qué protocolo se utiliza para enviar correos electrónicos?","Tecnología",new ArrayList<>(Arrays.asList(new Respuesta("a","HTTP",false),new Respuesta("b", "FTP",false), new Respuesta("c", "SMTP",true),new Respuesta("d","POP",false)))));
        preguntas.add(new Pregunta(30,"¿Cuál es el nombre del primer navegador web desarrollado por Tim Berners-Lee en 1990?","Tecnología",new ArrayList<>(Arrays.asList(new Respuesta("a","Mozilla",false),new Respuesta("b", "Internet Explorer",false), new Respuesta("c", "WorldWideWeb",true),new Respuesta("d","Netscape Navigator",false)))));
        preguntas.add(new Pregunta(61, "¿Qué significa la sigla 'HTML' en el contexto de desarrollo web?", "Tecnología",
                new ArrayList<>(Arrays.asList(
                        new Respuesta("a", "Hyper Text Markup Language", true),
                        new Respuesta("b", "Hyperlinks and Text Markup Language", false),
                        new Respuesta("c", "Home Tool Markup Language", false),
                        new Respuesta("d", "Hyper Transfer Mode Language", false)
                ))));
        preguntas.add(new Pregunta(62, "¿Cuál es el sistema operativo desarrollado por Apple para sus dispositivos móviles?", "Tecnología",
                new ArrayList<>(Arrays.asList(
                        new Respuesta("a", "Windows", false),
                        new Respuesta("b", "iOS", true),
                        new Respuesta("c", "Android", false),
                        new Respuesta("d", "Linux", false)
                ))));
        preguntas.add(new Pregunta(63, "¿Cuál es la tecnología inalámbrica que permite la transferencia de datos a corta distancia?", "Tecnología",
                new ArrayList<>(Arrays.asList(
                        new Respuesta("a", "Bluetooth", true),
                        new Respuesta("b", "Wi-Fi", false),
                        new Respuesta("c", "NFC (Near Field Communication)", false),
                        new Respuesta("d", "RFID (Radio-Frequency Identification)", false)
                ))));
        preguntas.add(new Pregunta(64, "¿Qué siglas representan a la Unidad Central de Procesamiento en computación?", "Tecnología",
                new ArrayList<>(Arrays.asList(
                        new Respuesta("a", "UCA (Unidad de Cálculo Avanzado)", false),
                        new Respuesta("b", "CPU (Central Processing Unit)", true),
                        new Respuesta("c", "UCP (Unidad de Control de Procesos)", false),
                        new Respuesta("d", "UCD (Unidad de Control de Datos)", false)
                ))));
        preguntas.add(new Pregunta(65, "¿Qué compañía desarrolló el lenguaje de programación 'JavaScript'?", "Tecnología",
                new ArrayList<>(Arrays.asList(
                        new Respuesta("a", "Microsoft", false),
                        new Respuesta("b", "Google", false),
                        new Respuesta("c", "Netscape", true),
                        new Respuesta("d", "IBM", false)
                ))));

        //Videojuegos
        preguntas.add(new Pregunta(31, "¿En qué año se lanzó el videojuego 'The Legend of Zelda: Ocarina of Time'?", "Videojuegos",
                new ArrayList<>(Arrays.asList(
                        new Respuesta("a", "1998", true),
                        new Respuesta("b", "1999", false),
                        new Respuesta("c", "1997", false),
                        new Respuesta("d", "1996", false)
                ))));
        preguntas.add(new Pregunta(32, "¿Cuál es el nombre del fontanero protagonista de la serie de videojuegos de Nintendo?", "Videojuegos",
                new ArrayList<>(Arrays.asList(
                        new Respuesta("a", "Luigi", false),
                        new Respuesta("b", "Mario", true),
                        new Respuesta("c", "Yoshi", false),
                        new Respuesta("d", "Wario", false)
                ))));
        preguntas.add(new Pregunta(33, "¿Cuál es el estudio desarrollador del videojuego 'The Witcher 3: Wild Hunt'?", "Videojuegos",
                new ArrayList<>(Arrays.asList(
                        new Respuesta("a", "Bioware", false),
                        new Respuesta("b", "CD Projekt Red", true),
                        new Respuesta("c", "Bethesda Game Studios", false),
                        new Respuesta("d", "Rockstar Games", false)
                ))));
        preguntas.add(new Pregunta(34, "¿Cuál es el nombre del protagonista en el videojuego 'The Legend of Zelda: Breath of the Wild'?", "Videojuegos",
                new ArrayList<>(Arrays.asList(
                        new Respuesta("a", "Link", true),
                        new Respuesta("b", "Ganondorf", false),
                        new Respuesta("c", "Zelda", false),
                        new Respuesta("d", "Impa", false)
                ))));
        preguntas.add(new Pregunta(35, "¿Cuál es el juego que popularizó el término 'battle royale'?", "Videojuegos",
                new ArrayList<>(Arrays.asList(
                        new Respuesta("a", "Fortnite", false),
                        new Respuesta("b", "PUBG (PlayerUnknown's Battlegrounds)", true),
                        new Respuesta("c", "Apex Legends", false),
                        new Respuesta("d", "Call of Duty: Warzone", false)
                ))));

        crearPreguntas(preguntas);
        System.out.println("BBDD generada");

    }


    /**
     * Crea BBDD y la puebla con preguntas
     * @param preguntas listado de preguntas que se van a añadir a la BBDD
     * @throws Exception
     */
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


    /**
     * Borra preguntas cargadas en BBDD
     * @throws Exception
     */
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
