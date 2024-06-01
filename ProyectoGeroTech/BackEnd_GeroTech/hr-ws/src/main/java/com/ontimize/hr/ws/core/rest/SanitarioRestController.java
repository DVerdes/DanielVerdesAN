package com.ontimize.hr.ws.core.rest;

import com.ontimize.hr.api.core.service.IGestorService;
import com.ontimize.hr.api.core.service.ISanitarioService;
import com.ontimize.jee.server.rest.ORestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sanitarios")
public class SanitarioRestController extends ORestController<ISanitarioService> {

    @Autowired
    private ISanitarioService sanitarioService;

    @Override
    public ISanitarioService getService() {
        return this.sanitarioService;
    }
}