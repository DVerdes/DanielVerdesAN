package org.example;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

public class Tarea implements Serializable {

    private int id;
    private String nombre;
    private String descripcion;
    private Timestamp fecha;
    private String estado;

    private Set<Subtarea> subtareas;

    public Tarea() {
    }

    public Tarea(int id, String nombre, String descripcion, Timestamp fecha, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.estado = estado;
    }

    public Tarea(int id, String nombre, String descripcion, Timestamp fecha, String estado, Set<Subtarea> subtareas) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.estado = estado;
        this.subtareas = subtareas;
    }

    public Tarea(String nombre, String descripcion, Timestamp fecha, String estado, Set<Subtarea> subtareas) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.estado = estado;
        this.subtareas = subtareas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Set<Subtarea> getSubtareas() {
        return subtareas;
    }

    public void setSubtareas(Set<Subtarea> subtareas) {
        this.subtareas = subtareas;
    }

    @Override
    public String toString() {
        return "Tarea{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fecha=" + fecha +
                ", estado='" + estado + '\'' +
                ", subtareas=" + subtareas +
                '}';
    }
}


