package com.resumebuilder.resumebuilder.controller;

import com.resumebuilder.resumebuilder.service.EducationService;
import com.resumebuilder.resumebuilder.service.InternshipService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
//Can be use for experience also
public class InternshipController//or ExperienceController
{
    @Autowired
    private InternshipService internshipService;


    @GetMapping("/getexperience/{id}")
    public ResponseEntity<?> getEducation(@PathVariable("id") int id) throws NotFoundException
    {
        return internshipService.getInternshipById(id);
    }

    /*
     private String company;
    private String location;
    private String position;
    private Date startDate;
    private Date endDate;
    private String description;
        */

    @PostMapping("/addexperience")
    public ResponseEntity<?> addEducation(@RequestParam("company") String company,
                                          @RequestParam("location") String location,
                                          @RequestParam("position") String position,
                                          @RequestParam("startDate") String startDate,
                                          @RequestParam("endDate") String endDate,
                                          @RequestParam("description") String description) throws ParseException
    {
        try
        {
            SimpleDateFormat format = new SimpleDateFormat("mm-yyyy");
            Date date1 = format.parse(startDate);
            Date date2 = format.parse(endDate);
            return internshipService.createInternship(company, location, position, date1, date2, description);
        }
        catch (ParseException exception)
        {
            return  new ResponseEntity<>("Enter date in MM-YYYY  format", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/addexperience/{id}")
    public ResponseEntity<?> updateEducation(@PathVariable("id") int id,
                                             @RequestParam("company") String company,
                                             @RequestParam("location") String location,
                                             @RequestParam("position") String position,
                                             @RequestParam("startDate") String startDate,
                                             @RequestParam("endDate") String endDate,
                                             @RequestParam("description") String description
    ) throws NotFoundException
    {
        try
        {
            SimpleDateFormat format = new SimpleDateFormat("mm-yyyy");
            Date date1 = format.parse(startDate);
            Date date2 = format.parse(endDate);
            return internshipService.updateInternship(id, company, location, position, date1, date2, description);
        }
        catch (ParseException exception)
        {
            return  new ResponseEntity<>("Enter date in MM-YYYY  format", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteexperience/{id}")
    public ResponseEntity<?> deleteExperience(@PathVariable int id) throws NotFoundException
    {
        internshipService.deleteIntership(id);
        return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
    }
}
