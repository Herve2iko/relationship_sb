package com.herve2iko.relation.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Client {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String email;
    private String genre;

    @OneToMany(targetEntity = Produit.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="cp_pk" , referencedColumnName = "id")
    List <Produit> produits;
}
