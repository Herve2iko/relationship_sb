package com.herve2iko.relation.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.herve2iko.relation.Entity.Employer;

public interface EmployerRepository extends JpaRepository<Employer,Long> {
    
    List<Employer>findByDepartementName(String nom);
    
    @Query("from Employer where departement.name = :nom")
    List<Employer>getByDepartementName(String nom);
}
