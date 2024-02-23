package dao;

import model.Departamento;
import model.Empleado;

import java.sql.SQLException;
import java.util.List;

public interface EmpleadosDAO {
    List<Empleado> obtenerTodos() throws SQLException;
    List<Empleado> obtenerPorNombre(String nombre) throws SQLException;

    String obtenerDepartamento(String nombre, String apellidos) throws SQLException;

    Empleado obtenerPorID(int id) throws SQLException;

    int crear (Empleado e) throws SQLException;

    void actualizar(Empleado e) throws SQLException;
    void eliminar(int id) throws SQLException;

     void moverEmpleados(int id , List<Empleado> listaEmp) throws SQLException;

}
