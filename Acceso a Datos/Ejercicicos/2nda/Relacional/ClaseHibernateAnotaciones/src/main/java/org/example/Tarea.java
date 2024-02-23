package org.example;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "Tareas")
public class Tarea implements Serializable {
    private int id;
    private String nombre;
    private String descripcion;
    private Timestamp fecha;
    private String estado;
    private Set<SubTarea> subtareas;

    public Tarea() {
    }

    public Tarea(int id, String nombre, String descripcion, Timestamp fecha, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.estado = estado;
    }

    public Tarea(String nombre, String descripcion, Timestamp fecha, String estado) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.estado = estado;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }
    @Column(name = "nombre")
    public String getNombre() {
        return nombre;
    }
    @Column(name = "descripcion")
    public String getDescripcion() {
        return descripcion;
    }
    @Column(name = "fecha")
    public Timestamp getFecha() {
        return fecha;
    }
    @Column(name = "estado")
    public String getEstado() {
        return estado;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idTarea")
    public Set<SubTarea> getSubtareas() {
        return subtareas;
    }

    public void setSubtareas(Set<SubTarea> subtareas) {
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
                '}';
    }
}
