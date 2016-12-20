package gestionIa;

import java.util.List;
import java.util.Random;

import exceptions.UnknownGameIDException;
import model.CODEENDGAME;
import model.DIFFICULTE;
import model.JOUEUR;
import outils.Converter;
import outils.RandomGenerator;

public class GestionGame extends AGestionGame{
    
    public void newGameStarted(DIFFICULTE difficulty, JOUEUR player) {
    	this.setGameID(RandomGenerator.generateNewGameID());
        toggleState();

        /// Complete it if you need to do something when a new game starts.
    }
    
    public char[] gamePlay(String game_ID, DIFFICULTE difficulty,
                    JOUEUR player,
                    char[] board) throws UnknownGameIDException {
        // Only if gameID is the good one.
        if (game_ID == this.getGameID()) {
            // TODO
            /// Conversion to internal format.
            /* InternalFormat iF = */Converter.convertToInternalFormat(board);

            /// AI reflection.
            /* InternalFormat iaBoard = iF.think(player, difficulty);*/

            /// Conversion to external format.
            return Converter.convertToExternalFormat(/*iaBoard*/);
        } else {
            throw new UnknownGameIDException(game_ID);
        }
    }
    
    public void gameEnded(String game_ID, JOUEUR winner,
                     CODEENDGAME codeEndGame) throws UnknownGameIDException {
        // Only if gameID is the good one.
        if (game_ID == this.getGameID()) {
            this.setGameID("");
            toggleState();

            /// Complete it if you need to do something when a new game ends.
        } else {
            throw new UnknownGameIDException(game_ID);
        }
    }
}
