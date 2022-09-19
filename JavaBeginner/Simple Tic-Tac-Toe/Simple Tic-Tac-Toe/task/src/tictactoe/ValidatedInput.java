package tictactoe;

import java.util.Scanner;

public class ValidatedInput {
    static final Scanner scanner = new Scanner(System.in);
    Field field;

    public ValidatedInput(Field field) {
        this.field = field;
    }


    public void nextPosition(String playerStr) {
        do {
            int x;
            int y;
            try {
                String[] input = scanner.nextLine().split(" ");
                x = Integer.parseInt(input[0]);
                y = Integer.parseInt(input[1]);
            } catch (NumberFormatException ex) {
                System.out.println("You should enter numbers!");
                continue;
            } catch (Exception ex) {
                continue;
            }
            if (x < 1 || y < 1 || x > 3 || y > 3) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }
            if (!field.field[x - 1][y - 1].equals("_")) {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }
            field.field[x - 1][y - 1] = playerStr;
            break;
        } while (true);
    }
}
