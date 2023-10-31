/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3;

/**
 *
 * @author FP
 */
public class Reserva {
    
    private String participantsNumber;
    
    private String roomName;
    
    private String schedule;

    public Reserva(String participantsNumber, String roomName, String schedule) {
        this.participantsNumber = participantsNumber;
        this.roomName = roomName;
        this.schedule = schedule;
    }

    public Reserva() {
    }
    
    

    public String getParticipantsNumber() {
        return participantsNumber;
    }

    public void setParticipantsNumber(String participantsNumber) {
        this.participantsNumber = participantsNumber;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }
    
    
    
}
