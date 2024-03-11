package com.example.demo.mapper;

import com.example.demo.dtos.SalaDTO;
import com.example.demo.dtos.SesionDTO;
import com.example.demo.model.Sala;
import com.example.demo.model.Sesion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Mapper de sesisón
 */
public class SesionMapper {

    public static SesionDTO sesionADTO (Sesion sesion){
        return new SesionDTO(sesion.getSesionID(),sesion.getPeliculaID(),sesion.getHoraInicio(),sesion.getHoraFin());
    }

    public static Sesion dtoASESION (SesionDTO sesion){
        return new Sesion(sesion.getSesionID(),sesion.getPeliculaID(),sesion.getHoraInicio(),sesion.getHoraFin());
    }


    public static List<Sesion> resALista(ResultSet res) throws SQLException {
        List<Sesion> sesiones = new ArrayList<Sesion>();
        while (res.next()){
            sesiones.add(new Sesion(res.getInt("SesionID"),res.getInt("PeliculaID"),res.getTimestamp("HoraInicio"),res.getTimestamp("HoraFin")));
        }
        return sesiones;
    }

}
