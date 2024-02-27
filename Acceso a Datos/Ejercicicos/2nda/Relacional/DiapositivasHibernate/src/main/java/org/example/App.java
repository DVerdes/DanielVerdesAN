package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;


/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args )
    {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();

        Timestamp  ts= new Timestamp(System.currentTimeMillis());
        /*
        Tarea tarea1 = new Tarea(1,"Tarea 1","Prueba 1",ts,"Pendiente");
        Tarea tarea2 = new Tarea(2,"Tarea 2","Prueba 2",ts,"En proceso");


       Transaction transaction = session.beginTransaction();
        session.save(tarea1);
        session.save(tarea2);
        transaction.commit();



        Set <Subtarea> subtareaSet = new HashSet<Subtarea>();
        subtareaSet.add(new Subtarea("st1"));
        subtareaSet.add(new Subtarea("st2"));
        Tarea st1 = new Tarea("Tarea de subtarea","Prueba sub",ts,"Completada",subtareaSet);


        TareaDAO.crearTarea(st1);

        */


        SubtareaDAO.crearSubtarea(new Subtarea(1,"a ver si va"));
        SubtareaDAO.leerSubtarea(6);

        Tarea t = TareaDAO.leerTarea(1);
        System.out.println(t.toString());
        for(Subtarea st : t.getSubtareas()) System.out.println(st.toString());


        //TareaDAO.eliminarTarea(1);

        //TareaDAO.leerTarea(1);








//TareaDAO.crearTarea(new Tarea(1,"Tarea 3","Prueba 3",ts,"Completada"));
        /*
        TareaDAO.leerTarea(2);
        TareaDAO.modificarTarea(1);
        //TareaDAO.eliminarTarea(5);
        TareaDAO.consultarTareasSQL();
        TareaDAO.consultarTareasHQL();
        SubtareaDAO.crearSubtarea(new Subtarea(1,1,"st1",st1));
        SubtareaDAO.leerSubtarea(1);
        SubtareaDAO.modificarSubtarea(1);
        //SubtareaDAO.eliminarSubtarea(2);
*/


    }


}
