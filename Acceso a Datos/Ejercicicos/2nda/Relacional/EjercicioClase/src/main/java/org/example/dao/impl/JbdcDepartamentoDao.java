package org.example.dao.impl;

import org.example.dao.DBConnector;
import org.example.dao.DepartamentoDao;
import org.example.mapper.DepartamentoMapper;
import org.example.model.Departamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JbdcDepartamentoDao implements DepartamentoDao {

    private DBConnector connector =  new HikariDBConnector();

    @Override
    public  List<Departamento> listar() throws SQLException {

        Connection c = connector.obtenerConexion();
        PreparedStatement s = null;
        try{
            s = c.prepareStatement("SELECT * FROM Departamento");
            List <Departamento> departamentos = new ArrayList<Departamento>();

            return DepartamentoMapper.resALista(s.executeQuery());

        }catch (SQLException e){
            System.out.println("Consulta KO");
            throw new RuntimeException(e);
        }finally {
            if(s!=null) s.close();;
            if (c!=null) c.close();
        }

    }

    public int contarEmpleadosDepartamento(int id) throws SQLException {
        Connection c = connector.obtenerConexion();
        PreparedStatement s = null;
        try{
            s = c.prepareStatement("SELECT COUNT(*) FROM Empleados WHERE idDepartamento like ?");
            s.setString(1, String.valueOf(id));

            ResultSet res = s.executeQuery();

            while (res.next())             return res.getInt(1);

            return 0;

        }catch (SQLException e){
            System.out.println("Consulta KO");
            throw new RuntimeException(e);
        }finally {
            if(s!=null) s.close();;
            if (c!=null) c.close();
        }

    }


}
