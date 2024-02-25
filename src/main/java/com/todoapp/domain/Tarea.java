package com.todoapp.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Entity
@Data
@Table(name = "tareas")
public class Tarea implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tarea")
    private Long idTarea;

    private String nombreTarea;
    private String descripcion;
    private boolean activa;

    public Tarea() {
    }

    public Tarea(String nombreTarea, String descripcion, boolean activa) {
        this.nombreTarea = nombreTarea;
        this.descripcion = descripcion;
        this.activa = activa;
    }
}
