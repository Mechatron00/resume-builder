package com.resumebuilder.resumebuilder.controller;

import com.resumebuilder.resumebuilder.service.EducationService;
import com.resumebuilder.resumebuilder.service.ResumeService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class ResumeController
{
    @Autowired
    private ResumeService resumeService;


    @GetMapping("/getresume/{id}")
    public ResponseEntity<?> getResume(@PathVariable("id") int id)  throws NotFoundException
    {
        return resumeService.getResumeById(id);
    }

    /*
     private String fname;
    private String lname;
    private String email;
    private String gender;
    private String contact;
    private String city;
    private String state;
    private Date dob;
    private String linkedin_link;
    private String githublink;
    private String website;
        */

    @PostMapping("/create")
    public ResponseEntity<?> createResume(@RequestParam("fname") String fname,
                                          @RequestParam("lname") String lname,
                                          @RequestParam("email") String email,
                                          @RequestParam("gender") String gender,
                                          @RequestParam("contact") String contact,
                                          @RequestParam("city") String city,
                                          @RequestParam("state") String state,
                                          @RequestParam("dob") String dob,
                                          @RequestParam("linkedin") String linkedin,
                                          @RequestParam("github") String github,
                                          @RequestParam("website") String website
                                          ) throws ParseException
    {
        try
        {
            SimpleDateFormat format = new SimpleDateFormat("dd-mm-yyyy");
            Date dOfBirth = format.parse(dob);

            return resumeService.createResume(fname, lname, email, gender, contact, city, state, dOfBirth, linkedin, github, website );
        }
        catch (ParseException exception)
        {
            return  new ResponseEntity<>("Enter date in DD-MM-YYYY  format", HttpStatus.BAD_REQUEST);
        }
    }

    //there is no need of update and delete resume
    // you can implement this apis in Angular or React to use external templates
}
