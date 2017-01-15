package fr.univrouen.api.service.AI.util;



import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author anto
 */
public class Rules {
    public static List<Board<Piece>> getAvailableMoves(Board<Piece> board, PlayerNb p) {
        List<Board<Piece>> boards = new ArrayList<>();
        Piece[] cases = reverseCases(board.toArray());

        List<Piece[]> casesList = ReverseRules.getAvailableMoves(cases, p);
        Board b;
        for(Piece[] c : casesList) {
            b = new Board(reverseCases(c));
            boards.add(b);
        }

        return boards;
    }

    private static int reverseCaseIndice(int indice) {
        assert indice >= 0 && indice < 50;
        int column = indice % 5;
        int row = (indice) / 5;
        return (9 - row) * 5 + column;
    }

    private static Piece[] reverseCases(Piece[] pieces) {
        Piece[] reverseCases = new Piece[Game.PIECE_SIZE];
        //int[] test = new int[Game.PIECE_SIZE];
        for (int i = 0; i < Game.PIECE_SIZE; ++i) {
            reverseCases[reverseCaseIndice(i)] = pieces[i];
            //test[i] = reverseCaseIndice(i);
        }
        //affichageTableau(test);
        return reverseCases;
    }
}
