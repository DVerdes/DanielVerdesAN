package org.example.service;

import org.example.dto.DepartamentoDTO;
import org.example.dto.EmpleadoDTO;

import java.sql.SQLException;
import java.util.List;

public interface EmpleadoService {

    List<EmpleadoDTO> obtenerTodos() throws SQLException;

    List<EmpleadoDTO> obtenerPorNombre(String nombre);

    EmpleadoDTO obtenerPorId(int id);

    int crear(EmpleadoDTO entidad);

    void actualizar(EmpleadoDTO entidad);

    void eliminar(int id);

    void moverEmpleados(int idDepartamento, List<EmpleadoDTO> lista);


}
