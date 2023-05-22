package com.resumebuilder.resumebuilder.controller;

import com.resumebuilder.resumebuilder.service.ProjectsService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class ProjectsController
{
    @Autowired
    private ProjectsService projectsService;


    @GetMapping("/getprojet/{id}")
    public ResponseEntity<?> getProject(@PathVariable("id") int id) throws NotFoundException
    {
        return projectsService.getProjectsById(id);
    }

    /*
    private String title;
    private Date startDate;
    private Date endDate;
    private String weblink;
    private String description;    */

    @PostMapping("/addproject")
    public ResponseEntity<?> addProject(@RequestParam("title") String title,
                                        @RequestParam("startDate") String startDate,
                                        @RequestParam("endDate") String endDate,
                                        @RequestParam("weblink") String weblink,
                                        @RequestParam("description") String description) throws ParseException
    {
        try
        {
            SimpleDateFormat format = new SimpleDateFormat("mm-yyyy");
            Date sDate = format.parse(startDate);
            Date eDate = format.parse(endDate);
            return projectsService.createProjects(title, sDate, eDate, weblink, description);
        }
        catch (ParseException exception)
        {
            return  new ResponseEntity<>("Enter date in MM-YYYY  format", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/addproject/{id}")
    public ResponseEntity<?> updateProject(@PathVariable("id") int id,
                                                 @RequestParam("title") String title,
                                                 @RequestParam("startDate") String startDate,
                                                 @RequestParam("endDate") String endDate,
                                                 @RequestParam("weblink") String weblink,
                                                 @RequestParam("description") String description
    ) throws NotFoundException
    {
        try
        {
            SimpleDateFormat format = new SimpleDateFormat("mm-yyyy");
            Date sDate = format.parse(startDate);
            Date eDate = format.parse(endDate);
            return projectsService.updateProjects(id, title, sDate, eDate, weblink, description);
        }
        catch (ParseException exception)
        {
            return  new ResponseEntity<>("Enter date in MM-YYYY  format", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteproject/{id}")
    public ResponseEntity<?> deleteProject(@PathVariable int id) throws NotFoundException
    {
        projectsService.deleteProjects(id);
        return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
    }
}
