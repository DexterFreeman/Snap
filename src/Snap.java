import jdk.jshell.execution.Util;

import java.io.Console;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;
public class Snap extends CardGame{
    public static ArrayList<Card> drawnCards = new ArrayList<>();

    int playerTwoWins = 0;
    public static void startGame() {

        CardGame snap = new CardGame();
        snap.getDeckOfCards();
        Scanner s = new Scanner(System.in);
        System.out.println("Player one: Input your name: ");
        String input = s.nextLine();
        Player playerOne = new Player(input, true, 0);
        System.out.println("Player Two: Input your name: ");
        input = s.nextLine();
        Player playerTwo = new Player(input,false, 0);
        boolean hasSnap = false;
        System.out.println("Drawing first card:");
        Card firstCard = snap.dealCard();
        drawnCards.add(firstCard);
        System.out.println(firstCard.toString());
        boolean gameOver = false;
        while (gameOver == false) {
            snap.shuffleDeck();
            while (hasSnap == false) {
                snap.shuffleDeck();
                String lastCardDrawnInfo = drawnCards.get(drawnCards.size() - 1).toString();
                System.out.println("Drawn for turn: ");
                drawnCards.add(snap.dealCard());
                System.out.println(lastCardDrawnInfo + " | " + drawnCards.get(drawnCards.size() - 1).toString());
                if (drawnCards.get(drawnCards.size() - 1).getSymbol() == drawnCards.get(drawnCards.size() - 2).getSymbol()) {
                    long startTime = System.currentTimeMillis();
                    input = s.nextLine().toLowerCase();
                    long endTime = System.currentTimeMillis();
                    if (input.equals("snap") && (startTime - endTime) <= 2000) {
                        hasSnap = true;
                        playerOne.setScore(playerOne.isTurn() ? playerOne.getScore() + 1 : playerOne.getScore());
                        playerTwo.setScore(!playerOne.isTurn() ? playerTwo.getScore() + 1 : playerTwo.getScore());
                        System.out.println("Snap! " + (playerOne.isTurn() ? playerOne.getName() : playerOne.getName()) + " has won :)");
                    } else {
                        System.out.println("There was a snap, but you either missed it or wasn't quick enough! Continue");
                    }
                } else {
                    System.out.printf("No Snap, press enter to continue");
                    s.nextLine();
                }
                playerOne.setTurn(!playerOne.isTurn());
                playerTwo.setTurn(!playerTwo.isTurn());
            }
            hasSnap = false;
            gameOver = Utils.isNewGame(playerOne.getScore(), playerTwo.getScore());
        }
    }
}
