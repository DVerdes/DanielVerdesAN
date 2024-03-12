package com.example.ReviewsProyecto.controllers;

import com.example.ReviewsProyecto.dto.ItemDTO;
import com.example.ReviewsProyecto.service.ItemService;
import com.example.ReviewsProyecto.service.impl.ItemServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

/**
 * Endpoints Item
 */
@RestController
public class ItemController {


    /**
     * Devuelve películas de BBDD
     * @return listado películas
     * @throws SQLException
     */
    @GetMapping("/api/items/peliculas")
    List<ItemDTO> devolverPeliculas() throws SQLException {

        ItemService is = new ItemServiceImpl();
        return is.obtenerPeliculas();
    }

    /**
     * Devuelve series de BBDD
     * @return listado series
     * @throws SQLException
     */
    @GetMapping("/api/items/series")
    List<ItemDTO> devolverSeries() throws SQLException {

        ItemService is = new ItemServiceImpl();
        return is.obtenerSeries();
    }

    /**
     * Devuelve libros BBDD
     * @return listado libros
     * @throws SQLException
     */
    @GetMapping("/api/items/libros")
    List<ItemDTO> devolverLibros() throws SQLException {

        ItemService is = new ItemServiceImpl();
        return is.obtenerLibros();
    }

    /**
     * Devuelve videojuegos BBDD
     * @return listado videojuegos
     * @throws SQLException
     */
    @GetMapping("/api/items/juegos")
    List<ItemDTO> devolverVideojuegos() throws SQLException {

        ItemService is = new ItemServiceImpl();
        return is.obtenerVideojuegos();
    }

    /**
     * Devuelve música BBDD
     * @return listado música
     * @throws SQLException
     */
    @GetMapping("/api/items/musicas")
    List<ItemDTO> devolverMusica() throws SQLException {

        ItemService is = new ItemServiceImpl();
        return is.obtenerMusica();
    }

    /**
     * Devuelve un item BBDD
     * @param itemID ID del item buscado
     * @return item requerido
     * @throws SQLException
     */
    @GetMapping("/api/items/{idItem}/item")
    ItemDTO devolverItem(@PathVariable int itemID) throws SQLException {
        ItemService is = new ItemServiceImpl();
        return is.obtenerPorId(itemID);
    }
}
