package com.herve2iko.relation.RequestClass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartRequest {
    private Long id;
    private String name;
    private Boolean status;
    
    public DepartRequest(String name, Boolean status) {
        this.name = name;
        this.status = status;
    }
    
}
