package battleship;

import battleship.Exceptions.WrongCoordinatesException;

public class Vector2 implements Comparable<Vector2> {
    public int x;
    public int y;

    public Vector2(String coordinates) throws WrongCoordinatesException {
        this.x = Integer.parseInt(coordinates.substring(1));
        this.y = coordinates.charAt(0) - Field.alfaStart + 1;
        if(!this.valid()){
            throw new WrongCoordinatesException();
        }
    }

    @Override
    public int compareTo(Vector2 other) {
        return this.x - other.x + this.y - other.y;
    }

    private boolean valid() {
        return x >= 1 && x < Field.size + 1 && y >= 1 && y < Field.size + 1;
    }


    public static int Distance(Vector2 first, Vector2 second) {
        int length = Math.abs(first.x - second.x);
        if (length != 0) {
            return length + 1;
        }
        length = Math.abs(first.y - second.y);
        return length + 1;
    }

    @Override
    public String toString() {
        return String.format("Vector2(%c, %d)", (char) (y + Field.alfaStart), x);
    }

    public static boolean OnLine(Vector2 first, Vector2 second) {
        return first.x == second.x ^ first.y == second.y;
    }
}