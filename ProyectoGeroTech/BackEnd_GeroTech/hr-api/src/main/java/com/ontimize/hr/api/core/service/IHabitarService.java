package com.ontimize.hr.api.core.service;

import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;

import java.util.List;
import java.util.Map;

public interface IHabitarService {


    EntityResult habitarQuery(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException;

    EntityResult habitarInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException;

    EntityResult habitarUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap) throws OntimizeJEERuntimeException;

    EntityResult habitarDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException;
}