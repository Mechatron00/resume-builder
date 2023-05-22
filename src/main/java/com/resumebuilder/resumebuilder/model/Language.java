package com.resumebuilder.resumebuilder.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Language
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String language;
    private String profiency;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getProfiency() {
        return profiency;
    }

    public void setProfiency(String profiency) {
        this.profiency = profiency;
    }
}
