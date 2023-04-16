public class Club implements Suit {

  /*
   * Defines rank of a card
   */
  int suit;

  Club() {
    this.setSuit(0);
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
    return "Club";
  }
}
