package com.resumebuilder.resumebuilder.service;

import com.resumebuilder.resumebuilder.model.Education;
import com.resumebuilder.resumebuilder.repository.EducationRepo;
import javassist.NotFoundException;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class EducationService
{
    @Autowired
    private EducationRepo educationRepo;

    //create
    public ResponseEntity<?> createEducation(String instituteName, String degree, String branch, Date startDate, Date endDate, String score, String description)
    {
        Education education = new Education();
        education.setInstitute_name(instituteName);
        education.setDegree(degree);
        education.setBranch(branch);
        education.setStartDate(startDate);
        education.setEndDate(endDate);
        education.setScore(score);
        education.setDescription(description);

        Education persist = educationRepo.save(education);
        return new ResponseEntity<>(persist, HttpStatus.OK);
    }

    //update
    public ResponseEntity<?> updateEducation(int id, String instituteName, String degree, String branch, Date startDate, Date endDate, String score, String description ) throws NotFoundException {
        Optional<Education> existed = educationRepo.getEducationById(id);
        if(existed.isPresent())
        {
            Education education = existed.get();
            education.setInstitute_name(instituteName);
            education.setDegree(degree);
            education.setBranch(branch);
            education.setStartDate(startDate);
            education.setEndDate(endDate);
            education.setScore(score);
            education.setDescription(description);

            Education updated = educationRepo.save(education);
            return new ResponseEntity<>(updated, HttpStatus.OK);

        }
        else
        {
            throw new NotFoundException("Not Found");
        }
    }

    //get
    public ResponseEntity<?> getEducationById(int id) throws NotFoundException
    {
        Optional<Education> res = educationRepo.getEducationById(id);
        if (res.isPresent())
        {
            Education education = res.get();
            return new ResponseEntity<>(education, HttpStatus.OK);
        }
        else
        {
            throw new NotFoundException("Not Found");
        }
    }
    //delete
    public void deleteEducation(int id) throws NotFoundException
    {
        Optional<Education> res = educationRepo.getEducationById(id);
        if(res.isPresent())
        {
            Education education = res.get();
            educationRepo.delete(education);
            new ResponseEntity<>(HttpStatus.OK);
        }
        else
        {
            throw new NotFoundException("Not Found");
        }
    }
}
