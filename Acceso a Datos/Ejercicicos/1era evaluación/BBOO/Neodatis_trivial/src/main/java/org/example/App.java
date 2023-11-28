package org.example;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase principal con bucle jugable
 *
 */
public class App 
{

    static ArrayList <Pregunta> preguntasEliminadas = new ArrayList<Pregunta>();

    public static void main( String[] args ) throws Exception {

        Scanner scanner = new Scanner(System.in);


        Partida partida = new Partida(new ArrayList<Jugador>());
        ArrayList <Pregunta> preguntasConsultadas = consultarPreguntas();


        int numeroJugadores = 0;
        String letraCorrecta = "";
        int puntosVictoria = 5;
        int contadorGanadores = 0;
        String nombreGanador = "";
        String respuestaJugador = "";
        int contadorRondas = 0;

        System.out.println("Bienvenido al trivial!");
        System.out.println("Introduzca el número de jugadores");
        numeroJugadores = pedirNumero(6);

        for(int i = 1; i<numeroJugadores+1; i++){
            System.out.println("Jugador "+i+", introduzca su nombre: ");
            partida.getJugadores().add(new Jugador(pedirNombre(10),0));
        }

        System.out.println(partida.toString());

        while (true){
            contadorRondas++;
            System.out.println("Ronda "+contadorRondas+":");
            // Bucle jugadores
            for(int i = 0; i<partida.getJugadores().size(); i++){
                System.out.println("Turno de "+partida.getJugadores().get(i).getNombre()+": ");
                Pregunta pregunta = preguntaAleatoria(preguntasConsultadas);
                preguntasEliminadas.add(pregunta);
                preguntasConsultadas.remove(pregunta);
                System.out.println("Categoría: "+pregunta.getTema());
                System.out.println(pregunta.getEnunciado());
                for(int j = 0; j<pregunta.getRespuestas().size(); j++){
                    System.out.println(pregunta.getRespuestas().get(j).getLetra()+") "+pregunta.getRespuestas().get(j).getContenido());
                    if(pregunta.getRespuestas().get(j).isEsCorrecta()){
                        letraCorrecta = pregunta.getRespuestas().get(j).getLetra();
                    }
                }

                if(pedirOpcion().equals(letraCorrecta)){
                    System.out.println("Respuesta correcta!");
                    System.out.println(partida.getJugadores().get(i).getNombre()+" gana un punto");
                    partida.getJugadores().get(i).setPuntos(partida.getJugadores().get(i).getPuntos()+1);
                }else{
                    System.out.println("Respuesta incorrecta");
                }



            }

            // Control de puntuaciones
            System.out.println("Puntuaciones: ");
            for(int k = 0; k<partida.getJugadores().size(); k++){
                System.out.println(partida.getJugadores().get(k).getNombre()+": "+partida.getJugadores().get(k).getPuntos()+" puntos");
                if(partida.getJugadores().get(k).getPuntos()>=puntosVictoria){
                    contadorGanadores++;
                    nombreGanador = partida.getJugadores().get(k).getNombre();
                }
            }

            if(contadorGanadores==1){
                System.out.println("GANA "+nombreGanador);
                break;
            }else if(contadorGanadores>1){
                System.out.println("Desempate!");
                puntosVictoria++;
            }
            contadorGanadores = 0;



        }


        System.out.println("Fin partida");


    }

    /**
     * Saca pregunta aleatoria (también repone preguntas si se han agotado)
     * @param preguntasConsultadas listado de preguntas actual
     * @return pregunta aleatoria
     */
    private static Pregunta preguntaAleatoria(ArrayList<Pregunta> preguntasConsultadas) {
        if(preguntasConsultadas.size()==0){
            System.out.println("Reponiendo preguntas");
            preguntasConsultadas = preguntasEliminadas;
        }
        return preguntasConsultadas.get((int) (Math.random() * (preguntasConsultadas.size() - 0)) + 0);
    }


    /**
     * Consulta listado de preguntas de la BBDD
     * @return lista de preguntas completo
     * @throws Exception
     */
    public static ArrayList<Pregunta> consultarPreguntas() throws Exception{
        ODB odb = null;
        ArrayList <Pregunta> coleccionPreguntas = new ArrayList<Pregunta>();
        try{
            odb = ODBFactory.open("NeodatisTrivial.db");
            Objects preguntas = odb.getObjects(Pregunta.class);
            while (preguntas.hasNext()){
                coleccionPreguntas.add((Pregunta) preguntas.next());
            }
            return coleccionPreguntas;
        }finally{
            if(odb!=null){
                odb.close();
            }
        }
    }


    /**
     * Pide un número al jugador,
     *  realiza manejo de excepciones
     * @param limite superior del número
     * @return número introducido por jugador
     */
    public static int pedirNumero(int limite) {
        int numero = 0;
        boolean comprobacion = false;
        do {
            Scanner scanner = new Scanner(System.in);
            try {
                do {
                    numero = Integer.parseInt(scanner.next());
                    if (numero >= limite || numero <= 0) {
                        System.out.println("Por favor, introduzca un valor entre 1 y 6");
                    }
                } while (numero >= limite || numero <= 0);
                comprobacion = true;
            } catch (Exception e) {
                System.out.println("Por favor, introduzca un valor correcto");
                comprobacion = false;
            }
        } while (!comprobacion);
        return numero;
    }


    /**
     * Pide nombre al jugador
     * @param longitudMaxima longitud máxima del nombre
     * @return nombre comprobado
     */
    public static String pedirNombre(int longitudMaxima) {
        Scanner scanner = new Scanner(System.in);
        String nombre = "";

        do {
            nombre = scanner.nextLine();
            if (nombre.equals("")) {
                System.out.println("Por favor, escriba un nombre");
            } else if (nombre.length() > longitudMaxima) {
                System.out.println("Por favor, escriba un nombre más corto");
            }

        } while (nombre.equals("") || nombre.length() > longitudMaxima);

        return nombre;
    }

    /**
     * Pide opción de respuesta al jugador y comprueba su validez
     * @return opción controlada
     */
    public static String pedirOpcion() {
        Scanner scanner = new Scanner(System.in);
        String opcion = "";
        do {
            opcion = scanner.nextLine().toLowerCase();
            if (!opcion.equals("a") && !opcion.equals("b") && !opcion.equals("c") && !opcion.equals("d")) {
                System.out.println("Por favor, elija una opción correcta");
            }
        }while (!opcion.equals("a") && !opcion.equals("b") && !opcion.equals("c") && !opcion.equals("d")) ;
            return opcion;
        }
}
