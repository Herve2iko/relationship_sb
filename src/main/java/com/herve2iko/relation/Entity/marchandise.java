package com.herve2iko.relation.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class marchandise {

    @Id
    @GeneratedValue
    private Long item_id;
    private String item_designation;
    private String item_quantity;
    private String item_price;
    private String item_ct;
    private String item_tl;
    private String item_price_nvat;
    private String vat;
    private String item_price_wvat;
    private String item_total_mount;
}
