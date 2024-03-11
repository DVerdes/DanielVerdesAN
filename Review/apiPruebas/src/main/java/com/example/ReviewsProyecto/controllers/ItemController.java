package com.example.ReviewsProyecto.controllers;

import com.example.ReviewsProyecto.dto.ItemDTO;
import com.example.ReviewsProyecto.service.ItemService;
import com.example.ReviewsProyecto.service.impl.ItemServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
public class ItemController {


    @GetMapping("/api/items/peliculas")
    List<ItemDTO> devolverPeliculas() throws SQLException {

        ItemService is = new ItemServiceImpl();
        return is.obtenerPeliculas();
    }

    @GetMapping("/api/items/series")
    List<ItemDTO> devolverSeries() throws SQLException {

        ItemService is = new ItemServiceImpl();
        return is.obtenerSeries();
    }

    @GetMapping("/api/items/libros")
    List<ItemDTO> devolverLibros() throws SQLException {

        ItemService is = new ItemServiceImpl();
        return is.obtenerLibros();
    }

    @GetMapping("/api/items/juegos")
    List<ItemDTO> devolverVideojuegos() throws SQLException {

        ItemService is = new ItemServiceImpl();
        return is.obtenerVideojuegos();
    }

    @GetMapping("/api/items/musicas")
    List<ItemDTO> devolverMusica() throws SQLException {

        ItemService is = new ItemServiceImpl();
        return is.obtenerMusica();
    }

    @GetMapping("/api/items/{idItem}/item")
    ItemDTO devolverItem(@PathVariable int itemID) throws SQLException {
        ItemService is = new ItemServiceImpl();
        return is.obtenerPorId(itemID);
    }
}
