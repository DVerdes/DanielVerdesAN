package com.ontimize.hr.api.core.service;

import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;

import java.util.List;
import java.util.Map;

public interface ICamaService {


    EntityResult camaQuery(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException;

    EntityResult camaInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException;

    EntityResult camaUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap) throws OntimizeJEERuntimeException;

    EntityResult camaDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException;
}