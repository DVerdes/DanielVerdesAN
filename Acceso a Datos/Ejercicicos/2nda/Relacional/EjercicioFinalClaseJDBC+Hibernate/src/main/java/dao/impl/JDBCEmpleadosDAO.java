package dao.impl;

import dao.DBConector;
import dao.EmpleadosDAO;
import mapper.DepartamentoMapper;
import mapper.EmpleadoMapper;
import model.Departamento;
import model.Empleado;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCEmpleadosDAO implements EmpleadosDAO {
     static DBConector conector = new HikariDBConector();

    public  List<Empleado> obtenerTodos() throws SQLException {

        List<Empleado> listaDept = new ArrayList<>();


        Connection c = null;
        c = conector.obtenerConexion();

        PreparedStatement s = null;

        try {
            s = c.prepareStatement("select * from Empleados");


            ResultSet res = s.executeQuery();


            return EmpleadoMapper.resaLista(res);


        }catch (SQLException e ){
            System.out.println("consulta ko");
            throw new RuntimeException();
        }
        finally {
            if (s!=null) s.close();
            if (c!=null) c.close();
        }



    }
    public static int obtenerNumEmpleados(int idDepartamento) throws SQLException {

        List<Departamento> listaDept = new ArrayList<>();

        Connection c = null;
        c = conector.obtenerConexion();

        PreparedStatement s = null;

        try {
            s = c.prepareStatement("select count(*) from Empleados where idDepartamento like ? ");
            s . setString(1,String.valueOf(idDepartamento));


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

    public List<Empleado> obtenerPorNombre(String nombre) throws SQLException {

        List<Empleado> listaDept = new ArrayList<>();

        Connection c = null;
        c = conector.obtenerConexion();

        PreparedStatement s = null;

        try {
            s = c.prepareStatement("select * from empleados where nombre = ?");
            s . setString(1,nombre );

            ResultSet res = s.executeQuery();


            return EmpleadoMapper.resaLista(res);


        }catch (SQLException e ){
            System.out.println("consulta ko");
            throw new RuntimeException();
        }
        finally {
            if (s!=null) s.close();
            if (c!=null) c.close();
        }

    }

    public String obtenerDepartamento (String nombre , String apellidos) throws SQLException {

        List<Empleado> listaDept = new ArrayList<>();

        Connection c = null;
        c = conector.obtenerConexion();

        PreparedStatement s = null;

        try {
            s = c.prepareStatement("select d.nombre from departamento as d join empleados as e on d.id = e.idDepartamento where e.nombre = ? and e.apellido = ?");
            s . setString(1,nombre  );
            s . setString(2,apellidos  );

            ResultSet res = s.executeQuery();

        while (res.next()){
            return res.getString("nombre");

        }

        return "";


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
    public Empleado obtenerPorID(int id) throws SQLException {

        Connection c = null;
        c = conector.obtenerConexion();

        PreparedStatement s = null;

        try {
            s = c.prepareStatement("select * from Empleados where id = ?");
            s . setInt(1,id);

            ResultSet res = s.executeQuery();


            return EmpleadoMapper.resaEmp(res);


        }catch (SQLException e ){
            System.out.println("consulta ko");
            throw  new RuntimeException();
        }
        finally {
            if (s!=null) s.close();
            if (c!=null) c.close();
        }
    }

    @Override
    public int crear(Empleado e) throws SQLException {
        Connection c = null;
        c = conector.obtenerConexion();

        PreparedStatement s = null;

        try {
            s = c.prepareStatement("insert into empleados (nombre,apellido,pinAcceso,salario , fechaContratacion,direccion, telefono ,email,idDepartamento )values (?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);


            s.setString(1,e.getNombre());
            s.setString(2,e.getApellido());
            s.setString(3,e.getPinAcceso());
            s.setBigDecimal(4,e.getSalario());
            s.setDate(5,e.getFechaContratacion());
            s.setString(6,e.getDireccion());
            s.setString(7,e.getTelefono());
            s.setString(8,e.getEmail());
            s.setInt(9,e.getIdDepartamento());

           s.executeUpdate();

            ResultSet id = s.getGeneratedKeys();
            if (id.next()){

             return id.getInt(1);

            }

            return 0;



        }catch (SQLException ex ){
            System.out.println("consulta ko");
            throw new RuntimeException();
        }
        finally {
            if (s!=null) s.close();
            if (c!=null) c.close();
        }

    }

    @Override
    public void actualizar(Empleado e) throws SQLException {

        Connection c = null;
        c = conector.obtenerConexion();

        PreparedStatement s = null;

        try {
            s = c.prepareStatement("Update empleados set nombre = ?  ,  direccion = ?  ,  email = ?  ,  telefono = ?  where id = ? ");
            s . setString(1,e.getNombre());
            s . setString(2,e.getDireccion());
            s . setString(3,e.getEmail());
            s . setString(4,e.getTelefono());
            s.setInt(5 , e.getId());

            s.executeUpdate();


        }catch (SQLException ex ){
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

            s = c.prepareStatement("delete from empleados  where id = ? ");
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
    public void moverEmpleados(int id , List<Empleado> listaEmp) throws SQLException {

        Connection c = null;
        c = conector.obtenerConexion();

        PreparedStatement s = null;

        try {

            for (Empleado e: listaEmp) {

                s = c.prepareStatement("Update empleados set idDepartamento = ?  where id = ? ");
                s.setInt(2 , e.getId());
                s.setInt(1,id);
                s.executeUpdate();

            }



        }catch (SQLException ex ){
            System.out.println("consulta ko");
            throw new RuntimeException();
        }
        finally {
            if (s!=null) s.close();
            if (c!=null) c.close();
        }

    }


}
