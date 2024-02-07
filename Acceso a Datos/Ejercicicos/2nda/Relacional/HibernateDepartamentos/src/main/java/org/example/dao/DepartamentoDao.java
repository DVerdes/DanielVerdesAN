package org.example.dao;

import org.example.model.Departamento;

import java.sql.*;
import java.util.List;

public interface DepartamentoDao {

    List<Departamento> listar() throws SQLException;

    List<Departamento> listarPorNombre(String nombre) throws SQLException;

    Departamento obtenerDepartamento(int id) throws SQLException;

    int insertarDepartamento(Departamento departamento) throws SQLException;

    int contarEmpleadosDepartamento(int id) throws SQLException;

    void elimarDepartamento(int id) throws SQLException;


    void actualizarDepartamento(Departamento departamento) throws SQLException;
}
