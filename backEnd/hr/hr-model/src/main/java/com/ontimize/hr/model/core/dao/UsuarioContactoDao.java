package com.ontimize.hr.model.core.dao;

import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

@Repository("UsuarioContactoDao")
@Lazy
@ConfigurationFile(configurationFile = "dao/UsuarioContactoDao.xml", configurationFilePlaceholder = "dao/placeholders.properties")
public class UsuarioContactoDao extends OntimizeJdbcDaoSupport {

    public static final String ID_USR_CNT = "ID_USR_CNT";
    public static final String ID_USUARIO = "ID_USUARIO";
    public static final String ID_CONTACTO = "ID_CONTACTO";

}