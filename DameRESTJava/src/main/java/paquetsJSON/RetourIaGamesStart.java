package paquetsJSON;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import model.Status;

public class RetourIaGamesStart {

    private String token;
    private Status status;
    private String tokenPartie;
    
    @JsonCreator
    public RetourIaGamesStart(@JsonProperty("token")String t, @JsonProperty("status")Status s, @JsonProperty("tokenPartie")String tp) {
        token = t;
        status = s;
        tokenPartie = tp;
    }

    public String getToken() {
        return token;
    }

    public Status getStatus() {
        return status;
    }

    public String getTokenPartie() {
        return tokenPartie;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setTokenPartie(String tokenPartie) {
        this.tokenPartie = tokenPartie;
    }
}
