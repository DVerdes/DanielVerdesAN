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

/**
 * Service Review Impl
 */
public class ReviewServiceImpl implements ReviewService {

    /**
     * Lista reviews de un item determinado
     * @param idItem id del item
     * @return lista de reviews
     * @throws SQLException
     */
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

    /**
     * Crea review
     * @param entidad objeto ReviewDTO a crear
     * @return índice autoincremental generado
     * @throws SQLException
     */
    @Override
    public int crearReview(ReviewDTO entidad) throws SQLException {
        ReviewDAO rdao = new ORMReviewDAO();
        ItemDAO idao = new ORMItemDAO();
        return rdao.insertarReview(ReviewMapper.dtoReview(entidad, idao.obtenerItem(entidad.getIdItem())));
    }
}
