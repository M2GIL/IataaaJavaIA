package paquetsJSON;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import model.CodeEndGame;
import model.Player;

public class EntreeIaGamesEndId {

    private String token;
    private Player winner;
    private CodeEndGame code;
    
    @JsonCreator
    public EntreeIaGamesEndId(@JsonProperty("token")String t, @JsonProperty("winner")Player w, @JsonProperty("code")CodeEndGame c) {
        token = t;
        winner = w;
        code = c;
    }

    public String getToken() {
        return token;
    }

    public Player getWinner() {
        return winner;
    }

    public CodeEndGame getCode() {
        return code;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public void setCode(CodeEndGame code) {
        this.code = code;
    }

}
