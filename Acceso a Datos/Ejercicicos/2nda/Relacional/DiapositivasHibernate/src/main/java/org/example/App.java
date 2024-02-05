package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.sql.Timestamp;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        Timestamp  ts= new Timestamp(System.currentTimeMillis());
        Tarea tarea1 = new Tarea(1,"Tarea 1","Prueba 1",ts,"Pendiente");
        Tarea tarea2 = new Tarea(2,"Tarea 2","Prueba 2",ts,"En proceso");


        Transaction transaction = session.beginTransaction();
        session.save(tarea1);
        session.save(tarea2);
        transaction.commit();

    }
}
