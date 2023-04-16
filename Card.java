class Card {

  Rank rank;
  Suit suit;

  /*
   * A card is defined by its Rank and Suit
   * Rank (1 (Ace/Skip), 2 ,3, 4, 5, 6, 7, 8, 9, 10, 11 (Jack/+4), 12 (Queen/+2), 13(King/Reverse))
   * Suit (Club, Diamond, Heart, Diamond)
   */

  Card(Rank rank, Suit suit) {
    this.rank = rank;
    this.suit = suit;
  }

  public int getSuit() {
    return this.suit.getSuit();
  }

  public String getSuitString() {
    return this.suit.getSuitString();
  }

  public int getRank() {
    return this.rank.getRank();
  }

  public String toString() {
    return this.getSuitString() + " " + this.getRank();
  }

  public boolean cardIsActionCard() {
    return (
      this.getRank() == 0 ||
      this.getRank() == 11 ||
      this.getRank() == 12 ||
      this.getRank() == 13
    );
  }

  public boolean cardIsNumberCard() {
    return !this.cardIsActionCard();
  }

  public boolean isCardAce(Card card) {
    if (card.getRank() == 0) return true;
    return false;
  }

  public boolean isCardJack(Card card) {
    if (card.getRank() == 11) return true;
    return false;
  }

  public boolean isCardQueen(Card card) {
    if (card.getRank() == 12) return true;
    return false;
  }

  public boolean isCardKing(Card card) {
    if (card.getRank() == 13) return true;
    return false;
  }

  public char[][] draw() {
    char[][] a = new char[5][5];
    return a;
  }
}
