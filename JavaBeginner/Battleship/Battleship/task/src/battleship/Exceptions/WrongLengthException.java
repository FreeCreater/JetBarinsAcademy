package battleship.Exceptions;

public class WrongLengthException extends Exception {
    public WrongLengthException(String name) {
        super(String.format("Error! Wrong length of the %s! Try again:",
                name
        ));
    }
}
