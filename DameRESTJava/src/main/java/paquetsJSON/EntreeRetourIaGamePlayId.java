package paquetsJSON;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import model.Difficulty;
import model.Player;

public class EntreeRetourIaGamePlayId {
    private String token;
    private Difficulty difficulty;
    private Player player;
    private char[] board;
    
    @JsonCreator
    public EntreeRetourIaGamePlayId (@JsonProperty("token")String t, @JsonProperty("difficulty")Difficulty d, @JsonProperty("player")Player p, @JsonProperty("board")char[] b) {
        token = t;
        difficulty = d;
        player = p;
        board = b;
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

    public char[] getBoard() {
        return board;
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

    public void setBoard(char[] board) {
        this.board = board;
    }
}
