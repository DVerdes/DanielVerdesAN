package com.example.ReviewsProyecto.dao.impl;

import com.example.ReviewsProyecto.dao.ItemDAO;
import com.example.ReviewsProyecto.model.Item;
import com.example.ReviewsProyecto.model.Review;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import java.sql.SQLException;
import java.util.List;

public class ORMItemDAO implements ItemDAO {
    @Override
    public List<Item> listar() throws SQLException {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {

            Query<Item> query = session.createNativeQuery("Select * from Items" ,Item.class);
            List<Item> items = query.list();

            transaction.commit();
            return items;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {

            session.close();

        }
        return null;
    }

    @Override
    public List<Item> listarPorTipo(String tipo) throws SQLException {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {

            Query<Item> query = session.createNativeQuery("Select * from Items WHERE Tipo like :tipo" ,Item.class);
            query.setParameter("tipo",tipo);
            //query.set("tipo","%"+tipo+"%");
            List<Item> items = query.list();

            for(Review r: items.get(0).getReviewSet()){
                System.out.println(r.toString());
            }

            transaction.commit();
            return items;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
            return null;

        }finally {

            session.close();

        }
    }

    @Override
    public Item obtenerItem(int id) throws SQLException {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            Item item = session.get(Item.class,id);
            transaction.commit();
            return item;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
            return null;
        }finally {
            session.close();
        }
    }

}

