package com.herve2iko.relation.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herve2iko.relation.Entity.Employer;
import com.herve2iko.relation.RequestClass.EmployRequest;
import com.herve2iko.relation.Services.EmployerService;

@RestController
@RequestMapping("/employes")
public class EmployerController {
    @Autowired
    private EmployerService employerService;

    @GetMapping()
    public List<Employer>allEmployer(){
        return employerService.allEmployer();
    }
    @GetMapping("/{id}")
    public Employer oneEmployer(@PathVariable Long id){
        return employerService.getOneEmployer(id);
    }
    @GetMapping("/departement/{nom}")
    public List <Employer> DepartementEmployer(@PathVariable String nom){
        return employerService.getEmployerDepartement(nom);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployer(@PathVariable Long id){
        employerService.deleteEmployer(id);
    }

    @PostMapping
    public EmployRequest saveEmploye(@RequestBody EmployRequest request){
        return employerService.saveEmployer(request);
    }
}
