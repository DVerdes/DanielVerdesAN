package com.ontimize.hr.ws.core.rest;

import com.ontimize.hr.api.core.service.ICentroService;
import com.ontimize.hr.api.core.service.IHabitacionService;
import com.ontimize.jee.server.rest.ORestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/habitaciones")
public class HabitacionRestController extends ORestController<IHabitacionService> {

    @Autowired
    private IHabitacionService habitacionService;

    @Override
    public IHabitacionService getService() {
        return this.habitacionService;
    }
}