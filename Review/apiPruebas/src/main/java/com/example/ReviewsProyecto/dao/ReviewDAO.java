package com.example.ReviewsProyecto.dao;


import com.example.ReviewsProyecto.model.Review;

import java.sql.SQLException;
import java.util.List;

public interface ReviewDAO {

    List<Review> listarPorItem(int idItem) throws SQLException;

    Review obtenerReview(int id) throws SQLException;

    int insertarReview(Review review) throws SQLException;
}
