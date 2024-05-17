package com.ontimize.hr.ws.core.rest;

import com.ontimize.hr.api.core.service.ICamaService;
import com.ontimize.hr.api.core.service.IHabitacionService;
import com.ontimize.jee.server.rest.ORestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/camas")
public class CamaRestController extends ORestController<ICamaService> {

    @Autowired
    private ICamaService camaService;

    @Override
    public ICamaService getService() {
        return this.camaService;
    }
}