package gestionIa;

import exceptions.UnknownGameIDException;
import model.CODEENDGAME;
import model.DIFFICULTE;
import model.JOUEUR;

public interface IGestionGame {
    
    public void newGameStarted(DIFFICULTE difficulty, JOUEUR player);
    
    public char[] gamePlay(String game_ID, DIFFICULTE difficulty,
                    JOUEUR player,
                    char[] board) throws UnknownGameIDException;
    
    public void gameEnded(String game_ID, JOUEUR winner,
                     CODEENDGAME codeEndGame) throws UnknownGameIDException;
}
