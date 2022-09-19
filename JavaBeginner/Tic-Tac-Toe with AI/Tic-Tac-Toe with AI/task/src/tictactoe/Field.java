package tictactoe;

import tictactoe.Exceptions.WrongInput;
import tictactoe.Exceptions.WrongInputException;

import java.util.Random;
import java.util.Scanner;

public class Field {
    final int size = 3;
    private char[][] field = new char[size][size];

    public Field() {
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                field[y][x] = Game.emptyChar;
            }
        }
    }

    public char getCell(int y, int x){
        return  field[y][x];
    }

    public void setCell(int y, int x, char cell) throws WrongInputException{
        if (x < 0 || x >= size || y < 0 || y >= size) {
            throw new WrongInputException(WrongInput.Range);
        }
        if(field[y][x] != Game.emptyChar) {
            throw new WrongInputException(WrongInput.CellOccupied);
        }
        field[y][x] = cell;
    }

    public boolean isFilled() {
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                if (field[y][x] == Game.emptyChar) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isWin(char cell) {
        for (int i = 0; i < size; i++) {
            if (field[i][0] == cell && field[i][1] == cell && field[i][2] == cell
                    || field[0][i] == cell && field[1][i] == cell && field[2][i] == cell) {
                return true;
            }
        }
        return field[0][0] == cell && field[1][1] == cell && field[2][2] == cell
                || field[0][2] == cell && field[1][1] == cell && field[2][0] == cell;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("---------\n");
        for (int y = 0; y < size; y++) {
            sb.append("|");
            for (int x = 0; x < size; x++) {
                char cell = field[y][x] == Game.emptyChar ? ' ' : field[y][x];
                sb.append(String.format(" %s", cell));
            }
            sb.append(" |\n");
        }
        sb.append("---------");
        return sb.toString();
    }

}
