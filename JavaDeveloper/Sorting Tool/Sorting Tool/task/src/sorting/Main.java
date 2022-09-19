package sorting;

import java.util.*;

public class Main {
    public static void main(final String[] args) {
        Scanner scanner = new Scanner(System.in);

        long maxNumber = Long.MIN_VALUE;
        int totalNumbers = 0;
        int countOfMax = 0;
        while (scanner.hasNextLong()) {
            long number = scanner.nextLong();
            if (number >= maxNumber) {
                if (number > maxNumber) {
                    countOfMax = 0;
                }
                maxNumber = number;
                countOfMax++;
            }
            totalNumbers++;
        }

        int percent = countOfMax/totalNumbers;
        System.out.printf("""
                Total numbers: %d.
                The greatest number: %d (%d time(s), %d%%).
                                
                """, totalNumbers, maxNumber, countOfMax, percent);
    }
}
