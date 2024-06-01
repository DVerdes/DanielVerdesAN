package com.ontimize.hr.api.core.service;

import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;

import java.util.List;
import java.util.Map;

public interface IGestorService {


    EntityResult gestorQuery(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException;



    EntityResult loginQuery(Map<String, Object> keyMap, List<String> attrList)
            throws OntimizeJEERuntimeException;

    EntityResult gestorInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException;

    EntityResult gestorUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap) throws OntimizeJEERuntimeException;

    EntityResult gestorDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException;
}