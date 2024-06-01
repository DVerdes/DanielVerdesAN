package com.ontimize.hr.api.core.service;

import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;

import java.util.List;
import java.util.Map;

public interface IContactoService {


    EntityResult contactoQuery(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException;

    EntityResult contactosUsuarioQuery(Map<String, Object> keyMap, List<String> attrList)
            throws OntimizeJEERuntimeException;

    EntityResult contactoInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException;

    EntityResult contactoUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap) throws OntimizeJEERuntimeException;

    EntityResult contactoDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException;
}