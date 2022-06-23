package com.herve2iko.relation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.herve2iko.relation.Entity.Employer;

public interface EmployerRepository extends JpaRepository<Employer,Long> {
    
}
