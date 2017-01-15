/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univrouen.api.service.AI;

import fr.univrouen.api.model.Case;
import fr.univrouen.api.model.CodeEndGame;
import fr.univrouen.api.model.Difficulty;
import fr.univrouen.api.model.EnumPlayer;


/**
 *
 * @author anto
 */
public interface AI {
    /**
     * End of the game.
     * @param winner
     * @param code 
     */
    void endGame(EnumPlayer winner, CodeEndGame code);
    /**
     * Return a movement of game. 
     * @param difficulty
     * @param player
     * @param board
     * @return movement of game.
     */
    Case[] play(Difficulty difficulty, EnumPlayer player, Case[] board);
    /**
     * Start the game with difficulty. The ai player number is player.
     * @param difficulty
     * @param player 
     */
    void startGame(Difficulty difficulty, EnumPlayer player);
}
