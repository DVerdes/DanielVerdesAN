package com.ontimize.hr.ws.core.rest;

import com.ontimize.hr.api.core.service.ICandidateService;
import com.ontimize.hr.api.core.service.ICentroService;
import com.ontimize.jee.server.rest.ORestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/centros")
public class CentroRestController extends ORestController<ICentroService> {

    @Autowired
    private ICentroService centroService;

    @Override
    public ICentroService getService() {
        return this.centroService;
    }
}