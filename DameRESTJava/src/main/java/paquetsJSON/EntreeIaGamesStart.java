package paquetsJSON;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import model.Difficulty;
import model.Player;

public class EntreeIaGamesStart {

    private String token;
    private Difficulty difficulty;
    private Player player;
    
    @JsonCreator
    public EntreeIaGamesStart(@JsonProperty("token")String t, @JsonProperty("difficulty")Difficulty d, @JsonProperty("player")Player p) {
        token = t;
        difficulty = d;
        player = p;
    }
    
    public String getToken() {
        return token;
    }
    public Difficulty getDifficulty() {
        return difficulty;
    }
    public Player getPlayer() {
        return player;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
