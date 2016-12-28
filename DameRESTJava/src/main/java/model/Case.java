package model;

public enum Case {
    EMPTY('0'), // '\0'
    BLACK_PAWN('1'), // '\1'
    BLACK_DRAUGHT('2'), // '\2'
    WHITE_PAWN('3'), // '\3'
    WHITE_DRAUGHT('4'); // '\4'
    
    private char charRepresentation;
    
    private Case(char c) {
        charRepresentation = c;
    }
    
    public char getCharRepresentation() {
        return this.charRepresentation;
    }
    
}