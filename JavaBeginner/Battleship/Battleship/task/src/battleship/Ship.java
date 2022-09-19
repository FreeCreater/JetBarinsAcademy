package battleship;

import battleship.Exceptions.WrongLengthException;
import battleship.Exceptions.WrongShipLocationException;

public class Ship {
    private String name;
    private int length;

    private int hp;

    Vector2 start;
    Vector2 end;


    public Ship(String name, int length) {
        this.name = name;
        this.length = length;
        this.hp = length;
    }

    public void setCoordinates(Vector2 start, Vector2 end) throws WrongShipLocationException, WrongLengthException {
        if (end.compareTo(start) > 0) {
            this.start = start;
            this.end = end;
        } else {
            this.end = start;
            this.start = end;
        }

        if (!Vector2.OnLine(start, end)) {
            throw new WrongShipLocationException();
        }
        if (Vector2.Distance(start, end) != this.length) {
            throw new WrongLengthException(this.name);
        }
    }

    @Override
    public String toString() {
        return String.format("%s (%d cells)", name, length);
    }

    public boolean isHit(Vector2 point) {
        if (point.x >= start.x && point.x <= end.x && point.y >= start.y && point.y <= end.y) {
            this.hp--;
            return true;
        }
        return false;
    }

    public boolean isSank() {
        return hp <= 0;
    }
}
