package com.herve2iko.relation.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
@Entity
@Data
public class contributeur {

        @Id
        @GeneratedValue
        private Long id; 
        private String ctr_type;
        private String ctr_name;
        private String ctr_TIN;
        private String ctr_trade_number;
        private String ctr_postal_number;
        private String ctr_phone_number;
        private String ctr_address_commune;
        private String ctr_address_quartier;
        private String ctr_address_avenue;
        private String ctr_address_number;
        private String ctr_fiscal_center;
        private String ctr_activity_sector;
        private String ctr_legal_form;
}
