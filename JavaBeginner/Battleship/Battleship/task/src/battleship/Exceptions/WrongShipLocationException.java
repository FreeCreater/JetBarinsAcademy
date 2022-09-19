package battleship.Exceptions;

public class WrongShipLocationException extends Exception{
    public WrongShipLocationException(){
        super("Error! Wrong ship location! Try again:");
    }
}
