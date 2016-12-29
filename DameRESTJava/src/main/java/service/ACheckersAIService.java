package service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Status;

public abstract class ACheckersAIService implements ICheckersAIService {
	
    private String gameID;
    private Status state;
    private String token;
    private List<String> listToken;
    
    
    public ACheckersAIService() {
    	this.inializeListToken("src/main/java/utils/TokenFile");
    }
    
    public void inializeListToken(String pathTokensFile) {
    	listToken = new ArrayList<String>();
    	try {
			File tokenFile = new File(pathTokensFile);
			Scanner scanner = new Scanner(tokenFile);
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				listToken.add(line);
				//System.out.println(line);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    }
    
    
    public List<String> getListToken() {
    	return listToken;
    }
    /**
     * Toggles the state between AVAILABLE and BUSY.
     */
    public void toggleState() {
        state = (state == Status.AVAILABLE ? Status.BUSY
                : Status.AVAILABLE);
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
    	if (listToken.contains(tok)) {
    		token = tok;
    	}
        return listToken.contains(tok);
    }
    
    public String getGameID() {
        return gameID;
    }

    public void setGameID(String gameID) {
        this.gameID = gameID;
    }

    public Status getState() {
        return state;
    }

    public void setState(Status state) {
        this.state = state;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
