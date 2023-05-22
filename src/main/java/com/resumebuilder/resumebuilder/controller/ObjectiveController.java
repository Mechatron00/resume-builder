package com.resumebuilder.resumebuilder.controller;

import com.resumebuilder.resumebuilder.service.HobbiesService;
import com.resumebuilder.resumebuilder.service.ObjectiveService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ObjectiveController
{
    @Autowired
    private ObjectiveService objectiveService;


    @GetMapping("/getobjective/{id}")
    public ResponseEntity<?> getObjective(@PathVariable("id") int id) throws NotFoundException
    {
        return objectiveService.getObjectiveById(id);
    }

    /*
     private String objective
        */

    @PostMapping("/addobjective")
    public ResponseEntity<?> addObjective(
            @RequestParam("objective") String objective)
    {
        return objectiveService.createObjective(objective);
    }

    @PutMapping("/addobjective/{id}")
    public ResponseEntity<?> updateObjective(@PathVariable("id") int id,
                                         @RequestParam("objective") String objective
    ) throws NotFoundException
    {
        return objectiveService.updateObjective(id, objective);
    }

    @DeleteMapping("/deleteobjective/{id}")
    public ResponseEntity<?> deleteObjective(@PathVariable int id) throws NotFoundException
    {
        objectiveService.deleteObjective(id);
        return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
    }
}
