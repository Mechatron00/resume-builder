package com.resumebuilder.resumebuilder.service;

import com.resumebuilder.resumebuilder.model.Education;
import com.resumebuilder.resumebuilder.model.ExtraCurricular;
import com.resumebuilder.resumebuilder.repository.EducationRepo;
import com.resumebuilder.resumebuilder.repository.ExtraCurricularRepo;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class ExtraCurricularService
{
    @Autowired
    private ExtraCurricularRepo extraCurricularRepo;

    //create
    public ResponseEntity<?> createExtraCurricular(String description)
    {
        ExtraCurricular extraCurricular = new ExtraCurricular();
        extraCurricular.setDescription(description);
        ExtraCurricular persist = extraCurricularRepo.save(extraCurricular);
        return new ResponseEntity<>(persist, HttpStatus.OK);
    }

    //update
    public ResponseEntity<?> updateExtracurricular(int id, String description ) throws NotFoundException {
        Optional<ExtraCurricular> existed = extraCurricularRepo.getExtraCurricularById(id);
        if(existed.isPresent())
        {
            ExtraCurricular extraCurricular = existed.get();

            extraCurricular.setDescription(description);

            ExtraCurricular updated = extraCurricularRepo.save(extraCurricular);
            return new ResponseEntity<>(updated, HttpStatus.OK);

        }
        else
        {
            throw new NotFoundException("Not Found");
        }
    }

    //get
    public ResponseEntity<?> getExtraCurricularById(int id) throws NotFoundException
    {
        Optional<ExtraCurricular> res = extraCurricularRepo.getExtraCurricularById(id);
        if (res.isPresent())
        {
            ExtraCurricular extraCurricular = res.get();
            return new ResponseEntity<>(extraCurricular, HttpStatus.OK);
        }
        else
        {
            throw new NotFoundException("Not Found");
        }
    }
    //delete
    public void deleteExtraCurricular(int id) throws NotFoundException
    {
        Optional<ExtraCurricular> res = extraCurricularRepo.getExtraCurricularById(id);
        if(res.isPresent())
        {
            ExtraCurricular extraCurricular = res.get();
            extraCurricularRepo.delete(extraCurricular);
            new ResponseEntity<>(HttpStatus.OK);
        }
        else
        {
            throw new NotFoundException("Not Found");
        }
    }
}
