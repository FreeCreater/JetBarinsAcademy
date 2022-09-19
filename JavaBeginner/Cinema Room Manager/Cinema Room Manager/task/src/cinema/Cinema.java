package cinema;

import java.util.Scanner;

public class Cinema {
    static final Scanner scanner = new Scanner(System.in);
    private Hall hall;

    private int purchasedTickets = 0;
    private int income = 0;
    private final int totalIncome;

    public Cinema() {
        System.out.println("Enter the number of rows: ");
        int rows = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter the number of seats in each row: ");
        int seats = Integer.parseInt(scanner.nextLine());

        hall = new Hall(rows, seats);
        totalIncome = hall.calculateTotalIncome();
        showSeats();
    }

    public void startMenu() {
        boolean exit = false;
        while (!exit) {
            printMenu();
            int answer = Integer.parseInt(scanner.nextLine());
            switch (answer) {
                case 1 -> showSeats();
                case 2 -> buyTicket();
                case 3 -> showStatistics();
                case 0 -> exit = true;
            }
        }
    }

    private void printMenu() {
        System.out.println("""
                1. Show the seats
                2. Buy a ticket
                3. Statistics
                0. Exit
                                
                """);
    }

    private void showSeats() {
        System.out.println(hall);
    }

    private void showStatistics() {
        float percent = hall.calculatePercent(purchasedTickets);
        System.out.printf("""
                Number of purchased tickets: %d
                Percentage: %.2f%%
                Current income: $%d
                Total income: $%d
                                
                """, purchasedTickets, percent, income, totalIncome);
    }

    private void buyTicket() {
        int price = 0;
        while (true) {
            System.out.println("Enter a row number:");
            int row = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter a seat number in that row:");
            int seat = Integer.parseInt(scanner.nextLine());
            price = hall.takeSeat(row, seat);
            if (price != 0) {
                System.out.printf("Ticket price: $%d\n", price);
                this.purchasedTickets++;
                this.income += price;
                break;
            }
            System.out.println("That ticket has already been purchased!");
        }
        System.out.println(hall);
    }
}
