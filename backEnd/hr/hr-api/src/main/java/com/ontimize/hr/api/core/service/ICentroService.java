package com.ontimize.hr.api.core.service;

import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;

import java.util.List;
import java.util.Map;

public interface ICentroService {


    EntityResult centroQuery(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException;

    EntityResult centroOtroQuery(Map<String, Object> keyMap, List<String> attrList)
            throws OntimizeJEERuntimeException;

    EntityResult centroInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException;

    EntityResult centroUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap) throws OntimizeJEERuntimeException;

    EntityResult centroDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException;
}