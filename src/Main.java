public class Main {
    public static void main(String[] args) {
        CardGame test = new CardGame();
        test.getDeckOfCards();
        test.sortDeckInNumberOrder();
        System.out.println(test.getDeck());
        test.sortDeckIntoSuits();
        System.out.println(test.getDeck());
        test.shuffleDeck();
        System.out.println(test.getDeck());
    }
}