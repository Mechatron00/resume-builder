package com.resumebuilder.resumebuilder.repository;

import com.resumebuilder.resumebuilder.model.Awards;
import com.resumebuilder.resumebuilder.model.PersonalSkills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonalSkillsRepo extends JpaRepository<PersonalSkills, Integer>
{
    Optional<PersonalSkills> getPersonalSkillsById(int id);
}
