package com.example.ReviewsProyecto.service;


import com.example.ReviewsProyecto.dto.ItemDTO;

import java.sql.SQLException;
import java.util.List;

/**
 * Interfaz ITEMSERVICE
 */
public interface ItemService {

    List<ItemDTO> obtenerTodos() throws SQLException;

    List<ItemDTO> obtenerPeliculas() throws SQLException;

    List<ItemDTO> obtenerSeries() throws SQLException;

    List<ItemDTO> obtenerLibros() throws SQLException;

    List<ItemDTO> obtenerVideojuegos() throws SQLException;

    List<ItemDTO> obtenerMusica() throws SQLException;

    ItemDTO obtenerPorId(int id) throws SQLException;

}
