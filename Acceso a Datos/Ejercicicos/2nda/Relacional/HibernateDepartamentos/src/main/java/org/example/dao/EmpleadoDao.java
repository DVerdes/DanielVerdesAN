package org.example.dao;

import org.example.model.Departamento;
import org.example.model.Empleado;

import java.sql.SQLException;
import java.util.List;

public interface EmpleadoDao {

    List<Empleado> listar() throws SQLException;

    List<Empleado> listarPorNombre(String nombre) throws SQLException;

    Empleado obtenerEmpleado(int id) throws SQLException;

    int insertarEmpleado(Empleado empleado) throws SQLException;

    void actualizarEmpleado(Empleado empleado) throws SQLException;

    void elimarEmpleado(int id) throws SQLException;




}
