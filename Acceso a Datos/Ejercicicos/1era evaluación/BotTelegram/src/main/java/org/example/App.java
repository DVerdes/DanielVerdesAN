package org.example;

/**
 * Clase principal
 */
public class App {

    /**
     * Método principal
     *
     * @param args Argumentos desde la línea de comandos cuando se inicia el programa (no se utilizan)
     */
    public static void main(String[] args) {

        try {
            // Bucle para procesar peticiones del Bot cada segundo
            while (true) {
                BotUtils.procesarPeticiones();
                Thread.sleep(1000);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


}
