package com.example.form.logic;

import java.io.Serializable;

public class Usuario implements Serializable {

    String id;
    String password;
    int rol;

    public Usuario() {
        this.id = "";
        this.password = "";
        this.rol = 0;
    }

    public Usuario(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
