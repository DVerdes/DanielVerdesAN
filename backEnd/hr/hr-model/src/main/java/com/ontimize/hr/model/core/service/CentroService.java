package com.ontimize.hr.model.core.service;

import com.ontimize.hr.api.core.service.ICentroService;
import com.ontimize.hr.model.core.dao.CentroDao;
import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("CentroService")
@Lazy
public class CentroService implements ICentroService {

    @Autowired
    private CentroDao centroDao;
    @Autowired
    private DefaultOntimizeDaoHelper daoHelper;

    @Override
    public EntityResult centroQuery(Map<String, Object> keyMap, List<String> attrList)
            throws OntimizeJEERuntimeException {

        return this.daoHelper.query(this.centroDao, keyMap, attrList);
    }



    @Override
    public EntityResult centroInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException {

        return this.daoHelper.insert(this.centroDao, attrMap);
    }

    @Override
    public EntityResult centroUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap)
            throws OntimizeJEERuntimeException {
        return this.daoHelper.update(this.centroDao, attrMap, keyMap);
    }

    @Override
    public EntityResult centroDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException {
        return this.daoHelper.delete(this.centroDao, keyMap);
    }

}