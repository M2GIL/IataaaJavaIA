package outils;

import model.CASE;

public class Converter {
    /**
     * Converts a board to internal format.
     */
    public static void /* InternalFormat */convertToInternalFormat(char[] board) {
        /// Change return type from void to internal format.
        /// Write function to convert board to your format.

        // Example :
        // InternalFormat iF;
        // for (int i = 0; i < board.size(); ++i) {
        //    iF.setSquare(i, board[i]);
        // }
        //return iF;
    }

    /**
     * Converts a board to external format.
     */
    public static char[] convertToExternalFormat(/* const InternalFormat& */) {
        /// Take as parameter a const reference to internal format.
        /// Write a function to convert the board from your format to
        /// BoardSquareType format.

        // Example (white draughts everywhere) :
        char[] a = new char[50];
        for (int i = 0; i < 50; ++i) {
            a[i] = CASE.WHITE_DRAUGHT.getCharRepresentation();
        }
        return a;
    }
}
