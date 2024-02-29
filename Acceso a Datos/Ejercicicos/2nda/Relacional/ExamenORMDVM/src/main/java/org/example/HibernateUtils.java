package org.example;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Clase con SessionFactory para manejar objetos Session de Hibernate
 */
public class HibernateUtils {
    private static final SessionFactory sessionFactory;
    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();


        }catch (Throwable ex){
            System.err.println("Error al crear el session factory: "+ex);
            throw new ExceptionInInitializerError(ex);

        }}

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
