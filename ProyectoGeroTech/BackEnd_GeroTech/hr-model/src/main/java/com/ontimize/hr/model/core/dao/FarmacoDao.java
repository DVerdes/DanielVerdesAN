package com.ontimize.hr.model.core.dao;

import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

@Repository("FarmacoDao")
@Lazy
@ConfigurationFile(configurationFile = "dao/FarmacoDao.xml", configurationFilePlaceholder = "dao/placeholders.properties")
public class FarmacoDao extends OntimizeJdbcDaoSupport {

    public static final String ID_FARMACO = "ID_FARMACO";
    public static final String NOMBRE_FARMACO = "NOMBRE_FARMACO";


}