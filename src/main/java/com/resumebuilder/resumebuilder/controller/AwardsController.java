package com.resumebuilder.resumebuilder.controller;

import com.resumebuilder.resumebuilder.service.AwardsService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class AwardsController
{
    @Autowired
    private AwardsService awardsService;


    @GetMapping("/getaward/{id}")
    public ResponseEntity<?> getAwards(@PathVariable("id") int id) throws NotFoundException
    {
        return awardsService.getAwardById(id);
    }

    /*private String title;
    private String issuer;
    private Date issuedDate;
    private String description;
    */

    @PostMapping("/addaward")
    public ResponseEntity<?> addAwards(@RequestParam("title") String title,
                                       @RequestParam("issuer") String issuer,
                                       @RequestParam("issuedDate") String issuedDate,
                                       @RequestParam("description") String description) throws ParseException
    {
        try
        {
            SimpleDateFormat format = new SimpleDateFormat("mm-yyyy");
            Date date = format.parse(issuedDate);
            return awardsService.createAward(title, issuer, date, description);
        }
        catch (ParseException exception)
        {
            return  new ResponseEntity<>("Enter date in MM-YYYY  format", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/addaward/{id}")
    public ResponseEntity<?> updateAwards(@PathVariable("id") int id,
                                          @RequestParam("title") String title,
                                          @RequestParam("issuer") String issuer,
                                          @RequestParam("issuedDate") String issuedDate,
                                          @RequestParam("description") String description
                                          ) throws NotFoundException
    {
        try
        {
            SimpleDateFormat format = new SimpleDateFormat("mm-yyyy");
            Date date = format.parse(issuedDate);
            return awardsService.updateAward(id,title, issuer, date, description );
        }
        catch (ParseException exception)
        {
            return  new ResponseEntity<>("Enter date in MM-YYYY  format", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteaward/{id}")
    public ResponseEntity<?> deleteAward(@PathVariable int id) throws NotFoundException
    {
        awardsService.deleteAward(id);
        return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
    }


}
