package machine.Coffee;

public enum Coffee {
    Cappuccino(200,100,12,6),
    Espresso(250, 0, 16, 4),
    Latte(350,75,20,7);

    public final int water;
    public final int milk;
    public final int coffeeBeans;

    public final int coast;

    Coffee(int water, int milk, int coffeeBeans, int coast) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.coast = coast;
    }
}
