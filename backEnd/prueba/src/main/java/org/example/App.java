package org.example;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws UnirestException {
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.get("http://localhost:33333/farmacos/farmaco?columns=NOMBRE_FARMACO")
                .header("Authorization", "Basic ZGVtbzpkZW1vdXNlcg==")
                .header("Cookie", "JSESSIONID=D10598DB040BC72EFB26AC5AB22C60CD")
                .asString();


        System.out.println(response.getBody());
    }

}
