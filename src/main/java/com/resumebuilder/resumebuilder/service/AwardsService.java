package com.resumebuilder.resumebuilder.service;

import com.resumebuilder.resumebuilder.model.Awards;
import com.resumebuilder.resumebuilder.repository.AwardsRepo;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class AwardsService {
    @Autowired
    private AwardsRepo awardsRepo;

    //create an award
    public ResponseEntity<?> createAward(String title, String issuer, Date issuedDate, String description) {

        Awards award = new Awards();
        award.setTitle(title);
        award.setIssuer(issuer);
        award.setIssuedDate(issuedDate);
        award.setDescription(description);

        Awards awards = awardsRepo.save(award);
        return new ResponseEntity<>(awards, HttpStatus.OK);
    }

    //update


    public ResponseEntity<?> updateAward(int id, String title, String issuer, Date issuedDate, String description) throws NotFoundException
    {

        Optional<Awards> existed = awardsRepo.findById(id);

        if(existed.isPresent())
        {
            Awards award =existed.get();
            award.setTitle(title);
            award.setIssuer(issuer);
            award.setIssuedDate(issuedDate);
            award.setDescription(description);
            Awards awards = awardsRepo.save(award);
            return new ResponseEntity<>(awards, HttpStatus.OK);
        }
        else
        {
            throw new NotFoundException("Requested award not found");
        }
    }

    //get Award
    public ResponseEntity<?> getAwardById(int id) throws NotFoundException
    {
        Optional<Awards> res=awardsRepo.getAwardsById(id);
        if(res.isPresent())
        {
            Awards awards=res.get();
            return new ResponseEntity<>(awards, HttpStatus.OK);
        }
        else
        {
            throw new NotFoundException("Sorry, award not found");
        }
    }

    //delete award
    public void deleteAward(int id)throws  NotFoundException
    {
        Optional<Awards> res = awardsRepo.getAwardsById(id);
        if (res.isPresent())
        {
            Awards award = res.get();
            awardsRepo.delete(award);
            new ResponseEntity<>(HttpStatus.OK);
        }
        else
        {
            throw new NotFoundException("award not found");
        }
    }





}
