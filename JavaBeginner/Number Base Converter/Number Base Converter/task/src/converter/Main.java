package converter;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number ib decimal system: ");
        int decimal = scanner.nextInt();
        System.out.print("Enter target base: ");
        int base = scanner.nextInt();

        String result = "";
        switch (base) {
            case 2 -> result = Integer.toBinaryString(decimal);
            case 8 -> result = Integer.toOctalString(decimal);
            case 16 -> result = Integer.toHexString(decimal);
        }
        System.out.printf("Conversion result: %s\n",result);
    }
}
