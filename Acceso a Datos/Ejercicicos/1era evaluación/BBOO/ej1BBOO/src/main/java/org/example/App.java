package org.example;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception {

        crearInstancia();
        crearInstanciasRelacionadas();
        consulta();
        consultaCondicion();

    }


    public static void crearInstancia() throws Exception{

        Pais pais = new Pais("España");

        ODB odb = null;
        try{

            odb = ODBFactory.open("C:\\BBOO\\NeodatisDeportes.db");
            odb.store(pais);
        }finally{
            if(odb!=null){
                odb.close();
            }

        }

    }

    public static void crearInstanciasRelacionadas() throws Exception{

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
    }

    public static void consulta() throws Exception{

        ODB odb = null;

        try{
            odb = ODBFactory.open("C:\\BBOO\\NeodatisDeportes.db");
            Objects jugadores = odb.getObjects(Jugador.class);

            while (jugadores.hasNext()){
                System.out.println(jugadores.next());
            }
        }finally{
            if(odb!=null){
                odb.close();
            }
        }
    }

    public static void consultaCondicion() throws Exception{

        ODB odb = null;

        try{
            odb = ODBFactory.open("C:\\BBOO\\NeodatisDeportes.db");
            IQuery query = new CriteriaQuery(Jugador.class, Where.equal("nombre","Hugo"));
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



    }

    private static void borrar() throws Exception{

        ODB odb = null;

        try{
            odb = ODBFactory.open("C:\\BBOO\\NeodatisDeportes.db");
            IQuery query = new CriteriaQuery(Jugador.class, Where.equal("nombre","Hugo"));

            Objects jugadores = odb.getObjects(query);
            Jugador jugador = (Jugador) jugadores.getFirst();
            odb.delete(jugador);


        }finally{
            if(odb!=null){
                odb.close();
            }
        }


    }

}
