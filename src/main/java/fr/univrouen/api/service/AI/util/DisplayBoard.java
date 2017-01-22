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
public class DisplayBoard {
    
    public static void displayBoard(Board<Piece> board) {
        displayBoard(board.toArray());
    }
    
    public static void displayBoard(Piece[] boardToDisplay) {
        Piece[][] board = convertFiftyToHundredBoard(boardToDisplay);

        String line = getLine(board.length);
        String str = line;

        for (int i = 0; i < 10; i++) {
            str += "|";
            for (int j = 0; j < 10; j++) {
                // Decal to be VERY beautiful <3
                str += " " ;
                str += board[i][j].toString() + " |";
            }

            str += "\n" + line;
        }
        System.out.println(str);
    }
    
    /**
     * Convert the Piece[] board in Piece[][] board for display
     *
     * @param boardFifty char[]
     * @return Piece[][] board
     */
    public static Piece[][] convertFiftyToHundredBoard(Piece[] boardFifty) {
        Piece[][] boardFinal = new Piece[10][10];

        for (int i = 0; i < boardFinal.length; i++) {
            for (int j = 0; j < boardFinal[i].length; j++) {
                boardFinal[i][j] = Piece.EMPTY;
            }
        }

        for (int i = 0; i < boardFifty.length; i++) {
            int row = (i / 5);
            int column = (((i / 5) + 1) % 2) + (i % 5 * 2);
            boardFinal[row][column] = boardFifty[i];
        }
        return boardFinal;
    }
    
    /**
     * Get a line of the display
     *
     * @param n number of column
     * @return String
     */
    private static String getLine(int n) {
        String line = "|";
        for (int i = 0; i < n; i++) {
            line += "---|";
        }
        return line + "\n";
    }
    
    
}
