package com.example.demo.service.impl;

import com.example.demo.dao.SalaDAO;
import com.example.demo.dao.SesionDAO;
import com.example.demo.dao.impl.JbdcSesionDAO;
import com.example.demo.dao.impl.JdbcSalaDAO;
import com.example.demo.dtos.PeliculaDTO;
import com.example.demo.dtos.SesionDTO;
import com.example.demo.mapper.PeliculaMapper;
import com.example.demo.mapper.SalaMapper;
import com.example.demo.mapper.SesionMapper;
import com.example.demo.model.Pelicula;
import com.example.demo.model.Sesion;
import com.example.demo.service.SesionService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SesionServiceImpl implements SesionService {
    @Override
    public SesionDTO insertarSesion(SesionDTO sesionDTO) throws SQLException {
        SesionDAO sd = new JbdcSesionDAO();

        return SesionMapper.sesionADTO(sd.insertarSesion(SesionMapper.dtoASESION(sesionDTO)));
    }

    @Override
    public List<SesionDTO> listarSesionesdePelicula(int idPelicula) throws SQLException {
        SesionDAO sd = new JbdcSesionDAO();

        List <SesionDTO> sesionesDto = new ArrayList<SesionDTO>();

        for(Sesion sesion : sd.listarSesionesDePelicula(idPelicula)){
            sesionesDto.add(SesionMapper.sesionADTO(sesion));
        }

        return sesionesDto;
    }
}
