package com.example.ReviewsProyecto;

import com.example.ReviewsProyecto.dto.ItemDTO;
import com.example.ReviewsProyecto.dto.ReviewDTO;
import com.example.ReviewsProyecto.model.Item;
import com.example.ReviewsProyecto.model.Review;
import com.example.ReviewsProyecto.service.ItemService;
import com.example.ReviewsProyecto.service.ReviewService;
import com.example.ReviewsProyecto.service.impl.ItemServiceImpl;
import com.example.ReviewsProyecto.service.impl.ReviewServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;
import java.util.List;

@SpringBootApplication
public class ReviewsProyectoApplication {

	public static void main(String[] args) throws SQLException {

		SpringApplication.run(ReviewsProyectoApplication.class, args);





	}

}
