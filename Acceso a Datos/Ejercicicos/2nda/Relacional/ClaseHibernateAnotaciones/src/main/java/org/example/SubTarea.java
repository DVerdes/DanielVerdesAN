package org.example;

import javax.persistence.*;

@Entity
@Table(name = "Subtareas")
public class SubTarea {
    private int id;
    private String nombre;
    private Tarea tarea;

    public SubTarea() {
    }

    public SubTarea(int id, String nombre, Tarea tarea) {
        this.id = id;
        this.nombre = nombre;
        this.tarea = tarea;
    }

    public SubTarea(String nombre) {
        this.nombre = nombre;
    }

    public SubTarea(String nombre, Tarea tarea) {
        this.nombre = nombre;
        this.tarea = tarea;
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
    @ManyToOne
    @JoinColumn(name = "idTarea", insertable = false, updatable = false)
    public Tarea getTarea() {
        return tarea;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTarea(Tarea tarea) {
        this.tarea = tarea;
    }

    @Override
    public String toString() {
        return "SubTarea{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", tarea=" + tarea +
                '}';
    }
}
