package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.entidades.Envio;
import org.example.entidades.Nombre;
import org.example.entidades.Peticion;
import org.example.entidades.Respuesta;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Clase con métodos para utilizar el bot de Telegram
 */
public class BotUtils {

    static final String BOT_TOKEN = "6433169485:AAGX5Lqqc3XwgP4T8vzxJGaF8nIJm4tFiHU";
    static final String API_TELEGRAM = "https://api.telegram.org/bot";
    static final String METHOD_GET = "GET";
    static final String METHOD_POST = "POST";
    static final String PROPERTY_ACCEPT = "Accept";
    static final String PROPERTY_APPLICATION_JSON = "application/json";
    static final String PROPERTY_CONTENT_TYPE = "Content-Type";
    static final String LOG_ERROR_SOLICITUD = "Error en la solicitud. Código de respuesta: ";
    static final String LOG_ENVIO_CORRECTO = "Envío correcto";
    static final int HTTP_CODE_OK = 200;
    static long offset = 0;

    /**
     * Método que invocará al API de Telegram para ver si hay peticiones de usuarios pendientesd de procesar
     */
    public static void procesarPeticiones() {

        try {
            // Crear petición HTTP
            String apiUrl = API_TELEGRAM + BOT_TOKEN + "/getUpdates?offset=" + offset;
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod(METHOD_GET);
            conn.setRequestProperty(PROPERTY_ACCEPT, PROPERTY_APPLICATION_JSON);

            // Obtiene el código de respuesta
            int responseCode = conn.getResponseCode();
            // Si es un 200 la petición se ha realizado con éxito
            if (responseCode == HTTP_CODE_OK) {

                // Lee la respuesta JSON
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Parsea la respuesta
                Gson gson = new Gson();
                Respuesta respuesta = gson.fromJson(response.toString(), Respuesta.class);

                // Recorremos todas las peticiones y las procesamos
                for (Peticion peticion : respuesta.getResult()) {
                    procesarPeticion(peticion);
                }
            } else {
                System.out.println(LOG_ERROR_SOLICITUD + responseCode);
            }

            // Cierra la conexión
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que evaluará una petición enviada por un usuario al bot
     *
     * @param peticion Datos de la petición del usuario
     * @throws IOException Excepción en envío de mensaje
     */
    public static void procesarPeticion(Peticion peticion) throws IOException {

        // Obtener datos del mensaje recibido
        long destinatario = peticion.getMessage().getFrom().getId();
        String texto = peticion.getMessage().getText();

        if (texto.equals("/nombre")) {
            // añadir aquí
            ArrayList<Nombre> listaNombres = leerJSON("C:\\Users\\FP\\Documents\\GitHub\\DanielVerdesAN\\Acceso a Datos\\Ejercicicos\\1era evaluación\\BotTelegram\\src\\main\\java\\org\\example\\datos\\names.json");
            int random = (int) Math.floor(Math.random() * ((listaNombres.size() - 1) - 0 + 1) + 0);

            // Crear el mensaje de envío
            Envio envio = new Envio();
            envio.setChat_id(destinatario);
            envio.setText("Nombre aleatorio: " + listaNombres.get(random).getNombre());

            // Enviar mensaje
            enviarMensaje(envio);

            // Nos quedamos con el último mensaje procesado
            offset = peticion.getUpdate_id() + 1;

        } else if (texto.matches("^/anadirNombre .*$")) {

            String[] arrOfStr = texto.split(" ", 15);
            String nombreSugerido = arrOfStr[1];

            ArrayList<Nombre> listaNombres = leerJSON("C:\\Users\\FP\\Documents\\GitHub\\DanielVerdesAN\\Acceso a Datos\\Ejercicicos\\1era evaluación\\BotTelegram\\src\\main\\java\\org\\example\\datos\\names.json");
            listaNombres.add(new Nombre(nombreSugerido));


            File fichero1 = new File("C:\\Users\\FP\\Documents\\GitHub\\DanielVerdesAN\\Acceso a Datos\\Ejercicicos\\1era evaluación\\BotTelegram\\src\\main\\java\\org\\example\\datos\\names.json");
            fichero1.createNewFile();

            FileWriter fw = new FileWriter(fichero1);
            fw.write(escribirJSON(listaNombres));
            fw.close();
            
            Envio envio = new Envio();
            envio.setChat_id(destinatario);
            envio.setText(nombreSugerido + " añadido con éxito");

            // Enviar mensaje
            enviarMensaje(envio);

            offset = peticion.getUpdate_id() + 1;

        } else if (texto.equals("/ayuda")) {
            Envio envio = new Envio();
            envio.setChat_id(destinatario);
            envio.setText("Lista de comandos: \n-/nombre: devuelve nombre aleatorio\n-/anadirNombre Nombre: añade el nombre indicado");

            // Enviar mensaje
            enviarMensaje(envio);

            // Nos quedamos con el último mensaje procesado
            offset = peticion.getUpdate_id() + 1;
        }


    }

    /**
     * Método que enviará un mensaje a un usuario
     *
     * @param envio Datos de destinatario del mensaje y mensaje a enviar
     * @throws IOException Excepción en envío de mensaje
     */
    public static void enviarMensaje(Envio envio) throws IOException {

        // Crear petición HTTP
        String apiUrl = API_TELEGRAM + BOT_TOKEN + "/sendMessage";
        URL url = new URL(apiUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod(METHOD_POST);
        conn.setRequestProperty(PROPERTY_CONTENT_TYPE, PROPERTY_APPLICATION_JSON);
        conn.setDoOutput(true);

        // Utilizar Gson para convertir el objeto JSON en una cadena
        String jsonMessage = new Gson().toJson(envio);

        // Crear un OutputStreamWriter para escribir en el OutputStream que se ligará a la conexión
        try (OutputStream os = conn.getOutputStream(); OutputStreamWriter osw = new OutputStreamWriter(os, StandardCharsets.UTF_8)) {
            osw.write(jsonMessage);
            osw.flush();
        }

        // Enviar peticion HTTP
        int responseCode = conn.getResponseCode();

        // Evaluar respuesta petición HTTP
        if (responseCode == HTTP_CODE_OK) {
            System.out.println(LOG_ENVIO_CORRECTO);
        } else {
            System.out.println(LOG_ERROR_SOLICITUD + responseCode);
        }
    }

    public static void ultimarMensaje(String mensaje) {

    }

    public static String escribirJSON(ArrayList<Nombre> listaNombres) throws FileNotFoundException {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
        String json = gson.toJson(listaNombres);
        return json;
    }// escribirJson

    public static ArrayList<Nombre> leerJSON(String ruta) throws FileNotFoundException {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        FileReader fr = new FileReader(ruta);
        Nombre[] nombres = gson.fromJson(fr, Nombre[].class);
        return new ArrayList<Nombre>(Arrays.asList(nombres));
    }// leer JSON
}



