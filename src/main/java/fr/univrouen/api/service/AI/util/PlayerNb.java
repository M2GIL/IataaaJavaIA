package fr.univrouen.api.service.AI.util;


public enum PlayerNb {
    PLAYER_1, PLAYER_2;

    public static PlayerNb getNextPlayer(PlayerNb player) {
        if (player == null) throw new AssertionError();
        if (player == PLAYER_1) return PLAYER_2;
        return PLAYER_1;
    }
}
