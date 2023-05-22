package com.resumebuilder.resumebuilder.service;

import com.resumebuilder.resumebuilder.model.Objective;
import com.resumebuilder.resumebuilder.repository.ObjectiveRepo;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class ObjectiveService
{
    @Autowired
    private ObjectiveRepo objectiveRepo;

    //create
    public ResponseEntity<?> createObjective(String obj)
    {
        Objective objective = new Objective();
        objective.setObjective(obj);

        Objective persist = objectiveRepo.save(objective);
        return new ResponseEntity<>(persist, HttpStatus.OK);
    }

    //update
    public ResponseEntity<?> updateObjective(int id, String obj) throws NotFoundException {
        Optional<Objective> existed = objectiveRepo.getObjectiveById(id);
        if(existed.isPresent())
        {
            Objective objective = existed.get();
            objective.setObjective(obj);

            Objective updated = objectiveRepo.save(objective);
            return new ResponseEntity<>(updated, HttpStatus.OK);

        }
        else
        {
            throw new NotFoundException("Not Found");
        }
    }

    //get
    public ResponseEntity<?> getObjectiveById(int id) throws NotFoundException
    {
        Optional<Objective> res = objectiveRepo.getObjectiveById(id);
        if (res.isPresent())
        {
            Objective objective = res.get();
            return new ResponseEntity<>(objective, HttpStatus.OK);
        }
        else
        {
            throw new NotFoundException("Not Found");
        }
    }
    //delete
    public void deleteObjective(int id) throws NotFoundException
    {
        Optional<Objective> res = objectiveRepo.getObjectiveById(id);
        if(res.isPresent())
        {
            Objective objective = res.get();
            objectiveRepo.delete(objective);
            new ResponseEntity<>(HttpStatus.OK);
        }
        else
        {
            throw new NotFoundException("Not Found");
        }
    }
}
