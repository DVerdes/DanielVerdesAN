package com.ontimize.hr.model.core.service;

import com.ontimize.hr.api.core.service.ICandidateService;
import com.ontimize.hr.model.core.dao.CandidateDao;
import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("CandidateService")
@Lazy
public class CandidateService implements ICandidateService {

    @Autowired
    private CandidateDao candidateDao;
    @Autowired
    private DefaultOntimizeDaoHelper daoHelper;

    @Override
    public EntityResult candidateQuery(Map<String, Object> keyMap, List<String> attrList)
            throws OntimizeJEERuntimeException {
        return this.daoHelper.query(this.candidateDao, keyMap, attrList);
    }

    @Override
    public EntityResult candidateInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException {
        return this.daoHelper.insert(this.candidateDao, attrMap);
    }

    @Override
    public EntityResult candidateUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap)
            throws OntimizeJEERuntimeException {
        return this.daoHelper.update(this.candidateDao, attrMap, keyMap);
    }

    @Override
    public EntityResult candidateDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException {
        return this.daoHelper.delete(this.candidateDao, keyMap);
    }

}