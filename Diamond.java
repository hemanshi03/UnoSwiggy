public class Diamond implements Suit {

  /*
   * Defines rank of a card
   */
  int suit;

  Diamond() {
    this.setSuit(1);
  }

  /*
   * Getter and setters
   */
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
