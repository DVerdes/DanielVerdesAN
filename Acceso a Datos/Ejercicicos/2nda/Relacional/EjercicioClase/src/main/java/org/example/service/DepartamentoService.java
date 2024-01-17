package org.example.service;

import org.example.dto.DepartamentoDTO;

import java.sql.SQLException;
import java.util.List;

public interface DepartamentoService {
    List<DepartamentoDTO> obtenerTodos() throws SQLException;

    List<DepartamentoDTO> obtenerPorNombre(String nombre);

    DepartamentoDTO obtenerPorId(int id);

    int crear(DepartamentoDTO entidad);

    void actualizar(DepartamentoDTO entidad);

    void eliminar(int id);
}
