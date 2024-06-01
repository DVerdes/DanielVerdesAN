package com.ontimize.hr.model.core.dao;

import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

@Repository("UsuarioDao")
@Lazy
@ConfigurationFile(configurationFile = "dao/UsuarioDao.xml", configurationFilePlaceholder = "dao/placeholders.properties")
public class UsuarioDao extends OntimizeJdbcDaoSupport {

    public static final String ID_USUARIO = "ID_USUARIO";
    public static final String FOTO_USUARIO = "FOTO_USUARIO";
    public static final String NOMBRE_USUARIO = "NOMBRE_USUARIO";
    public static final String APELLIDOS_USUARIO = "APELLIDOS_USUARIO";
    public static final String FECHA_NACIMIENTO = "FECHA_NACIMIENTO";
    public static final String GENERO_USUARIO = "GENERO_USUARIO";
    public static final String DEPENDENCIA_USUARIO = "DEPENDENCIA_USUARIO";
    public static final String ALTA_USUARIO = "ALTA_USUARIO";
    public static final String BAJA_USUARIO = "BAJA_USUARIO";



}