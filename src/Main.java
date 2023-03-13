public class Main {
    public static void main(String[] args) {
        CardGame test = new CardGame();
        test.getDeckOfCards();
        System.out.println(test.getDeck());
        System.out.println(test.dealCard());
    }
}