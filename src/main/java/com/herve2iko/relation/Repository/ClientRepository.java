package com.herve2iko.relation.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.herve2iko.relation.Entity.Client;
import com.herve2iko.relation.dto.detailData;

public interface ClientRepository extends JpaRepository<Client,Integer> {
    
    @Query("SELECT new com.herve2iko.relation.dto.detailData(c.name,p.prod_name) from Client c JOIN c.produits p")
    public List<detailData> getJoinedInfo();
}
