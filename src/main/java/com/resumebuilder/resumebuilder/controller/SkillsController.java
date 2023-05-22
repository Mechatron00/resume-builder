package com.resumebuilder.resumebuilder.controller;

import com.resumebuilder.resumebuilder.service.HobbiesService;
import com.resumebuilder.resumebuilder.service.SkillsService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SkillsController
{
    @Autowired
    private SkillsService skillsService;


    @GetMapping("/getskill/{id}")
    public ResponseEntity<?> getSkill(@PathVariable("id") int id) throws NotFoundException
    {
        return skillsService.getSkillsById(id);
    }

    /*
      private String skill;
    private String comptetence;
        */

    @PostMapping("/addskill")
    public ResponseEntity<?> addSkill(
            @RequestParam("skill") String skill,
            @RequestParam("competence") String competence)
    {
        return skillsService.createSkills(skill, competence);
    }

    @PutMapping("/addskill/{id}")
    public ResponseEntity<?> updateSkill(@PathVariable("id") int id,
                                         @RequestParam("skill") String skill,
                                         @RequestParam("competence") String competence
    ) throws NotFoundException
    {
        return skillsService.updateSkills(id, skill, competence);
    }

    @DeleteMapping("/deleteskill/{id}")
    public ResponseEntity<?> deleteSkill(@PathVariable int id) throws NotFoundException
    {
        skillsService.deleteSkills(id);
        return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
    }
}
