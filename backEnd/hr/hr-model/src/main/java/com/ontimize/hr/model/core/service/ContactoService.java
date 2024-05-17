package com.ontimize.hr.model.core.service;

import com.ontimize.hr.api.core.service.IContactoService;
import com.ontimize.hr.model.core.dao.ContactoDao;
import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("ContactoService")
@Lazy
public class ContactoService implements IContactoService {

    @Autowired
    private ContactoDao ContactoDao;
    @Autowired
    private DefaultOntimizeDaoHelper daoHelper;

    @Override
    public EntityResult contactoQuery(Map<String, Object> keyMap, List<String> attrList)
            throws OntimizeJEERuntimeException {

        return this.daoHelper.query(this.ContactoDao, keyMap, attrList);
    }



    @Override
    public EntityResult contactoInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException {

        return this.daoHelper.insert(this.ContactoDao, attrMap);
    }

    @Override
    public EntityResult contactoUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap)
            throws OntimizeJEERuntimeException {
        return this.daoHelper.update(this.ContactoDao, attrMap, keyMap);
    }

    @Override
    public EntityResult contactoDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException {
        return this.daoHelper.delete(this.ContactoDao, keyMap);
    }

}