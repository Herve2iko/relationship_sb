package com.herve2iko.relation.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.herve2iko.relation.Entity.Agence;

@Repository
public interface AgenceREpository extends JpaRepository<Agence,Integer>{
    Optional <Agence> findById(Integer id);
    
}
