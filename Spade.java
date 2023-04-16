public class Spade implements Suit {

  int suit;

  Spade() {
    this.setSuit(3);
  }

  public void setSuit(int suit) {
    this.suit = suit;
  }

  public int getSuit() {
    return this.suit;
  }

  public String getSuitString() {
    return "Spade";
  }
}
