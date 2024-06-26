/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.utils;

import com.mycompany.mavenproject1.Cama;
import com.mycompany.mavenproject1.Centro;
import com.mycompany.mavenproject1.Contacto;
import com.mycompany.mavenproject1.Farmaco;
import com.mycompany.mavenproject1.Pauta;
import com.mycompany.mavenproject1.Usuario;
import com.mycompany.mavenproject1.Vacuna;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Utilidades parseo JSON
 * @author DVerd
 */
public class JsonUtils {

    /**
     * Completa respuesta considerando formato Ontimize Boot
     * @param responseBody
     * @return 
     */
    public static JSONArray getResponseData(String responseBody) {
        responseBody += "]";
        String str2 = "[";
        str2 += responseBody;
        JSONArray array = new JSONArray(str2);
        JSONObject obj = array.getJSONObject(0);
        JSONArray data = obj.getJSONArray("data");

        return data;
    }

    /**
     * Devuelve lista de fármacos de petición
     * @param responseBody cuerpo petición
     * @return lista Fármacos
     */
    public static List<Farmaco> parseFarmaco(String responseBody) {

        JSONArray farmacos = new JSONArray(getResponseData(responseBody));
        List<Farmaco> listaFarmacos = new ArrayList<Farmaco>();
        for (int i = 0; i < farmacos.length(); i++) {
            JSONObject farmaco = farmacos.getJSONObject(i);
            listaFarmacos.add(new Farmaco(farmaco.getString("NOMBRE_FARMACO")));
        }
        return listaFarmacos;
    }

    /**
     * Devuelve lista contactos petición
     * @param responseBody cuerpo petición
     * @return listado contactos
     */
    public static List<Contacto> parseContacto(String responseBody) {
        List<Contacto> listaContactos = new ArrayList<Contacto>();
        try {
            JSONArray contactos = new JSONArray(getResponseData(responseBody));
            for (int i = 0; i < contactos.length(); i++) {
                JSONObject contacto = contactos.getJSONObject(i);
                Contacto c = new Contacto();
                c.setNOMBRE_CONTACTO(contacto.getString("NOMBRE_CONTACTO"));
                c.setAPELL_CONTACTO(contacto.getString("APELLIDOS_CONTACTO"));
                c.setTELF_CONTACTO(contacto.getString("TELF_CONTACTO"));
                c.setEMAIL_CONTACTO(contacto.getString("EMAIL_CONTACTO"));

                listaContactos.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaContactos;
    }

    /**
     * Devuelve listado vacunas
     * @param responseBody cuerpo
     * @return  listado vacunas
     */
    public static List<Vacuna> parseVacuna(String responseBody) {
        List<Vacuna> lista = new ArrayList<Vacuna>();
        try {
            JSONArray array = new JSONArray(getResponseData(responseBody));
            for (int i = 0; i < array.length(); i++) {
                JSONObject objeto = array.getJSONObject(i);
                Vacuna c = new Vacuna();
                c.setID_VACUNA(objeto.getInt("ID_VACUNA"));
                c.setNOMBRE_VACUNA(objeto.getString("NOMBRE_VACUNA"));
                long longDate = objeto.getLong("FECHA_VACUNACION");
                java.util.Date utilDate = new java.util.Date(longDate);
                java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                c.setFECHA_VACUNACION(sqlDate);

                lista.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    /**
     * Devuelve centros
     * @param responseBody cuerpo
     * @return listado centros
     */
    public static List<Centro> parseCentro(String responseBody) {

        JSONArray centros = new JSONArray(getResponseData(responseBody));
        List<Centro> listaCentros = new ArrayList<Centro>();
        for (int i = 0; i < centros.length(); i++) {
            JSONObject centro = centros.getJSONObject(i);
            listaCentros.add(new Centro(centro.getInt("ID_CENTRO"), centro.getString("NOMBRE_CENTRO")));

        }
        return listaCentros;
    }

    /**
     * Listado usuarios
     * @param responseBody cuerpo
     * @return lista usuarios
     * @throws ParseException 
     */
    public static List<Usuario> parseUsuarios(String responseBody) throws ParseException {

        JSONArray usuarios = new JSONArray(getResponseData(responseBody));
        List<Usuario> listaUsuarios = new ArrayList<Usuario>();
        for (int i = 0; i < usuarios.length(); i++) {
            JSONObject usuario = usuarios.getJSONObject(i);
            Usuario u = new Usuario();
            u.setID_USUARIO(usuario.getInt("ID_USUARIO"));
            u.setNOMBRE_USUARIO(usuario.getString("NOMBRE_USUARIO"));
            u.setAPELLIDOS_USUARIO(usuario.getString("APELLIDOS_USUARIO"));

            long longDate = usuario.getLong("FECHA_NACIMIENTO");
            java.util.Date utilDate = new java.util.Date(longDate);
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            u.setFECHA_NACIMIENTO(sqlDate);

            u.setGENERO_USUARIO(usuario.getString("GENERO_USUARIO"));
            u.setDEPENDENCIA_USUARIO(usuario.getString("DEPENDENCIA_USUARIO"));
            //u.setFOTO_USUARIO(usuario.getString("FOTO_USUARIO"));

            longDate = usuario.getLong("ALTA_USUARIO");
            utilDate = new java.util.Date(longDate);
            sqlDate = new java.sql.Date(utilDate.getTime());
            u.setALTA_USUARIO(sqlDate);

            u.setFOTO_USUARIO(usuario.getString("FOTO_USUARIO"));

            listaUsuarios.add(u);
        }
        return listaUsuarios;
    }

    /**
     * Login
     * @param responseBody datos login
     * @return validación credenciales
     */
    public static boolean login(String responseBody) {
        int id = 12;
        try {
            JSONArray array = new JSONArray(getResponseData(responseBody));
            for (int i = 0; i < array.length(); i++) {
                JSONObject objeto = array.getJSONObject(i);
                id = objeto.getInt("ID_PROFESIONAL");
                return true;

            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Devuelve habitaciones y camas 
     * @param responseBody filtro de centro
     * @return listado de habitaciones y camas
     * @throws ParseException 
     */
    public static List<String> parseHabitacionCama(String responseBody) throws ParseException {

        JSONArray datos = new JSONArray(getResponseData(responseBody));
        List<String> lista = new ArrayList<String>();
        for (int i = 0; i < datos.length(); i++) {
            JSONObject objeto = datos.getJSONObject(i);

            lista.add(objeto.getString("NOM_HABITACION") + " Cama " + objeto.getString("NOMBRE_CAMA"));

        }
        return lista;
    }

    /**
     * Devuelve listado de pautas de medicamentos 
     * @param responseBody cuerpo
     * @return pautas
     * @throws ParseException 
     */
    public static List<Pauta> parsePauta(String responseBody) throws ParseException {
        List<Pauta> lista = new ArrayList<Pauta>();

        try {
            JSONArray datos = new JSONArray(getResponseData(responseBody));
            for (int i = 0; i < datos.length(); i++) {
                JSONObject objeto = datos.getJSONObject(i);
                Pauta p = new Pauta();
                p.setNombreFarmaco(objeto.getString("NOMBRE_FARMACO"));
                p.setViaAdministracion(objeto.getString("VIA_ADMINISTRACION"));
                p.setDosis(objeto.getString("DOSIS"));
                p.setPosologia(objeto.getString("POSOLOGIA"));

                lista.add(p);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    /**
     * Devuelve habitaciones disponibles
     * @param responseBody cuerpo
     * @return listado de camas
     * @throws ParseException 
     */
    public static List<Cama> parseCama(String responseBody) throws ParseException {

        JSONArray datos = new JSONArray(getResponseData(responseBody));
        List<Cama> lista = new ArrayList<Cama>();
        for (int i = 0; i < datos.length(); i++) {
            JSONObject objeto = datos.getJSONObject(i);

            if (!objeto.has("ID_USUARIO")) {
                Cama c = new Cama();
                c.setID_CAMA(objeto.getInt("ID_CAMA"));
                c.setNOMBRE_CAMA(objeto.getString("NOM_HABITACION") + ", Cama: " + objeto.getString("NOMBRE_CAMA"));

                lista.add(c);

            }

        }
        return lista;
    }

    /**
     * Devuelve id del usuario insertado
     * @param responseBody cuerpo
     * @return id insertada
     * @throws ParseException 
     */
    public static int returnInsertedUserId(String responseBody) throws ParseException {
        int id = 0;
        responseBody += "]";
        String str2 = "[";
        str2 += responseBody;
        JSONArray datos = new JSONArray(str2);
        for (int i = 0; i < datos.length(); i++) {
            JSONObject objeto = datos.getJSONObject(i);

            JSONObject data = objeto.getJSONObject("data");

            id = data.getInt("ID_USUARIO");

        }
        return id;
    }

    /**
     * Devuelve id del contacto insertado
     * @param responseBody cuerpo
     * @return id contacto
     * @throws ParseException 
     */
    public static int returnInsertedContactoId(String responseBody) throws ParseException {
        int id = 0;
        responseBody += "]";
        String str2 = "[";
        str2 += responseBody;
        JSONArray datos = new JSONArray(str2);
        for (int i = 0; i < datos.length(); i++) {
            JSONObject objeto = datos.getJSONObject(i);

            JSONObject data = objeto.getJSONObject("data");

            id = data.getInt("ID_CONTACTO");

        }
        return id;
    }

}
