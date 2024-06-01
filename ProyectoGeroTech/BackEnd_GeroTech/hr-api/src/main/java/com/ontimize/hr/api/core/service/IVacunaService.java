package com.ontimize.hr.api.core.service;

import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;

import java.util.List;
import java.util.Map;

public interface IVacunaService {


    EntityResult vacunaQuery(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException;

    EntityResult vacunaInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException;

    EntityResult vacunaUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap) throws OntimizeJEERuntimeException;

    EntityResult vacunaDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException;
}