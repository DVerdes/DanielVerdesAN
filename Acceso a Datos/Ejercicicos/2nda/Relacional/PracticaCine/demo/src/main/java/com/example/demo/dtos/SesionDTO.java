package com.example.demo.dtos;

import java.sql.Date;
import java.sql.Timestamp;

public class SesionDTO {

    private int SesionID;
    private int PeliculaID;
    private Timestamp HoraInicio;
    private Timestamp HoraFin;

    public SesionDTO() {
    }

    public SesionDTO(int sesionID, int peliculaID, Timestamp horaInicio, Timestamp horaFin) {
        SesionID = sesionID;
        PeliculaID = peliculaID;
        HoraInicio = horaInicio;
        HoraFin = horaFin;
    }

    public SesionDTO(int peliculaID, Timestamp horaInicio, Timestamp horaFin) {
        PeliculaID = peliculaID;
        HoraInicio = horaInicio;
        HoraFin = horaFin;
    }

    public int getSesionID() {
        return SesionID;
    }

    public void setSesionID(int sesionID) {
        SesionID = sesionID;
    }

    public int getPeliculaID() {
        return PeliculaID;
    }

    public void setPeliculaID(int peliculaID) {
        PeliculaID = peliculaID;
    }

    public Timestamp getHoraInicio() {
        return HoraInicio;
    }

    public void setHoraInicio(Timestamp horaInicio) {
        HoraInicio = horaInicio;
    }

    public Timestamp getHoraFin() {
        return HoraFin;
    }

    public void setHoraFin(Timestamp horaFin) {
        HoraFin = horaFin;
    }

    @Override
    public String toString() {
        return "SesionDTO{" +
                "SesionID=" + SesionID +
                ", PeliculaID=" + PeliculaID +
                ", HoraInicio=" + HoraInicio +
                ", HoraFin=" + HoraFin +
                '}';
    }
}
