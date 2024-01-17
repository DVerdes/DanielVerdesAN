package org.example.service;

import org.example.dto.DepartamentoDTO;

import java.sql.SQLException;
import java.util.List;

public interface DepartamentoService {
    List<DepartamentoDTO> obtenerTodos() throws SQLException;

    List<DepartamentoDTO> obtenerPorNombre(String nombre) throws SQLException;

    DepartamentoDTO obtenerPorId(int id) throws SQLException;

    int crear(DepartamentoDTO entidad) throws SQLException;

    void actualizar(DepartamentoDTO entidad) throws SQLException;

    void eliminar(int id) throws SQLException;
}
