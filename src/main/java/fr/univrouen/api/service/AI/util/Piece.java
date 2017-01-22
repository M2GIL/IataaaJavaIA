package fr.univrouen.api.service.AI.util;

public enum Piece {
    WHITE_PIECE(1, "o"),
    BLACK_PIECE(-1, "x"),
    WHITE_QUEEN(3, "O"),
    BLACK_QUEEN(-3, "X"),
    EMPTY(0, " ");
    
    private final int value;
    private final String toString;
    
    private Piece(int value, String toString) {
        this.value = value;
        this.toString = toString;
    }

    public int getValue() {
        return value;
    } 

    @Override
    public String toString() {
        return toString;
    }
    
    
}