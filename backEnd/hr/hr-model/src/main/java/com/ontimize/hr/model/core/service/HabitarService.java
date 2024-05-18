package com.ontimize.hr.model.core.service;

import com.ontimize.hr.api.core.service.IHabitarService;
import com.ontimize.hr.model.core.dao.HabitarDao;
import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("HabitarService")
@Lazy
public class HabitarService implements IHabitarService {

    @Autowired
    private HabitarDao HabitarDao;
    @Autowired
    private DefaultOntimizeDaoHelper daoHelper;

    @Override
    public EntityResult habitarQuery(Map<String, Object> keyMap, List<String> attrList)
            throws OntimizeJEERuntimeException {

        return this.daoHelper.query(this.HabitarDao, keyMap, attrList);
    }



    @Override
    public EntityResult habitarInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException {

        return this.daoHelper.insert(this.HabitarDao, attrMap);
    }

    @Override
    public EntityResult habitarUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap)
            throws OntimizeJEERuntimeException {
        return this.daoHelper.update(this.HabitarDao, attrMap, keyMap);
    }

    @Override
    public EntityResult habitarDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException {
        return this.daoHelper.delete(this.HabitarDao, keyMap);
    }

}