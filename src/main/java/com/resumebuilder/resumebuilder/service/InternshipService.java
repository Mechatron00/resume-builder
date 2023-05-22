package com.resumebuilder.resumebuilder.service;

import com.resumebuilder.resumebuilder.model.Internship;
import com.resumebuilder.resumebuilder.repository.InternshipRepo;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class InternshipService
{
    @Autowired
    private InternshipRepo internshipRepo;

    //create
    public ResponseEntity<?> createInternship(String company, String location, String position, Date startDate, Date endDate, String description)
    {
        Internship internship = new Internship();
        internship.setCompany(company);
        internship.setLocation(location);
        internship.setPosition(position);
        internship.setStartDate(startDate);
        internship.setEndDate(endDate);
        internship.setDescription(description);

        Internship persist = internshipRepo.save(internship);
        return new ResponseEntity<>(persist, HttpStatus.OK);
    }

    //update
    public ResponseEntity<?> updateInternship(int id, String company, String location, String position, Date startDate, Date endDate, String description ) throws NotFoundException {
        Optional<Internship> existed = internshipRepo.getInternshipById(id);
        if(existed.isPresent())
        {
            Internship internship = existed.get();
            internship.setCompany(company);
            internship.setLocation(location);
            internship.setPosition(position);
            internship.setStartDate(startDate);
            internship.setEndDate(endDate);
            internship.setDescription(description);


            Internship updated = internshipRepo.save(internship);
            return new ResponseEntity<>(updated, HttpStatus.OK);

        }
        else
        {
            throw new NotFoundException("Not Found");
        }
    }

    //get
    public ResponseEntity<?> getInternshipById(int id) throws NotFoundException
    {
        Optional<Internship> res = internshipRepo.getInternshipById(id);
        if (res.isPresent())
        {
            Internship internship = res.get();
            return new ResponseEntity<>(internship, HttpStatus.OK);
        }
        else
        {
            throw new NotFoundException("Not Found");
        }
    }
    //delete
    public void deleteIntership(int id) throws NotFoundException
    {
        Optional<Internship> res = internshipRepo.getInternshipById(id);
        if(res.isPresent())
        {
            Internship internship = res.get();
            internshipRepo.delete(internship);
            new ResponseEntity<>(HttpStatus.OK);
        }
        else
        {
            throw new NotFoundException("Not Found");
        }
    }
}
