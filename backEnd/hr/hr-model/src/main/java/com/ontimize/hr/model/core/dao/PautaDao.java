package com.ontimize.hr.model.core.dao;

import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

@Repository("PautaDao")
@Lazy
@ConfigurationFile(configurationFile = "dao/PautaDao.xml", configurationFilePlaceholder = "dao/placeholders.properties")
public class PautaDao extends OntimizeJdbcDaoSupport {

    public static final String ID_PAUTA = "ID_PAUTA";
    public static final String ID_FARMACO = "ID_FARMACO";
    public static final String ID_USUARIO = "ID_USUARIO";
    public static final String VIA_ADMINISTRACION = "VIA_ADMINISTRACION";
    public static final String DOSIS = "DOSIS";
    public static final String POSOLOGIA = "POSOLOGIA";
    public static final String INICIO_PAUTA = "INICIO_PAUTA";
    public static final String FIN_PAUTA = "FIN_PAUTA";

}