package com.ontimize.hr.model.core.service;

import com.ontimize.hr.api.core.service.ICamaService;
import com.ontimize.hr.model.core.dao.CamaDao;
import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("CamaService")
@Lazy
public class CamaService implements ICamaService {

    @Autowired
    private CamaDao CamaDao;
    @Autowired
    private DefaultOntimizeDaoHelper daoHelper;

    @Override
    public EntityResult camaQuery(Map<String, Object> keyMap, List<String> attrList)
            throws OntimizeJEERuntimeException {

        return this.daoHelper.query(this.CamaDao, keyMap, attrList);
    }

    @Override
    public EntityResult camaCentroQuery(Map<String, Object> keyMap, List<String> attrList)
            throws OntimizeJEERuntimeException {

        return this.daoHelper.query(this.CamaDao, keyMap, attrList,"camasCentro");
    }



    @Override
    public EntityResult camaInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException {

        return this.daoHelper.insert(this.CamaDao, attrMap);
    }

    @Override
    public EntityResult camaUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap)
            throws OntimizeJEERuntimeException {
        return this.daoHelper.update(this.CamaDao, attrMap, keyMap);
    }

    @Override
    public EntityResult camaDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException {
        return this.daoHelper.delete(this.CamaDao, keyMap);
    }

}