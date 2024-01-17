package org.example.dao.impl;

import org.example.dao.DBConnector;
import org.example.dao.EmpleadoDao;
import org.example.mapper.DepartamentoMapper;
import org.example.mapper.EmpleadoMapper;
import org.example.model.Empleado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class JbdcEmpleadoDao implements EmpleadoDao {

    private DBConnector connector =  new HikariDBConnector();

    @Override
    public List<Empleado> listar() throws SQLException {

        Connection c = connector.obtenerConexion();
        PreparedStatement s = null;
        try{
            s = c.prepareStatement("SELECT * FROM Empleados");

            return EmpleadoMapper.resALista(s.executeQuery());

        }catch (SQLException e){
            System.out.println("Consulta KO");
            throw new RuntimeException(e);
        }finally {
            if(s!=null) s.close();;
            if (c!=null) c.close();
        }



    }
}
