package tictactoe;

import tictactoe.Exceptions.WrongInput;
import tictactoe.Exceptions.WrongInputException;

public class Menu {

    public boolean nextCommand(String commandLine) {
        try {
            if (commandLine.startsWith("exit")) {
                return false;
            }
            String[] args = commandLine.split(" ");
            if (args.length < 3) {
                throw new WrongInputException(WrongInput.BadParameters);
            }
            PlayerDifficulty player1 = PlayerDifficulty.getValue(args[1]);
            PlayerDifficulty player2 = PlayerDifficulty.getValue(args[2]);
            game(player1, player2);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return true;
        }
    }

    private void game(PlayerDifficulty player1, PlayerDifficulty player2) {
        Game game = new Game(player1, player2);
        GameState currentState = GameState.NotFinished;
        System.out.println(Game.field);
        do {
            try {
                game.nextTurn();
                System.out.println(Game.field);
                currentState = game.getCurrentState();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (!currentState.finished);

        System.out.println(currentState.message);
    }

}
