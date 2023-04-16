public class Heart implements Suit {

  int suit;

  Heart() {
    this.setSuit(2);
  }

  public void setSuit(int suit) {
    this.suit = suit;
  }

  public int getSuit() {
    return this.suit;
  }

  public String getSuitString() {
    return "Heart";
  }
}
