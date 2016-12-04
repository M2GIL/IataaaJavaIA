package persistance;

import model.JOUEUR;

public class Game {
    
    String token;
    IA player1;
    IA player2;
    
    public Game(String t, IA p1, IA p2) {
        token = t;
        player1 = p1;
        player2 = p2;
    }
    
    public char[] getMove(char[] board, JOUEUR j) {
        return board;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
