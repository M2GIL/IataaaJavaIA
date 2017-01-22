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
import fr.univrouen.api.service.AI.util.Board;
import fr.univrouen.api.service.AI.util.DisplayBoard;
import fr.univrouen.api.service.AI.util.Piece;
import fr.univrouen.api.service.AI.util.PlayerNb;
import fr.univrouen.api.service.AI.util.Rules;
import java.util.List;

/**
 *
 * @author anto
 */
public class AIImpl implements AI {

    @Override
    public void startGame(Difficulty difficulty, EnumPlayer player) {
        
    }

    @Override
    public Case[] play(Difficulty difficulty, EnumPlayer player, Case[] boardCase) {
        Case[] cases = boardCase;
        Piece[] pieces = new Piece[cases.length];
        for (int i = 0; i < cases.length; ++i) {
            Case c = cases[i];
            switch (c) {
                case EMPTY :
                    pieces[i] = Piece.EMPTY;
                    break;
                case BLACK_PIECE :
                    pieces[i] = Piece.BLACK_PIECE;
                    break;
                case BLACK_QUEEN :
                    pieces[i] = Piece.BLACK_QUEEN;
                    break;
                case WHITE_PIECE :
                    pieces[i] = Piece.WHITE_PIECE;
                    break;
                case WHITE_QUEEN :
                    pieces[i] = Piece.WHITE_QUEEN;
                    break;
            }
        }
        
        
        Board<Piece> board = new Board<>(pieces);
        
        System.out.println("Board recu :");
        System.out.println("-----------------------");
        DisplayBoard.displayBoard(board);
        System.out.println("-----------------------");
        
        PlayerNb pl = (player == EnumPlayer.J1) ? PlayerNb.PLAYER_1 : PlayerNb.PLAYER_2;
        List<Board<Piece>> boards = Rules.getAvailableMoves(board, pl);
        if (!boards.isEmpty()) {
            int l = (int) (Math.random() * boards.size());
            pieces = boards.get(l).toArray();
            
            System.out.println("Board répondu :");
            System.out.println("-----------------------");
            DisplayBoard.displayBoard(boards.get(l));
            System.out.println("-----------------------");
            
            for (int i = 0; i < cases.length; ++i) {
                Piece p = pieces[i];
                switch (p) {
                    case EMPTY :
                        cases[i] = Case.EMPTY;
                        break;
                    case BLACK_PIECE :
                        cases[i] = Case.BLACK_PIECE;
                        break;
                    case BLACK_QUEEN :
                        cases[i] = Case.BLACK_QUEEN;
                        break;
                    case WHITE_PIECE :
                        cases[i] = Case.WHITE_PIECE;
                        break;
                    case WHITE_QUEEN :
                        cases[i] = Case.WHITE_QUEEN;
                        break;
                }
            }
        } else {
            cases = null;
        }
        return cases;
    }

    @Override
    public void endGame(EnumPlayer winner, CodeEndGame code) {
        System.out.println("Le gagnant est : " + winner);
        System.out.println("code de victoire : " + code);
    }
    
    
}
