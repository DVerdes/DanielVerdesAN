package org.example.service.impl;

import org.example.dao.DepartamentoDao;
import org.example.dao.EmpleadoDao;
import org.example.dao.impl.JbdcDepartamentoDao;
import org.example.dao.impl.JbdcEmpleadoDao;
import org.example.dao.impl.OrmDepartamentoDAO;
import org.example.dao.impl.OrmEmpleadoDAO;
import org.example.dto.EmpleadoDTO;
import org.example.mapper.DepartamentoMapper;
import org.example.mapper.EmpleadoMapper;
import org.example.model.Departamento;
import org.example.model.Empleado;
import org.example.service.EmpleadoService;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class EmpleadoServiceImpl implements EmpleadoService {
    @Override
    public List<EmpleadoDTO> obtenerTodos() throws SQLException {
        EmpleadoDao ed = new OrmEmpleadoDAO();
        DepartamentoDao dd = new OrmDepartamentoDAO();




        HashMap<Empleado, String> empleadoStringHashMap = new HashMap<Empleado, String>();

        for(Empleado emp : ed.listar()){
            empleadoStringHashMap.put(emp,dd.obtenerDepartamento(emp.getIdDepartamento()).getNombre());
        }



        return EmpleadoMapper.convertirLista(empleadoStringHashMap);
    }

    @Override
    public List<EmpleadoDTO> obtenerPorNombre(String nombre) throws SQLException {
        EmpleadoDao ed = new OrmEmpleadoDAO();
        DepartamentoDao dd = new OrmDepartamentoDAO();


        HashMap<Empleado, String> empleadosHashMap = new HashMap<Empleado, String>();

        for(Empleado emp : ed.listarPorNombre(nombre)){
                empleadosHashMap.put(emp,dd.obtenerDepartamento(emp.getIdDepartamento()).getNombre());
        }




        return EmpleadoMapper.convertirLista(empleadosHashMap);

    }

    @Override
    public EmpleadoDTO obtenerPorId(int id) throws SQLException {
        EmpleadoDao ed = new OrmEmpleadoDAO();
        DepartamentoDao dd = new OrmDepartamentoDAO();


        return EmpleadoMapper.convertirADTO(ed.obtenerEmpleado(id),dd.obtenerDepartamento(ed.obtenerEmpleado(id).getIdDepartamento()).getNombre());
    }

    @Override
    public int crear(EmpleadoDTO entidad) throws SQLException {
        EmpleadoDao ed = new OrmEmpleadoDAO();


        return ed.insertarEmpleado(EmpleadoMapper.convertirAEmpleado(entidad));
    }

    @Override
    public void actualizar(EmpleadoDTO entidad) throws SQLException {
        EmpleadoDao ed = new OrmEmpleadoDAO();

        ed.actualizarEmpleado(EmpleadoMapper.convertirAEmpleado(entidad));

    }

    @Override
    public void eliminar(int id) throws SQLException {
        EmpleadoDao ed = new OrmEmpleadoDAO();
        ed.elimarEmpleado(id);
    }

    @Override
    public void moverEmpleados(int idDepartamento, List<EmpleadoDTO> lista) {

    }
}
