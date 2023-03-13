import java.io.Console;
import java.util.ArrayList;
import java.util.Scanner;

public class Snap extends CardGame{
    public static ArrayList<Card> drawnCards = new ArrayList<>();
    public static void startGame() {
        CardGame snap = new CardGame();
        snap.getDeckOfCards();
        snap.shuffleDeck();
        Scanner s = new Scanner(System.in);
        boolean hasSnap = false;
        System.out.println("Initial Setup...");
        System.out.println("Drawing first card:");
        Card firstCard = snap.dealCard();
        drawnCards.add(firstCard);
        System.out.println(drawnCards);
        while(hasSnap == false) {
            snap.shuffleDeck();
            System.out.println("Drawn for turn: ");
            Card drawnCard = snap.dealCard();
            drawnCards.add(drawnCard);
            System.out.println(drawnCards);
            if(drawnCards.get(drawnCards.size() -1).getSymbol() == drawnCards.get(drawnCards.size() - 2).getSymbol()){
                hasSnap = true;
                System.out.printf("Snap! You have won :)");
            }
            else{
                System.out.printf("No Snap, press enter to continue");
                s.nextLine();

            }

        }
    }
}
