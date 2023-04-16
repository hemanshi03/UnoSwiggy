public class Spade implements Suit {

  /*
   * Defines rank of a card
   */
  int suit;

  Spade() {
    this.setSuit(3);
  }

  /*
   * Getters and Setters
   */
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
