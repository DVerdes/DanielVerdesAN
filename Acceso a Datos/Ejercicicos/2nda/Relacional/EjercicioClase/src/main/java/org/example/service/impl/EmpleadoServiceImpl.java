package org.example.service.impl;

import org.example.dao.DepartamentoDao;
import org.example.dao.EmpleadoDao;
import org.example.dao.impl.JbdcDepartamentoDao;
import org.example.dao.impl.JbdcEmpleadoDao;
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
        EmpleadoDao ed = new JbdcEmpleadoDao();
        DepartamentoDao dd = new JbdcDepartamentoDao();




        HashMap<Empleado, String> empleadoStringHashMap = new HashMap<Empleado, String>();

        for(Empleado emp : ed.listar()){
            empleadoStringHashMap.put(emp,dd.obtenerDepartamento(emp.getIdDepartamento()).getNombre());
        }



        return EmpleadoMapper.convertirLista(empleadoStringHashMap);
    }

    @Override
    public List<EmpleadoDTO> obtenerPorNombre(String nombre) {
        return null;
    }

    @Override
    public EmpleadoDTO obtenerPorId(int id) {
        return null;
    }

    @Override
    public int crear(EmpleadoDTO entidad) {
        return 0;
    }

    @Override
    public void actualizar(EmpleadoDTO entidad) {

    }

    @Override
    public void eliminar(int id) {

    }

    @Override
    public void moverEmpleados(int idDepartamento, List<EmpleadoDTO> lista) {

    }
}
