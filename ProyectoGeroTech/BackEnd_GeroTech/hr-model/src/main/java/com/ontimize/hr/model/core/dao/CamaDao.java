package com.ontimize.hr.model.core.dao;

import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

@Repository("CamaDao")
@Lazy
@ConfigurationFile(configurationFile = "dao/CamaDao.xml", configurationFilePlaceholder = "dao/placeholders.properties")
public class CamaDao extends OntimizeJdbcDaoSupport {

    public static final String ID_CAMA = "ID_CAMA";
    public static final String ID_HABITACION = "ID_HABITACION";
    public static final String NOMBRE_CAMA = "NOMBRE_CAMA";

}