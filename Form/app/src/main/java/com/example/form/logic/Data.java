package com.example.form.logic;

import java.io.Serializable;
import java.util.ArrayList;

public class Data implements Serializable {

    private static Data singleton_instance = null;
    public ArrayList<Usuario> usuarios;
    public Usuario mainUser;

    private Data(){
        usuarios=new ArrayList<>();
        usuarios.add(new Usuario("admin","admin"));
        mainUser=null;
    }

    public static Data getInstance(){
        if(singleton_instance==null)
            singleton_instance=new Data();
        return singleton_instance;
    }

}
