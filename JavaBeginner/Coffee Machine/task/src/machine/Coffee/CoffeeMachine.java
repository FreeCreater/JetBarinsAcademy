package machine.Coffee;

import machine.State;

import java.util.Scanner;

public class CoffeeMachine {
    private int water;
    private int milk;
    private int coffeeBeans;
    private int disposableCups;
    private int money;

    public boolean on = true;

    public State state = State.MainMenu;

    @Override
    public String toString() {
        return String.format("""
                        The coffee machine has:
                        %d ml of water
                        %d ml of milk
                        %d g of coffee beans
                        %d disposable cups
                        $%d of money
                        """,
                this.water,
                this.milk,
                this.coffeeBeans,
                this.disposableCups,
                this.money);
    }

    public CoffeeMachine(int water, int milk, int coffeeBeans, int disposableCups, int money) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.disposableCups = disposableCups;
        this.money = money;
    }

    public void clickButton(String action) {
        switch (state) {
            case MainMenu:
                switch (action) {
                    case "buy" -> state = State.ChooseCoffee;
                    case "fill" -> state = State.FillWater;
                    case "take" -> take();
                    case "remaining" -> System.out.println(this);
                    case "exit" -> on = false;
                }
                break;
            case ChooseCoffee:
                buy(action);
                state = State.MainMenu;
                break;
            default:
                fill(Integer.parseInt(action));
        }
    }

    private void ingredientList(Coffee coffee, int countOfCups) {
        System.out.printf("""
                        For %d cups of coffee you will need:
                        %d ml of water
                        %d ml of milk
                        %d g of coffee beans
                        """,
                countOfCups,
                coffee.water * countOfCups,
                coffee.milk * countOfCups,
                coffee.coffeeBeans * countOfCups);
        System.out.println();
    }

    private void makeCoffee(Coffee coffee) {
        if (water < coffee.water) {
            System.out.println("Sorry, not enough water!");
            return;
        }
        if (milk < coffee.milk) {
            System.out.println("Sorry, not enough milk!");
            return;
        }
        if (coffeeBeans < coffee.coffeeBeans) {
            System.out.println("Sorry, not enough coffee beans!");
            return;
        }
        if (disposableCups < 0) {
            System.out.println("Sorry, not enough disposable cups!");
            return;
        }

        water -= coffee.water;
        milk -= coffee.milk;
        coffeeBeans -= coffee.coffeeBeans;
        disposableCups--;
        money += coffee.coast;
    }

    private void buy(String answer) {
        Coffee coffee = null;
        switch (answer) {
            case "1":
                coffee = Coffee.Espresso;
                break;
            case "2":
                coffee = Coffee.Latte;
                break;
            case "3":
                coffee = Coffee.Cappuccino;
                break;
            case "back":
                return;
        }
        assert coffee != null;
        makeCoffee(coffee);
    }

    private void fill(int value) {
        switch (state) {
            case FillWater -> {
                this.water += value;
                state = State.FillMilk;
            }
            case FillMilk -> {
                this.milk += value;
                state = State.FillCoffeeBeans;
            }
            case FillCoffeeBeans -> {
                this.coffeeBeans += value;
                state = State.FillDisposableCups;
            }
            case FillDisposableCups -> {
                this.disposableCups += value;
                state = State.MainMenu;
            }
        }
    }

    private void take() {
        System.out.printf("I gave you $%d\n", this.money);
        this.money = 0;
    }

}
