package org.example;

import java.io.*;
import java.util.ArrayList;

public class CiudadMapping {

    public static ArrayList <Ciudad> leerCiudad(String ruta) throws IOException {


        ArrayList <Ciudad> ciudades = new ArrayList<>();
        File fic = new File(ruta);
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        Ciudad ciudad = new Ciudad();


        try{
            fis = new FileInputStream(fic);
            ois = new ObjectInputStream(fis);


            while (true){
                try{
                    ciudades.add((Ciudad) ois.readObject());

                }catch (Exception e){
                    return ciudades;
                }
            }



        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            try{
                if(fis!=null)fis.close();
                if(ois!=null)ois.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }


    }


    public static boolean escribirFichero(String ruta, ArrayList<Ciudad> ciudades){

        File fic = new File(ruta);
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;


        try{
            fos = new FileOutputStream(fic);
            oos = new ObjectOutputStream(fos);


            for(Ciudad ciudad: ciudades){
                oos.writeObject(ciudad);
            }



        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            try{
                if(fos!=null)fos.close();
                if(oos!=null)oos.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        return true;

    }



}
