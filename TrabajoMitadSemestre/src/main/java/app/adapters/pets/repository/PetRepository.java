package app.adapters.pets.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.adapters.pets.entity.PetEntity;

public interface PetRepository extends JpaRepository<PetEntity, Long> {
    List<PetEntity> findByPersonId(long personId);
    boolean existsByPersonIdAndName(long personId, String name);
}

