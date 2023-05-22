package com.resumebuilder.resumebuilder.service;

import com.resumebuilder.resumebuilder.model.Education;
import com.resumebuilder.resumebuilder.model.Language;
import com.resumebuilder.resumebuilder.repository.EducationRepo;
import com.resumebuilder.resumebuilder.repository.LanguageRepo;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class LanguageService
{
    @Autowired
    private LanguageRepo languageRepo;

    //create
    public ResponseEntity<?> createLanguage(String lang, String profiency)
    {
        Language language = new Language();
        language.setLanguage(lang);
        language.setProfiency(profiency);


        Language persist = languageRepo.save(language);
        return new ResponseEntity<>(persist, HttpStatus.OK);
    }

    //update
    public ResponseEntity<?> updateLanguage(int id, String lang, String profiency) throws NotFoundException {
        Optional<Language> existed = languageRepo.getLanguageById(id);
        if(existed.isPresent())
        {
            Language language = existed.get();
            language.setLanguage(lang);
            language.setProfiency(profiency);


            Language updated = languageRepo.save(language);
            return new ResponseEntity<>(updated, HttpStatus.OK);

        }
        else
        {
            throw new NotFoundException("Not Found");
        }
    }

    //get
    public ResponseEntity<?> getLanguageById(int id) throws NotFoundException
    {
        Optional<Language> res = languageRepo.getLanguageById(id);
        if (res.isPresent())
        {
            Language language = res.get();
            return new ResponseEntity<>(language, HttpStatus.OK);
        }
        else
        {
            throw new NotFoundException("Not Found");
        }
    }
    //delete
    public void deleteLanguage(int id) throws NotFoundException
    {
        Optional<Language> res = languageRepo.getLanguageById(id);
        if(res.isPresent())
        {
            Language language = res.get();
            languageRepo.delete(language);
            new ResponseEntity<>(HttpStatus.OK);
        }
        else
        {
            throw new NotFoundException("Not Found");
        }
    }
}
