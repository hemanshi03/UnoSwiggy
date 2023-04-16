public class Club implements Suit {

  int suit;

  Club() {
    this.setSuit(0);
  }

  public void setSuit(int suit) {
    this.suit = suit;
  }

  public int getSuit() {
    return this.suit;
  }

  public String getSuitString() {
    return "Club";
  }
}
