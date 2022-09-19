package tictactoe.Exceptions;

public enum WrongInput {
    CellOccupied("This cell is occupied! Choose another one!"),
    Number("You should enter numbers!"),
    Range("Coordinates should be from 1 to 3!"),
    BadParameters("Bad parameters!");

    public final String message;

    WrongInput(String message) {
        this.message = message;
    }
}
