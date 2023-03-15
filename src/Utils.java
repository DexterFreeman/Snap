import java.util.Scanner;

public class Utils {
    static Scanner s = new Scanner(System.in);
    public static boolean isNewGame(int playerOneScore, int playerTwoScore){
        System.out.println("Player one wins: " + playerOneScore);
        System.out.println("Player two wins: " + playerTwoScore);
        System.out.println("Play again? Y/N");
        String input = s.nextLine().toLowerCase();
        if(input.equals("y") || input.equals("yes")){
            System.out.println("Playing again...");
            return false;
        }
        else {
            return true;
        }
    }
}
