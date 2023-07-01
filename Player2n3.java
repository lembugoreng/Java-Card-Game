import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Player2n3 extends Player {

  public Player2n3() {
  }
  
  public Player2n3(String name) {
      super(name);
  }
    
    @Override
    public void PlayerReceiveCard(Queue<String> queueplayerCard)
    {   playercard = new ArrayList<>();
        cardsathand = new LinkedList<>();
        for(int i = 0; i < 17; i++)
        {
          cardsathand.add(queueplayerCard.peek()); //Sorting values
          playercard.add(queueplayerCard.remove()); //Display
        }
    }
}