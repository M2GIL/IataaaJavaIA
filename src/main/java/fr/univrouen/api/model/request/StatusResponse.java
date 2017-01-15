/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univrouen.api.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.univrouen.api.model.StatusService;

/**
 *
 * @author najwa
 */
public class StatusResponse {
    
    @JsonProperty
    private String token;
    @JsonProperty
    private StatusService status; 

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public StatusService getStatus() {
        return status;
    }

    public void setStatus(StatusService status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "StatusResponseBean{" + "token=" + token + ", status=" + status + '}';
    }
    
}
