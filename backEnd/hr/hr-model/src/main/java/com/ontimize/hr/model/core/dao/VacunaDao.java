package com.ontimize.hr.model.core.dao;

import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

@Repository("VacunaDao")
@Lazy
@ConfigurationFile(configurationFile = "dao/VacunaDao.xml", configurationFilePlaceholder = "dao/placeholders.properties")
public class VacunaDao extends OntimizeJdbcDaoSupport {

    public static final String ID_VACUNA = "ID_VACUNA";
    public static final String NOMBRE_VACUNA = "NOMBRE_VACUNA";
    public static final String FECHA_VACUNACION = "FECHA_VACUNACION";
    public static final String ID_USUARIO = "ID_USUARIO";



}