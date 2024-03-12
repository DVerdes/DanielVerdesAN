package com.example.ReviewsProyecto.mapper;


import com.example.ReviewsProyecto.dto.ItemDTO;
import com.example.ReviewsProyecto.dto.ReviewDTO;
import com.example.ReviewsProyecto.model.Item;
import com.example.ReviewsProyecto.model.Review;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Mapper de objetos Item
 */
public class ItemMapper {

    /**
     * Convierte objetos Item en ItemDTO
     * @param item objeto item
     * @return ItemDTO
     */
    public static ItemDTO modelDTO(Item item){
        return new ItemDTO(item.getIdItem(),item.getTipo(), item.getNombre(), item.getGenero(), item.getAutor(), item.getDuracion(),item.getRutaPortada(), item.getEstreno(), item.getSinopsis(), calcularPuntuacionMedia(item));
    }


    /**
     * Convierte objetos ItemDTO en Item
     * @param itemDTO objeto ItemDTO
     * @return Item
     */
    public static Item dtoModel(ItemDTO itemDTO){
        return new Item(itemDTO.getIdItem(), itemDTO.getTipo(), itemDTO.getAutor(), itemDTO.getGenero(), itemDTO.getAutor(), itemDTO.getDuracion(), itemDTO.getRutaPortada(), itemDTO.getEstreno(), itemDTO.getSinopsis(),new HashSet<>());
    }

    /**
     * Calcula puntuación media de las reseñas de un item
     * @param item del que calcular puntuación media
     * @return puntuación media
     */
    static double calcularPuntuacionMedia(Item item){
        double punt = 0;
        if(item.getReviewSet().size()!=0){
            for(Review r : item.getReviewSet()){
                punt += r.getPuntuacion();
            }
            return punt/item.getReviewSet().size();
        }
       return 0;
    }


}
