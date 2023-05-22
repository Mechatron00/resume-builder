package com.resumebuilder.resumebuilder.controller;

import com.resumebuilder.resumebuilder.service.ObjectiveService;
import com.resumebuilder.resumebuilder.service.PersonalSkillsService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonalSkillsController
{
    @Autowired
    private PersonalSkillsService personalSkillsService;


    @GetMapping("/getpersonalskill/{id}")
    public ResponseEntity<?> getPersonalSkill(@PathVariable("id") int id) throws NotFoundException
    {
        return personalSkillsService.getPersonalSkillsById(id);
    }

    /*
     private String description
        */

    @PostMapping("/addpersonalskill")
    public ResponseEntity<?> addPersonalSkill(
            @RequestParam("description") String description)
    {
        return personalSkillsService.createPersonalSkills(description);
    }

    @PutMapping("/addpersonalskill/{id}")
    public ResponseEntity<?> updateObjective(@PathVariable("id") int id,
                                             @RequestParam("description") String description
    ) throws NotFoundException
    {
        return personalSkillsService.updatePersonalSkills(id, description);
    }

    @DeleteMapping("/deletepersonalskill/{id}")
    public ResponseEntity<?> deleteObjective(@PathVariable int id) throws NotFoundException
    {
        personalSkillsService.deletePersonalSkills(id);
        return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
    }
}
