package controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import exceptions.UnknownGameIDException;
import gestionIa.GestionGame;
import paquetsJSON.EntreeIaGamesEndId;
import paquetsJSON.EntreeIaGamesStart;
import paquetsJSON.EntreeIaStatus;
import paquetsJSON.EntreeRetourIaGamePlayId;
import paquetsJSON.RetourIaGamesEndId;
import paquetsJSON.RetourIaGamesStart;
import paquetsJSON.RetourIaStatus;

// Note : Spring se charge lui-même de l'envoie de l'erreur 400 -> "Invalid arguments."
@RestController
public class DameController {
    

    private GestionGame gestionGame = new GestionGame();
    
    @RequestMapping(value = "/ai/status", method = RequestMethod.POST)
    public ResponseEntity<?> status(@RequestBody EntreeIaStatus token) {

        // Is token the correct one ?
        if (!gestionGame.isGoodToken(token.getToken())) {
            return ResponseEntity
            .status(HttpStatus.UNAUTHORIZED)
            .body("Invalid token.");
        }
        
        // Returns the status.
        return ResponseEntity
            .ok()
            .body(new RetourIaStatus(gestionGame.getToken(), gestionGame.getState()));
    }
    
    @RequestMapping(value="/ai/games/start/", method = RequestMethod.POST)
    public ResponseEntity<?> beginGame(@RequestBody EntreeIaGamesStart e) {
        //Prévenir les IA qu’une partie les concernant va commencer
        gestionGame.newGameStarted(e.getDifficulty(), e.getPlayer());
        
        // Is token the correct one ?
        if (!gestionGame.isGoodToken(e.getToken())) {
            return ResponseEntity
            .status(HttpStatus.UNAUTHORIZED)
            .body("Invalid token.");
        }
        
        return ResponseEntity
            .ok()
            .body(new RetourIaGamesStart(gestionGame.getToken(), gestionGame.getState(), gestionGame.getGameID()));
    }
    
    @RequestMapping(value = "/ai/games/play/{game_id:.+}", method = RequestMethod.POST)
    public ResponseEntity<?> getMove(@PathVariable("game_id") String game_id, @RequestBody EntreeRetourIaGamePlayId e) {
    
        // Is token the correct one ?
        if (!gestionGame.isGoodToken(e.getToken())) {
            return ResponseEntity
            .status(HttpStatus.UNAUTHORIZED)
            .body("Invalid token.");
        }
    
        //Demande de jouer un coup sur un plateau donnée sur une partie
        char[] responseBoard = new char[50];
        
        try {
            responseBoard = gestionGame.gamePlay(game_id, e.getDifficulty(), e.getPlayer(), e.getBoard());
        } catch (UnknownGameIDException e1) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Invalid gameID.");
        }
        
        //test de retour
        return ResponseEntity
            .ok()
            .body(new EntreeRetourIaGamePlayId(gestionGame.getToken(), e.getDifficulty(), e.getPlayer(), responseBoard));
    }
    
    @RequestMapping(value="/ai/games/end/{game_id:.+}", method=RequestMethod.POST)
    public ResponseEntity<?> endGame(@PathVariable("game_id") String game_id, @RequestBody EntreeIaGamesEndId e) {
    
        // Is token the correct one ?
        if (!gestionGame.isGoodToken(e.getToken())) {
            return ResponseEntity
            .status(HttpStatus.UNAUTHORIZED)
            .body("Invalid token.");
        }
    
        //Annoncer la fin de partie avec code explicatif pour gérer les parties avortées et les parties standards.
        try {
            gestionGame.gameEnded(game_id, e.getWinner(), e.getCode());
        } catch (UnknownGameIDException e1) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Invalid gameID.");
        }
        
        return ResponseEntity
            .ok()
            .body(new RetourIaGamesEndId (gestionGame.getToken(), gestionGame.getState()));
    }

}
