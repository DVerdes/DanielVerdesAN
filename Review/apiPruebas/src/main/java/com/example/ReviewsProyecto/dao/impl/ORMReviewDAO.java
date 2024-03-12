package com.example.ReviewsProyecto.dao.impl;


import com.example.ReviewsProyecto.dao.ReviewDAO;
import com.example.ReviewsProyecto.model.Review;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

/**
 * Clase ORM Acceso a Datos Review
 */
public class ORMReviewDAO implements ReviewDAO {

    /**
     * Lista reviews de un item determinado
     * @param idItem id del item del que buscamos reviews
     * @return listado de reviews
     * @throws SQLException
     */
    @Override
    public List<Review> listarPorItem(int idItem) throws SQLException {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {

            Query<Review> query = session.createNativeQuery("Select * from Reviews WHERE ItemID like :item" ,Review.class);
            query.setParameter("item",String.valueOf(idItem));
            List<Review> reviews = query.list();

            transaction.commit();
            return reviews;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
            return null;

        }finally {

            session.close();

        }
    }

    /**
     * Obtiene una reviews concreta
     * @param id de la review
     * @return Review requerida
     * @throws SQLException
     */
    @Override
    public Review obtenerReview(int id) throws SQLException {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            Review review = session.get(Review.class,id);
            transaction.commit();
            return review;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
            return null;
        }finally {
            session.close();
        }
    }

    /**
     * Inserta review en BBDD
     * @param review a insertar
     * @return id de la review insertada
     * @throws SQLException
     */
    @Override
    public int insertarReview(Review review) throws SQLException {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.save(review);
            transaction.commit();
            return review.getReviewID();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
            return 0;

        }finally {
            session.close();
        }
    }
}
