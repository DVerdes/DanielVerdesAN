package org.example;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class SubtareaDAO {

    public static void crearSubtarea(Subtarea subtarea) {

        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.save(subtarea);
            transaction.commit();
            System.out.println(subtarea.toString());
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public static void leerSubtarea(int id){
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try {
            Subtarea subtarea = session.get(Subtarea.class,id);
            System.out.println(subtarea.toString());
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public static void modificarSubtarea(int id){
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try {
            Subtarea subtarea = session.get(Subtarea.class,id);
            subtarea.setNombre("Subtarea y");
            session.update(subtarea);
            System.out.println(subtarea.toString());
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }


    }

    public static void eliminarSubtarea(int id){
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try {
            Subtarea subtarea = session.get(Subtarea.class,id);
            session.delete(subtarea);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }

    }
}
