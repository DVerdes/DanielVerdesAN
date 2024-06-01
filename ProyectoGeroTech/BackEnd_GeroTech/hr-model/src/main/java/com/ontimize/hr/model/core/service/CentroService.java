package com.ontimize.hr.model.core.service;

import com.ontimize.hr.api.core.service.ICentroService;
import com.ontimize.hr.model.core.dao.CamaDao;
import com.ontimize.hr.model.core.dao.CentroDao;
import com.ontimize.hr.model.core.dao.HabitacionDao;
import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("CentroService")
@Lazy
public class CentroService implements ICentroService {

    @Autowired
    private CentroDao centroDao;

    @Autowired
    private HabitacionDao habitacionDao;

    @Autowired
    private CamaDao camaDao;
    @Autowired
    private DefaultOntimizeDaoHelper daoHelper;

    @Override
    public EntityResult centroQuery(Map<String, Object> keyMap, List<String> attrList)
            throws OntimizeJEERuntimeException {

        return this.daoHelper.query(this.centroDao, keyMap, attrList);
    }

    @Override
    public EntityResult centroCamasQuery(Map<String, Object> keyMap, List<String> attrList)
            throws OntimizeJEERuntimeException {

        return this.daoHelper.query(this.centroDao, keyMap, attrList,"camasDisponibles");
    }



    @Override
    public EntityResult centroInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException {
        System.out.println("break");



        EntityResult er = this.daoHelper.insert(this.centroDao, attrMap);

        int idCentro = (int) er.get("ID_CENTRO");


        int numHabIndividuales = Integer.parseInt((String) attrMap.get("HAB_INDIV"));
        Map<String, Object> mapaHabitaciones = new HashMap<>();
        Map<String, Object> mapaCamas = new HashMap<>();
        mapaCamas.put("NOMBRE_CAMA", "A");


        mapaHabitaciones.put("ID_CENTRO", idCentro);
        mapaHabitaciones.put("NOM_HABITACION",0);
        for(int i= 1; i<=numHabIndividuales; i++){
            mapaHabitaciones.replace("NOM_HABITACION","Individual "+i);
            EntityResult hr = this.daoHelper.insert(this.habitacionDao, mapaHabitaciones);

            int idHabitacion = (int) hr.get("ID_HABITACION");
            mapaCamas.put("ID_HABITACION", idHabitacion);
            mapaCamas.replace("NOMBRE_CAMA", "A");
            this.daoHelper.insert(this.camaDao, mapaCamas);

        }

        int numHabDobles = Integer.parseInt((String) attrMap.get("HAB_DOBLE"));
        for(int i= 1; i<=numHabDobles; i++){
            mapaHabitaciones.replace("NOM_HABITACION","Doble "+i);
            EntityResult hr = this.daoHelper.insert(this.habitacionDao, mapaHabitaciones);

            int idHabitacion = (int) hr.get("ID_HABITACION");
            mapaCamas.put("ID_HABITACION", idHabitacion);
            mapaCamas.replace("NOMBRE_CAMA", "A");
            this.daoHelper.insert(this.camaDao, mapaCamas);
            mapaCamas.replace("NOMBRE_CAMA", "B");
            this.daoHelper.insert(this.camaDao, mapaCamas);
        }

        int numHabTriples = Integer.parseInt((String) attrMap.get("HAB_TRIPLE"));
        for(int i= 1; i<=numHabDobles; i++){
            mapaHabitaciones.replace("NOM_HABITACION","Triple "+i);
            EntityResult hr = this.daoHelper.insert(this.habitacionDao, mapaHabitaciones);

            int idHabitacion = (int) hr.get("ID_HABITACION");
            mapaCamas.put("ID_HABITACION", idHabitacion);
            mapaCamas.replace("NOMBRE_CAMA", "A");
            this.daoHelper.insert(this.camaDao, mapaCamas);
            mapaCamas.replace("NOMBRE_CAMA", "B");
            this.daoHelper.insert(this.camaDao, mapaCamas);
            mapaCamas.replace("NOMBRE_CAMA", "C");
            this.daoHelper.insert(this.camaDao, mapaCamas);
        }


        return er;

    }

    @Override
    public EntityResult centroUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap)
            throws OntimizeJEERuntimeException {
        return this.daoHelper.update(this.centroDao, attrMap, keyMap);
    }

    @Override
    public EntityResult centroDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException {
        return this.daoHelper.delete(this.centroDao, keyMap);
    }

}