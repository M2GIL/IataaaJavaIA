package paquetsJSON;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import model.Status;

public class RetourIaGamesStart {

    private String token;
    private Status status;
    private String game_id;
    
    @JsonCreator
    public RetourIaGamesStart(@JsonProperty("token")String t, @JsonProperty("status")Status s, @JsonProperty("game_id")String tp) {
        token = t;
        status = s;
        game_id = tp;
    }

    public String getToken() {
        return token;
    }

    public Status getStatus() {
        return status;
    }

    public String getTokenPartie() {
        return game_id;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setTokenPartie(String tokenPartie) {
        this.game_id = tokenPartie;
    }
}
