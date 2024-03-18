package com.todoapp.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Entity
@Data
@Table(name = "usuarios")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;

    private String nombre;
    private String apellidos;
    private String genero;
    private String correo;
    private String contrasena;
    
    @OneToMany
    @JoinColumn(name = "id_usuario", insertable = false, updatable = false)
    private List<Tarea> tareas;

    public Usuario(String nombre, String apellidos, String genero, String correo, String contrasena) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.genero = genero;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public Usuario() {
    }

}
