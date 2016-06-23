package com.translator.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Word {
    @Id
    private int id;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Word() {
    }
}
