package com.ontimize.hr.model.core.dao;

import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

@Repository("ContactoDao")
@Lazy
@ConfigurationFile(configurationFile = "dao/ContactoDao.xml", configurationFilePlaceholder = "dao/placeholders.properties")
public class ContactoDao extends OntimizeJdbcDaoSupport {

    public static final String ID_CONTACTO = "ID_CONTACTO";
    public static final String NOMBRE_CONTACTO = "NOMBRE_CONTACTO";
    public static final String APELLIDOS_CONTACTO = "APELLIDOS_CONTACTO";
    public static final String TELF_CONTACTO = "TELF_CONTACTO";
    public static final String EMAIL_CONTACTO = "EMAIL_CONTACTO";


}