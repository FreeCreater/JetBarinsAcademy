package tictactoe;

import tictactoe.Exceptions.WrongInputException;

public class Game {
    static final char xChar = 'X';
    static final char oChar = 'O';
    static final char emptyChar = '_';

    public static Field field;

    static Player player1;
    static Player player2;
    int turn = 0;

    public Game(PlayerDifficulty playerDifficulty1, PlayerDifficulty playerDifficulty2){
        field = new Field();
        player1 = new Player(xChar, playerDifficulty1, oChar);
        player2 = new Player(oChar, playerDifficulty2, xChar);
    }

    public GameState getCurrentState() {
        if (field.isWin(xChar)) {
            return GameState.XWin;
        }
        if (field.isWin(oChar)) {
            return GameState.OWin;
        }
        if (field.isFilled()) {
            return GameState.Draw;
        }
        return GameState.NotFinished;
    }

    public void nextTurn() throws WrongInputException {
        Player player = turn % 2 == 0 ? player1: player2;
        player.nextTurn();
        turn++;
    }
}
