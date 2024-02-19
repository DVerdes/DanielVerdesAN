package org.example.dao.impl;

import org.example.dao.DBConnector;
import org.example.dao.EmpleadoDao;
import org.example.mapper.DepartamentoMapper;
import org.example.mapper.EmpleadoMapper;
import org.example.model.Empleado;

import java.sql.*;
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

    @Override
    public List<Empleado> listarPorNombre(String nombre) throws SQLException {


        Connection c = connector.obtenerConexion();
        PreparedStatement s = null;
        try{
            s = c.prepareStatement("SELECT * FROM Empleados WHERE nombre like ?");
            s.setString(1,"%"+nombre+"%");


            return EmpleadoMapper.resALista(s.executeQuery());

        }catch (SQLException e){
            System.out.println("Consulta KO");
            throw new RuntimeException(e);
        }finally {
            if(s!=null) s.close();;
            if (c!=null) c.close();
        }

    }

    @Override
    public Empleado obtenerEmpleado(int id) throws SQLException {
        Connection c = connector.obtenerConexion();
        PreparedStatement s = null;
        try{
            s = c.prepareStatement("SELECT * FROM Empleados WHERE id like ?");
            s.setString(1,"%"+id+"%");
            ResultSet res = s.executeQuery();
            while (res.next()) return EmpleadoMapper.resAEmp(res);

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
    public int insertarEmpleado(Empleado empleado) throws SQLException {

        Connection c = connector.obtenerConexion();
        PreparedStatement s = null;
        try{
            s = c.prepareStatement("INSERT INTO Empleados (nombre,apellido,pinAcceso,salario,fechaContratacion,direccion,telefono,email,idDepartamento) VALUES (?,?,?,?,?,?,?,?,?);",
                    Statement.RETURN_GENERATED_KEYS);
            s.setString(1,empleado.getNombre());
            s.setString(2,empleado.getApellido());
            s.setString(3, empleado.getPinAcceso());
            s.setBigDecimal(4,empleado.getSalario());
            s.setDate(5, empleado.getFechaContratacion());
            s.setString(6, empleado.getDireccion());
            s.setString(7, empleado.getTelefono());
            s.setString(8,empleado.getEmail());
            s.setInt(9,empleado.getIdDepartamento());

            s.executeUpdate();
            System.out.println("Insertar empleado ok");

            //Obtener ID insertado
            ResultSet generatedKeys = s.getGeneratedKeys();
            if(generatedKeys.next()){
                return generatedKeys.getInt(1);
            }
        }catch (SQLException e){
            System.out.println("Insertar empleado KO");
            throw new RuntimeException(e);
        }finally {
            if(s!=null) s.close();;
            if (c!=null) c.close();
        }
        return 0;


    }

    @Override
    public void actualizarEmpleado(Empleado empleado) throws SQLException {
        Connection c = connector.obtenerConexion();
        PreparedStatement s = null;
        try{
            s = c.prepareStatement("UPDATE Empleados SET nombre=?,apellido = ?, pinAcceso = ?, salario = ?, fechaContratacion= ?, direccion  = ?, telefono = ?, email= ?, idDepartamento = ? WHERE id = ?");
            s.setString(1,empleado.getNombre());
            s.setString(2,empleado.getApellido());
            s.setString(3, empleado.getPinAcceso());
            s.setBigDecimal(4,empleado.getSalario());
            s.setDate(5, empleado.getFechaContratacion());
            s.setString(6, empleado.getDireccion());
            s.setString(7, empleado.getTelefono());
            s.setString(8,empleado.getEmail());
            s.setInt(9,empleado.getIdDepartamento());
            s.setInt(10,empleado.getId());

            s.executeUpdate();
            System.out.println("Actualizar empleado ok");

        }catch (SQLException e){
            System.out.println("Actualizar empleado ko");
            throw new RuntimeException(e);
        }finally {
            if(s!=null) s.close();;
            if(c!=null) c.close();
        }
    }

    @Override
    public void elimarEmpleado(int id) throws SQLException {
        Connection c = connector.obtenerConexion();
        PreparedStatement s = null;
        try{
            s = c.prepareStatement("DELETE FROM Empleados WHERE id = ?");
            s.setInt(1,id);
            s.executeUpdate();
            System.out.println("borrado ok");


        }catch (SQLException e){
            System.out.println("borrado ko");
            throw new RuntimeException(e);
        }finally {
            if(s!=null) s.close();;
            if(c!=null) c.close();
        }
    }
}
