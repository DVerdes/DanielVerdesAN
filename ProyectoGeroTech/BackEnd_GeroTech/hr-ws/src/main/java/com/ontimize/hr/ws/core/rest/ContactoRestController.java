package com.ontimize.hr.ws.core.rest;

import com.ontimize.hr.api.core.service.ICamaService;
import com.ontimize.hr.api.core.service.IContactoService;
import com.ontimize.jee.server.rest.ORestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contactos")
public class ContactoRestController extends ORestController<IContactoService> {

    @Autowired
    private IContactoService contactoService;

    @Override
    public IContactoService getService() {
        return this.contactoService;
    }
}