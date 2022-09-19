package tictactoe;


public class Main {
    public static void main(String[] args) {
        Field field = new Field();
        ValidatedInput input = new ValidatedInput(field);
        for (int i = 0; i < 9; i++) {
            System.out.println(field);
            input.nextPosition(i % 2 == 0 ? "X" : "O");
            String curState = field.currentState();
            if (!curState.equals("Game not finished")) {
                System.out.println(field);
                System.out.println(curState);
                break;
            }
        }
    }
}
