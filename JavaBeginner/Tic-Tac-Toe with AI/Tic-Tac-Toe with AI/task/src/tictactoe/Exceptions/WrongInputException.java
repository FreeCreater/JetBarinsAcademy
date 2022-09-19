package tictactoe.Exceptions;

public class WrongInputException extends Exception{
    public WrongInputException(WrongInput wrongInput){
        super(wrongInput.message);
    }
}

