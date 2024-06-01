package com.ontimize.hr.ws.core.rest;

import com.ontimize.hr.api.core.service.ICamaService;
import com.ontimize.hr.api.core.service.IHabitarService;
import com.ontimize.jee.server.rest.ORestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/habitares")
public class HabitarRestController extends ORestController<IHabitarService> {

    @Autowired
    private IHabitarService habitarService;

    @Override
    public IHabitarService getService() {
        return this.habitarService;
    }
}