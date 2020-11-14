package com.example.barakatravelapp.data.model;

public class ItemObjectModel {
    private String name;
//    private int photo;

//    public ItemObjectModel(String name, int photo) {
//        this.name = name;
//    }
    public ItemObjectModel(String name) {
        this.name = name;
    }
    public ItemObjectModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}