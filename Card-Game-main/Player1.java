import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Player1 extends Player {

  public Player1() {
  }

  public Player1(String name) {
    super(name);
  }
  
  @Override
  public void PlayerReceiveCard(Queue<String> queueplayerCard)
    {   playercard = new ArrayList<>();
        cardsathand = new LinkedList<>();
        for(int i = 0; i < 18; i++)
        {
          cardsathand.add(queueplayerCard.peek()); //Sorting values
          playercard.add(queueplayerCard.remove()); //Display 18 cards
        }
    }
}