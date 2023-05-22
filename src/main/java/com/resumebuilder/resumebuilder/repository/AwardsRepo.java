package com.resumebuilder.resumebuilder.repository;

import com.resumebuilder.resumebuilder.model.Awards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AwardsRepo extends JpaRepository<Awards, Integer>
{
    Optional<Awards> getAwardsById(int id);
    List<Awards> findAll();
}
