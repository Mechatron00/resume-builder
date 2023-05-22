package com.resumebuilder.resumebuilder.service;

import com.resumebuilder.resumebuilder.model.*;
import com.resumebuilder.resumebuilder.repository.*;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ResumeService
{
    @Autowired
    private ResumeRepo resumeRepo;


    @Autowired
    private AwardsRepo awardsRepo;
    @Autowired
    private CertificationRepo certificationRepo;
    @Autowired
    private EducationRepo educationRepo;
    @Autowired
    private ExtraCurricularRepo extraCurricularRepo;
    @Autowired
    private HobbiesRepo hobbiesRepo;
    @Autowired
    private InternshipRepo internshipRepo;
    @Autowired
    private LanguageRepo languageRepo;
    @Autowired
    private ObjectiveRepo objectiveRepo;
    @Autowired
    private PersonalSkillsRepo personalSkillsRepo;
    @Autowired
    private ProjectsRepo projectsRepo;
    @Autowired
    private SkillsRepo skillsRepo;




    //create
    /*
    private String fname;
    private String lname;
    private String email;
    private String gender;
    private String contact;
    private String city;
    private String state;
    private Date dob;
    private String linkedin_link;
    private String githublink;
    private String website;

    */

    public ResponseEntity<?> createResume(String fname, String lname, String email, String gender, String contact,
                                          String city, String state, Date dob, String linkedinLink, String githubLink, String website)
    {
        Resume resume = new Resume();
        resume.setFname(fname);
        resume.setLname(lname);
        resume.setEmail(email);
        resume.setGender(gender);
        resume.setContact(contact);
        resume.setCity(city);
        resume.setState(state);
        resume.setDob(dob);
        resume.setLinkedin_link(linkedinLink);
        resume.setGithublink(githubLink);
        resume.setWebsite(website);

        List<Awards> awardsList = getAwards();
        resume.setAwardsList(awardsList);

        //System.out.println(resume.getAwardsList());
        List<Certification> certificationList = getCertifications();
        resume.setCertificationList(certificationList);

        List<Education> educationList = getEducations();
        resume.setEducationList(educationList);

        List<ExtraCurricular> extraCurricularList = getExtracurriculars();
        resume.setExtraCurricularList(extraCurricularList);

        List<Hobbies> hobbiesList = getHobbies();
        resume.setHobbiesList(hobbiesList);

        List<Internship> internshipList = getInternships();
        resume.setInternshipList(internshipList);

        List<Language> languageList = getLanguages();
        resume.setLanguageList(languageList);

        List<Objective> objectiveList = getObjectives();
        resume.setObjectiveList(objectiveList);

        List<PersonalSkills> personalSkillsList = getPersonalskills();
        resume.setPersonalSkillsList(personalSkillsList);

        List<Projects>  projectsList= getProjects();
        resume.setProjectsList(projectsList);

        List<Skills> skillsList = getSkills();
        resume.setSkillsList(skillsList);


        Resume created = resumeRepo.save(resume);
        return new ResponseEntity<>(created, HttpStatus.OK);

    }



    //get resume
    public ResponseEntity<?> getResumeById(int id) throws NotFoundException
    {
        Optional<Resume> res=resumeRepo.getResumeById(id);
        if(res.isPresent())
        {
            Resume resume=res.get();
            return new ResponseEntity<>(resume, HttpStatus.OK);
        }
        else
        {
            throw new NotFoundException("Sorry, resume not found");
        }
    }


    //delete
    public void deleteResume(int id)throws  NotFoundException
    {
        Optional<Resume> res = resumeRepo.getResumeById(id);
        if (res.isPresent())
        {
            Resume resume = res.get();
            resumeRepo.delete(resume);
            new ResponseEntity<>(HttpStatus.OK);
        }
        else
        {
            throw new NotFoundException("Resume not found");
        }
    }




//methods for getting lists of attributes
    private List<Awards> getAwards()
    {
        List<Awards> awardsList = new ArrayList<>();
        awardsList = awardsRepo.findAll();
        return awardsList;
    }
    private List<Certification> getCertifications()
    {
        List<Certification> certificationList = new ArrayList<>();
        certificationList = certificationRepo.findAll();
        return certificationList;
    }
    private List<Education> getEducations()
    {
        List<Education> educationList = new ArrayList<>();
        educationList = educationRepo.findAll();
        return educationList;
    }
    private List<ExtraCurricular> getExtracurriculars()
    {
        List<ExtraCurricular> extraCurricularList = new ArrayList<>();
        extraCurricularList = extraCurricularRepo.findAll();
        return extraCurricularList;
    }
    private List<Hobbies> getHobbies()
    {
        List<Hobbies> hobbiesList = new ArrayList<>();
        hobbiesList = hobbiesRepo.findAll();
        return hobbiesList;
    }
    private List<Internship> getInternships()
    {
        List<Internship> internshipList = new ArrayList<>();
        internshipList = internshipRepo.findAll();
        return internshipList;
    }
    private List<Language> getLanguages()
    {
        List<Language> languageList = new ArrayList<>();
        languageList = languageRepo.findAll();
        return languageList;
    }
    private List<Objective> getObjectives()
    {
        List<Objective> objectiveList = new ArrayList<>();
        objectiveList = objectiveRepo.findAll();
        return objectiveList;
    }
    private List<PersonalSkills> getPersonalskills()
    {
        List<PersonalSkills> personalSkillsList = new ArrayList<>();
        personalSkillsList = personalSkillsRepo.findAll();
        return personalSkillsList;
    }
    private List<Projects> getProjects()
    {
        List<Projects> projectsList = new ArrayList<>();
        projectsList = projectsRepo.findAll();
        return projectsList;
    }
    private List<Skills> getSkills()
    {
        List<Skills> skillsList = new ArrayList<>();
        skillsList = skillsRepo.findAll();
        return skillsList;
    }

}
