package com.example.demo.mapper;

import com.example.demo.dtos.UsuarioDTO;
import com.example.demo.model.Usuario;

public class UsuarioMapper {



public static Usuario DTOaUsuario(UsuarioDTO usuarioDTO){
    return new Usuario(usuarioDTO.getNombreUsuario(),usuarioDTO.getEmail(), usuarioDTO.getClaveAcceso(),usuarioDTO.getRol());
}

    public static UsuarioDTO UsuarioaDTO(Usuario usuario){

        return new UsuarioDTO(usuario.getNombreUsuario(),usuario.getEmail(), usuario.getClaveAcceso());
    }


}
