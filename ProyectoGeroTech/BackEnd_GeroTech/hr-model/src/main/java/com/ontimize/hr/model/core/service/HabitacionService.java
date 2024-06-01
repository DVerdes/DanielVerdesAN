package com.ontimize.hr.model.core.service;

import com.ontimize.hr.api.core.service.ICentroService;
import com.ontimize.hr.api.core.service.IHabitacionService;
import com.ontimize.hr.model.core.dao.CentroDao;
import com.ontimize.hr.model.core.dao.HabitacionDao;
import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("HabitacionService")
@Lazy
public class HabitacionService implements IHabitacionService {

    @Autowired
    private HabitacionDao habitacionDao;
    @Autowired
    private DefaultOntimizeDaoHelper daoHelper;

    @Override
    public EntityResult habitacionQuery(Map<String, Object> keyMap, List<String> attrList)
            throws OntimizeJEERuntimeException {

        return this.daoHelper.query(this.habitacionDao, keyMap, attrList);
    }



    @Override
    public EntityResult habitacionInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException {

        return this.daoHelper.insert(this.habitacionDao, attrMap);
    }

    @Override
    public EntityResult habitacionUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap)
            throws OntimizeJEERuntimeException {
        return this.daoHelper.update(this.habitacionDao, attrMap, keyMap);
    }

    @Override
    public EntityResult habitacionDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException {
        return this.daoHelper.delete(this.habitacionDao, keyMap);
    }

}