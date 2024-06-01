package com.ontimize.hr.ws.core.rest;

import com.ontimize.hr.api.core.service.IGestorService;
import com.ontimize.hr.api.core.service.IVacunaService;
import com.ontimize.jee.server.rest.ORestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gestores")
public class GestorRestController extends ORestController<IGestorService> {

    @Autowired
    private IGestorService gestorService;

    @Override
    public IGestorService getService() {
        return this.gestorService;
    }
}