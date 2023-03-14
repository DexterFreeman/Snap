import java.io.Console;
import java.util.ArrayList;
import java.util.Scanner;
public class Snap extends CardGame{
    public static ArrayList<Card> drawnCards = new ArrayList<>();

    public static void startGame() {
        boolean isPlayerOneTurn = true;
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
            isPlayerOneTurn = !isPlayerOneTurn;
            snap.shuffleDeck();
            System.out.println("Drawn for turn: ");
            Card drawnCard = snap.dealCard();
            String lastCardDrawnInfo = drawnCards.get(drawnCards.size() -1).toString();
            drawnCards.add(drawnCard);
            String cardInfo = drawnCard.toString();
            System.out.println(lastCardDrawnInfo + " | " + cardInfo);
            if(drawnCards.get(drawnCards.size() -1).getSymbol() == drawnCards.get(drawnCards.size() - 2).getSymbol()){
                long startTime = System.currentTimeMillis();
                String input = s.nextLine().toLowerCase();
                long endTime = System.currentTimeMillis();
                long timeSpentInputting = endTime - startTime;
                if (input.equals("snap") && timeSpentInputting <= 2000){
                    hasSnap = true;
                    System.out.println("Snap! " + (isPlayerOneTurn ? "Player one" : "Player two") + " has won :)");
                }
                else{
                    System.out.println("There was a snap, but you either missed it or wasn't quick enough! Continue");
                }
            }
            else{
                System.out.printf("No Snap, press enter to continue");

                s.nextLine();

            }

        }
    }
}
