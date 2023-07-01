import java.util.HashMap;

public class Hand {
  private String suit;
  private String face;
  private HashMap<String, Integer> faceValues = new HashMap<>();

  public Hand() {
  }

  public Hand(String suit, String face) {
    this.suit = suit;
    this.face = face;
  }

  @Override
  public String toString() {
    return suit + face;
  }

  public String getSuit() {
    return this.suit;
  }

  public String getFaceString() {
    return this.face;
  }

  public int getFace() {
    if (this.face.equals("A")) {
      return 1;
    } else if (this.face.equals("X")) {
      return 10;
    } else if (this.face.equals("J")) {
      return 11;
    } else if (this.face.equals("Q")) {
      return 12;
    } else if (this.face.equals("K")) {
      return 13;
    } else {
      return Integer.valueOf(this.face);
    }
  }

  public void faceValue() {
    for (int i = 1; i < 11; i++) {
      if (i == 1) {
        faceValues.put("A", i);
      } else if (i == 10) {
        faceValues.put("X", i);
        faceValues.put("J", i);
        faceValues.put("Q", i);
        faceValues.put("K", i);
      } else {
        faceValues.put(Integer.toString(i), i);
      }
    }
  }

  public HashMap<String, Integer> getFaceValue() {
    return faceValues;
  }
  
}