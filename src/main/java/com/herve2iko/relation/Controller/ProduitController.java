package com.herve2iko.relation.Controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herve2iko.relation.Entity.Client;
import com.herve2iko.relation.Entity.Produit;
import com.herve2iko.relation.Repository.ClientRepository;

@RequestMapping("/produits")
@RestController
public class ProduitController {
    ClientRepository clientRepository;

    @PostMapping("/{cli}")
    public Produit addprod(@PathVariable int cli, @RequestBody Produit pro){
        Optional<Client>client = clientRepository.findById(cli);
        if(!client.isPresent()){
            throw new IllegalStateException("client not exist");
        }
        Client _Client = client.get();
        _Client.getProduits().add(pro);
        clientRepository.save(_Client);
        return _Client.getProduits().get(_Client.getProduits().size()-1);
        
    }
}
