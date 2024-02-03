package com.example.demo.mapper;

import com.example.demo.dtos.PeliculaDTO;
import com.example.demo.model.Pelicula;
import com.example.demo.model.Sala;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PeliculaMapper {

    public static Pelicula DTOaPeli (PeliculaDTO pdto){
        return new Pelicula(pdto.getPeliculaID(),pdto.getSalaID(),pdto.getTitulo(),pdto.getFechaInicio(),pdto.getFechaFin(),pdto.getGenero(),pdto.getClasificacionEdad());
    }

    public static PeliculaDTO peliADTO (Pelicula peli){
        return new PeliculaDTO(peli.getPeliculaID(),peli.getSalaID(),peli.getTitulo(),peli.getFechaInicio(),peli.getFechaFin(),peli.getGenero(),peli.getClasificacionEdad());
    }


    public static List<Pelicula> resALista(ResultSet res) throws SQLException {
        List<Pelicula> peliculas = new ArrayList<Pelicula>();
        while (res.next()){
            peliculas.add(new Pelicula(res.getInt("PeliculaID"),res.getInt("SalaID"), res.getString("Titulo"),res.getDate("FechaInicio"),res.getDate("FechaFin"),res.getString("Genero"),res.getInt("ClasificacionEdad")));
        }
        return peliculas;
    }
}
