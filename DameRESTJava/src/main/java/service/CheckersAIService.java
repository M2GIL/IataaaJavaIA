package service;


import exceptions.UnknownGameIDException;
import model.CodeEndGame;
import model.Difficulty;
import model.Player;
import utils.Converter;
import utils.RandomGenerator;

public class CheckersAIService extends ACheckersAIService implements ICheckersAIService {
    @Override
    public void newGameStarted(Difficulty difficulty, Player player) {
    	this.setGameID(RandomGenerator.generateNewGameID());
        toggleState();

        /// Complete it if you need to do something when a new game starts.
    }
    
    @Override
    public char[] gamePlay(String game_ID, Difficulty difficulty,
                    Player player,
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
    
    @Override
    public void gameEnded(String game_ID, Player winner,
                     CodeEndGame codeEndGame) throws UnknownGameIDException {
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
