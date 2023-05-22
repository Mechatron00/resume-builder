package com.resumebuilder.resumebuilder.repository;

import com.resumebuilder.resumebuilder.model.Awards;
import com.resumebuilder.resumebuilder.model.ExtraCurricular;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExtraCurricularRepo extends JpaRepository<ExtraCurricular, Integer>
{
    Optional<ExtraCurricular> getExtraCurricularById(int id);
}
