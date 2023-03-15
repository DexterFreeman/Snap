public class Player {
    private String name;
    private boolean isTurn;
    private int score;

    public Player(String name, boolean isTurn, int score) {
        this.name = name;
        this.isTurn = isTurn;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isTurn() {
        return isTurn;
    }

    public void setTurn(boolean turn) {
        isTurn = turn;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
