package service;

import exceptions.UnknownGameIDException;
import model.CodeEndGame;
import model.Difficulty;
import model.Player;

public interface ICheckersAIService {
    
    public void newGameStarted(Difficulty difficulty, Player player);
    
    public char[] gamePlay(String game_ID, Difficulty difficulty,
                    Player player,
                    char[] board) throws UnknownGameIDException;
    
    public void gameEnded(String game_ID, Player winner,
                     CodeEndGame codeEndGame) throws UnknownGameIDException;
}
