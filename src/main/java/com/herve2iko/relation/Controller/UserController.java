package com.herve2iko.relation.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herve2iko.relation.Entity.User;
import com.herve2iko.relation.Repository.UserRepository;

@RequestMapping("/users")
@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;


    @GetMapping("/all")
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @GetMapping("/{name}")
    public List<User> getUser(@PathVariable("name") final String name) {
        return userRepository.findByName(name);

    }

    @GetMapping("/{id}")
    public User getId(@PathVariable("id") final Integer id) {
        return userRepository.findById(id).get();
    }

    @GetMapping("/update/{id}/{name}")
    public User update(@PathVariable("id") final Integer id, @PathVariable("name")
                         final String name) {
        User user = getId(id);
        user.setName(name);
        return userRepository.save(user);
    }
}
