package com.example.form.logic;

import java.util.ArrayList;

public class ModelData {
    private ArrayList<Form> formList;


    public ModelData() {
        formList = new ArrayList<>();
        prepareFormData();
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

    public ArrayList<Form> getFormList() {
        return formList;
    }

    public void setFormList(ArrayList<Form> formList) {
        this.formList = formList;
    }
}
