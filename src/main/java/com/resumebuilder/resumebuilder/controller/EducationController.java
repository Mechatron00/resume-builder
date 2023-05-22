package com.resumebuilder.resumebuilder.controller;

import com.resumebuilder.resumebuilder.service.CertificationService;
import com.resumebuilder.resumebuilder.service.EducationService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class EducationController
{
    @Autowired
    private EducationService educationService;


    @GetMapping("/geteducation/{id}")
    public ResponseEntity<?> getEducation(@PathVariable("id") int id) throws NotFoundException
    {
        return educationService.getEducationById(id);
    }

    /*
     private String institute_name;
    private String degree;
    private String branch;
    private Date startDate;
    private Date endDate;

    private String score;
    private String description;
        */

    @PostMapping("/addeducation")
    public ResponseEntity<?> addEducation(@RequestParam("instituteName") String instituteName,
                                          @RequestParam("degree") String degree,
                                          @RequestParam("branch") String branch,
                                          @RequestParam("startDate") String startDate,
                                          @RequestParam("endDate") String endDate,
                                          @RequestParam("score") String score,
                                              @RequestParam("description") String description) throws ParseException
    {
        try
        {
            SimpleDateFormat format = new SimpleDateFormat("mm-yyyy");
            Date date1 = format.parse(startDate);
            Date date2 = format.parse(endDate);
            return educationService.createEducation(instituteName, degree, branch, date1, date2, score, description);
        }
        catch (ParseException exception)
        {
            return  new ResponseEntity<>("Enter date in MM-YYYY  format", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/addeducation/{id}")
    public ResponseEntity<?> updateEducation(@PathVariable("id") int id,
                                                 @RequestParam("instituteName") String instituteName,
                                                 @RequestParam("degree") String degree,
                                                 @RequestParam("branch") String branch,
                                                 @RequestParam("startDate") String startDate,
                                                 @RequestParam("endDate") String endDate,
                                                 @RequestParam("score") String score,
                                                 @RequestParam("description") String description
    ) throws NotFoundException
    {
        try
        {
            SimpleDateFormat format = new SimpleDateFormat("mm-yyyy");
            Date date1 = format.parse(startDate);
            Date date2 = format.parse(endDate);
            return educationService.updateEducation(id, instituteName, degree, branch, date1, date2, score, description);
        }
        catch (ParseException exception)
        {
            return  new ResponseEntity<>("Enter date in MM-YYYY  format", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteeducation/{id}")
    public ResponseEntity<?> deleteEducation(@PathVariable int id) throws NotFoundException
    {
        educationService.deleteEducation(id);
        return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
    }
}
