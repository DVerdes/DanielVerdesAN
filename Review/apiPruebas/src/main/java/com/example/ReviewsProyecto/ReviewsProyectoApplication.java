package com.example.ReviewsProyecto;

import com.example.ReviewsProyecto.dto.ItemDTO;
import com.example.ReviewsProyecto.dto.ReviewDTO;
import com.example.ReviewsProyecto.model.Item;
import com.example.ReviewsProyecto.model.Review;
import com.example.ReviewsProyecto.service.ItemService;
import com.example.ReviewsProyecto.service.impl.ItemServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;
import java.util.List;

@SpringBootApplication
public class ReviewsProyectoApplication {

	public static void main(String[] args) throws SQLException {

		SpringApplication.run(ReviewsProyectoApplication.class, args);
		/*
		ItemService is = new ItemServiceImpl();
		List<ItemDTO>items = is.obtenerPeliculas();

		for(ItemDTO i: items){
			System.out.println(i.toString());
			for(ReviewDTO review: i.getReviewList()){
				System.out.println(review.toString());
			}
		}
		*/


	}

}
