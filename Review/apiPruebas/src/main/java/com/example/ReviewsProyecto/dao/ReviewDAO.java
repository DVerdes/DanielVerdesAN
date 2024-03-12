package com.example.ReviewsProyecto.dao;


import com.example.ReviewsProyecto.model.Review;

import java.sql.SQLException;
import java.util.List;

/**
 * INTERFAZ REVIEW DAO
 */
public interface ReviewDAO {

    /**
     * Lista reviews de un item determinado
     * @param idItem id del item requerido
     * @return listado de reviews
     * @throws SQLException
     */
    List<Review> listarPorItem(int idItem) throws SQLException;

    /**
     * Obtiene una review por id
     * @param id de la review
     * @return Review buscada
     * @throws SQLException
     */
    Review obtenerReview(int id) throws SQLException;

    /**
     * Inserta review en BBDD
     * @param review a insertar
     * @return índice de la review
     * @throws SQLException
     */
    int insertarReview(Review review) throws SQLException;
}
