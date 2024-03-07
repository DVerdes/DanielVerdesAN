package com.example.ReviewsProyecto.controllers;

import com.example.ReviewsProyecto.dto.ItemDTO;
import com.example.ReviewsProyecto.dto.ReviewDTO;
import com.example.ReviewsProyecto.service.ItemService;
import com.example.ReviewsProyecto.service.ReviewService;
import com.example.ReviewsProyecto.service.impl.ItemServiceImpl;
import com.example.ReviewsProyecto.service.impl.ReviewServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.SQLException;
import java.util.List;

public class ReviewController {


    @PostMapping("/api/reviews")
    int crearReview(@RequestBody ReviewDTO reviewDTO) throws SQLException {
        ReviewService rs = new ReviewServiceImpl();
        return rs.crearReview(reviewDTO);
    }

    @GetMapping("/api/reviews/{idItem}")
    List<ReviewDTO> devolverReviewsDeitem(@PathVariable int itemID) throws SQLException {
        ReviewService rs = new ReviewServiceImpl();
        return rs.obtenerPorItem(itemID);
    }




}
