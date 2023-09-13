package org.example;

public class BotFormal extends Bot {

    public BotFormal(String nombre) {
        super(nombre);
    }

    public String saludar() {

        return super.saludar() + " es todo un placer";
    }

}
