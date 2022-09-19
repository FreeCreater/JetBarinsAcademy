package tictactoe;

class Field {
    public String[][] field;

    public String strField() {
        StringBuilder sb = new StringBuilder();
        sb.append("---------\n");
        for (String[] line : field) {
            sb.append("| ");
            for (String cell : line) {
                sb.append(String.format("%s ", cell.equals("_") ? " " : cell));
            }
            sb.append("|\n");
        }
        sb.append("---------");
        return sb.toString();
    }

    public Field(String fieldLine) {
        field = new String[3][3];
        for (int coll = 0; coll < 3; coll++) {
            for (int row = 0; row < 3; row++) {
                String letter = String.valueOf(fieldLine.charAt(coll * 3 + row));
                field[coll][row] = letter;
            }
        }
    }

    public Field() {
        field = new String[3][3];
        for (int coll = 0; coll < 3; coll++) {
            for (int row = 0; row < 3; row++) {
                field[coll][row] = "_";
            }
        }
    }

    @Override
    public String toString() {
        return strField();
    }

    interface Checkable {
        boolean isImpossible();

        boolean isWin(String playerSign);

        boolean hasEmpty();
    }

    public String currentState() {

        Checkable check = new Checkable() {
            @Override
            public boolean isImpossible() {
                int dif = (int) (strField().chars().filter(ch -> ch == 'X').count() -
                        strField().chars().filter(ch -> ch == 'O').count());
                return Math.abs(dif) > 1;
            }

            @Override
            public boolean isWin(String playerSign) {
                String winLine = playerSign.repeat(3);
                for (int i = 0; i < 3; i++) {
                    if ((field[i][0] + field[i][1] + field[i][2]).equals(winLine) ||
                            (field[0][i] + field[1][i] + field[2][i]).equals(winLine)) {
                        return true;
                    }
                }
                return (field[0][0] + field[1][1] + field[2][2]).equals(winLine) ||
                        (field[0][2] + field[1][1] + field[2][0]).equals(winLine);
            }

            @Override
            public boolean hasEmpty() {
                for (String[] line : field) {
                    for (String s : line) {
                        if (s.equals("_")) {
                            return true;
                        }
                    }
                }
                return false;
            }
        };

        boolean xWin = check.isWin("X");
        boolean oWin = check.isWin("O");
        if (check.isImpossible() || (xWin && oWin)) {
            return "Impossible";
        }
        if (xWin) {
            return "X wins";
        }
        if (oWin) {
            return "O wins";
        }

        if (check.hasEmpty()) {
            return "Game not finished";
        }
        return "Draw";
    }


}
