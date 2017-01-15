/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univrouen.api.model.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import fr.univrouen.api.model.StatusService;

/**
 *
 * @author najwa
 */
public class StartGameResponse {

    @JsonProperty
    private String token;
    @JsonProperty
    private StatusService status;
    @JsonProperty
    private String game_id;

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

    public String getGame_id() {
        return game_id;
    }

    public void setGame_id(String game_id) {
        this.game_id = game_id;
    }

    @Override
    @JsonIgnore
    public String toString() {
        return "StartGameResponseBean{" + "token=" + token + ", status=" + status + ", game_id=" + game_id + '}';
    }
}
