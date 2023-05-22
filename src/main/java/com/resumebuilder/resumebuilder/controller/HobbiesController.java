package com.resumebuilder.resumebuilder.controller;

import com.resumebuilder.resumebuilder.model.Hobbies;
import com.resumebuilder.resumebuilder.service.ExtraCurricularService;
import com.resumebuilder.resumebuilder.service.HobbiesService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class HobbiesController
{
    @Autowired
    private HobbiesService hobbiesService;


    @GetMapping("/gethobby/{id}")
    public ResponseEntity<?> getHobby(@PathVariable("id") int id) throws NotFoundException
    {
        return hobbiesService.getHobbyById(id);
    }

    /*
     private String hobby;
        */

    @PostMapping("/addhobby")
    public ResponseEntity<?> addHobby(
            @RequestParam("hobby") String hobby)
    {
        return hobbiesService.createHobby(hobby);
    }

    @PutMapping("/addhobby/{id}")
    public ResponseEntity<?> updateHobby(@PathVariable("id") int id,
                                         @RequestParam("hobby") String hobby
    ) throws NotFoundException
    {
        return hobbiesService.updateHobbies(id, hobby);
    }

    @DeleteMapping("/deletehobby/{id}")
    public ResponseEntity<?> deleteHobby(@PathVariable int id) throws NotFoundException
    {
        hobbiesService.deleteHobby(id);
        return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
    }
}
