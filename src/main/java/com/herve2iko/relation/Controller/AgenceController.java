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

import com.herve2iko.relation.ApiResponses.AgenceResp;
import com.herve2iko.relation.Entity.Agence;
import com.herve2iko.relation.Services.AgentService;

@RestController
@RequestMapping("/agence")
public class AgenceController {
    @Autowired
    private AgentService agenceService;

    @GetMapping()
    public AgenceResp<List <Agence>> allAgence(){
        List<Agence> depart = agenceService.allAgence();
        return new AgenceResp<List <Agence>>(depart.size(),depart);
    }
    @GetMapping("/pagination/{offset}/{pageSize}")
    public AgenceResp<Page<Agence>> paginationAgence(
        @PathVariable int offset,
        @PathVariable int pageSize){
        Page<Agence> depart = agenceService.allAgencepagina(offset,pageSize);
        return new AgenceResp<Page<Agence>>(depart.getSize(),depart);
    }
    
    @GetMapping("/{id}")
    public Agence oneAgence(@PathVariable int id){
        return agenceService.getOneAgence(id);
    }
    @DeleteMapping("/{id}")
    public void deleteAgence(@PathVariable int id){
        agenceService.deleteAgence(id);
    }
    @PostMapping
    public Agence saveAgence(@RequestBody Agence request){
        return agenceService.saveAgence(request);
    }
    @PutMapping("/{id}")
    public Agence updateAgence(@PathVariable int id, @RequestBody Agence request){
        return agenceService.updateAgence(id, request);
    }
}
