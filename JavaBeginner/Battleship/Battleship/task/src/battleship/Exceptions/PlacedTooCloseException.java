package battleship.Exceptions;

public class PlacedTooCloseException extends Exception{
    public PlacedTooCloseException(){
        super("Error! You placed it too close to another one. Try again:");
    }
}
