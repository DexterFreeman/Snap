import java.io.Console;
import java.util.ArrayList;
import java.util.Scanner;
public class Snap extends CardGame{
    public static ArrayList<Card> drawnCards = new ArrayList<>();

    int playerTwoWins = 0;
    public static void startGame() {
        Player playerOne = new Player("One", true, 0);
        Player playerTwo = new Player("Two", false, 0);
        CardGame snap = new CardGame();
        snap.getDeckOfCards();
        Scanner s = new Scanner(System.in);
        boolean hasSnap = false;
        System.out.println("Initial Setup...");
        System.out.println("Drawing first card:");
        Card firstCard = snap.dealCard();
        drawnCards.add(firstCard);
        System.out.println(drawnCards);
        boolean gameOver = false;
        while (gameOver == false) {
            snap.shuffleDeck();
            while (hasSnap == false) {
                playerOne.setTurn(!playerOne.isTurn());
                playerTwo.setTurn(!playerTwo.isTurn());
                snap.shuffleDeck();
                System.out.println("Drawn for turn: ");
                Card drawnCard = snap.dealCard();
                String lastCardDrawnInfo = drawnCards.get(drawnCards.size() - 1).toString();
                drawnCards.add(drawnCard);
                String cardInfo = drawnCard.toString();
                System.out.println(lastCardDrawnInfo + " | " + cardInfo);
                if (drawnCards.get(drawnCards.size() - 1).getSymbol() == drawnCards.get(drawnCards.size() - 2).getSymbol()) {
                    long startTime = System.currentTimeMillis();
                    String input = s.nextLine().toLowerCase();
                    long endTime = System.currentTimeMillis();
                    long timeSpentInputting = endTime - startTime;
                    if (input.equals("snap") && timeSpentInputting <= 2000) {
                        hasSnap = true;
                        if (playerOne.isTurn()) {
                            playerOne.setScore(playerTwo.getScore() + 1);
                        } else {
                            playerTwo.setScore(playerTwo.getScore() + 1);
                        }
                        System.out.println("Snap! " + (playerOne.isTurn() ? "Player one" : "Player two") + " has won :)");
                    } else {
                        System.out.println("There was a snap, but you either missed it or wasn't quick enough! Continue");
                    }
                } else {
                    System.out.printf("No Snap, press enter to continue");

                    s.nextLine();

                }

            }
            System.out.println("Player one wins: " + playerOne.getScore());
            System.out.println("Player two wins: " + playerTwo.getScore());
            System.out.println("Play again? Y/N");
            String input = s.nextLine().toLowerCase();
            if(input.equals("y") || input.equals("yes")){
                System.out.println("Playing again...");
                hasSnap = false;
            }
            else {
                gameOver = true;
            }


        }
    }
}
