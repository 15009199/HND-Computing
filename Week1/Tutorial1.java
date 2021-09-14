import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;

public class Tutorial1 {

    //Declares "kboard" as an object of Scanner classy
    static Scanner kboard = new Scanner(System.in);

    public static void main(String[] args) {
        String choice = "y";
        int gamesPlayed = 0;
        int gamesWon = 0;
        int houseScore, card1, card2, newcard, playerScore;
        ArrayList<Integer> playerCardsHistory = new ArrayList<Integer>();

        while (choice.equalsIgnoreCase("y") && gamesPlayed < 5) {

            boolean playerBusted = false;
            houseScore = generateHouseScore(17, 21); // house always scores more than 16 and doesn't go over the 21 limit
            card1 = getRandomNumber();
            card2 = getRandomNumber();
            ArrayList<Integer> playerCards = new ArrayList<Integer>();
            gamesPlayed++;
            playerScore = card1 + card2;
            playerCards.add(card1);
            playerCards.add(card2);
            playerCardsHistory.add(card1);
            playerCardsHistory.add(card2);

            System.out.println("card one: " + card1 + " | card two: " + card2);
            System.out.println("would you like another card (y/n)?");
            choice = kboard.next();

            while (choice.equalsIgnoreCase("y")) {
                newcard = getRandomNumber();
                playerCards.add(newcard);
                playerCardsHistory.add(newcard);
                System.out.println("new card: " + newcard);

                playerScore = calcPlayerScore(playerScore, newcard);
                System.out.println("total: " + playerScore);

                if (busted(playerScore)) {
                    playerBusted = true;
                    break;
                }

                System.out.println("would you like another card (y/n)?");
                choice = kboard.next();
            }

            if (!playerBusted) {
                boolean result = getResult(playerScore, houseScore);
                if (result) {
                    gamesWon++;
                }
            }

            System.out.println("cards drawn: " + playerCards);

            if (gamesPlayed >= 5) {
                System.out.println("(5/5) games played, thanks for playing!");
                break;
            } else {
                System.out.println("("+gamesPlayed+"/5) games played, next game (y/n)?");
            }

            choice = kboard.next();

        }
        int winPercentage = (int) Math.round((double) gamesWon / gamesPlayed * 100);

        System.out.println("number of games won: "+gamesWon+"/"+gamesPlayed+" ("+winPercentage+")%");

        for (int i = 1; i < 11; i++) {
            int occurrences = Collections.frequency(playerCardsHistory, i);
            System.out.println(i+" shows: "+occurrences+" times");
        }

    }

    public static int getRandomNumber() {
        int value = (int)(Math.random()*9) + 1;
        return value;
    }

    public static int calcPlayerScore(int x, int y){
        int playerScore = x + y;
        return playerScore;
    }

    public static boolean getResult(int z, int j) {
        if (z > j && z <= 21) {
            System.out.println("you have won with "+z+" the house has "+j);
            return true;
        } else {
            System.out.println("you have lost with "+z+" the house has "+j);
            return false;
        }
    }

    public static boolean busted(int z) {
        if (z > 21) {
            System.out.println("you have lost - you went over 21");
            return true;
        } else {
            return false;
        }
    }

    public static int generateHouseScore(int min, int max) {
        int score = min + (int)(Math.random() * ((max - min) + 1));
        return score;
    }
}










