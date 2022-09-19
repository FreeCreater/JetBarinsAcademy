package tictactoe;

public enum PlayerDifficulty {
    User("user"),
    Easy("easy"),
    Medium("medium"),
    Hard("hard");

    public final String key;

    static PlayerDifficulty getValue(String key) {
        for(PlayerDifficulty e: PlayerDifficulty.values()) {
            if(e.key.equals(key)) {
                return e;
            }
        }
        return null;
    }

    PlayerDifficulty(String key){
        this.key = key;
    }
}
