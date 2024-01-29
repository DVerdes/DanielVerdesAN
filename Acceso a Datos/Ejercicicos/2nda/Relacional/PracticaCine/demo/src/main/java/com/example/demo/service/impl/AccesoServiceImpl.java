package com.example.demo.service.impl;

import com.example.demo.dao.AccesoDAO;
import com.example.demo.dao.impl.JbdcAccesoDAO;
import com.example.demo.dtos.AccesoDTO;
import com.example.demo.mapper.AccesoMapper;
import com.example.demo.service.AccesoService;

import java.sql.SQLException;

public class AccesoServiceImpl implements AccesoService {

    @Override
    public boolean validarInicioSesion(AccesoDTO adto) throws SQLException {
        AccesoDAO ad = new JbdcAccesoDAO();
        return ad.comprobarInicioSesion(AccesoMapper.DTOaAcceso(adto));

    }
}
