package bullscows;

public class GuessNumber {
    private String secretNumber = "";

    public GuessNumber(int length) {
        String errorText = "Error: can't generate a secret number with a length of 11 because there aren't enough unique digits.";
        if (length > 10) {
            System.out.println(errorText);
            return;
        }

        StringBuilder pseudoRandomNumber = new StringBuilder(String.valueOf(System.nanoTime()));
        pseudoRandomNumber.reverse();

        StringBuilder sb = new StringBuilder();
        int i = 0;
        try {
            while (sb.length() < length) {
                String num = String.valueOf(pseudoRandomNumber.charAt(i));
                i++;
                if (sb.length() == 0 && "0".equals(num)) {
                    continue;
                }
                if (sb.indexOf(num) == -1) {
                    sb.append(num);
                }
            }
        } catch (StringIndexOutOfBoundsException exp) {
            System.out.println(errorText);
            return;
        }

        secretNumber = sb.toString();
    }

    public String getSecretNumber() {
        return secretNumber;
    }

    public boolean checkAnswer(String answer) {
        int bulls = 0;
        int cows = 0;

        String uncheckedNumbers = getSecretNumber();
        for (int i = 0; i < answer.length(); i++) {
            String ansLetter = answer.substring(i, i + 1);
            if (!uncheckedNumbers.contains(ansLetter)) {
                continue;
            }
            String secLetter = uncheckedNumbers.substring(i, i + 1);
            uncheckedNumbers = uncheckedNumbers.replaceFirst(secLetter, "*");
            if (ansLetter.equals(secLetter)) {
                bulls++;
                continue;
            }
            cows++;
        }

        String grade = "";
        if (bulls > 0) {
            grade += String.format("%d bull%s",
                    bulls,
                    bulls > 1 ? "s" : "");
        }
        if (cows > 0) {
            grade += String.format("%s%d cow%s",
                    bulls > 0 ? " and " : "",
                    cows,
                    cows > 1 ? "s" : "");
        }
        System.out.printf("Grade: %s\n",
                "".equals(grade) ? "None" : grade);
        return bulls == secretNumber.length();
    }
}
