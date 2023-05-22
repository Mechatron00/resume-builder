package com.resumebuilder.resumebuilder.service;

import com.resumebuilder.resumebuilder.model.Education;
import com.resumebuilder.resumebuilder.model.PersonalSkills;
import com.resumebuilder.resumebuilder.repository.EducationRepo;
import com.resumebuilder.resumebuilder.repository.PersonalSkillsRepo;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class PersonalSkillsService
{
    @Autowired
    private PersonalSkillsRepo personalSkillsRepo;

    //create
    public ResponseEntity<?> createPersonalSkills(String description)
    {
        PersonalSkills personalSkills = new PersonalSkills();
        personalSkills.setDescription(description);

        PersonalSkills persist = personalSkillsRepo.save(personalSkills);
        return new ResponseEntity<>(persist, HttpStatus.OK);
    }

    //update
    public ResponseEntity<?> updatePersonalSkills(int id, String description ) throws NotFoundException {
        Optional<PersonalSkills> existed = personalSkillsRepo.getPersonalSkillsById(id);
        if(existed.isPresent())
        {
            PersonalSkills personalSkills = existed.get();
            personalSkills.setDescription(description);

            PersonalSkills updated = personalSkillsRepo.save(personalSkills);
            return new ResponseEntity<>(updated, HttpStatus.OK);

        }
        else
        {
            throw new NotFoundException("Not Found");
        }
    }

    //get
    public ResponseEntity<?> getPersonalSkillsById(int id) throws NotFoundException
    {
        Optional<PersonalSkills> res = personalSkillsRepo.getPersonalSkillsById(id);
        if (res.isPresent())
        {
            PersonalSkills personalSkills = res.get();
            return new ResponseEntity<>(personalSkills, HttpStatus.OK);
        }
        else
        {
            throw new NotFoundException("Not Found");
        }
    }
    //delete
    public void deletePersonalSkills(int id) throws NotFoundException
    {
        Optional<PersonalSkills> res = personalSkillsRepo.getPersonalSkillsById(id);
        if(res.isPresent())
        {
            PersonalSkills personalSkills = res.get();
            personalSkillsRepo.delete(personalSkills);
            new ResponseEntity<>(HttpStatus.OK);
        }
        else
        {
            throw new NotFoundException("Not Found");
        }
    }
}
