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
 *
 * @author DVerd
 */
public class JsonUtils {
    
    public static JSONArray getResponseData(String responseBody){
        responseBody+="]";
        String str2 = "[";
        str2 += responseBody;
        JSONArray array = new JSONArray(str2);
        JSONObject obj = array.getJSONObject(0);
        JSONArray data = obj.getJSONArray("data");
           
        return data;
    }
    
    
    
    public static List<Farmaco> parseFarmaco(String responseBody){
        
        JSONArray farmacos = new JSONArray(getResponseData(responseBody));
        List <Farmaco> listaFarmacos = new ArrayList<Farmaco>();
        for(int i = 0; i< farmacos.length(); i++){
            JSONObject farmaco = farmacos.getJSONObject(i);
            listaFarmacos.add(new Farmaco(farmaco.getString("NOMBRE_FARMACO")));
        }
        return listaFarmacos;
    }
    
    public static List<Contacto> parseContacto(String responseBody){
        
        JSONArray contactos = new JSONArray(getResponseData(responseBody));
        List <Contacto> listaContactos = new ArrayList<Contacto>();
        for(int i = 0; i< contactos.length(); i++){
            JSONObject contacto = contactos.getJSONObject(i);
            Contacto c = new Contacto();
            c.setNOMBRE_CONTACTO(contacto.getString("NOMBRE_CONTACTO"));
            c.setAPELL_CONTACTO(contacto.getString("APELLIDOS_CONTACTO"));
            c.setTELF_CONTACTO(contacto.getString("TELF_CONTACTO"));
            c.setEMAIL_CONTACTO(contacto.getString("EMAIL_CONTACTO"));
            
            
            
            listaContactos.add(c);
        }
        return listaContactos;
    }
    
    public static List<Centro> parseCentro(String responseBody){
        
        JSONArray centros = new JSONArray(getResponseData(responseBody));
        List <Centro> listaCentros = new ArrayList<Centro>();
        for(int i = 0; i< centros.length(); i++){
            JSONObject centro = centros.getJSONObject(i);
            listaCentros.add(new Centro(centro.getInt("ID_CENTRO"),centro.getString("NOMBRE_CENTRO")));

        }
        return listaCentros;
    }
    
    public static List<Usuario> parseUsuarios(String responseBody) throws ParseException{
        
        JSONArray usuarios = new JSONArray(getResponseData(responseBody));
        List <Usuario> listaUsuarios = new ArrayList<Usuario>();
        for(int i = 0; i< usuarios.length(); i++){
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
    
    public static List<String> parseHabitacionCama(String responseBody) throws ParseException{
        
        JSONArray datos = new JSONArray(getResponseData(responseBody));
        List <String> lista = new ArrayList<String>();
        for(int i = 0; i< datos.length(); i++){
            JSONObject objeto = datos.getJSONObject(i);
            
            lista.add(objeto.getString("NOM_HABITACION")+" Cama "+objeto.getString("NOMBRE_CAMA"));
            
                
        }
        return lista;
    }
    
    public static List<Pauta> parsePauta(String responseBody) throws ParseException{
                List <Pauta> lista = new ArrayList<Pauta>();

                
                try{
                    JSONArray datos = new JSONArray(getResponseData(responseBody));
        for(int i = 0; i< datos.length(); i++){
            JSONObject objeto = datos.getJSONObject(i);
            Pauta p = new Pauta();
            p.setNombreFarmaco(objeto.getString("NOMBRE_FARMACO"));
            p.setViaAdministracion(objeto.getString("VIA_ADMINISTRACION"));
            p.setDosis(objeto.getString("DOSIS"));
            p.setPosologia(objeto.getString("POSOLOGIA"));
            
            lista.add(p);
            
                
        }
                }catch(Exception e){
                    e.printStackTrace();
                }
        
        return lista;
    }
    
    
    
    public static List<Cama> parseCama(String responseBody) throws ParseException{
        
        JSONArray datos = new JSONArray(getResponseData(responseBody));
        List <Cama> lista = new ArrayList<Cama>();
        for(int i = 0; i< datos.length(); i++){
            JSONObject objeto = datos.getJSONObject(i);
            
            if(!objeto.has("ID_USUARIO")){
                    Cama c = new Cama();
                    c.setID_CAMA(objeto.getInt("ID_CAMA"));
                    c.setNOMBRE_CAMA(objeto.getString("NOM_HABITACION")+", Cama: "+objeto.getString("NOMBRE_CAMA"));
                    
                                lista.add(c);

            }
           
            
            
                
        }
        return lista;
    }
    
    public static int returnInsertedUserId(String responseBody) throws ParseException{
        int id = 0;
        responseBody+="]";
        String str2 = "[";
        str2 += responseBody;
        JSONArray datos = new JSONArray(str2);
        for(int i = 0; i< datos.length(); i++){
            JSONObject objeto = datos.getJSONObject(i);
            
            JSONObject data = objeto.getJSONObject("data");
            
           id = data.getInt("ID_USUARIO");
                
        }
        return id;
    }
    
    public static int returnInsertedContactoId(String responseBody) throws ParseException{
        int id = 0;
        responseBody+="]";
        String str2 = "[";
        str2 += responseBody;
        JSONArray datos = new JSONArray(str2);
        for(int i = 0; i< datos.length(); i++){
            JSONObject objeto = datos.getJSONObject(i);
            
            JSONObject data = objeto.getJSONObject("data");
            
           id = data.getInt("ID_CONTACTO");
                
        }
        return id;
    }
    
}
