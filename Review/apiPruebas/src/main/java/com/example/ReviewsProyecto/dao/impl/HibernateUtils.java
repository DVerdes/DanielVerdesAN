package com.example.ReviewsProyecto.dao.impl;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * HIBERNATE UTILS
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

    /**
     * Devuelve SessionFactory
     * @return SessionFactory
     */
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }


}
