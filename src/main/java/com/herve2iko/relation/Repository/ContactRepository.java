package com.herve2iko.relation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.herve2iko.relation.Entity.UserContact;

public interface ContactRepository extends JpaRepository<UserContact,Integer> {
    
}
