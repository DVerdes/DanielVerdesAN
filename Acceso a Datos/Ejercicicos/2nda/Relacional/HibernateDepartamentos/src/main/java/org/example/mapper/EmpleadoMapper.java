package org.example.mapper;

import org.example.dto.EmpleadoDTO;
import org.example.model.Departamento;
import org.example.model.Empleado;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EmpleadoMapper {

    public static List<Empleado> resALista(ResultSet res) throws SQLException {
        List<Empleado> empleados = new ArrayList<Empleado>();
        while (res.next()){
            empleados.add(new Empleado(res.getInt("id"), res.getString("nombre"),res.getString("apellido"),res.getString("pinAcceso"),res.getBigDecimal("salario"),res.getDate("fechaContratacion"),res.getString("direccion"),res.getString("telefono"),res.getString("email"),res.getInt("idDepartamento")));
        }
        return empleados;
    }

    public static EmpleadoDTO convertirADTO(Empleado empleado, String nombreDepartamento) throws SQLException {
        return new EmpleadoDTO(empleado.getNombre(),empleado.getApellido(),empleado.getSalario().doubleValue(),empleado.getFechaContratacion(), empleado.getDireccion(),empleado.getTelefono(), empleado.getEmail(),empleado.getIdDepartamento(), nombreDepartamento);
    }

    public static List<EmpleadoDTO> convertirLista(HashMap<Empleado, String> empleadoStringHashMap) throws SQLException {

        List <EmpleadoDTO> listaDTO = new ArrayList<>();

        for (Empleado i : empleadoStringHashMap.keySet()) {
            listaDTO.add(convertirADTO(i,empleadoStringHashMap.get(i)));
        }



        return listaDTO;

    }


    public static Empleado resAEmp(ResultSet res) throws SQLException {
        return new Empleado(res.getInt("id"),res.getString("nombre"),res.getString("apellido"),res.getString("pinAcceso"),res.getBigDecimal("salario"), res.getDate("fechaContratacion"),res.getString("direccion"),res.getString("telefono"),res.getString("email"),res.getInt("idDepartamento"));
    }


    public static Empleado convertirAEmpleado(EmpleadoDTO entidad) {
        return new Empleado(entidad.getId(), entidad.getNombre(), entidad.getApellido(), "", BigDecimal.valueOf(entidad.getSalario()),entidad.getFechaContratacion(), entidad.getDireccion(), entidad.getTelefono(), entidad.getEmail(), entidad.getIdDepartamento());

    }
}
