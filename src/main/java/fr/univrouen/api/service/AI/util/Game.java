/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univrouen.api.service.AI.util;


/**
 *
 * @author anto
 */
public interface Game  {

    /**
     * The size of the board.
     */
    int PIECE_SIZE = 50;
    int CASE_NB_OF_LINE = 5;
    int LINE_NB = 10;
    String EVENT_BOARD_CHANGED = "BoardChanged"; // Attends un Piece[] en argument

}
