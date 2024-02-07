package org.example.dao.impl;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConexion {
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
