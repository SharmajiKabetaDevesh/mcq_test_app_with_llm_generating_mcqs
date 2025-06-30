package com.testApp.testApp.Model;

import jakarta.persistence.*;


@Entity
public class Tests {

    @Id
    private int id;

    public Tests(){};
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    public Tests(int id,String name){
        this.id=id;
        this.name=name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
