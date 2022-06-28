package com.herve2iko.relation.RequestClass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployRequest {
    private Long id;
    private String nom;
    private String genre;
    private Long departement;
    private int agence;

}
