package battleship;

public enum HitState {


    Missed("You missed!", HitState.missedChar),
    Hit("You hit a ship!", HitState.hitChar),
    Sank("You sank a ship!", HitState.hitChar);

    static final char hitChar = 'X';
    static final char missedChar = 'M';

    public final String message;
    public final char cellState;

    private HitState(String message, char cellState) {
        this.message = message;
        this.cellState = cellState;
    }

}
