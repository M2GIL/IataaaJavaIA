package paquetsJSON;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import model.Status;

public class RetourIaStatus {

    private String token;
    private Status status;
    
    @JsonCreator
    public RetourIaStatus(@JsonProperty("token")String t, @JsonProperty("status")Status s) {
        token = t;
        status = s;
    }

    public String getToken() {
        return token;
    }

    public Status getStatus() {
        return status;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
