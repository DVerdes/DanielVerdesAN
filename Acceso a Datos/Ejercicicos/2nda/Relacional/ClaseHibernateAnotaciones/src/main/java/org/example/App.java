package org.example;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
  /*      crearTarea();

        Tarea tarea = null;
        tarea = leerTarea(1);
        modificarTarea(4);
        eliminarTarea(3);

        List<Tarea> tareasRealizadas = tareasRealizadas();

        for(int i = 0; i<tareasRealizadas.size(); i++){
            System.out.println(tareasRealizadas.get(i).toString());
        }

        List<Tarea> tareasPendientes = obtenerTareasEstado("pendiente");

        for(int i = 0; i<tareasPendientes.size(); i++){
            System.out.println(tarea.toString());
        }

        SubTarea subTarea = null;
        crearSubTarea(1);
        subTarea = leerSubTarea(1);
        modificarSubTarea(1);
        eliminarSubTarea(2);
        System.out.println(subTarea.toString());
*/
        Set<SubTarea> listaSubTareas = new HashSet<>();
        listaSubTareas.add(new SubTarea("NuevaSub"));
        listaSubTareas.add(new SubTarea("NuevaSub2"));
        Tarea tareaNueva = new Tarea();
        tareaNueva.setSubtareas(listaSubTareas);


        agregarTareaPersonalizada(tareaNueva);
        System.out.println(tareaNueva.toString());
        HibernateUtil.close();
    }

    public static void crearTarea(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyy HH:mm");
        Date date = null;

        try {
            date = dateFormat.parse("23/01/2023 12:30");
        } catch (ParseException e){
            throw new RuntimeException();
        }

        long time = date.getTime();
        Tarea tarea = new Tarea("Obra Aula Nosa", "Obra en clase 0 Aula Nosa", new Timestamp(time), "Pendiente");

        Transaction transaction = session.beginTransaction();
        session.save(tarea);
        transaction.commit();
        System.out.println(tarea);
    }

    public static void agregarTareaPersonalizada(Tarea tarea){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        Transaction transaction = session.beginTransaction();
        session.save(tarea);
        transaction.commit();
    }

    public static Tarea leerTarea(int id){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        Transaction transaction = session.beginTransaction();
        Tarea tarea = session.get(Tarea.class, id);
        System.out.println(tarea);
        transaction.commit();


        return tarea;
    }

    public static void modificarTarea(int id){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        Transaction transaction = session.beginTransaction();
        Tarea tarea = session.get(Tarea.class, id);
        tarea.setEstado("Realizada");
        session.update(tarea);
        transaction.commit();

    }

    public static void eliminarTarea(int id){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        Transaction transaction = session.beginTransaction();
        Tarea tarea = session.get(Tarea.class, id);
        if(tarea!=null){
            session.delete(tarea);
        }
        transaction.commit();

    }

    public static List<Tarea> tareasRealizadas(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        Transaction transaction = session.beginTransaction();
        Query<Tarea> q = session.createNativeQuery("SELECT * FROM Tareas WHERE estado = 'Realizada'", Tarea.class);
        List<Tarea> lista = q.list();
        transaction.commit();

        return lista;
    }

    public static List<Tarea> obtenerTareasEstado(String estado){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        Transaction transaction = session.beginTransaction();
        Query q = session.createQuery("from Tarea where estado = :estado");
        q.setString("estado", estado);
        List<Tarea> tareas = q.list();
        transaction.commit();

        return tareas;
    }

    public static void crearSubTarea(int id){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        SubTarea subTarea = new SubTarea( "SubtareaNueva");

        Transaction transaction = session.beginTransaction();
        session.save(subTarea);
        transaction.commit();
        System.out.println(subTarea);
    }

    public static SubTarea leerSubTarea(int id){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        Transaction transaction = session.beginTransaction();
        SubTarea subTarea = session.get(SubTarea.class, id);
        System.out.println(subTarea);
        transaction.commit();


        return subTarea;
    }

    public static void modificarSubTarea(int id){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        Transaction transaction = session.beginTransaction();
        SubTarea subTarea = session.get(SubTarea.class, id);
        subTarea.setNombre("SubTareaModificada");
        session.update(subTarea);
        transaction.commit();

    }

    public static void eliminarSubTarea(int id){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        Transaction transaction = session.beginTransaction();
        SubTarea subTarea = session.get(SubTarea.class, id);
        if(subTarea!=null){
            session.delete(subTarea);
        }
        transaction.commit();
    }


}
