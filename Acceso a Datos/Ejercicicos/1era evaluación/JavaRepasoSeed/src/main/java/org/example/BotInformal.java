package org.example;

public class BotInformal extends Bot {

    public BotInformal(String nombre) {
        super(nombre);
    }

    public String saludar() {
        return super.saludar() + " ¿que pasa?";
    }

}
