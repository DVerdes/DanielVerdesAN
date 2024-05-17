package com.ontimize.hr.model.core.service;

import com.ontimize.hr.api.core.service.IUsuarioService;
import com.ontimize.hr.model.core.dao.UsuarioDao;
import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("UsuarioService")
@Lazy
public class UsuarioService implements IUsuarioService {

    @Autowired
    private UsuarioDao UsuarioDao;
    @Autowired
    private DefaultOntimizeDaoHelper daoHelper;

    @Override
    public EntityResult usuarioQuery(Map<String, Object> keyMap, List<String> attrList)
            throws OntimizeJEERuntimeException {

        return this.daoHelper.query(this.UsuarioDao, keyMap, attrList);
    }



    @Override
    public EntityResult usuarioInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException {

        return this.daoHelper.insert(this.UsuarioDao, attrMap);
    }

    @Override
    public EntityResult usuarioUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap)
            throws OntimizeJEERuntimeException {
        return this.daoHelper.update(this.UsuarioDao, attrMap, keyMap);
    }

    @Override
    public EntityResult usuarioDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException {
        return this.daoHelper.delete(this.UsuarioDao, keyMap);
    }

}