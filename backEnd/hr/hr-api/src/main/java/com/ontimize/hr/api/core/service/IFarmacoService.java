package com.ontimize.hr.api.core.service;

import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;

import java.util.List;
import java.util.Map;

public interface IFarmacoService {


    EntityResult farmacoQuery(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException;

    EntityResult farmacoInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException;

    EntityResult farmacoUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap) throws OntimizeJEERuntimeException;

    EntityResult farmacoDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException;
}