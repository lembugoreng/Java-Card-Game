import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class main  {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    Interface hiding = new Interface();
    Hand hand = new Hand();
    
    hand.faceValue();
    hiding.start(input);

    do {
      hiding.creatingCards();
      hiding.gameStart();
    } while (hiding.pregameInput(input));

    for(int i = 1; i<4; i++) {
      System.out.println("*** ROUND " + i + " ***");
      hiding.roundStart(input, hand);
    }

    hiding.displayWinner(3);
    System.out.println("\n\n" + "******************" + "\n" + "* 2-Player Phase *" + "\n" + "******************");

    do {
      hiding.creatingCards();
      hiding.gameStart2();
      System.out.println();
    } while (hiding.pregameInput(input));

    for (int i = 1; i<5; i++) {
      System.out.println("*** ROUND " + i + " ***");
      hiding.TwoPlayerPhase(input, hand);
    }

    hiding.displayWinner(2);
  }

  public static ArrayList<Hand> returnfiveSorted(Player p) {
    ArrayList<Hand> sortCards = new ArrayList<>();

    sortCards = p.sortingCards();
    Comparator<Hand> comparator = Comparator // sorting by suit and face
            .comparing(Hand::getSuit).thenComparing(Hand::getFace);
    Collections.sort(sortCards, comparator);

    return sortCards;
  }
}