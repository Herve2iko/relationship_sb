package com.herve2iko.relation.ApiResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerResp<T> {
    private int count;
    private T data;
}
