/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univrouen.api.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author anto
 */
public class StatusRequest {
    @JsonProperty
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    
    
}
