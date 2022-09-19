package bullscows;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please, enter the secret code's length:");
        int length = Integer.parseInt(scanner.nextLine());
        GuessNumber gn = new GuessNumber(length);
        System.out.println("Okay, let's start a game!");

        int turn = 1;
        boolean win = false;
        while (!win) {
            System.out.printf("Turn %d:\n", turn);
            String input = scanner.nextLine();
            win = gn.checkAnswer(input);
            turn++;
        }
        System.out.println("Congratulations! You guessed the secret code.");
    }
}
