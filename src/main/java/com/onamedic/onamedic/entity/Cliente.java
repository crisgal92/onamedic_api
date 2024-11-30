package com.onamedic.onamedic.entity;

import jakarta.persistence.*;

@Entity //Sirve para mapear como tabla
@Table (name="clientes")
//Creacion de los atributos para mapear en la base de datos
public class Cliente {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY) //El id lo va incrementando
    private Integer id;
    private String nombre;
    @Column (unique = true, nullable = false)
    private String correo;
   @Lob // Indica que es un campo de texto superior a 255 caracteres
    private String descripcion;

    //Constructores
    public Cliente() {
    }

    public Cliente(Integer id, String nombre, String correo, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.descripcion = descripcion;
    }

    //Setters y Getters


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
