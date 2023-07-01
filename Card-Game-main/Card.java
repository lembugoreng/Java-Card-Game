import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Card {

    // 2 player phase
    private List<String> suit;
    private List<String> cards;
    private List<String> cardValues;
    private Queue<String> queueplayerCard;

    public void SuitValue() {
        suit = new ArrayList<>();
        suit.add("d");
        suit.add("s");
        suit.add("h");
        suit.add("c");
    }

    public List<String> valuesCard() {
        cardValues = new LinkedList<>();
        for (int i = 2; i < 10; i++) {
            cardValues.add(Integer.toString(i));
        }
        cardValues.add("A");
        cardValues.add("K");
        cardValues.add("Q");
        cardValues.add("J");
        cardValues.add("X");

        return cardValues;
    }

    public void processCards() { // Creation of 52 cards
        cards = new LinkedList<>();
        for (int i = 0; i < suit.size(); i++) {
            for (int j = 0; j < cardValues.size(); j++) {
                cards.add(suit.get(i) + cardValues.get(j));                
            }
        }
    }

    public List<String> getCards() {
        return cards;
    }

    public void shuffleCards(){
        Collections.shuffle(cards);
    }

    public void LinkedtoQueueCard(){
        queueplayerCard = new LinkedList<>(getCards());
    }

    public Queue<String> getcardQueue() {
        return this.queueplayerCard;
    }
}