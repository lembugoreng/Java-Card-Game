import java.util.ArrayList;
import java.util.Random;

public class Game {

    public int countingScore(ArrayList<Hand> sortCards, Hand hand) {
        int club = 0;
        int heart = 0;
        int spade = 0;
        int diamond = 0;

        for (int i = 0; i < 5; i++) {
            switch (sortCards.get(i).getSuit()) {
                case "c":
                    club += hand.getFaceValue().get(sortCards.get(i).getFaceString());
                    break;
                case "d":
                    diamond += hand.getFaceValue().get(sortCards.get(i).getFaceString());
                    break;
                case "h":
                    heart += hand.getFaceValue().get(sortCards.get(i).getFaceString());
                    break;
                case "s":
                    spade += hand.getFaceValue().get(sortCards.get(i).getFaceString());
                    break;
            }
        }
        return Math.max(Math.max(heart, spade), Math.max(diamond, club));
    }

    public String[] chooseWinner(Player player1, Player player2, Player player3) {
        int lowestScore = Math.min(Math.min(player1.getScore(), player2.getScore()), player3.getScore());
        String winner1;
        String winner2;

        // FOR THREE PLAYERS WITH THE SAME SCORE
        if ((player1.getScore() == player2.getScore()) && (player2.getScore() == player3.getScore())) {
            int[] intArray1 = { 1, 2, 3 };
            int randyThreeWinner1 = intArray1[new Random().nextInt(intArray1.length)];

            // CHECKING FOR TWO PEOPLE RANDOMIZED
            if (randyThreeWinner1 == 1) {
                winner1 = player1.getName();
                int randyThreeWinner2 = (Math.random() <= 0.5) ? 2 : 3;

                if (randyThreeWinner2 == 2) {
                    winner2 = player2.getName();
                } else {
                    winner2 = player3.getName();
                }

            } else if (randyThreeWinner1 == 2) {
                winner1 = player2.getName();
                int randyThreeWinner2 = (Math.random() <= 0.5) ? 1 : 3;

                if (randyThreeWinner2 == 1) {
                    winner2 = player1.getName();
                } else {
                    winner2 = player3.getName();
                }

            } else {
                winner1 = player3.getName();
                int randyThreeWinner2 = (Math.random() <= 0.5) ? 1 : 2;

                if (randyThreeWinner2 == 1) {
                    winner2 = player1.getName();
                } else {
                    winner2 = player2.getName();
                }
            }
        }
        // For two players with same score
        else if (player1.getScore() == player2.getScore()) {
            winner1 = player3.getName();
            int randyTwoWinner = (Math.random() <= 0.5) ? 1 : 2;

            if (randyTwoWinner == 1) {
                winner2 = player1.getName();
            } else {
                winner2 = player2.getName();
            }

        } else if (player1.getScore() == player3.getScore()) {

            winner1 = player2.getName();
            int randyTwoWinner = (Math.random() <= 0.5) ? 1 : 2;

            if (randyTwoWinner == 1) {
                winner2 = player1.getName();
            } else {
                winner2 = player3.getName();
            }

        } else if (player2.getScore() == player3.getScore()) {
            winner1 = player1.getName();
            int randyTwoWinner = (Math.random() <= 0.5) ? 1 : 2;

            if (randyTwoWinner == 1) {
                winner2 = player2.getName();
            } else {
                winner2 = player3.getName();
            }

        } else {

            if (lowestScore == player1.getScore()) {
                winner1 = player2.getName();
                winner2 = player3.getName();
            } else if (lowestScore == player2.getScore()) {
                winner1 = player1.getName();
                winner2 = player3.getName();
            } else {
                winner1 = player1.getName();
                winner2 = player2.getName();
            }
        }
        String[] winnerArr = { winner1, winner2 };
        return winnerArr;
    }

    public String chooseWinner2(Player player1, Player player2) {
        String winner;
        if (player1.getScore() == player2.getScore()) {
            int randyTwoWinner = (Math.random() <= 0.5) ? 1 : 2;

            if (randyTwoWinner == 1) {
                winner = player1.getName();
            } else {
                winner = player2.getName();
            }
        } else if(player1.getScore() > player2.getScore()) {
            winner = player1.getName();
        } else {
            winner = player2.getName();
        }
        return winner;
    }
}