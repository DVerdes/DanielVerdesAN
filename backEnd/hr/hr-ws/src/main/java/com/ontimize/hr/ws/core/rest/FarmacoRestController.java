package com.ontimize.hr.ws.core.rest;

import com.ontimize.hr.api.core.service.ICamaService;
import com.ontimize.hr.api.core.service.IFarmacoService;
import com.ontimize.jee.server.rest.ORestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/farmacos")
public class FarmacoRestController extends ORestController<IFarmacoService> {

    @Autowired
    private IFarmacoService farmacoService;

    @Override
    public IFarmacoService getService() {
        return this.farmacoService;
    }
}