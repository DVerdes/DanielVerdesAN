package dao;

import model.Departamento;

import java.sql.SQLException;
import java.util.List;

public interface DepartamentoDAO {

     List<Departamento> obtenerTodos() throws SQLException;
     List<Departamento> obtenerPorNombre(String nombre) throws SQLException;

     Departamento obtenerPorId(int id) throws SQLException;
     int crear (Departamento dept) throws SQLException;

     void actualizar(Departamento dept) throws SQLException;
     void eliminar(int id) throws SQLException;





}
