public class Diamond implements Suit {

  int suit;

  Diamond() {
    this.setSuit(1);
  }

  public void setSuit(int suit) {
    this.suit = suit;
  }

  public int getSuit() {
    return this.suit;
  }

  public String getSuitString() {
    return "Diamond";
  }
}
