package com.resumebuilder.resumebuilder.controller;

import com.resumebuilder.resumebuilder.service.AwardsService;
import com.resumebuilder.resumebuilder.service.CertificationService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class CertificationController
{
    @Autowired
    private CertificationService certificationService;


    @GetMapping("/getcertification/{id}")
    public ResponseEntity<?> getAwards(@PathVariable("id") int id) throws NotFoundException
    {
        return certificationService.getCertificationById(id);
    }

    /*
    private String title;
    private String weblink;
    private Date issuedDate;
    private String description;    */

    @PostMapping("/addcertification")
    public ResponseEntity<?> addCertification(@RequestParam("title") String title,
                                       @RequestParam("weblink") String weblink,
                                       @RequestParam("issuedDate") String issuedDate,
                                       @RequestParam("description") String description) throws ParseException
    {
        try
        {
            SimpleDateFormat format = new SimpleDateFormat("mm-yyyy");
            Date date = format.parse(issuedDate);
            return certificationService.createCertification(title, weblink, date, description);
        }
        catch (ParseException exception)
        {
            return  new ResponseEntity<>("Enter date in MM-YYYY  format", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/addcertification/{id}")
    public ResponseEntity<?> updateCertification(@PathVariable("id") int id,
                                          @RequestParam("title") String title,
                                          @RequestParam("weblink") String weblink,
                                          @RequestParam("issuedDate") String issuedDate,
                                          @RequestParam("description") String description
    ) throws NotFoundException
    {
        try
        {
            SimpleDateFormat format = new SimpleDateFormat("mm-yyyy");
            Date date = format.parse(issuedDate);
            return certificationService.updateCertification(id,title, weblink, date, description );
        }
        catch (ParseException exception)
        {
            return  new ResponseEntity<>("Enter date in MM-YYYY  format", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deletecertification/{id}")
    public ResponseEntity<?> deleteCertification(@PathVariable int id) throws NotFoundException
    {
        certificationService.deleteCertification(id);
        return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
    }
}
