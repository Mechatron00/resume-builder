package com.resumebuilder.resumebuilder.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Resume
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

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


    @OneToMany
    private List<Objective> objectiveList;
    @OneToMany
    private List<Education> educationList;
    @OneToMany
    private List<Internship> internshipList;
    @OneToMany
    private List<Projects> projectsList;
    @OneToMany(targetEntity = Awards.class, cascade = CascadeType.ALL)
    private List<Awards> awardsList;
    @OneToMany
    private List<Certification> certificationList;
    @OneToMany
    private List<Skills> skillsList;
    @OneToMany
    private List<PersonalSkills> personalSkillsList;
    @OneToMany
    private List<ExtraCurricular> extraCurricularList;
    @OneToMany
    private List<Language> languageList;
    @OneToMany
    private List<Hobbies> hobbiesList;


    public int getId() {        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getLinkedin_link() {
        return linkedin_link;
    }

    public void setLinkedin_link(String linkedin_link) {
        this.linkedin_link = linkedin_link;
    }

    public String getGithublink() {
        return githublink;
    }

    public void setGithublink(String githublink) {
        this.githublink = githublink;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public List<Objective> getObjectiveList() {
        return objectiveList;
    }

    public void setObjectiveList(List<Objective> objectiveList) {
        this.objectiveList = objectiveList;
    }

    public List<Education> getEducationList() {
        return educationList;
    }

    public void setEducationList(List<Education> educationList) {
        this.educationList = educationList;
    }

    public List<Internship> getInternshipList() {
        return internshipList;
    }

    public void setInternshipList(List<Internship> internshipList) {
        this.internshipList = internshipList;
    }

    public List<Projects> getProjectsList() {
        return projectsList;
    }

    public void setProjectsList(List<Projects> projectsList) {
        this.projectsList = projectsList;
    }

    public List<Awards> getAwardsList() {
        return awardsList;
    }

    public void setAwardsList(List<Awards> awardsList) {
        this.awardsList = awardsList;
    }

    public List<Certification> getCertificationList() {
        return certificationList;
    }

    public void setCertificationList(List<Certification> certificationList) {
        this.certificationList = certificationList;
    }

    public List<Skills> getSkillsList() {
        return skillsList;
    }

    public void setSkillsList(List<Skills> skillsList) {
        this.skillsList = skillsList;
    }

    public List<PersonalSkills> getPersonalSkillsList() {
        return personalSkillsList;
    }

    public void setPersonalSkillsList(List<PersonalSkills> personalSkillsList) {
        this.personalSkillsList = personalSkillsList;
    }

    public List<ExtraCurricular> getExtraCurricularList() {
        return extraCurricularList;
    }

    public void setExtraCurricularList(List<ExtraCurricular> extraCurricularList) {
        this.extraCurricularList = extraCurricularList;
    }

    public List<Language> getLanguageList() {
        return languageList;
    }

    public void setLanguageList(List<Language> languageList) {
        this.languageList = languageList;
    }

    public List<Hobbies> getHobbiesList() {
        return hobbiesList;
    }

    public void setHobbiesList(List<Hobbies> hobbiesList) {
        this.hobbiesList = hobbiesList;
    }
}
