package com.herve2iko.relation.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.herve2iko.relation.Entity.Agence;
import com.herve2iko.relation.Repository.AgenceREpository;

@Service
public class AgentService {
    @Autowired
    private AgenceREpository agenceRepository;

    public List<Agence>allAgence(){
        return agenceRepository.findAll();
    }

    public Page<Agence>allAgencepagina(int offset,int pageSize){
        Page<Agence> agPaginates = agenceRepository.findAll(PageRequest.of(offset,pageSize));
        return agPaginates;
    }
    
    public Agence getOneAgence(int id) {
        Optional <Agence> dep = agenceRepository.findById(id);
        if(!dep.isPresent()){
            throw new IllegalStateException("agence introuvable"); 
        }
        return dep.get();
    }

    public Agence saveAgence(Agence request){
        return agenceRepository.save(request);        
    }
    public Agence updateAgence(Integer id,Agence agence){
        Optional <Agence> ag = agenceRepository.findById(id);
        if(!ag.isPresent()){
            throw new IllegalStateException("agence introuvable"); 
        }
        Agence _ag = ag.get();
        _ag.setNom(agence.getNom());

        return agenceRepository.save(_ag);
    }

    public Optional<Agence> getAgenceById(int id){
        Optional <Agence> ag = agenceRepository.findById(id);
        if(!ag.isPresent()){
            throw new IllegalStateException("agence introuvable"); 
        }
        return ag;
    }
    public void deleteAgence(int id){
        Optional <Agence> dep = agenceRepository.findById(id);
        if(!dep.isPresent()){
            throw new IllegalStateException("agence introuvable"); 
        }
        agenceRepository.delete(dep.get());
    }

}
