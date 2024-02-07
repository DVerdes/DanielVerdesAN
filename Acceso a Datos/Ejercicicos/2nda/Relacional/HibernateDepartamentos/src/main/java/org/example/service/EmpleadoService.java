package org.example.service;

import org.example.dto.DepartamentoDTO;
import org.example.dto.EmpleadoDTO;

import java.sql.SQLException;
import java.util.List;

public interface EmpleadoService {

    List<EmpleadoDTO> obtenerTodos() throws SQLException;

    List<EmpleadoDTO> obtenerPorNombre(String nombre) throws SQLException;

    EmpleadoDTO obtenerPorId(int id) throws SQLException;

    int crear(EmpleadoDTO entidad) throws SQLException;

    void actualizar(EmpleadoDTO entidad) throws SQLException;

    void eliminar(int id) throws SQLException;

    void moverEmpleados(int idDepartamento, List<EmpleadoDTO> lista);


}
