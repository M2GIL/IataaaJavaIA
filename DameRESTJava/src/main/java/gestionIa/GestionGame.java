package gestionIa;

import java.util.Random;

import exceptions.UnknownGameIDException;
import model.CODEENDGAME;
import model.DIFFICULTE;
import model.JOUEUR;
import model.STATUS;
import outils.Converter;

public class GestionGame {
    
    private String gameID;
    private STATUS state;
    private String token;
    
    public void generateNewGameID() {
        // Generates a new random gameID of length 10.
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuffer randomString = new StringBuffer();
        for(int x=0; x<=10; x++) {
            Random random=new Random();
            int val = random.nextInt(str.length());
            randomString.append(str.charAt(val));
        }
        gameID = new String(randomString);
    }
    
    public void newGameStarted(DIFFICULTE difficulty, JOUEUR player) {
        generateNewGameID();
        toggleState();

        /// Complete it if you need to do something when a new game starts.
    }
    
    public char[] gamePlay(String game_ID, DIFFICULTE difficulty,
                    JOUEUR player,
                    char[] board) throws UnknownGameIDException {
        // Only if gameID is the good one.
        if (game_ID == gameID) {
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
        if (game_ID == gameID) {
            gameID = "";
            toggleState();

            /// Complete it if you need to do something when a new game ends.
        } else {
            throw new UnknownGameIDException(game_ID);
        }
    }

    /**
     * Toggles the state between AVAILABLE and BUSY.
     */
    public void toggleState() {
        state = (state == STATUS.AVAILABLE ? STATUS.BUSY
                : STATUS.AVAILABLE);
    }

    /**
     * Verifies the gameID.
     * @param game_ID the gameID
     * @return true if game_ID is recognized, false otherwise
     */
    public Boolean isKnownGameID(String game_ID) {
        return game_ID == gameID;
    }
    
    /**
     * Verifies the token.
     * @param tok the token
     * @return true if token is valid, false otherwise
     */
    public Boolean isGoodToken(String tok) {
        return tok == token;
    }
    
    public String getGameID() {
        return gameID;
    }

    public void setGameID(String gameID) {
        this.gameID = gameID;
    }

    public STATUS getState() {
        return state;
    }

    public void setState(STATUS state) {
        this.state = state;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
