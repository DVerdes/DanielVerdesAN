package org.example;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;

/**
 * CLASE PARA OPERACIONES ACCESO BBDD
 */
public class ActorDAO {

    /**
     * INSERTA ACTOR
     * @param actor actor a insertar
     * @return id del actor insertado
     */
    public static int insertarActor(Actor actor) {

        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.save(actor);
            transaction.commit();
            return actor.getId();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
            return  0;

        }finally {
            session.close();
        }
    }

    /**
     * Lee un actor de la BBDD
     * @param id del actor a leer
     * @return Actor obtenido
     * @throws SQLException
     */
    public static Actor obtenerActor(int id) throws SQLException {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try {
            Actor actor = session.get(Actor.class,id);
            transaction.commit();

            return actor;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }   return null; }

}
