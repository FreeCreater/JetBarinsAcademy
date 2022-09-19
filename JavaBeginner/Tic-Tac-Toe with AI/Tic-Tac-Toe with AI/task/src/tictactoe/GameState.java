package tictactoe;

public enum GameState {
    XWin("X wins", true),
    OWin("O wins", true),
    NotFinished("Game not finished", false),
    Draw("Draw", true);

    public final String message;
    public final boolean finished;

    GameState(String message, boolean finished) {
        this.message = message;
        this.finished = finished;
    }
}
