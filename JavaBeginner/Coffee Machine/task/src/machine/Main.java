package machine;

import machine.Coffee.CoffeeMachine;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoffeeMachine coffeeMachine = new CoffeeMachine(400, 540, 120, 9, 550);

        while (coffeeMachine.on) {
            System.out.println(coffeeMachine.state.question);
            String answer = scanner.nextLine();
            coffeeMachine.clickButton(answer);
        }
    }
}
