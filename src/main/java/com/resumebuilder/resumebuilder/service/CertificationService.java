package com.resumebuilder.resumebuilder.service;

import com.resumebuilder.resumebuilder.model.Certification;
import com.resumebuilder.resumebuilder.repository.CertificationRepo;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class CertificationService
{
    @Autowired
    private CertificationRepo certificationRepo;

    //create
    public ResponseEntity<?> createCertification(String title, String weblink, Date issuedDate, String description)
    {
        Certification certification = new Certification();
        certification.setTitle(title);
        certification.setWeblink(weblink);
        certification.setIssuedDate(issuedDate);
        certification.setDescription(description);

        Certification persist = certificationRepo.save(certification);
        return new ResponseEntity<>(persist, HttpStatus.OK);
    }

    //update
    public ResponseEntity<?> updateCertification(int id, String title, String weblink, Date issuedDate, String description) throws NotFoundException {
        Optional<Certification> existed = certificationRepo.findById(id);
        if(existed.isPresent())
        {
            Certification certification = existed.get();
            certification.setTitle(title);
            certification.setWeblink(weblink);
            certification.setIssuedDate(issuedDate);
            certification.setDescription(description);

            Certification updated = certificationRepo.save(certification);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        }
        else
        {
            throw  new NotFoundException("Not Found");
        }
    }

    //get certification
    public ResponseEntity<?> getCertificationById(int id)throws NotFoundException
    {
        Optional<Certification> res = certificationRepo.getCertificationById(id);
        if(res.isPresent())
        {
            Certification certification = res.get();
            return new ResponseEntity<>(certification, HttpStatus.OK);
        }
        else
        {
            throw new NotFoundException("Not Found");
        }
    }

    //delete
    public void deleteCertification(int id)throws NotFoundException
    {
        Optional<Certification> res = certificationRepo.getCertificationById(id);
        if(res.isPresent())
        {
            Certification certification = res.get();
            certificationRepo.delete(certification);
            new ResponseEntity<>(HttpStatus.OK);
        }
        else
        {
            throw new NotFoundException("Not found");
        }
    }
}
