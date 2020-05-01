package com.example.form.logic;

import java.io.Serializable;
import java.util.ArrayList;

public class Data implements Serializable {

    private static Data singleton_instance = null;
    public ArrayList<Usuario> usuarios;
    private ArrayList<Form> formList;
    public Usuario mainUser;


    private Data() {
        usuarios = new ArrayList<>();
        formList = new ArrayList<>();
        usuarios.add(new Usuario("admin", "admin"));
        mainUser = null;
        prepareFormData();
    }

    public static Data getInstance() {
        if (singleton_instance == null)
            singleton_instance = new Data();
        return singleton_instance;
    }

    public void prepareFormData() {
        Form form = new Form("Carlos", "Obando", "Calle #18, La Ilusion",
                "San Francisco de Ulloa",
                "Heredia", "Heredia",
                "40103", "Costa Rica",
                "carlos.obando.avendana@gmail.com",
                "87106583",
                "Developer",
                "28/11/1997");
        formList.add(form);
        Form form2 = new Form("Felipe", "Piedra", "Calle sin salida",
                "Curridabat",
                "Chepe", "Chepe",
                "10394", "Costa Rica",
                "pw.felipe@gmail.com",
                "849236747",
                "Developer",
                "01/12/1996");
        formList.add(form2);

    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public ArrayList<Form> getFormList() {
        return formList;
    }

    public void setFormList(ArrayList<Form> formList) {
        this.formList = formList;
    }
}
