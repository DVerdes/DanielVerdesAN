package com.ontimize.hr.model.core.service;

import com.ontimize.hr.api.core.service.IVacunaService;
import com.ontimize.hr.model.core.dao.VacunaDao;
import com.ontimize.hr.model.core.dao.PautaDao;
import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("VacunaService")
@Lazy
public class VacunaService implements IVacunaService {

    @Autowired
    private VacunaDao VacunaDao;
    @Autowired
    private PautaDao pautaDao;
    @Autowired
    private DefaultOntimizeDaoHelper daoHelper;

    @Override
    public EntityResult vacunaQuery(Map<String, Object> keyMap, List<String> attrList)
            throws OntimizeJEERuntimeException {

        return this.daoHelper.query(this.VacunaDao, keyMap, attrList);
    }



    @Override
    public EntityResult vacunaInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException {



        return this.daoHelper.insert(this.VacunaDao, attrMap);


    }

    @Override
    public EntityResult vacunaUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap)
            throws OntimizeJEERuntimeException {
        return this.daoHelper.update(this.VacunaDao, attrMap, keyMap);
    }

    @Override
    public EntityResult vacunaDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException {
        return this.daoHelper.delete(this.VacunaDao, keyMap);
    }

}