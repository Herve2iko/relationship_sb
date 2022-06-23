package com.herve2iko.relation.ApiResponses;


public class DepartementResp<T> {
    private int count;
    private T response;
    
    public DepartementResp() {
    }

    public DepartementResp(int count, T response) {
        this.count = count;
        this.response = response;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }

    
    
}
