package com.example.demo.mapper;

import com.example.demo.dtos.AccesoDTO;
import com.example.demo.model.Acceso;

public class AccesoMapper {

    public static Acceso DTOaAcceso(AccesoDTO adto){
        return new Acceso(adto.getNombreUsuario(),adto.getClaveAcceso());
    }

    public static AccesoDTO AccaDTO(Acceso acc){
        return new AccesoDTO(acc.getNombreUsuario(),acc.getClaveAcceso());
    }
}
