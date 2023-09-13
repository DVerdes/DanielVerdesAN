package org.example;

public class MainBot {

    public static void main(String[] args) {

        Bot robot1 = new BotFormal("Paco");
        System.out.println(robot1.saludar());

        Bot robot2 = new BotInformal("Pepe");
        System.out.println(robot2.saludar());


    }

}
