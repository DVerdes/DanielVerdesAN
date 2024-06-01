package com.ontimize.hr.model.core.dao;

import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

@Repository("HabitarDao")
@Lazy
@ConfigurationFile(configurationFile = "dao/HabitarDao.xml", configurationFilePlaceholder = "dao/placeholders.properties")
public class HabitarDao extends OntimizeJdbcDaoSupport {

    public static final String ID_HABITAR = "ID_HABITAR";
    public static final String ID_CAMA = "ID_CAMA";
    public static final String ID_USUARIO = "ID_USUARIO";

}