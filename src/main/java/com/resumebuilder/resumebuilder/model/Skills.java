package com.resumebuilder.resumebuilder.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Skills
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String skill;
    private String comptetence;//levels-beginner,intermediate or expert

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getComptetence() {
        return comptetence;
    }

    public void setComptetence(String comptetence) {
        this.comptetence = comptetence;
    }
}
