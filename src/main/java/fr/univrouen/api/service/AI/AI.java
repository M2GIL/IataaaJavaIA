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
    Case[] play(String gameId, Difficulty difficulty, EnumPlayer player, Case[] board);
    void endGame(EnumPlayer winner, CodeEndGame code);
    void startGame(String gameId, Difficulty difficulty, EnumPlayer player);
}
