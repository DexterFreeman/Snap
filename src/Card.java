import java.util.Arrays;
import java.util.Comparator;

public class Card {
    private String suit;
    private String symbol;
    private int value;

    public Card(String suit, String symbol, int value) {
        this.suit = suit;
        this.symbol = symbol;
        this.value = value;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return symbol + " " +
                "of " + suit;
    }

    public void printCard() {
        String[] suits = {"♠", "♥", "♦", "♣"};
        String[] symbols = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        int suitIndex = Arrays.asList(suits).indexOf(this.suit);
        int symbolIndex = Arrays.asList(symbols).indexOf(this.symbol);
        String[][] card = {
                {"┌──────────┐"},
                {"│" + this.symbol + "        │"},
                {"│         │"},
                {"│    " + suits[suitIndex] + "    │"},
                {"│         │"},
                {"│        " + this.symbol + "│"},
                {"└──────────┘"}
        };
        for (String[] row : card) {
            System.out.println(row[0]);
        }
    }
}
