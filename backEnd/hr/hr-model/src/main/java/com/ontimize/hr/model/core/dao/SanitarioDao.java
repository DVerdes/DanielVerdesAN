package com.ontimize.hr.model.core.dao;

import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

@Repository("SanitarioDao")
@Lazy
@ConfigurationFile(configurationFile = "dao/SanitarioDao.xml", configurationFilePlaceholder = "dao/placeholders.properties")
public class SanitarioDao extends OntimizeJdbcDaoSupport {

    public static final String ID_PROFESIONAL = "ID_PROFESIONAL";
    public static final String NOMBRE_PROFESIONAL = "NOMBRE_PROFESIONAL";
    public static final String APELLIDO_PROFESIONAL = "APELLIDO_PROFESIONAL";
    public static final String CATEGORIA_PROF = "CATEGORIA_PROF";
    public static final String CONTRASENA = "CONTRASENA";
    public static final String ALTA_PROFESIONAL = "ALTA_PROFESIONAL";
    public static final String BAJA_PROFESIONAL = "BAJA_PROFESIONAL";



}