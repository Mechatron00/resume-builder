package com.resumebuilder.resumebuilder.controller;

import com.resumebuilder.resumebuilder.service.HobbiesService;
import com.resumebuilder.resumebuilder.service.LanguageService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LanguageController
{
    @Autowired
    private LanguageService languageService;


    @GetMapping("/getlanguage/{id}")
    public ResponseEntity<?> getLanguage(@PathVariable("id") int id) throws NotFoundException
    {
        return languageService.getLanguageById(id);
    }

    /*
      private String language;
    private String profiency;
        */

    @PostMapping("/addlanguage")
    public ResponseEntity<?> addLanguage(
            @RequestParam("language") String language,
            @RequestParam("profiency") String profiency
            )
    {
        return languageService.createLanguage(language, profiency);
    }

    @PutMapping("/addlanguage/{id}")
    public ResponseEntity<?> updateLanguage(@PathVariable("id") int id,
                                            @RequestParam("language") String language,
                                            @RequestParam("profiency") String profiency
    ) throws NotFoundException
    {
        return languageService.updateLanguage(id, language, profiency);
    }

    @DeleteMapping("/deletelanguage/{id}")
    public ResponseEntity<?> deleteLanguage(@PathVariable int id) throws NotFoundException
    {
        languageService.deleteLanguage(id);
        return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
    }
}
