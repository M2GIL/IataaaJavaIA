package fr.univrouen.api.controller;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import fr.univrouen.api.service.CherckersService;
import org.springframework.http.HttpStatus;

/**
 *
 * @author anto
 */
@RestController
public class CheckersController {
    
    @Autowired
    private CherckersService service;
    
    @RequestMapping(value = "/ai/status", method = RequestMethod.POST)
    public ResponseEntity<StatusResponse> getStatus(@RequestBody StatusRequest request) {
       StatusResponse response = service.getStatus(request);
       
       if (response != null) {
            return ResponseEntity
                .ok()
                .body(response);
       } else {
           return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
       }
    }
    
    @RequestMapping(value="/ai/games/start/", method = RequestMethod.POST)
    public ResponseEntity<StartGameResponse> startGame(@RequestBody StartGameRequest request) {
        StartGameResponse response = service.startGame(request);
        
        System.out.println("PLAY");
        System.out.println("response = " + response);

        if (response != null) {
             return ResponseEntity
                 .ok()
                 .body(response);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    
    @RequestMapping(value = "/ai/games/play/{game_id}", method = RequestMethod.POST)
    public ResponseEntity<PlayGameRequest> play(@PathVariable("game_id") String game_id, @RequestBody PlayGameRequest request) {
        PlayGameRequest response = service.play(game_id, request);
        if (response != null) {
             return ResponseEntity
                 .ok()
                 .body(response);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }        
    }
    
    
    @RequestMapping(value="/ai/games/end/{game_id}", method=RequestMethod.POST)
    public ResponseEntity<EndGameResponse> endGame(
            @PathVariable("game_id") String game_id, 
            @RequestBody EndGameRequest request) {
        
        EndGameResponse response = service.endGame(game_id, request);
        if (response != null) {
             return ResponseEntity
                 .ok()
                 .body(response);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
     }

}
