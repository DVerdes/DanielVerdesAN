package org.example.dao.impl;

import org.example.dao.DBConnector;
import org.example.dao.DepartamentoDao;
import org.example.mapper.DepartamentoMapper;
import org.example.model.Departamento;

import java.sql.*;
import java.util.List;

public class JbdcDepartamentoDao implements DepartamentoDao {

    private DBConnector connector =  new HikariDBConnector();

    @Override
    public  List<Departamento> listar() throws SQLException {

        Connection c = connector.obtenerConexion();
        PreparedStatement s = null;
        try{
            s = c.prepareStatement("SELECT * FROM Departamento");

            return DepartamentoMapper.resALista(s.executeQuery());

        }catch (SQLException e){
            System.out.println("Consulta KO");
            throw new RuntimeException(e);
        }finally {
            if(s!=null) s.close();;
            if (c!=null) c.close();
        }

    }

    @Override
    public List<Departamento> listarPorNombre(String nombre) throws SQLException {

        Connection c = connector.obtenerConexion();
        PreparedStatement s = null;
        try{
            s = c.prepareStatement("SELECT * FROM Departamento WHERE nombre like ?");
            s.setString(1,"%"+nombre+"%");


            return DepartamentoMapper.resALista(s.executeQuery());

        }catch (SQLException e){
            System.out.println("Consulta KO");
            throw new RuntimeException(e);
        }finally {
            if(s!=null) s.close();;
            if (c!=null) c.close();
        }


    }

    @Override
    public Departamento obtenerDepartamento(int id) throws SQLException {
        Connection c = connector.obtenerConexion();
        PreparedStatement s = null;
        try{
            s = c.prepareStatement("SELECT * FROM Departamento WHERE id like ?");
            s.setString(1,"%"+id+"%");
            ResultSet res = s.executeQuery();
            while (res.next())return new Departamento(res.getInt("id"),res.getString("nombre"),res.getString("ubicacion"),res.getString("email"),res.getString("telefono"));

            return null;


        }catch (SQLException e){
            System.out.println("Consulta KO");
            throw new RuntimeException(e);
        }finally {
            if(s!=null) s.close();;
            if (c!=null) c.close();
        }

    }

    @Override
    public int insertarDepartamento(Departamento departamento) throws SQLException {
        Connection c = connector.obtenerConexion();
        PreparedStatement s = null;
        try{
            s = c.prepareStatement("INSERT INTO Departamento (nombre,ubicacion,email,telefono) VALUES (?,?,?,?);",
                    Statement.RETURN_GENERATED_KEYS);
            s.setString(1,departamento.getNombre());
            s.setString(2,departamento.getUbicacion());
            s.setString(3, departamento.getEmail());
            s.setString(4,departamento.getTelefono());
            s.executeUpdate();
            System.out.println("Insertar equipo ok");

            //Obtener ID insertado
            ResultSet generatedKeys = s.getGeneratedKeys();
            if(generatedKeys.next()){
                return generatedKeys.getInt(1);
            }
        }catch (SQLException e){
            System.out.println("Insertar equipo KO");
            throw new RuntimeException(e);
        }finally {
            if(s!=null) s.close();;
            if (c!=null) c.close();
        }
        return 0;
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

    @Override
    public void elimarDepartamento(int id) throws SQLException {
        Connection c = connector.obtenerConexion();
        PreparedStatement s = null;
        try{

            s = c.prepareStatement("DELETE FROM Empleados WHERE idDepartamento like ?");
            s.setString(1,"%"+id+"%");
            s.executeUpdate();


            s = c.prepareStatement("DELETE FROM Departamento WHERE id like ?");
            s.setString(1,"%"+id+"%");
            s.executeUpdate();




        }catch (SQLException e){
            System.out.println("Consulta KO");
            throw new RuntimeException(e);
        }finally {
            if(s!=null) s.close();;
            if (c!=null) c.close();
        }
    }

    @Override
    public void actualizarDepartamento(Departamento departamento) throws SQLException {
        Connection c = connector.obtenerConexion();
        PreparedStatement s = null;
        try{
            s = c.prepareStatement("UPDATE Departamento SET nombre=?,ubicacion=?,email=?,telefono=?  WHERE Id = ?");
            s.setString(1,departamento.getNombre());
            s.setString(2,departamento.getUbicacion());
            s.setString(3,departamento.getEmail());
            s.setString(4,departamento.getTelefono());
            s.setInt(5,departamento.getId());
            s.executeUpdate();
            System.out.println("Actualizar departamento ok");
        }catch (SQLException e){
            System.out.println("Actualizar departamento KO");
            throw new RuntimeException(e);
        }finally {
            if(s!=null) s.close();;
            if (c!=null) c.close();
        }
    }


}
