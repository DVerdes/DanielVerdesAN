package com.example.ReviewsProyecto.dao;


import com.example.ReviewsProyecto.model.Item;

import java.sql.SQLException;
import java.util.List;

public interface ItemDAO {

    List<Item> listar() throws SQLException;

    List<Item> listarPorTipo(String tipo) throws SQLException;

    Item obtenerItem(int id) throws SQLException;

    //int insertarItem(Item item) throws SQLException;

    //void actualizarEmpleado(Empleado empleado) throws SQLException;

    //void elimarEmpleado(int id) throws SQLException;



}
