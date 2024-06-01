package com.ontimize.hr.model.core.dao;

import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

@Repository("HabitacionDao")
@Lazy
@ConfigurationFile(configurationFile = "dao/HabitacionDao.xml", configurationFilePlaceholder = "dao/placeholders.properties")
public class HabitacionDao extends OntimizeJdbcDaoSupport {

    public static final String ID_HABITACION = "ID_HABITACION";
    public static final String ID_CENTRO = "ID_CENTRO";
    public static final String NOM_HABITACION = "NOM_HABITACION";

}