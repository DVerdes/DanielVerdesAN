package dao.impl;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    public static final SessionFactory sessionFactory ;

    static {
        try {
            sessionFactory =  new Configuration().configure().buildSessionFactory();
        }catch (Throwable e){
            System.out.println("ERROR al crear el sesion factory " + e);
            throw new RuntimeException();
        }
    }

    public static SessionFactory getSessionFactory(){

        return sessionFactory;
    }

    public static void closeSessionFactory(){
        sessionFactory.close();
    }
}
