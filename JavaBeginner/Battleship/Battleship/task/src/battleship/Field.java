package battleship;

import battleship.Exceptions.PlacedTooCloseException;
import battleship.Exceptions.WrongCoordinatesException;

import java.util.Scanner;

public class Field {
    Scanner scanner = new Scanner(System.in);
    static char alfaStart = 'A';

    static final char emptyChar = '~';
    static final char shipChar = 'O';


    static final int size = 10;
    private char[][] field;

    public String getField(boolean showShips) {
        StringBuilder fieldStr;
        fieldStr = new StringBuilder("\n");
        fieldStr.append("  1 2 3 4 5 6 7 8 9 10\n");
        for (int i = 0; i < size; i++) {
            fieldStr.append((char) (alfaStart + i));
            for (int j = 1; j < size + 1; j++) {
                fieldStr.append(" ");
                char cell = field[i + 1][j];
                if (!showShips && cell == shipChar) {
                    cell = emptyChar;
                }
                fieldStr.append(cell);
            }
            fieldStr.append("\n");
        }
        return fieldStr.toString();
    }

    private Ship[] ships = new Ship[]{
            new Ship("Aircraft Carrier", 5),
            new Ship("Battleship", 4),
            new Ship("Submarine", 3),
            new Ship("Cruiser", 3),
            new Ship("Destroyer", 2)
    };

    public Field() {
        initField();
    }

    private void initField() {
        field = new char[size + 2][size + 2];
        for (int i = 0; i < size + 2; i++) {
            for (int j = 0; j < size + 2; j++) {
                field[i][j] = emptyChar;
            }
        }
    }

    public void placeShips() {
        System.out.println(getField(true));
        for (int i = 0; i < ships.length; ) {
            System.out.println("Enter the coordinates of the " + ships[i] + ":");
            String[] input = scanner.nextLine().split(" ");
            Ship ship = ships[i];
            try {
                Vector2 start = new Vector2(input[0]);
                Vector2 end = new Vector2(input[1]);
                ship.setCoordinates(start, end);
                if (closeShips(ship)) {
                    throw new PlacedTooCloseException();
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
                continue;
            }
            placeShip(ship);
            i++;
            System.out.println(getField(true));
        }
    }

    private boolean closeShips(Ship ship) {
        for (int y = ship.start.y - 1; y <= ship.end.y + 1; y++) {
            for (int x = ship.start.x - 1; x <= ship.end.x + 1; x++) {
                if (field[y][x] == shipChar) {
                    return true;
                }
            }
        }
        return false;
    }

    private void placeShip(Ship ship) {
        for (int y = ship.start.y; y <= ship.end.y; y++) {
            for (int x = ship.start.x; x <= ship.end.x; x++) {
                field[y][x] = shipChar;
            }
        }
    }

    public void shot() {
        Vector2 point;
        while (true) {
            String input = scanner.nextLine();
            try {
                point = new Vector2(input);
            } catch (WrongCoordinatesException e) {
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }
        HitState hitState = HitState.Missed;
        for (int i = 0; i < ships.length; i++) {
            if (ships[i].isHit(point)) {
                hitState = ships[i].isSank() ? HitState.Sank : HitState.Hit;
            }
        }
        System.out.println(hitState.message);
        field[point.y][point.x] = hitState.cellState;
    }

    public boolean IsAllShipsSank() {
        for (char[] chars : field) {
            for (char cell : chars) {
                if (cell == shipChar) {
                    return false;
                }
            }
        }
        return true;
    }
}
