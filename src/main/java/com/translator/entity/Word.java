package com.translator.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Word {
    @Id
    private int id;
    private String englishRepresentation;
    private String ukrainianRepresentation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEnglishRepresentation() {
        return englishRepresentation;
    }

    public void setEnglishRepresentation(String englishRepresentation) {
        this.englishRepresentation = englishRepresentation;
    }

    public String getUkrainianRepresentation() {
        return ukrainianRepresentation;
    }

    public void setUkrainianRepresentation(String ukrainianRepresentation) {
        this.ukrainianRepresentation = ukrainianRepresentation;
    }

    public Word() {
    }
}
