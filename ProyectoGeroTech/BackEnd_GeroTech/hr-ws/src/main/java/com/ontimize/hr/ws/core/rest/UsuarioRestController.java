package com.ontimize.hr.ws.core.rest;

import com.ontimize.hr.api.core.service.IHabitarService;
import com.ontimize.hr.api.core.service.IUsuarioService;
import com.ontimize.jee.server.rest.ORestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioRestController extends ORestController<IUsuarioService> {

    @Autowired
    private IUsuarioService usuarioService;

    @Override
    public IUsuarioService getService() {
        return this.usuarioService;
    }
}