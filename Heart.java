public class Heart implements Suit {

  /*
   * Defines rank of a card
   */
  int suit;

  Heart() {
    this.setSuit(2);
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
    return "Heart";
  }
}
