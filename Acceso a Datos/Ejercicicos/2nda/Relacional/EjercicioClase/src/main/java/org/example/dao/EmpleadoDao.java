package org.example.dao;

import org.example.model.Departamento;
import org.example.model.Empleado;

import java.sql.SQLException;
import java.util.List;

public interface EmpleadoDao {

    List<Empleado> listar() throws SQLException;




}
