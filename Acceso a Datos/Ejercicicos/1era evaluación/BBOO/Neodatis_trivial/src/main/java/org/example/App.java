package org.example;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception {

        Scanner scanner = new Scanner(System.in);


        Partida partida = new Partida(new ArrayList<Jugador>());
        int numeroJugadores = 0;
        String letraCorrecta = "";
        int puntosVictoria = 3;
        int contadorGanadores = 0;
        String nombreGanador = "";
        String respuestaJugador = "";
        int contadorRondas = 0;

        System.out.println("Bienvenido al trivial!");
        System.out.println("Introduzca el número de jugadores");
        numeroJugadores = scanner.nextInt();

        for(int i = 1; i<numeroJugadores+1; i++){
            System.out.println("Jugador "+i+", introduzca su nombre: ");
            partida.getJugadores().add(new Jugador(scanner.next(),0));
        }

        System.out.println(partida.toString());

        while (true){
            contadorRondas++;
            System.out.println("Ronda "+contadorRondas+":");
            // Bucle jugadores
            for(int i = 0; i<partida.getJugadores().size(); i++){
                System.out.println("Turno de "+partida.getJugadores().get(i).getNombre()+": ");
                Pregunta pregunta = consultarPregunta();
                System.out.println("Categoría: "+pregunta.getTema());
                System.out.println(pregunta.getEnunciado());
                for(int j = 0; j<pregunta.getRespuestas().size(); j++){
                    System.out.println(pregunta.getRespuestas().get(j).getLetra()+") "+pregunta.getRespuestas().get(j).getContenido());
                    if(pregunta.getRespuestas().get(j).isEsCorrecta()){
                        letraCorrecta = pregunta.getRespuestas().get(j).getLetra();
                    }
                }
                respuestaJugador = scanner.next();
                if(respuestaJugador.equals(letraCorrecta)){
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

    public static Pregunta consultarPregunta() throws Exception{

        ODB odb = null;
        ArrayList <Pregunta> coleccionPreguntas = new ArrayList<Pregunta>();

        try{
            odb = ODBFactory.open("C:\\BBOO\\NeodatisTrivial.db");

            IQuery query = new CriteriaQuery(Pregunta.class, Where.equal("tema",temaAleatorio()));
            Objects preguntas = odb.getObjects(query);

            while (preguntas.hasNext()){
                coleccionPreguntas.add((Pregunta) preguntas.next());
            }

            return coleccionPreguntas.get((int) (Math.random() * (coleccionPreguntas.size() - 0)) + 0);

        }finally{
            if(odb!=null){
                odb.close();
            }
        }

    }


    public static String temaAleatorio(){
        int random = (int) (Math.random() * (3 - 1)) + 1;
        switch (random){
            case 1:
                return "Ciencia";
            case 2:
                return "Cine";
            case 3:
                return "Historia";

        }

        return null;
    }

}
