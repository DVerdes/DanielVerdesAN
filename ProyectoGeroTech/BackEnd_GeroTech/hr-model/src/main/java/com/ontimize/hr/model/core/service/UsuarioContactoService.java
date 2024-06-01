package com.ontimize.hr.model.core.service;

import com.ontimize.hr.api.core.service.IUsuarioContactoService;
import com.ontimize.hr.model.core.dao.UsuarioContactoDao;
import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("UsuarioContactoService")
@Lazy
public class UsuarioContactoService implements IUsuarioContactoService {

    @Autowired
    private UsuarioContactoDao UsuarioContactoDao;
    @Autowired
    private DefaultOntimizeDaoHelper daoHelper;

    @Override
    public EntityResult usuarioContactoQuery(Map<String, Object> keyMap, List<String> attrList)
            throws OntimizeJEERuntimeException {

        return this.daoHelper.query(this.UsuarioContactoDao, keyMap, attrList);
    }



    @Override
    public EntityResult usuarioContactoInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException {

        return this.daoHelper.insert(this.UsuarioContactoDao, attrMap);
    }

    @Override
    public EntityResult usuarioContactoUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap)
            throws OntimizeJEERuntimeException {
        return this.daoHelper.update(this.UsuarioContactoDao, attrMap, keyMap);
    }

    @Override
    public EntityResult usuarioContactoDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException {
        return this.daoHelper.delete(this.UsuarioContactoDao, keyMap);
    }

}