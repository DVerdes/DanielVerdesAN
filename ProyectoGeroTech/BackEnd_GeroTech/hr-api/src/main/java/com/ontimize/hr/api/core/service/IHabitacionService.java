package com.ontimize.hr.api.core.service;

import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;

import java.util.List;
import java.util.Map;

public interface IHabitacionService {


    EntityResult habitacionQuery(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException;

    EntityResult habitacionInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException;

    EntityResult habitacionUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap) throws OntimizeJEERuntimeException;

    EntityResult habitacionDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException;
}