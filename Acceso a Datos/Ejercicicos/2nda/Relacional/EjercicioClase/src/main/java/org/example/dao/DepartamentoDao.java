package org.example.dao;

import org.example.dao.impl.HikariDBConnector;
import org.example.model.Departamento;
import org.example.model.Empleado;

import java.sql.*;
import java.util.List;

public interface DepartamentoDao {

    List<Departamento> listar() throws SQLException;

    public int contarEmpleadosDepartamento(int id) throws SQLException;


}
