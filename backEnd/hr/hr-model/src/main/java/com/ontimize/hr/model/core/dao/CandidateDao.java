package com.ontimize.hr.model.core.dao;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;

@Repository("CandidateDao")
@Lazy
@ConfigurationFile(configurationFile = "dao/CandidateDao.xml", configurationFilePlaceholder = "dao/placeholders.properties")
public class CandidateDao extends OntimizeJdbcDaoSupport {

    public static final String ATTR_ID = "ID";
    public static final String ATTR_PHOTO = "PHOTO";
    public static final String ATTR_NAME = "NAME";
    public static final String ATTR_SURNAME = "SURNAME";
    public static final String ATTR_BIRTHDAY = "BIRTHDAY";
    public static final String ATTR_DNI = "DNI";
    public static final String ATTR_PHONE = "PHONE";
    public static final String ATTR_EMAIL = "EMAIL";
    public static final String ATTR_EDUCATION = "EDUCATION";
    public static final String ATTR_SPECIALTIES = "SPECIALTIES";
    public static final String ATTR_STATUS = "STATUS";
    public static final String ATTR_ORIGIN = "ORIGIN";
    public static final String ATTR_WAGE_LEVEL = "WAGE_LEVEL";
    public static final String ATTR_EXPERIENCE_LEVEL = "EXPERIENCE_LEVEL";
    public static final String ATTR_PROFILE = "PROFILE";
    public static final String ATTR_COMMENT = "COMMENT";
    public static final String ATTR_LINKEDIN = "LINKEDIN";
}