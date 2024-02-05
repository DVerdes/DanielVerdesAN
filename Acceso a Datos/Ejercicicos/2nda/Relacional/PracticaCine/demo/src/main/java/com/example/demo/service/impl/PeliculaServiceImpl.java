package com.example.demo.service.impl;

import com.example.demo.dao.CineDAO;
import com.example.demo.dao.PeliculaDAO;
import com.example.demo.dao.SalaDAO;
import com.example.demo.dao.impl.JbdcCineDAO;
import com.example.demo.dao.impl.JbdcPeliculaDAO;
import com.example.demo.dao.impl.JdbcSalaDAO;
import com.example.demo.dtos.PeliculaDTO;
import com.example.demo.dtos.SalaDTO;
import com.example.demo.mapper.PeliculaMapper;
import com.example.demo.mapper.SalaMapper;
import com.example.demo.model.Pelicula;
import com.example.demo.model.Sala;
import com.example.demo.service.PeliculaService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PeliculaServiceImpl implements PeliculaService {
    @Override
    public PeliculaDTO insertarPelicula(PeliculaDTO peliculaDTO) throws SQLException {
        PeliculaDAO sd = new JbdcPeliculaDAO();

        return PeliculaMapper.peliADTO(sd.insertarPelicula(PeliculaMapper.DTOaPeli(peliculaDTO)));
    }

    @Override
    public List<PeliculaDTO> listarPeliculasDeCine(int idCine) throws SQLException {
        PeliculaDAO cd = new JbdcPeliculaDAO();
        List <PeliculaDTO> peliculaDTOS = new ArrayList<PeliculaDTO>();

        for(Pelicula peli : cd.listarPeliculasCine(idCine)){
            peliculaDTOS.add(PeliculaMapper.peliADTO(peli));
        }

        return peliculaDTOS;
    }
}
