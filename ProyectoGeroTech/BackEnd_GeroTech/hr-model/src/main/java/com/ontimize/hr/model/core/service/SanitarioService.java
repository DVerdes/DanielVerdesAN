package com.ontimize.hr.model.core.service;

import com.ontimize.hr.api.core.service.ISanitarioService;
import com.ontimize.hr.model.core.dao.PautaDao;
import com.ontimize.hr.model.core.dao.SanitarioDao;
import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("SanitarioService")
@Lazy
public class SanitarioService implements ISanitarioService {

    @Autowired
    private SanitarioDao SanitarioDao;
    @Autowired
    private PautaDao pautaDao;
    @Autowired
    private DefaultOntimizeDaoHelper daoHelper;

    @Override
    public EntityResult sanitarioQuery(Map<String, Object> keyMap, List<String> attrList)
            throws OntimizeJEERuntimeException {

        return this.daoHelper.query(this.SanitarioDao, keyMap, attrList);
    }



    @Override
    public EntityResult sanitarioInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException {



        return this.daoHelper.insert(this.SanitarioDao, attrMap);


    }

    @Override
    public EntityResult sanitarioUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap)
            throws OntimizeJEERuntimeException {
        return this.daoHelper.update(this.SanitarioDao, attrMap, keyMap);
    }

    @Override
    public EntityResult sanitarioDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException {
        return this.daoHelper.delete(this.SanitarioDao, keyMap);
    }

}