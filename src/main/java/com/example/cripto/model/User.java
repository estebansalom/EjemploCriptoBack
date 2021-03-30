package com.example.cripto.model;

import com.example.cripto.dto.UserDto;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    private int id;
    private String nombre;
    private String apellidos;
    private String identificacion;
    private String email;
    private String telefono;
    private String password;
    private String publicKey;

    public User(){
    }

    public User(@JsonProperty("nombre") String nombre,@JsonProperty("apellidos") String apellidos,@JsonProperty("identificacion")String identificacion,@JsonProperty("email") String email,@JsonProperty("telefono") String telefono,@JsonProperty("password") String password) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.identificacion = identificacion;
        this.email = email;
        this.telefono = telefono;
        this.password = password;
    }

    public User(int id, String nombre, String apellidos, String identificacion, String email, String telefono, String password) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.identificacion = identificacion;
        this.email = email;
        this.telefono = telefono;
        this.password = password;
    }

    public User(UserDto u){
        this.id = u.getId();
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
