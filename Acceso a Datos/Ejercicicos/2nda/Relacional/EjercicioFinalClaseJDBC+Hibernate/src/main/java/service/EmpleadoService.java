package service;

import dto.DepartamentoDTO;
import dto.EmpleadoDTO;

import java.sql.SQLException;
import java.util.List;

public interface EmpleadoService {

     List<EmpleadoDTO> obtenerTodos() throws SQLException;
     List<EmpleadoDTO> obtenerPorNombre(String nombre) throws SQLException;

     EmpleadoDTO obtenerPorId(int id) throws SQLException;

    int crear (EmpleadoDTO e) throws SQLException;

    void actualizar(EmpleadoDTO dept) throws SQLException;
    void elimniar (int id) throws SQLException;
    void moverEmpleados(int id , List<EmpleadoDTO> lista) throws SQLException;
}
