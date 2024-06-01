package com.ontimize.hr.ws.core.rest;

import com.ontimize.hr.api.core.service.ICamaService;
import com.ontimize.hr.api.core.service.IUsuarioContactoService;
import com.ontimize.jee.server.rest.ORestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarioContactos")
public class UsuarioContactoRestController extends ORestController<IUsuarioContactoService> {

    @Autowired
    private IUsuarioContactoService usuarioContactoService;

    @Override
    public IUsuarioContactoService getService() {
        return this.usuarioContactoService;
    }
}