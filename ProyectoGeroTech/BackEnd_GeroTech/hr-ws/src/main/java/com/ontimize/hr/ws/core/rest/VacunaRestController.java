package com.ontimize.hr.ws.core.rest;

import com.ontimize.hr.api.core.service.IFarmacoService;
import com.ontimize.hr.api.core.service.IVacunaService;
import com.ontimize.jee.server.rest.ORestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vacunas")
public class VacunaRestController extends ORestController<IVacunaService> {

    @Autowired
    private IVacunaService vacunaService;

    @Override
    public IVacunaService getService() {
        return this.vacunaService;
    }
}