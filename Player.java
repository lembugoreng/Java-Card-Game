import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Player {

  protected String name;
  protected int score = 0;
  protected List<String> playercard;
  protected Queue<String> cardsathand;
  protected ArrayList<Hand> hand;

  public Player() {
  }

  public Player(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
 
  public int getScore() {
    return score;
  }
  
  public void setScore(int score) {
    this.score += score;
  }
  
  public List<String> getPlayerCard() {
    return playercard;
  }

  public void PlayerReceiveCard(Queue<String> queueplayerCard) {
    playercard = new ArrayList<>();
    cardsathand = new LinkedList<>();
    for (int i = 0; i < 26; i++) {
      cardsathand.add(queueplayerCard.peek()); // Sorting values
      playercard.add(queueplayerCard.remove()); // Display  
    }
  }

  public ArrayList<Hand> sortingCards() {
    hand = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      String tempString = cardsathand.remove(); 
      playercard.remove(0);
      String[] temparray = tempString.split("");
      hand.add(new Hand(temparray[0], temparray[1]));
    }
    return hand;
  }

  public void displayplayerCard() {
    int cardCount = 5;

    for (int i = 0; i < this.playercard.size(); i++) {

      if (i == cardCount - 1) {
        System.out.print(this.playercard.get(i) + ", ");
        cardCount += 5;
      } else {
        System.out.print(this.playercard.get(i) + " ");
      }
    }
  }
}
