package com.example.ReviewsProyecto.service;


import com.example.ReviewsProyecto.dto.ReviewDTO;

import java.sql.SQLException;
import java.util.List;

public interface ReviewService {

    List<ReviewDTO> obtenerPorItem(int idItem) throws SQLException;


    int crearReview(ReviewDTO entidad) throws SQLException;



}
