package org.example;

import com.google.gson.Gson;
import org.example.entidades.Envio;
import org.example.entidades.Nombre;
import org.example.entidades.Peticion;
import org.example.entidades.Respuesta;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

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
    public static void procesarPeticion(Peticion peticion) throws IOException, ParserConfigurationException, SAXException {

        try {
            // Obtener datos del mensaje recibido
            long destinatario = peticion.getMessage().getFrom().getId();
            String texto = peticion.getMessage().getText();

            Envio envio = new Envio();
            envio.setChat_id(destinatario);


            if (texto == null) {
                // si texto nulo (imágenes, archivos de audio...)
                envio.setText("Formato incorrecto");
                enviarMensaje(envio);

            } else if (texto.equals("/start")) {
                // si se inicializa el bot
                envio.setText("Felices fiestas!, escribe /villancico para que el bot te recite una canción navideña!");
                enviarMensaje(envio);
                envio.setText("https://qrco.de/bedcQ3\n");
                enviarMensaje(envio);


            } else if (texto.equals("/villancico")) {
                // comando para devolver nombres aleatorios del fichero JSON
                ArrayList<Nombre> listaNombres = JsonUtils.leerJSON("src\\json\\villancicos.json");
                int random = (int) Math.floor(Math.random() * ((listaNombres.size() - 1) - 0 + 1) + 0);

                // Crear el mensaje de envío

                envio.setText(listaNombres.get(random).getNombre());

                // Enviar mensaje
                enviarMensaje(envio);


            } else if (texto.equals("/ayuda")) {
                // información de ayuda
                envio.setText("Felices fiestas!, escribe /villancico para que el bot te recite una canción navideña!");

                enviarMensaje(envio);


            } else {
                // si no se corresponde a ningún comando conocido
                envio.setText("No se ha introducido un comando válido. Por favor, escriba /ayuda para conocer la lista de funcionalidades del bot");
                enviarMensaje(envio);
            }

            offset = peticion.getUpdate_id() + 1;

        } catch (Exception e) {
            System.out.println("Error de excepción");
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


}



