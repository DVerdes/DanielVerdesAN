package com.ontimize.hr.api.core.service;

import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;

import java.util.List;
import java.util.Map;

public interface IPautaService {


    EntityResult pautaQuery(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException;

    EntityResult pautaInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException;

    EntityResult pautaUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap) throws OntimizeJEERuntimeException;

    EntityResult pautaDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException;
}