package com.herve2iko.relation.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.herve2iko.relation.Entity.Client;
import com.herve2iko.relation.Repository.ClientRepository;
import com.herve2iko.relation.RequestClass.detailData;

@RestController
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;


    @PostMapping("/client")
    public Client addClient(@RequestBody Client client){
        return clientRepository.save(client);
    }
    @GetMapping("/all")
    public List<Client>allClient(){
        return clientRepository.findAll();
    }
    @GetMapping("/all-info")
    public List<detailData>allInfo(){
        return clientRepository.getJoinedInfo();
    }
}
