import java.util.ArrayList;
import java.util.Scanner;

public class Interface {
    Card newcard = new Card();
    // 3 player phase
    Player p1;
    Player p2;
    Player p3;

    // 2 player phase
    Player player1;
    Player player2;

    ArrayList<Hand> p1tempcardstorefive;
    ArrayList<Hand> p2tempcardstorefive;
    ArrayList<Hand> p3tempcardstorefive;

    ArrayList<Hand> player1tempcardstorefive;
    ArrayList<Hand> player2tempcardstorefive;

    String[] winnerArray;

    Game gameObj = new Game();

    int countRound = 0;
    int countRound2 = 0;

    public void creatingCards() {
        newcard.SuitValue();
        newcard.valuesCard();
        newcard.processCards();
        newcard.shuffleCards();
        newcard.LinkedtoQueueCard();
    }

    public void start(Scanner input) {
        System.out.println("******************" + "\n" + "* 3-Player Phase *" + "\n" + "******************");
        System.out.print("Enter player 1 name: ");
        p1 = new Player1(input.nextLine());
        System.out.print("Enter player 2 name: ");
        p2 = new Player2n3(input.nextLine());
        System.out.print("Enter player 3 name: ");
        p3 = new Player2n3(input.nextLine());
        System.out.println();
    }

    public void gameStart() {
        p1.PlayerReceiveCard(newcard.getcardQueue()); // Get 18 cards in queue form 52 - 18
        p2.PlayerReceiveCard(newcard.getcardQueue());
        p3.PlayerReceiveCard(newcard.getcardQueue());
        System.out.println("Available Cards:");
        System.out.print(p1.getName() + ": ");
        p1.displayplayerCard();
        System.out.println();
        System.out.print(p2.getName() + ": ");
        p2.displayplayerCard();
        System.out.println();
        System.out.print(p3.getName() + ": ");
        p3.displayplayerCard();
        System.out.println("\n");
    }

    public void roundStart(Scanner input, Hand hand) {
        System.out.println("Cards at Hand: ");
        // First player
        p1tempcardstorefive = new ArrayList<>((main.returnfiveSorted(p1))); // temporarily store the 5 cards
        int p1TempScore = gameObj.countingScore(p1tempcardstorefive, hand);
        
        // Second player
        p2tempcardstorefive = new ArrayList<>(main.returnfiveSorted(p2)); // temporarily store the 5 cards
        int p2TempScore = gameObj.countingScore(p2tempcardstorefive, hand);

        // Third player
        p3tempcardstorefive = new ArrayList<>(main.returnfiveSorted(p3)); // temporarily store the 5 cards
        int p3TempScore = gameObj.countingScore(p3tempcardstorefive, hand);

        int tempwinner = Math.max(Math.max(p1TempScore, p2TempScore), p3TempScore);

        if ((p1TempScore == p2TempScore) && (p1TempScore == p3TempScore)) {
            p1.setScore(tempwinner);
            p2.setScore(tempwinner);
            p3.setScore(tempwinner);

            System.out.print(p1.getName() + ": ");
            System.out.println(p1tempcardstorefive + " | Point = " + p1TempScore + " | Win");
            System.out.print(p2.getName() + ": ");
            System.out.println(p2tempcardstorefive + " | Point = " + p2TempScore + " | Win");
            System.out.print(p3.getName() + ": ");
            System.out.println(p3tempcardstorefive + " | Point = " + p3TempScore + " | Win");
        } else if ((tempwinner == p1TempScore) && (p1TempScore == p2TempScore)) {// Check for p1 and p2 same score
            p1.setScore(p1TempScore);
            p2.setScore(p2TempScore);

            System.out.print(p1.getName() + ": ");
            System.out.println(p1tempcardstorefive + " | Point = " + p1TempScore + " | Win");
            System.out.print(p2.getName() + ": ");
            System.out.println(p2tempcardstorefive + " | Point = " + p2TempScore + " | Win");
            System.out.print(p3.getName() + ": ");
            System.out.println(p3tempcardstorefive + " | Point = " + p3TempScore);
        } else if ((tempwinner == p1TempScore) && (p1TempScore == p3TempScore)) {
            p1.setScore(p1TempScore);
            p3.setScore(p3TempScore);

            System.out.print(p1.getName() + ": ");
            System.out.println(p1tempcardstorefive + " | Point = " + p1TempScore + " | Win");
            System.out.print(p2.getName() + ": ");
            System.out.println(p2tempcardstorefive + " | Point = " + p2TempScore);
            System.out.print(p3.getName() + ": ");
            System.out.println(p3tempcardstorefive + " | Point = " + p3TempScore + " | Win");
        } else if ((tempwinner == p2TempScore) && (p2TempScore == p3TempScore)) {
            p2.setScore(p2TempScore);
            p3.setScore(p3TempScore);

            System.out.print(p1.getName() + ": ");
            System.out.println(p1tempcardstorefive + " | Point = " + p1TempScore);
            System.out.print(p2.getName() + ": ");
            System.out.println(p2tempcardstorefive + " | Point = " + p2TempScore + " | Win");
            System.out.print(p3.getName() + ": ");
            System.out.println(p3tempcardstorefive + " | Point = " + p3TempScore + " | Win");
        } else if (tempwinner == p1TempScore) {

            p1.setScore(tempwinner);
            System.out.print(p1.getName() + ": ");
            System.out.println(p1tempcardstorefive + " | Point = " + p1TempScore + " | Win");
            System.out.print(p2.getName() + ": ");
            System.out.println(p2tempcardstorefive + " | Point = " + p2TempScore);
            System.out.print(p3.getName() + ": ");
            System.out.println(p3tempcardstorefive + " | Point = " + p3TempScore);

        } else if (tempwinner == p2TempScore) {
            p2.setScore(tempwinner);
            System.out.print(p1.getName() + ": ");
            System.out.println(p1tempcardstorefive + " | Point = " + p1TempScore);
            System.out.print(p2.getName() + ": ");
            System.out.println(p2tempcardstorefive + " | Point = " + p2TempScore + " | Win");
            System.out.print(p3.getName() + ": ");
            System.out.println(p3tempcardstorefive + " | Point = " + p3TempScore);

        } else {
            p3.setScore(tempwinner);
            System.out.print(p1.getName() + ": ");
            System.out.println(p1tempcardstorefive + " | Point = " + p1TempScore);
            System.out.print(p2.getName() + ": ");
            System.out.println(p2tempcardstorefive + " | Point = " + p2TempScore);
            System.out.print(p3.getName() + ": ");
            System.out.println(p3tempcardstorefive + " | Point = " + p3TempScore + " | Win");
        }

        System.out.println();
        System.out.println("Score:");
        System.out.println(p1.getName() + " = " + p1.getScore());
        System.out.println(p2.getName() + " = " + p2.getScore());
        System.out.println(p3.getName() + " = " + p3.getScore());

        System.out.println("\n" + "Available Cards: ");
        System.out.print(p1.getName() + ": ");
        p1.displayplayerCard();
        System.out.println();
        System.out.print(p2.getName() + ": ");
        p2.displayplayerCard();
        System.out.println();
        System.out.print(p3.getName() + ": ");
        p3.displayplayerCard();
        System.out.println("\n");

        if (countRound != 2) {
            System.out.println("Press ENTER to next round.");

            while (true) {
                String readString = input.nextLine();
                if (readString.isEmpty())
                    System.out.println();
                    break;
            }
            countRound++;
        }
    }

    public boolean pregameInput(Scanner input) {
        System.out.println("Press S to Shuffle or ENTER to start.");

        while (true) {
            String readString = input.nextLine().toUpperCase();
            if (readString.isEmpty()) {
                System.out.println("<Enter is pressed>" + "\n" + "\n");
                return false;
            } else if (readString.equals("S")) {
                System.out.println("<S is pressed>" + "\n" + "\n");
                return true;
            }
        }
    }

    public void displayWinner(int i) {
        if(i==3) {
            winnerArray = gameObj.chooseWinner(p1, p2, p3);
            System.out.println("***** " + winnerArray[0] + " and " + winnerArray[1] + " proceed to 2-Player phase *****");
        } else if(i==2) {
            String winner = gameObj.chooseWinner2(player1, player2);
            System.out.println("***** " + winner + " is the WINNER! *****");
        }
    }

    public void gameStart2() {
        player1 = new Player(winnerArray[0]);
        player2 = new Player(winnerArray[1]);

        player1.PlayerReceiveCard(newcard.getcardQueue()); // Get 18 cards in queue form 52 - 18
        player2.PlayerReceiveCard(newcard.getcardQueue());
        System.out.println("Available Cards:");
        System.out.print(player1.getName() + ": ");
        player1.displayplayerCard();
        System.out.println();
        System.out.print(player2.getName() + ": ");
        player2.displayplayerCard();
        System.out.println();
    }

    public void TwoPlayerPhase(Scanner input, Hand hand) {

        System.out.println("Cards at Hand: ");
        // First player
        player1tempcardstorefive = new ArrayList<>((main.returnfiveSorted(player1))); // temporarily store the 5 cards
        int player1TempScore = gameObj.countingScore(player1tempcardstorefive, hand);

        // Second player
        player2tempcardstorefive = new ArrayList<>(main.returnfiveSorted(player2)); // temporarily store the 5 cards
        int player2TempScore = gameObj.countingScore(player2tempcardstorefive, hand);

        int winner = Math.max(player1TempScore, player2TempScore);

        if((winner == player1TempScore) && (player1TempScore == player2TempScore)) {
            player1.setScore(winner);
            player2.setScore(winner);
            System.out.print(player1.getName() + ": ");
            System.out.println(player1tempcardstorefive + " | Point = " + player1TempScore + " | Win");
            System.out.print(player2.getName() + ": ");
            System.out.println(player2tempcardstorefive + " | Point = " + player2TempScore + " | Win");
        } else if (winner == player1TempScore) {
            player1.setScore(winner);
            System.out.print(player1.getName() + ": ");
            System.out.println(player1tempcardstorefive + " | Point = " + player1TempScore + " | Win");
            System.out.print(player2.getName() + ": ");
            System.out.println(player2tempcardstorefive + " | Point = " + player2TempScore);
        } else if (winner == player2TempScore) {
            player2.setScore(winner);
            System.out.print(player1.getName() + ": ");
            System.out.println(player1tempcardstorefive + " | Point = " + player1TempScore);
            System.out.print(player2.getName() + ": ");
            System.out.println(player2tempcardstorefive + " | Point = " + player2TempScore + " | Win");
        }
        
        System.out.println();
        System.out.println("Score:");
        System.out.println(player1.getName() + " = " + player1.getScore());
        System.out.println(player2.getName() + " = " + player2.getScore());

        System.out.println("\n" + "Available Cards: ");
        System.out.print(player1.getName() + ": ");
        player1.displayplayerCard();
        System.out.println();
        System.out.print(player2.getName() + ": ");
        player2.displayplayerCard();
        System.out.println("\n");

        if (countRound2 != 3) {
            System.out.println("Press ENTER to next round.");

            while (true) {
                String readString = input.nextLine();
                if (readString.isEmpty())
                    System.out.println();
                    break;
            }
            countRound2++;
        }
    }
}