package com.resumebuilder.resumebuilder.repository;

import com.resumebuilder.resumebuilder.model.Awards;
import com.resumebuilder.resumebuilder.model.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ResumeRepo extends JpaRepository<Resume, Integer>
{

    Optional<Resume> getResumeById(int id);
    Optional<Resume> getResumeByIdAndEmail(int id,String email);
}

