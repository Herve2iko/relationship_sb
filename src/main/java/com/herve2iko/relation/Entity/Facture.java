package com.herve2iko.relation.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Facture {

    @Id
    @GeneratedValue
    private Long fact_id;
    private String invoice_number;
    private String invoice_date;
    private String vat_taxpayer;
    private String ct_taxpayer;
    private String tl_taxpayer;
    private String payment_type;
    private String cli_name;
    private String cli_TIN;
    private String cli_adress;
    private String vat_cli_payer;
    private String invoice_type;
    private String cancelled_invoice_ref;
    private String invoice_signature;
    private String invoice_signature_date;
    @ManyToOne
    @JoinColumn(name="cntr_id")
    private contributeur contributeur;
    @OneToMany(targetEntity = marchandise.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="fat_ref" , referencedColumnName = "fact_id")
    private List<marchandise> marchandises;
}
