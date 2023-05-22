package com.resumebuilder.resumebuilder.service;

import com.resumebuilder.resumebuilder.model.Projects;
import com.resumebuilder.resumebuilder.repository.ProjectsRepo;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class ProjectsService
{
    @Autowired
    private ProjectsRepo projectsRepo;

    //create
    public ResponseEntity<?> createProjects(String title, Date startDate, Date endDate, String weblink, String description)
    {
        Projects projects = new Projects();
        projects.setTitle(title);
        projects.setStartDate(startDate);
        projects.setEndDate(endDate);
        projects.setWeblink(weblink);
        projects.setDescription(description);

        Projects persist = projectsRepo.save(projects);
        return new ResponseEntity<>(persist, HttpStatus.OK);
    }

    //update
    public ResponseEntity<?> updateProjects(int id, String title, Date startDate, Date endDate, String weblink, String description ) throws NotFoundException {
        Optional<Projects> existed = projectsRepo.getProjectsById(id);
        if(existed.isPresent())
        {
            Projects projects = existed.get();
            projects.setTitle(title);
            projects.setStartDate(startDate);
            projects.setEndDate(endDate);
            projects.setWeblink(weblink);
            projects.setDescription(description);


            Projects updated = projectsRepo.save(projects);
            return new ResponseEntity<>(updated, HttpStatus.OK);

        }
        else
        {
            throw new NotFoundException("Not Found");
        }
    }

    //get
    public ResponseEntity<?> getProjectsById(int id) throws NotFoundException
    {
        Optional<Projects> res = projectsRepo.getProjectsById(id);
        if (res.isPresent())
        {
            Projects projects = res.get();
            return new ResponseEntity<>(projects, HttpStatus.OK);
        }
        else
        {
            throw new NotFoundException("Not Found");
        }
    }
    //delete
    public void deleteProjects(int id) throws NotFoundException
    {
        Optional<Projects> res = projectsRepo.getProjectsById(id);
        if(res.isPresent())
        {
            Projects projects = res.get();
            projectsRepo.delete(projects);
            new ResponseEntity<>(HttpStatus.OK);
        }
        else
        {
            throw new NotFoundException("Not Found");
        }
    }
}
