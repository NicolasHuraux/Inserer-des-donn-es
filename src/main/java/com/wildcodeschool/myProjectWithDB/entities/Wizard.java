package com.wildcodeschool.myProjectWithDB.entities;

public class Wizard {

    private int id;
    private String name;
    private Integer capacity;
    private String country;
   

    public Wizard(int id, String name, Integer capacity, String country) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.country= country;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public String getCountry() {
        return country;
    }

   
}
