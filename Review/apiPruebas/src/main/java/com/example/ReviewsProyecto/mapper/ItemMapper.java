package com.example.ReviewsProyecto.mapper;


import com.example.ReviewsProyecto.dto.ItemDTO;
import com.example.ReviewsProyecto.dto.ReviewDTO;
import com.example.ReviewsProyecto.model.Item;
import com.example.ReviewsProyecto.model.Review;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ItemMapper {


    public static ItemDTO modelDTO(Item item){
        return new ItemDTO(item.getIdItem(),item.getTipo(), item.getNombre(), item.getGenero(), item.getAutor(), item.getDuracion(),item.getRutaPortada(), item.getEstreno(), item.getSinopsis(), 0.0);
    }



    public static Item dtoModel(ItemDTO itemDTO){
        return new Item(itemDTO.getIdItem(), itemDTO.getTipo(), itemDTO.getAutor(), itemDTO.getGenero(), itemDTO.getAutor(), itemDTO.getDuracion(), itemDTO.getRutaPortada(), itemDTO.getEstreno(), itemDTO.getSinopsis(),new HashSet<>());
    }


    static double calcularPuntuacionMedia(Item item){
        double punt = 0;
        for(Review r : item.getReviewSet()){
            punt += r.getPuntuacion();
        }
        return punt/item.getReviewSet().size();
    }

    static List<ReviewDTO> devolverLista(Set<Review> itemSet){
        List<ReviewDTO>items = new ArrayList<>();
        for(Review i : itemSet){

            items.add(ReviewMapper.reviewDTO(i));
        }
        return items;

    }
    static Set<Review> devolverSet(List<ReviewDTO> itemList){
        Set<Review>items = new HashSet<>();
        for(ReviewDTO i : itemList){
            items.add(ReviewMapper.dtoReview(i,new Item()));
        }
        return items;

    }
}
