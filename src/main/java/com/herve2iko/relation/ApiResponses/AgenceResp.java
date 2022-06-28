package com.herve2iko.relation.ApiResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AgenceResp<T> {
    int count;
    T data;  
}
