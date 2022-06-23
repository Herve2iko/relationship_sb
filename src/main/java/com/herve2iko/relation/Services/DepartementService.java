package com.herve2iko.relation.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.herve2iko.relation.Entity.Departement;
import com.herve2iko.relation.Repository.DepartementRepository;
import com.herve2iko.relation.RequestClass.DepartRequest;

@Service
public class DepartementService {

    @Autowired
    private DepartementRepository departementRepository;

    public List<Departement>allDepartement(){
        return departementRepository.findAll();
    }

    public Page<Departement>allDepartementpagina(int offset,int pageSize){
        Page<Departement> depPaginates = departementRepository.findAll(PageRequest.of(offset,pageSize));
        return depPaginates;
    }
    
    public Departement getOneDepartement(Long id) {
        Optional <Departement> dep = departementRepository.findById(id);
        if(!dep.isPresent()){
            throw new IllegalStateException("departement introuvable"); 
        }
        return dep.get();
    }

    public DepartRequest saveDepartement(DepartRequest request){
        Departement departement = new Departement();

        BeanUtils.copyProperties(request, departement);
        Departement departement2 = departementRepository.save(departement); 
        System.out.println("created departement");
        System.out.println(departement2);
        System.out.println("created departement");
        
        return request;
    }
    public Departement updateDepartement(Long id,Departement departement){
        Optional <Departement> dep = departementRepository.findById(id);
        if(!dep.isPresent()){
            throw new IllegalStateException("departement introuvable"); 
        }
        Departement _dep = dep.get();
        _dep.setName(departement.getName());
        _dep.setStatus(departement.getStatus());

        return departementRepository.save(_dep);
    }

    public Optional<Departement> getDepartementById(Long id){
        Optional <Departement> dep = departementRepository.findById(id);
        if(!dep.isPresent()){
            throw new IllegalStateException("departement introuvable"); 
        }
        return dep;
    }
    public void deleteDep(Long id){
        Optional <Departement> dep = departementRepository.findById(id);
        if(!dep.isPresent()){
            throw new IllegalStateException("departement introuvable"); 
        }
        departementRepository.delete(dep.get());
    }

}
