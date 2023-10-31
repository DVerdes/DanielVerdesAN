/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.com.aulanosa.paneljuegos;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Método para guardar objetos Reserva
 * @author DVerd
 */
public class Reserva {
    
    private String usuario;
    
    private String email;
    
    private String participantsNumber;
    
    private String roomName;
    
    private String schedule;
    
    private String currentDate;

    public Reserva(String usuario, String email, String participantsNumber, String roomName, String schedule, String currentDate) {
        this.usuario = usuario;
        this.email = email;
        this.participantsNumber = participantsNumber;
        this.roomName = roomName;
        this.schedule = schedule;
        this.currentDate = currentDate;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

   
    
    
}
