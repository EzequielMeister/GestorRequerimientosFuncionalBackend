package com.ezequielmeister.gestionrequerimientos.model;

import jakarta.persistence.*;

@Entity
@Table(name = "requerimientos")
public class Requerimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    //atributos
    private Long id;
    private String titulo;
    private String descripcion;
    private String prioridad;
    private String estado;

    //constructores
    public Requerimiento() {}

    public Requerimiento(String titulo, String descripcion, String prioridad, String estado) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.estado = estado;
    }

    //metodos

    // Getters y Setters
    public Long getId() { return id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getPrioridad() { return prioridad; }
    public void setPrioridad(String prioridad) { this.prioridad = prioridad; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
