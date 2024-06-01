/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mycompany.mavenproject1.utils.JsonUtils;
import java.io.IOException;

/**
 * Utilidades de API 
 * @author DVerd
 */
public class APIConnector {

    /**
     * Método GET
     * @param url url 
     * @return cadena de texto con respuesta
     * @throws IOException
     * @throws UnirestException 
     */
    public static String getMethod(String url) throws IOException, UnirestException {
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.get(url)
                .header("Authorization", "Basic ZGVtbzpkZW1vdXNlcg==")
                .header("Cookie", "JSESSIONID=D10598DB040BC72EFB26AC5AB22C60CD")
                .asString();
        return response.getBody();

    }

    /**
     * Método POST
     * @param url url
     * @param body parámetros del filtro/inserción
     * @return cadena de texto con respuesta (JSON)
     * @throws UnirestException 
     */
    public static String postMethod(String url, String body) throws UnirestException {
        Unirest.setTimeouts(0, 0);
        return Unirest.post(url)
                .header("Content-Type", "application/json")
                .header("Authorization", "Basic ZGVtbzpkZW1vdXNlcg==")
                .body(body)
                .asString().getBody();
    }

    /**
     * Método PUT
     * @param url url
     * @param body parámetros del filtro/inserción
     * @return cadena de texto con respuesta (JSON)
     * @throws UnirestException 
     */
    public static String putMethod(String url, String body) throws UnirestException {
        Unirest.setTimeouts(0, 0);
        return Unirest.put(url)
                .header("Content-Type", "application/json")
                .header("Authorization", "Basic ZGVtbzpkZW1vdXNlcg==")
                .body(body)
                .asString().getBody();
    }
    
    
    /**
     * Método DELETE
     * @param url url
     * @param body parámetros del filtro
     * @return cadena de texto con respuesta (JSON)
     * @throws UnirestException 
     */
    public static String deleteMethod(String url, String body) throws UnirestException {
        Unirest.setTimeouts(0, 0);
        return Unirest.delete(url)
                .header("Content-Type", "application/json")
                .header("Authorization", "Basic ZGVtbzpkZW1vdXNlcg==")
                .body(body)
                .asString().getBody();
    }

}
