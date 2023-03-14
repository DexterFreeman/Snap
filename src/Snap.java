import java.io.Console;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;


public class Snap extends CardGame{
    public static ArrayList<Card> drawnCards = new ArrayList<>();
    public static Timer timer = new Timer();
    public static boolean inputReceived = false;
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
                timer.schedule(new TimerTask(){
                    @Override
                    public void run(){
                        synchronized (s){
                            if(!inputReceived){
                                System.out.println("There was a snap, however you didn't type snap.");
                            }
                        }
                    }
                }, 2000);
                String input = s.nextLine();
                synchronized(s) {
                    inputReceived = true;
                }
                System.out.println("You entered: " + input);
                hasSnap = true;
                System.out.println("Snap! " + (isPlayerOneTurn ? "Player one" : "Player two") + " has won :)");
            }
            else{
                System.out.printf("No Snap, press enter to continue");

                s.nextLine();

            }

        }
    }
}
