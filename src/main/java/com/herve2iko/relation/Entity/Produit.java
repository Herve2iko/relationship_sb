package com.herve2iko.relation.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Produit {

    @Id
    private int pid;
    private String prod_name;
    private int quantite;
    private int prix;

}
