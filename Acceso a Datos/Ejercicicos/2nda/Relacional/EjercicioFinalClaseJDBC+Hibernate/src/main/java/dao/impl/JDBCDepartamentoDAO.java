package dao.impl;

import dao.DBConector;
import dao.DepartamentoDAO;
import mapper.DepartamentoMapper;
import model.Departamento;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCDepartamentoDAO implements DepartamentoDAO {

    DBConector conector = new HikariDBConector();

    public  List<Departamento> obtenerTodos() throws SQLException {

        List<Departamento> listaDept = new ArrayList<>();


        Connection c = null;
        c = conector.obtenerConexion();

        PreparedStatement s = null;

        try {
            s = c.prepareStatement("select * from departamento");


            ResultSet res = s.executeQuery();


            return DepartamentoMapper.resaLista(res);


        }catch (SQLException e ){
            System.out.println("consulta ko");
            throw new RuntimeException();
        }
        finally {
            if (s!=null) s.close();
            if (c!=null) c.close();
        }



    }

    @Override
    public List<Departamento> obtenerPorNombre(String nombre) throws SQLException {

        List<Departamento> listaDept = new ArrayList<>();

        Connection c = null;
        c = conector.obtenerConexion();

        PreparedStatement s = null;

        try {
            s = c.prepareStatement("select * from departamento where nombre = ?");
            s . setString(1,nombre );

            ResultSet res = s.executeQuery();


            return DepartamentoMapper.resaLista(res);


        }catch (SQLException e ){
            System.out.println("consulta ko");
            throw new RuntimeException();
        }
        finally {
            if (s!=null) s.close();
            if (c!=null) c.close();
        }

    }

    @Override
    public Departamento obtenerPorId(int id) throws SQLException {


        Connection c = null;
        c = conector.obtenerConexion();

        PreparedStatement s = null;

        try {
            s = c.prepareStatement("select * from departamento where id = ?");
            s . setInt(1,id);

            ResultSet res = s.executeQuery();


            return DepartamentoMapper.resaDept(res);


        }catch (SQLException e ){
            System.out.println("consulta ko");
            throw new RuntimeException();
        }
        finally {
            if (s!=null) s.close();
            if (c!=null) c.close();
        }

    }

    @Override
    public int crear(Departamento dept) throws SQLException {

        Connection c = null;
        c = conector.obtenerConexion();

       PreparedStatement s = null;

        try {
            s = c.prepareStatement("insert into departamento (nombre,ubicacion,email,telefono)values (?,?,?,?)");
            s . setString(1,dept.getNombre());
            s . setString(2,dept.getUbicacion());
            s . setString(3,dept.getEmail());
            s . setString(4,dept.getTelefono());

            s.executeUpdate();


            return obtenerId(dept.getNombre());


        }catch (SQLException e ){
            System.out.println("consulta ko");
            throw new RuntimeException();
        }
        finally {
            if (s!=null) s.close();
            if (c!=null) c.close();
        }


    }

    @Override
    public void actualizar(Departamento dept) throws SQLException {

        Connection c = null;
        c = conector.obtenerConexion();

        PreparedStatement s = null;

        try {
            s = c.prepareStatement("Update departamento set nombre = ?  ,  ubicacion = ?  ,  email = ?  ,  telefono = ?  where id = ? ");
            s . setString(1,dept.getNombre());
            s . setString(2,dept.getUbicacion());
            s . setString(3,dept.getEmail());
            s . setString(4,dept.getTelefono());
            s.setInt(5 , dept.getId());

            s.executeUpdate();


        }catch (SQLException e ){
            System.out.println("consulta ko");
            throw new RuntimeException();
        }
        finally {
            if (s!=null) s.close();
            if (c!=null) c.close();
        }


    }

    @Override
    public void eliminar(int id) throws SQLException {

        Connection c = null;
        c = conector.obtenerConexion();

        PreparedStatement s = null;

        try {

            s = c.prepareStatement("delete from empleados  where idDepartamento = ? ");
            s.setInt(1, id);
            s.executeUpdate();
            s = c.prepareStatement("delete from departamento  where id = ? ");

            s.setInt(1, id);



            s.executeUpdate();


        }catch (SQLException e ){
            System.out.println("consulta ko");
            throw new RuntimeException();
        }
        finally {
            if (s!=null) s.close();
            if (c!=null) c.close();
        }


    }

    public int obtenerId(String nombre) throws SQLException {
        Connection c = null;
        c = conector.obtenerConexion();

        PreparedStatement s = null;

        try {
            s = c.prepareStatement("select id from Departamento where nombre = ? ");
            s . setString(1,nombre);


            ResultSet res = s.executeQuery();


            while(res.next()){
                return res.getInt(1);
            }
            return 0;

        }catch (SQLException e ){
            System.out.println("consulta ko");
            throw new RuntimeException();
        }
        finally {
            if (s!=null) s.close();
            if (c!=null) c.close();
        }
    }


}
