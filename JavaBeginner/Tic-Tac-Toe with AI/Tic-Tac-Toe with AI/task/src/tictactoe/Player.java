package tictactoe;

import tictactoe.Exceptions.WrongInputException;

import java.util.Random;
import java.util.Scanner;

public class Player {
    final Scanner scanner = new Scanner(System.in);
    final Random random = new Random();
    final char playerChar;
    final PlayerDifficulty difficulty;
    final char opponentChar;


    public Player(char playerChar, PlayerDifficulty difficulty, char opponentChar) {
        this.playerChar = playerChar;
        this.difficulty = difficulty;
        this.opponentChar = opponentChar;
    }

    public void nextTurn() throws WrongInputException {
        switch (difficulty) {
            case User -> userMove();
            case Easy -> {
                System.out.println("Making move level \"easy\"");
                randomMove();
            }
            case Medium -> {
                System.out.println("Making move level \"medium\"");
                mediumAiMove();
            }
            case Hard -> {
                System.out.println("Making move level \"hard\"");
                hardAiMove();
            }
        }
    }

    private void userMove() throws WrongInputException {
        System.out.print("Enter the coordinates: ");
        String inputLine = scanner.nextLine();
        String[] input = inputLine.split("\s");
        int y = Integer.parseInt(input[0]) - 1;
        int x = Integer.parseInt(input[1]) - 1;
        Game.field.setCell(y, x, playerChar);
    }


    private void randomMove() {
        while (true) {
            try {
                int y = random.nextInt(Game.field.size);
                int x = random.nextInt(Game.field.size);
                Game.field.setCell(y, x, playerChar);
                break;
            } catch (WrongInputException ignored) {
            }
        }
    }

    private void mediumAiMove() {
        if (InlineMove(playerChar)) {
            return;
        }
        if (InlineMove(opponentChar)) {
            return;
        }
        randomMove();
    }

    private boolean InlineMove(char checkChar) {

        int inLine;
        int moveY = 0;
        int moveX = 0;
        char cell;
        try {

            for (int i = 0; i < Game.field.size; i++) {
                //rows
                inLine = 0;
                for (int j = 0; j < Game.field.size; j++) {
                    cell = Game.field.getCell(i, j);
                    if (cell == checkChar) {
                        inLine++;
                    } else if (cell == Game.emptyChar) {
                        moveY = i;
                        moveX = j;
                    }
                }
                if (inLine == 2) {
                    Game.field.setCell(moveY, moveX, playerChar);
                    return true;
                }

                //columns
                inLine = 0;
                for (int j = 0; j < Game.field.size; j++) {
                    cell = Game.field.getCell(j, i);
                    if (cell == checkChar) {
                        inLine++;
                    } else if (cell == Game.emptyChar) {
                        moveY = j;
                        moveX = i;
                    }
                }
                if (inLine == 2) {
                    Game.field.setCell(moveY, moveX, playerChar);
                    return true;
                }


            }
            //main diagonal
            inLine = 0;
            for (int i = 0; i < Game.field.size; i++) {
                cell = Game.field.getCell(i, i);
                if (cell == checkChar) {
                    inLine++;
                } else if (cell == Game.emptyChar) {
                    moveY = i;
                    moveX = i;
                }
            }
            if (inLine == 2) {
                Game.field.setCell(moveY, moveX, playerChar);
                return true;
            }

            //main diagonal
            inLine = 0;
            for (int i = 0; i < Game.field.size; i++) {
                cell = Game.field.getCell(i, i);
                if (cell == checkChar) {
                    inLine++;
                } else if (cell == Game.emptyChar) {
                    moveY = i;
                    moveX = i;
                }
            }
            if (inLine == 2) {
                Game.field.setCell(moveY, moveX, playerChar);
                return true;
            }

            //other diagonal
            inLine = 0;
            for (int i = 0; i < Game.field.size; i++) {
                cell = Game.field.getCell(i, Game.field.size - 1 - i);
                if (cell == checkChar) {
                    inLine++;
                } else if (cell == Game.emptyChar) {
                    moveY = i;
                    moveX = Game.field.size - 1 - i;
                }
            }
            if (inLine == 2) {
                Game.field.setCell(moveY, moveX, playerChar);
                return true;
            }

        } catch (WrongInputException ignored) {
        }
        return false;
    }

    private void hardAiMove() {

    }

}
