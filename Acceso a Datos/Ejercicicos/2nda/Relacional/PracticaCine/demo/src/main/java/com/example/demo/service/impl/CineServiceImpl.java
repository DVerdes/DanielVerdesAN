package com.example.demo.service.impl;

import com.example.demo.dao.CineDAO;
import com.example.demo.dao.SalaDAO;
import com.example.demo.dao.impl.JbdcCineDAO;
import com.example.demo.dao.impl.JdbcSalaDAO;
import com.example.demo.dtos.CineDTO;
import com.example.demo.dtos.SalaDTO;
import com.example.demo.mapper.CineMapper;
import com.example.demo.mapper.SalaMapper;
import com.example.demo.model.Cine;
import com.example.demo.model.Sala;
import com.example.demo.service.CineService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CineServiceImpl implements CineService {
    @Override
    public List<CineDTO> listarCines() throws SQLException {
        CineDAO cd = new JbdcCineDAO();
        List <CineDTO> cinesDto = new ArrayList<CineDTO>();

        for(Cine cine : cd.listarCines()){
            cinesDto.add(CineMapper.cineADTO(cine));
        }

        return cinesDto;



    }

    @Override
    public List<SalaDTO> listarSalasDeCine(int idCine) throws SQLException {
        CineDAO cd = new JbdcCineDAO();
        List <SalaDTO> salasdto = new ArrayList<SalaDTO>();

        for(Sala sala : cd.listarSalasDeCine(idCine)){
            salasdto.add(SalaMapper.salaADTO(sala));
        }

        return salasdto;
    }

    @Override
    public CineDTO insertarCine(CineDTO cineDTO) throws SQLException {
        CineDAO cd = new JbdcCineDAO();
        return CineMapper.cineADTO(cd.insertarCine(CineMapper.dtoACINE(cineDTO)));

    }
}
