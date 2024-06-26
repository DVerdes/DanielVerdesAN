package com.ontimize.hr.api.core.service;

import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;

import java.util.List;
import java.util.Map;

public interface IUsuarioContactoService {


    EntityResult usuarioContactoQuery(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException;

    EntityResult usuarioContactoInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException;

    EntityResult usuarioContactoUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap) throws OntimizeJEERuntimeException;

    EntityResult usuarioContactoDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException;
}