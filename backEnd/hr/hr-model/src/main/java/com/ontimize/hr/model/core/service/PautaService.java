package com.ontimize.hr.model.core.service;

import com.ontimize.hr.api.core.service.IPautaService;
import com.ontimize.hr.model.core.dao.PautaDao;
import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("PautaService")
@Lazy
public class PautaService implements IPautaService {

    @Autowired
    private PautaDao PautaDao;
    @Autowired
    private DefaultOntimizeDaoHelper daoHelper;

    @Override
    public EntityResult pautaQuery(Map<String, Object> keyMap, List<String> attrList)
            throws OntimizeJEERuntimeException {

        return this.daoHelper.query(this.PautaDao, keyMap, attrList);
    }



    @Override
    public EntityResult pautaInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException {

        return this.daoHelper.insert(this.PautaDao, attrMap);
    }

    @Override
    public EntityResult pautaUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap)
            throws OntimizeJEERuntimeException {
        return this.daoHelper.update(this.PautaDao, attrMap, keyMap);
    }

    @Override
    public EntityResult pautaDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException {
        return this.daoHelper.delete(this.PautaDao, keyMap);
    }

}