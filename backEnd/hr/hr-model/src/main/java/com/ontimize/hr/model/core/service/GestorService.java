package com.ontimize.hr.model.core.service;

import com.ontimize.hr.api.core.service.IGestorService;
import com.ontimize.hr.model.core.dao.PautaDao;
import com.ontimize.hr.model.core.dao.GestorDao;
import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("GestorService")
@Lazy
public class GestorService implements IGestorService {

    @Autowired
    private GestorDao GestorDao;
    @Autowired
    private PautaDao pautaDao;
    @Autowired
    private DefaultOntimizeDaoHelper daoHelper;

    @Override
    public EntityResult gestorQuery(Map<String, Object> keyMap, List<String> attrList)
            throws OntimizeJEERuntimeException {

        return this.daoHelper.query(this.GestorDao, keyMap, attrList);
    }


    @Override
    public EntityResult loginQuery(Map<String, Object> keyMap, List<String> attrList)
            throws OntimizeJEERuntimeException {



        EntityResult er = this.daoHelper.query(this.GestorDao, keyMap, attrList);



        return er;
    }



    @Override
    public EntityResult gestorInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException {



        return this.daoHelper.insert(this.GestorDao, attrMap);


    }



    @Override
    public EntityResult gestorUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap)
            throws OntimizeJEERuntimeException {
        return this.daoHelper.update(this.GestorDao, attrMap, keyMap);
    }

    @Override
    public EntityResult gestorDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException {
        return this.daoHelper.delete(this.GestorDao, keyMap);
    }

}