package com.herve2iko.relation.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.herve2iko.relation.Entity.Departement;

public interface DepartementRepository extends JpaRepository<Departement,Long> {
    Optional<Departement>findById(Long id);
}
