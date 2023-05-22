package com.resumebuilder.resumebuilder.service;

import com.resumebuilder.resumebuilder.model.Education;
import com.resumebuilder.resumebuilder.model.Skills;
import com.resumebuilder.resumebuilder.repository.SkillsRepo;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class SkillsService
{
    @Autowired
    private SkillsRepo skillsRepo;

    //create
    public ResponseEntity<?> createSkills(String skill, String competence)
    {
        Skills skills = new Skills();
        skills.setSkill(skill);
        skills.setComptetence(competence);


        Skills persist = skillsRepo.save(skills);
        return new ResponseEntity<>(persist, HttpStatus.OK);
    }

    //update
    public ResponseEntity<?> updateSkills(int id, String skill, String competence) throws NotFoundException {
        Optional<Skills> existed = skillsRepo.getSkillsById(id);
        if(existed.isPresent())
        {
            Skills skills = existed.get();
            skills.setSkill(skill);
            skills.setComptetence(competence);


            Skills updated = skillsRepo.save(skills);
            return new ResponseEntity<>(updated, HttpStatus.OK);

        }
        else
        {
            throw new NotFoundException("Not Found");
        }
    }

    //get
    public ResponseEntity<?> getSkillsById(int id) throws NotFoundException
    {
        Optional<Skills> res = skillsRepo.getSkillsById(id);
        if (res.isPresent())
        {
            Skills skills = res.get();
            return new ResponseEntity<>(skills, HttpStatus.OK);
        }
        else
        {
            throw new NotFoundException("Not Found");
        }
    }
    //delete
    public void deleteSkills(int id) throws NotFoundException
    {
        Optional<Skills> res = skillsRepo.getSkillsById(id);
        if(res.isPresent())
        {
            Skills skills = res.get();
            skillsRepo.delete(skills);
            new ResponseEntity<>(HttpStatus.OK);
        }
        else
        {
            throw new NotFoundException("Not Found");
        }
    }
}
