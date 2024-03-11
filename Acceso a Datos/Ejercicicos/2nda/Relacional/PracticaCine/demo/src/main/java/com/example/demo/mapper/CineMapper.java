package com.example.demo.mapper;

import com.example.demo.dtos.CineDTO;
import com.example.demo.model.Cine;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Mapper de cine
 */
public class CineMapper {

    public static List<Cine> resALista(ResultSet res) throws SQLException {
        List<Cine> cines = new ArrayList<Cine>();
        while (res.next()){
            cines.add(new Cine(res.getInt("CineID"), res.getString("NombreCine"),res.getString("Direccion")));
        }
        return cines;
    }

    public static CineDTO cineADTO (Cine cine){
        return new CineDTO(cine.getCineId(),cine.getNombreCine(),cine.getDireccion());
    }

    public static Cine dtoACINE (CineDTO cine){
        return new Cine(cine.getCineId(),cine.getNombreCine(),cine.getDireccion());
    }

}
