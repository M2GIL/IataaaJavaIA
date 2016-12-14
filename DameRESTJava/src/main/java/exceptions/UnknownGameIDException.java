package exceptions;

public class UnknownGameIDException extends Exception{
    public UnknownGameIDException(String gameID) {
        System.out.println("Unknown gameID : " + gameID);
    }
}
