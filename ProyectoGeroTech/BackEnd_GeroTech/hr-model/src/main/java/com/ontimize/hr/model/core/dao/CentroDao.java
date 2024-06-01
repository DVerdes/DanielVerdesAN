package com.ontimize.hr.model.core.dao;

import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

@Repository("CentroDao")
@Lazy
@ConfigurationFile(configurationFile = "dao/CentroDao.xml", configurationFilePlaceholder = "dao/placeholders.properties")
public class CentroDao extends OntimizeJdbcDaoSupport {

    public static final String ID_CENTRO = "ID_CENTRO";
    public static final String ID_GESTOR = "ID_GESTOR";
    public static final String DIR_CENTRO = "DIR_CENTRO";
    public static final String NOMBRE_CENTRO = "NOMBRE_CENTRO";
    public static final String CNT_CREATION_DATE = "CNT_CREATION_DATE";
    public static final String CNT_DOWN_DATE = "CNT_DOWN_DATE";

}