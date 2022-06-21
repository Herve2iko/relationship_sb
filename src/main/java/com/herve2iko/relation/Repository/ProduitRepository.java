package com.herve2iko.relation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.herve2iko.relation.Entity.Produit;

public interface ProduitRepository extends JpaRepository <Produit,Integer> {
    
}
