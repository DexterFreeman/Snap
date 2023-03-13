import java.util.ArrayList;

public class CardGame {

    String[] suits = {"Clubs", "Hearts", "Diamonds", "Spades"};
    String[] symbols = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};


    public ArrayList<Card> deckOfCards = new ArrayList<>();

    public ArrayList<Card> getDeckOfCards() {
        for (String suit: suits){
            int index = 1;
            for(String symbol: symbols){
                deckOfCards.add(new Card(suit, symbol, index));
                index++;
            }
        }
        return deckOfCards;
    }

    public ArrayList<Card> getDeck(){
        for (Card card: deckOfCards) {
            System.out.println(card.toString());
        }
        return deckOfCards;
    }

    public Card dealCard(){
        return deckOfCards.get(0);
    }
}
