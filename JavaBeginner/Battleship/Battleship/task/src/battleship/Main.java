package battleship;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Player 1, place your ships on the game field");
        Field pl1Field = new Field();
        pl1Field.placeShips();
        System.out.println("Press Enter and pass the move to another player");
        scanner.nextLine();

        System.out.println("Player 2, place your ships on the game field");
        Field pl2Field = new Field();
        pl2Field.placeShips();
        System.out.println("Press Enter and pass the move to another player");
        scanner.nextLine();

        boolean gameFinished = false;
        while (!gameFinished) {
            System.out.println(
                    pl2Field.getField(false) +
                            "---------------------" +
                            pl1Field.getField(true));
            System.out.println("Player 1, it's your turn:");
            pl2Field.shot();
            System.out.println("Press Enter and pass the move to another player");
            scanner.nextLine();

            System.out.println(
                    pl1Field.getField(false) +
                            "---------------------" +
                            pl2Field.getField(true));
            System.out.println("Player 2, it's your turn:");
            pl1Field.shot();

            gameFinished = pl1Field.IsAllShipsSank() || pl2Field.IsAllShipsSank();

            if (!gameFinished) {
                System.out.println("Press Enter and pass the move to another player");
                scanner.nextLine();
            }
        }

        System.out.println("You sank the last ship. You won. Congratulations!");
    }
}
