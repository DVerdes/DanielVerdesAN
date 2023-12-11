package org.example;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

import java.util.ArrayList;

public class UsuarioDAO {

    public static void crearInstancia(Usuario usuario) throws Exception{



        ODB odb = null;
        try{

            odb = ODBFactory.open("C:\\BBOO\\repaso.db");
            odb.store(usuario);
        }finally{
            if(odb!=null){
                odb.close();
            }

        }

    }

    public static void crearInstanciasRelacionadas() throws Exception{

        /*
        Pais pais = new Pais("España");

        Jugador jugador1 = new Jugador("Hugo","Fubol",38,pais);
        Jugador jugador2 = new Jugador("Juana","Baloncesto",22,pais);

        ODB odb = null;

        try{
            odb = ODBFactory.open("C:\\BBOO\\NeodatisDeportes.db");
            odb.store(jugador1);
            odb.store(jugador2);
        }finally{
            if(odb!=null){
                odb.close();
            }

        }
        */

    }

    public static ArrayList<Usuario> consulta() throws Exception{

        ODB odb = null;
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

        try{
            odb = ODBFactory.open("C:\\BBOO\\repaso.db");
            Objects jugadores = odb.getObjects(Usuario.class);

            while (jugadores.hasNext()){
                usuarios.add((Usuario) jugadores.next());
            }

            return usuarios;
        }finally{
            if(odb!=null){
                odb.close();
            }
        }
    }

    public static void consultaCondicion(int codigo) throws Exception{

        ODB odb = null;

        try{
            odb = ODBFactory.open("C:\\BBOO\\repaso.db");
            IQuery query = new CriteriaQuery(Usuario.class, Where.equal("codigo",codigo));
            Objects jugadores = odb.getObjects(query);

            while (jugadores.hasNext()){
                System.out.println(jugadores.next());
            }
        }finally{
            if(odb!=null){
                odb.close();
            }
        }

    }

    public void consultaCondicionRelacion() throws Exception{

        /**
        ODB odb = null;

        try{
            odb = ODBFactory.open("C:\\BBOO\\NeodatisDeportes.db");
            IQuery query = new CriteriaQuery(Jugador.class, Where.equal("pais.nombre","España"));
            Objects jugadores = odb.getObjects(query);

            while (jugadores.hasNext()){
                System.out.println(jugadores.next());
            }
        }finally{
            if(odb!=null){
                odb.close();
            }
        }
    */


    }

    public static void borrar(int codigo) throws Exception{

        ODB odb = null;

        try{
            odb = ODBFactory.open("C:\\BBOO\\repaso.db");
            IQuery query = new CriteriaQuery(Usuario.class, Where.equal("codigo",codigo));

            Objects jugadores = odb.getObjects(query);
            Usuario jugador = (Usuario) jugadores.getFirst();
            odb.delete(jugador);


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
    public static void borrarBBDD() throws Exception{

        ODB odb = null;

        try{
            odb = ODBFactory.open("C:\\BBOO\\repaso.db");
            Objects preguntas = odb.getObjects(Usuario.class);

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
