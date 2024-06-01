package com.ontimize.hr.ws.core.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ontimize.hr.api.core.service.ICandidateService;
import com.ontimize.jee.server.rest.ORestController;

@RestController
@RequestMapping("/candidates")
public class CandidateRestController extends ORestController<ICandidateService> {

    @Autowired
    private ICandidateService candidateService;

    @Override
    public ICandidateService getService() {
        return this.candidateService;
    }
}