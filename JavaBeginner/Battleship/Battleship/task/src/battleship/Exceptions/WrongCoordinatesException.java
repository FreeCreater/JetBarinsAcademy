package battleship.Exceptions;

public class WrongCoordinatesException extends Exception{
    public WrongCoordinatesException(){
        super("Error! You entered the wrong coordinates! Try again:");
    }
}
