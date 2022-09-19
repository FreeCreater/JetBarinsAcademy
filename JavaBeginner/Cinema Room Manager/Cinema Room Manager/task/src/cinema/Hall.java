package cinema;

public class Hall {

    private static final int FRONT_COAST = 10;
    private static final int BACK_COAST = 8;
    private final String[][] places;
    private final int rows;
    private final int seats;
    private final int placeCount;

    public int calculateTotalIncome() {
        int income = 0;
        if (placeCount <= 60) {
            income = placeCount * 10;
        } else {
            for (int i = 1; i <= rows; i++) {
                income += getTicketPrice(i) * seats;
            }
        }
        return income;
    }

    public float calculatePercent(int purchasedTickets) {
        return (float) purchasedTickets / (float) placeCount*100;
    }

    private int getTicketPrice(int row) {
        int placesCount = rows * seats;
        if (placesCount <= 60) {
            return FRONT_COAST;
        }
        return row <= rows / 2 ? FRONT_COAST : BACK_COAST;
    }

    public Hall(int rows, int height) {
        this.rows = rows;
        this.seats = height;
        this.placeCount = rows * seats;
        places = new String[rows][height];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < height; j++) {
                places[i][j] = "S";
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder hallString = new StringBuilder();
        hallString.append("\nCinema:\n");
        hallString.append("  ");
        for (int i = 0; i < seats; i++) {
            hallString.append(String.format("%s ", i + 1));
        }
        hallString.append("\n");

        for (int i = 0; i < rows; i++) {
            hallString.append(String.format("%s ", i + 1));
            for (int j = 0; j < seats; j++) {
                hallString.append(String.format("%s ", places[i][j]));
            }
            hallString.append("\n");
        }
        return hallString.toString();
    }

    public int takeSeat(int row, int seat) {
        try {
            if (!places[row - 1][seat - 1].equals("S")) {
                return 0;
            }
            places[row - 1][seat - 1] = "B";
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Wrong input!");
            return 0;
        }
        return getTicketPrice(row);
    }
}
