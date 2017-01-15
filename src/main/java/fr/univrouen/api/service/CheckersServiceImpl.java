/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univrouen.api.service;

import fr.univrouen.api.model.Case;
import fr.univrouen.api.model.CodeEndGame;
import fr.univrouen.api.model.Difficulty;
import fr.univrouen.api.model.EnumPlayer;
import fr.univrouen.api.model.StatusService;
import fr.univrouen.api.model.request.EndGameRequest;
import fr.univrouen.api.model.request.EndGameResponse;
import fr.univrouen.api.model.request.PlayGameRequest;
import fr.univrouen.api.model.request.StartGameRequest;
import fr.univrouen.api.model.request.StartGameResponse;
import fr.univrouen.api.model.request.StatusRequest;
import fr.univrouen.api.model.request.StatusResponse;
import fr.univrouen.api.service.AI.AI;
import fr.univrouen.api.service.AI.AIImpl;
import fr.univrouen.api.util.RandomGenerator;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 *
 * @author anto
 */
@Service
public class CheckersServiceImpl implements CherckersService {
    
    private static final String FILENAME = "tokens.txt";
    private String tokenId;
    private Map<String, AI> ais;
    private boolean isInGame;
    
    public CheckersServiceImpl() {
        ais = new HashMap<>();
        isInGame = false;
        
        BufferedReader br = null;
        FileReader fr = null;
        try {
            fr = new FileReader(FILENAME);
            br = new BufferedReader(fr);
            tokenId = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (br != null)
                br.close();
            if (fr != null)
                fr.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
	
    }

    @Override
    public StatusResponse getStatus(StatusRequest request) {
        String token = request.getToken();
        if (!tokenId.equals(token)) {
            return null;
        }
        StatusResponse response = new StatusResponse();
        StatusService st = isInGame ? StatusService.BUSY : StatusService.AVAILABLE;
        response.setStatus(st);
        response.setToken(token);
        return response;
    }

    @Override
    public StartGameResponse startGame(StartGameRequest request) {
        String token = request.getToken();
        if (!tokenId.equals(token)) {
            return null;
        }
        
        StatusService st;
        String gameId = null;
        if (!isInGame) {
            AI ai = new AIImpl();
            gameId = RandomGenerator.generateNewGameID();
            ais.put(gameId, ai);
            isInGame = true;
            
            st = StatusService.AVAILABLE;
            Difficulty difficulty = request.getDifficulty();
            EnumPlayer playerNb = request.getPlayer();
            ai.startGame(token, difficulty, playerNb);
        } else {
            st = StatusService.BUSY;
        }
        StartGameResponse response = new StartGameResponse();
        response.setStatus(st);
        response.setToken(token);
        response.setGame_id(gameId);
       
        return response;
    }

    @Override
    public PlayGameRequest play(String gameId, PlayGameRequest request) {
        String token = request.getToken();
        if (!tokenId.equals(token)) {
            return null;
        }
        AI ai = ais.get(gameId);
        if (ai == null) {
            return null;
        }
        
        Difficulty difficulty = request.getDifficulty();
        EnumPlayer playerNb = request.getPlayer();
        Case[] board = request.getBoard();
        Case[] movement = ai.play(gameId, difficulty, playerNb, board);
        
        PlayGameRequest response = new PlayGameRequest();
        response.setBoard(movement);
        response.setDifficulty(difficulty);
        response.setPlayer(playerNb);
        response.setToken(token);
        return response;
    }

    @Override
    public EndGameResponse endGame(String gameId, EndGameRequest request) {
        String token = request.getToken();
        if (!tokenId.equals(token)) {
            return null;
        }
        AI ai = ais.get(gameId);
        if (ai == null) {
            return null;
        }
        EnumPlayer winner = request.getWinner();
        CodeEndGame code = request.getCode();
        ai.endGame(winner, code);
        isInGame = false;
        
        EndGameResponse response = new EndGameResponse();
        response.setStatus(StatusService.AVAILABLE);
        response.setToken(token);
        
        return response;
    }
    
    
    // PRIVATE
    
}
