package com.herve2iko.relation.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herve2iko.relation.ApiResponses.DepartementResp;
import com.herve2iko.relation.Entity.Departement;
import com.herve2iko.relation.RequestClass.DepartRequest;
import com.herve2iko.relation.Services.DepartementService;

@RestController
@RequestMapping("/departement")
public class DepartementController {
    @Autowired
    private DepartementService departementService;

    @GetMapping()
    public DepartementResp<List <Departement>> allDepartement(){
        List<Departement> depart = departementService.allDepartement();
        return new DepartementResp<List <Departement>>(depart.size(),depart);
    }
    @GetMapping("/pagination/{offset}/{pageSize}")
    public DepartementResp<Page<Departement>> paginationDepartement(
        @PathVariable int offset,
        @PathVariable int pageSize){
        Page<Departement> depart = departementService.allDepartementpagina(offset,pageSize);
        return new DepartementResp<Page<Departement>>(depart.getSize(),depart);
    }
    
    @GetMapping("/{id}")
    public Departement oneDepartement(@PathVariable Long id){
        return departementService.getOneDepartement(id);
    }
    @DeleteMapping("/{id}")
    public void deleteDepartement(@PathVariable Long id){
        departementService.deleteDep(id);
    }
    @PostMapping
    public DepartRequest saveDepartement(@RequestBody DepartRequest request){
        return departementService.saveDepartement(request);
    }
    @PutMapping("/{id}")
    public Departement updateDepartement(@PathVariable Long id, @RequestBody Departement request){
        return departementService.updateDepartement(id, request);
    }

}
 