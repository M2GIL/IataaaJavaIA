package fr.univrouen.api.controller;

import fr.univrouen.api.model.Case;
import fr.univrouen.api.model.CodeEndGame;
import fr.univrouen.api.model.Difficulty;
import fr.univrouen.api.model.EnumPlayer;
import fr.univrouen.api.model.request.EndGameRequest;
import fr.univrouen.api.model.request.EndGameResponse;
import fr.univrouen.api.model.request.PlayGameRequest;
import fr.univrouen.api.model.request.StartGameRequest;
import fr.univrouen.api.model.request.StartGameResponse;
import fr.univrouen.api.model.request.StatusRequest;
import fr.univrouen.api.model.request.StatusResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import fr.univrouen.api.service.CherckersService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author anto
 */
@RestController
public class CheckersController {
    
    @Autowired
    private CherckersService service;
    
    @RequestMapping(value = "/ai/status", method = RequestMethod.GET)
    public ResponseEntity<StatusResponse> getStatus(@RequestParam(name = "token") String token) {
        
       StatusRequest request = new StatusRequest();
       request.setToken(token);
       StatusResponse response = service.getStatus(request);
       
       if (response != null) {
            return ResponseEntity
                .ok()
                .body(response);
       } else {
           return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
       }
    }
    
    @RequestMapping(value="/ai/games/start", method = RequestMethod.GET)
    public ResponseEntity<StartGameResponse> startGame(
        @RequestParam(name = "token") String token, 
        @RequestParam(name = "difficulty") Difficulty difficulty, 
        @RequestParam(name = "player") EnumPlayer player) {
        
        StartGameRequest request = new StartGameRequest();
        request.setToken(token);
        request.setDifficulty(difficulty);
        request.setPlayer(player);
        
        StartGameResponse response = service.startGame(request);
        
        if (response != null) {
             return ResponseEntity
                 .ok()
                 .body(response);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    
    @RequestMapping(value = "/ai/games/play/{game_id}", method = RequestMethod.GET)
    public ResponseEntity<PlayGameRequest> play(
        @PathVariable("game_id") String game_id, 
        @RequestParam(name = "token") String token, 
        @RequestParam(name = "difficulty") Difficulty difficulty, 
        @RequestParam(name = "player") EnumPlayer player,
        @RequestParam(name = "board") String casesS) {
        
        PlayGameRequest request = new PlayGameRequest();
        request.setToken(token);
        request.setDifficulty(difficulty);
        request.setPlayer(player);
        
        Case[] board = stringToCases(casesS);
        request.setBoard(board);
        
        PlayGameRequest response = service.play(game_id, request);
        if (response != null) {
             return ResponseEntity
                 .ok()
                 .body(response);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }        
    }
    
    
    @RequestMapping(value="/ai/games/end/{game_id}", method=RequestMethod.GET)
    public ResponseEntity<EndGameResponse> endGame(
            @PathVariable("game_id") String game_id, 
            @RequestParam(name = "token") String token, 
            @RequestParam(name = "winner") EnumPlayer winner,
            @RequestParam(name = "code") CodeEndGame code) {
        
        EndGameRequest request = new EndGameRequest();
        request.setToken(token);
        request.setCode(code);
        request.setWinner(winner);
        
        EndGameResponse response = service.endGame(game_id, request);
        if (response != null) {
             return ResponseEntity
                 .ok()
                 .body(response);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
     }
    
    
    
    // PRIVATE
    
    private Case[] stringToCases(String caseS) {
        Case[] board = new Case[caseS.length()];
        int i = 0;
        for (char c : caseS.toCharArray()) {
            board[i] = Case.values()[Character.getNumericValue(c)];
            ++i;
        }  
        return board;
    }

}
