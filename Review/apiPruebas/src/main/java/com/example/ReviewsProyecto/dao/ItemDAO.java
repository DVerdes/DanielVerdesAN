package com.example.ReviewsProyecto.dao;


import com.example.ReviewsProyecto.model.Item;

import java.sql.SQLException;
import java.util.List;

/**
 * INTERFAZ ITEM DAO
 */
public interface ItemDAO {

    /**
     * Lista todos los items
     * @return item requerido
     * @throws SQLException
     */
    List<Item> listar() throws SQLException;

    /**
     * Lista por tipo de item
     * @param tipo de item
     * @return listado de items
     * @throws SQLException
     */
    List<Item> listarPorTipo(String tipo) throws SQLException;

    /**
     * Saca un item por id
     * @param id del item requerido
     * @return item buscado
     * @throws SQLException
     */
    Item obtenerItem(int id) throws SQLException;





}
