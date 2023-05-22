package com.resumebuilder.resumebuilder.controller;

import com.resumebuilder.resumebuilder.service.EducationService;
import com.resumebuilder.resumebuilder.service.ExtraCurricularService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class ExtracurricularController
{
    @Autowired
    private ExtraCurricularService extraCurricularService;


    @GetMapping("/getextrac/{id}")
    public ResponseEntity<?> getExtracurricular(@PathVariable("id") int id) throws NotFoundException
    {
        return extraCurricularService.getExtraCurricularById(id);
    }

    /*
     private String description;
        */

    @PostMapping("/addextrac")
    public ResponseEntity<?> addExtracurricular(@RequestParam("description") String description)
    {
            return extraCurricularService.createExtraCurricular(description);
    }

    @PutMapping("/addextrac/{id}")
    public ResponseEntity<?> updateExtracurricular(@PathVariable("id") int id,
                                                   @RequestParam("description") String description
    ) throws NotFoundException
    {
            return extraCurricularService.updateExtracurricular(id, description);
    }

    @DeleteMapping("/deleteextrac/{id}")
    public ResponseEntity<?> deleteExtracurricular(@PathVariable int id) throws NotFoundException
    {
        extraCurricularService.deleteExtraCurricular(id);
        return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
    }
}
