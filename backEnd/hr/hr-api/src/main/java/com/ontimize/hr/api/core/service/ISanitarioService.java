package com.ontimize.hr.api.core.service;

import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;

import java.util.List;
import java.util.Map;

public interface ISanitarioService {


    EntityResult sanitarioQuery(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException;

    EntityResult sanitarioInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException;

    EntityResult sanitarioUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap) throws OntimizeJEERuntimeException;

    EntityResult sanitarioDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException;
}