package com.herve2iko.relation.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.herve2iko.relation.Entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {
    List<User> findByName(String name);
    
}
