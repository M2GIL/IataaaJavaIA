/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univrouen.api.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.univrouen.api.model.Difficulty;
import fr.univrouen.api.model.EnumPlayer;

/**
 *
 * @author anto
 */
public class StartGameRequest {
    
    @JsonProperty
    private String token;
    @JsonProperty
    private Difficulty difficulty;
    @JsonProperty
    private EnumPlayer player;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public EnumPlayer getPlayer() {
        return player;
    }

    public void setPlayer(EnumPlayer player) {
        this.player = player;
    }

    @Override
    public String toString() {
        return "StartGameRequestBean{" + "token=" + token + ", difficulty=" + difficulty + ", player=" + player + '}';
    }

    
    
    
}
