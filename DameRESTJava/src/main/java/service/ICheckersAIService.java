package service;

import exceptions.UnknownGameIDException;
import model.CodeEndGame;
import model.Difficulty;
import model.Player;

public interface ICheckersAIService {
    
    /**
     * Initialize game with difficulty and player number.
     * @param difficulty
     * @param player 
     */
    public void newGameStarted(Difficulty difficulty, Player player);
    
    /**
     * Ask move to artificial intelligence.
     * @param game_ID
     * @param difficulty
     * @param player
     * @param board
     * @return
     * @throws UnknownGameIDException 
     */
    public char[] gamePlay(String game_ID, Difficulty difficulty,
                    Player player,
                    char[] board) throws UnknownGameIDException;
    
    /**
     * Stop game.
     * @param game_ID
     * @param winner
     * @param codeEndGame
     * @throws UnknownGameIDException 
     */
    public void gameEnded(String game_ID, Player winner,
                     CodeEndGame codeEndGame) throws UnknownGameIDException;
}
