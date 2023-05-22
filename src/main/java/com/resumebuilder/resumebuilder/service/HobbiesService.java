package com.resumebuilder.resumebuilder.service;

import com.resumebuilder.resumebuilder.model.Education;
import com.resumebuilder.resumebuilder.model.Hobbies;
import com.resumebuilder.resumebuilder.repository.EducationRepo;
import com.resumebuilder.resumebuilder.repository.HobbiesRepo;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class HobbiesService
{
    @Autowired
    private HobbiesRepo hobbiesRepo;

    //create
    public ResponseEntity<?> createHobby(String hobby)
    {
        Hobbies hobbies = new Hobbies();
        hobbies.setHobby(hobby);

        Hobbies persist = hobbiesRepo.save(hobbies);
        return new ResponseEntity<>(persist, HttpStatus.OK);
    }

    //update
    public ResponseEntity<?> updateHobbies(int id, String hobby ) throws NotFoundException {
        Optional<Hobbies> existed = hobbiesRepo.getHobbiesById(id);
        if(existed.isPresent())
        {
            Hobbies hobbies = existed.get();
            hobbies.setHobby(hobby);


            Hobbies updated = hobbiesRepo.save(hobbies);
            return new ResponseEntity<>(updated, HttpStatus.OK);

        }
        else
        {
            throw new NotFoundException("Not Found");
        }
    }

    //get
    public ResponseEntity<?> getHobbyById(int id) throws NotFoundException
    {
        Optional<Hobbies> res = hobbiesRepo.getHobbiesById(id);
        if (res.isPresent())
        {
            Hobbies hobbies = res.get();
            return new ResponseEntity<>(hobbies, HttpStatus.OK);
        }
        else
        {
            throw new NotFoundException("Not Found");
        }
    }
    //delete
    public void deleteHobby(int id) throws NotFoundException
    {
        Optional<Hobbies> res = hobbiesRepo.getHobbiesById(id);
        if(res.isPresent())
        {
            Hobbies hobbies = res.get();
            hobbiesRepo.delete(hobbies);
            new ResponseEntity<>(HttpStatus.OK);
        }
        else
        {
            throw new NotFoundException("Not Found");
        }
    }
}
