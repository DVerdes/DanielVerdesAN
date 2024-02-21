package service;

import dto.DepartamentoDTO;
import dto.EmpleadoDTO;
import model.Departamento;

import java.sql.SQLException;
import java.util.List;

public interface DepartamentoService {


    public List<DepartamentoDTO> obtenerTodos() throws SQLException;
    public List<DepartamentoDTO> obtenerPorNombre(String nombre) throws SQLException;
    DepartamentoDTO obtenerPorId(int id) throws SQLException;
    int crear (DepartamentoDTO dept) throws SQLException;
    void actualizar(DepartamentoDTO dept) throws SQLException;
     void elimniar (int id) throws SQLException;



}
