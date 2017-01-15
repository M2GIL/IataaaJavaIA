/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univrouen.api.service;

import fr.univrouen.api.model.request.EndGameRequest;
import fr.univrouen.api.model.request.EndGameResponse;
import fr.univrouen.api.model.request.PlayGameRequest;
import fr.univrouen.api.model.request.StartGameRequest;
import fr.univrouen.api.model.request.StartGameResponse;
import fr.univrouen.api.model.request.StatusRequest;
import fr.univrouen.api.model.request.StatusResponse;

/**
 *
 * @author anto
 */

public interface CherckersService {

    StatusResponse getStatus(StatusRequest request);
    StartGameResponse startGame(StartGameRequest request);
    PlayGameRequest play(String game_id, PlayGameRequest request);
    EndGameResponse endGame(String game_id, EndGameRequest request);
}
