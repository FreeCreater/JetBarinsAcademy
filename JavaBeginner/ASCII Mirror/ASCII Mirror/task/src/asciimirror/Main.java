package asciimirror;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input the file path: ");
        String path = scanner.nextLine();

        ArrayList<String> list = new ArrayList<>();
        try {
            FileReader fr = new FileReader(path);
            scanner = new Scanner(fr);
            while (scanner.hasNextLine()) {
                list.add(scanner.nextLine());
            }
            main.modifyStrings(list);
            for (String line : list) {
                System.out.printf("%s | %s\n", line, main.reverseString(line));
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found!");
        }
    }

    public void modifyStrings(ArrayList<String> strings) {
        int maxLength = 0;
        for (String string : strings) {
            if (string.length() > maxLength) {
                maxLength = string.length();
            }
        }
        for (int i = 0; i < strings.size(); i++) {
            String string = strings.get(i);
            string += " ".repeat(maxLength - string.length());
            strings.set(i, string);
        }
    }

    public String reverseString(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            char letter = switch (str.charAt(i)) {
                case '(' -> ')';
                case ')' -> '(';
                case '\\' -> '/';
                case '/' -> '\\';
                case '[' -> ']';
                case ']' -> '[';
                case '<' -> '>';
                case '>' -> '<';
                default -> str.charAt(i);
            };
            sb.append(letter);
        }
        return sb.toString();
    }
}