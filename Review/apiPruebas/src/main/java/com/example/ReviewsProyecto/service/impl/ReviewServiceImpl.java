package com.example.ReviewsProyecto.service.impl;



import com.example.ReviewsProyecto.dao.ItemDAO;
import com.example.ReviewsProyecto.dao.ReviewDAO;
import com.example.ReviewsProyecto.dao.impl.ORMItemDAO;
import com.example.ReviewsProyecto.dao.impl.ORMReviewDAO;
import com.example.ReviewsProyecto.dto.ReviewDTO;
import com.example.ReviewsProyecto.mapper.ReviewMapper;
import com.example.ReviewsProyecto.model.Review;
import com.example.ReviewsProyecto.service.ReviewService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReviewServiceImpl implements ReviewService {
    @Override
    public List<ReviewDTO> obtenerPorItem(int idItem) throws SQLException {
        ReviewDAO rdao = new ORMReviewDAO();
        List<Review>reviews = rdao.listarPorItem(idItem);
        List<ReviewDTO> reviewDTOS = new ArrayList<>();
        for(Review review:reviews){
            reviewDTOS.add(ReviewMapper.reviewDTO(review));
        }
        return reviewDTOS;
    }

    @Override
    public int crearReview(ReviewDTO entidad) throws SQLException {
        ReviewDAO rdao = new ORMReviewDAO();
        ItemDAO idao = new ORMItemDAO();
        return rdao.insertarReview(ReviewMapper.dtoReview(entidad, idao.obtenerItem(entidad.getIdItem())));
    }
}
