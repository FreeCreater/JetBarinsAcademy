package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        String input;
        do {
            System.out.println("Input command: ");
            input = scanner.nextLine();
        } while (menu.nextCommand(input));
    }
}
