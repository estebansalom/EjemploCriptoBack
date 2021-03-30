package com.example.cripto.dto;

import com.example.cripto.model.User;

import javax.persistence.*;

@Entity
public class UserDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "apellidos", nullable = false)
    private String apellidos;
    @Column(name = "identificacion", nullable = false)
    private String identificacion;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "telefono", nullable = false)
    private String telefono;
    @Column(name = "password", nullable = false)
    private String password;

    public UserDto() {
    }

    public UserDto(int id, String nombre, String apellidos, String identificacion, String email, String telefono, String password) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.identificacion = identificacion;
        this.email = email;
        this.telefono = telefono;
        this.password = password;
    }


    public UserDto(User u){
        this.nombre = u.getNombre();
        this.apellidos = u.getApellidos();
        this.identificacion = u.getIdentificacion();
        this.email = u.getEmail();
        this.telefono = u.getTelefono();
        this.password = u.getPassword();
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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identification) {
        this.identificacion = identification;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
