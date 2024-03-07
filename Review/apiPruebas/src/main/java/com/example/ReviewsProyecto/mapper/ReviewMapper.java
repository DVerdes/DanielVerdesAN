package com.example.ReviewsProyecto.mapper;

import com.example.ReviewsProyecto.dto.ReviewDTO;
import com.example.ReviewsProyecto.model.Item;
import com.example.ReviewsProyecto.model.Review;


public class ReviewMapper {



    public static ReviewDTO reviewDTO(Review review){
        return new ReviewDTO(review.getReviewID(), review.getIdItem(), review.getUsuario(), review.getPuntuacion(), review.getContenido());
    }

    public static Review dtoReview(ReviewDTO reviewDTO, Item item){
        return new Review(reviewDTO.getReviewID(), reviewDTO.getIdItem(), reviewDTO.getUsuario(), reviewDTO.getPuntuacion(), reviewDTO.getContenido(),item );
    }



}
