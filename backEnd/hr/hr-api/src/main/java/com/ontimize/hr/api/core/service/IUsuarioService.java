package com.ontimize.hr.api.core.service;

import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;

import java.util.List;
import java.util.Map;

public interface IUsuarioService {


    EntityResult usuarioQuery(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException;

    EntityResult usuarioInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException;

    EntityResult usuarioUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap) throws OntimizeJEERuntimeException;

    EntityResult usuarioDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException;
}