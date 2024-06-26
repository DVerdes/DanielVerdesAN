/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.utils;

import com.mycompany.mavenproject1.Farmaco;
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
  
            listaUsuarios.add(u);
        }
        return listaUsuarios;
    }
    
}
