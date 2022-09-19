package machine;

public enum State {
    MainMenu("Write action (buy, fill, take, remaining, exit):"),
    ChooseCoffee("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:"),

    FillWater("Write how many ml of water you want to add:"),
    FillMilk("Write how many ml of milk you want to add:"),
    FillCoffeeBeans("Write how many grams of coffee beans you want to add:"),
    FillDisposableCups("Write how many disposable cups of coffee you want to add:");

    public String question;

    State(String question) {
        this.question = question;
    }

}
