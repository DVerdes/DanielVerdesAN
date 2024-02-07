package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;


public class TareaDAO {

    public static void crearTarea(Tarea tarea) {

        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.save(tarea);
            transaction.commit();
            System.out.println(tarea.toString());
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public static void leerTarea(int id){
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try {
            Tarea tarea = session.get(Tarea.class,id);
            System.out.println(tarea.toString());
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public static void modificarTarea(int id){
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try {
            Tarea tarea = session.get(Tarea.class,id);
            tarea.setEstado("Finalizada");
            session.update(tarea);
            System.out.println(tarea.toString());
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }


    }

    public static void eliminarTarea(int id){
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try {
            Tarea tarea = session.get(Tarea.class,id);
            session.delete(tarea);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }

    }

    public static void consultarTareasSQL(){
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {

        Query<Tarea> query = session.createNativeQuery("Select * from Tareas WHERE estado like '%En proceso%'",Tarea.class);
        List<Tarea> tareas = query.list();
        for(Tarea tarea : tareas){
            System.out.println(tarea);
        }
        transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {

            session.close();

        }
    }

    public static void consultarTareasHQL(){
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            // en HQL se pasa en nombre del objeto mapeado no de la TABLA de la BBDD
            Query query = session.createQuery("from Tarea where estado =: estado");
            query.setString("estado","Completada");
            List<Tarea> tareas = query.list();
            for(Tarea tarea : tareas){
                System.out.println(tarea);
            }
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {

            session.close();

        }
    }


}
