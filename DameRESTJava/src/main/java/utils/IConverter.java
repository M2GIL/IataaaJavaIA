package utils;

public interface IConverter {

    /**
     * Converts a board to internal format.
     */
    public void /* InternalFormat */convertToInternalFormat(char[] board);

    /**
     * Converts a board to external format.
     */
    public char[] convertToExternalFormat(/* const InternalFormat& */);
}
