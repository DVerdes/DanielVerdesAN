package com.ontimize.hr.model.core.service;

import com.ontimize.hr.api.core.service.IFarmacoService;
import com.ontimize.hr.model.core.dao.FarmacoDao;
import com.ontimize.hr.model.core.dao.PautaDao;
import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("FarmacoService")
@Lazy
public class FarmacoService implements IFarmacoService {

    @Autowired
    private FarmacoDao FarmacoDao;
    @Autowired
    private PautaDao pautaDao;
    @Autowired
    private DefaultOntimizeDaoHelper daoHelper;

    @Override
    public EntityResult farmacoQuery(Map<String, Object> keyMap, List<String> attrList)
            throws OntimizeJEERuntimeException {

        return this.daoHelper.query(this.FarmacoDao, keyMap, attrList);
    }



    @Override
    public EntityResult farmacoInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException {



        EntityResult er =  this.daoHelper.insert(this.FarmacoDao, attrMap);
        int idFarmaco = (int) er.get("ID_FARMACO");
        attrMap.put("ID_FARMACO",idFarmaco);



        return  this.daoHelper.insert(this.pautaDao, attrMap);

    }

    @Override
    public EntityResult farmacoUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap)
            throws OntimizeJEERuntimeException {
        return this.daoHelper.update(this.FarmacoDao, attrMap, keyMap);
    }

    @Override
    public EntityResult farmacoDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException {
        return this.daoHelper.delete(this.FarmacoDao, keyMap);
    }

}