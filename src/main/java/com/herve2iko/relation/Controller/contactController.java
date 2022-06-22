package com.herve2iko.relation.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herve2iko.relation.Entity.UserContact;
import com.herve2iko.relation.Repository.ContactRepository;

@RestController
@RequestMapping("/contacts")
public class contactController {
    @Autowired
    ContactRepository contactRepository;

    @GetMapping
    public List <UserContact> getContact(){
        return contactRepository.findAll();
    }
    
}
