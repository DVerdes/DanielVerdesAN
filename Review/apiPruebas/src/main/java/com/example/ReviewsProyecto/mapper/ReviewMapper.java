package com.example.ReviewsProyecto.mapper;

import com.example.ReviewsProyecto.dto.ReviewDTO;
import com.example.ReviewsProyecto.model.Item;
import com.example.ReviewsProyecto.model.Review;


/**
 * Mapper de Review
 */
public class ReviewMapper {


    /**
     * Convierte objeto Review en ReviewDTO
     * @param review Review
     * @return ReviewDTO
     */
    public static ReviewDTO reviewDTO(Review review){
        return new ReviewDTO(review.getReviewID(), review.getIdItem(), review.getUsuario(), review.getPuntuacion(), review.getContenido());
    }

    /**
     * Convierte objeto ReviewDTO en Review
     * @param reviewDTO ReviewDTO
     * @param item Item asociado
     * @return Review
     */
    public static Review dtoReview(ReviewDTO reviewDTO, Item item){
        return new Review(reviewDTO.getReviewID(), reviewDTO.getIdItem(), reviewDTO.getUsuario(), reviewDTO.getPuntuacion(), reviewDTO.getContenido(),item );
    }



}
