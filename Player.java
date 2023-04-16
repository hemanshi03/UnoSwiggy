import java.util.ArrayList;
import java.util.List;

public class Player {

  /*
   * Name of player
   */
  public String name;

  /*
   * Is player the winner
   */
  public boolean isWinner;

  /*
   * Player's current card's
   */
  private ArrayList<Card> cards;

  Player(String name) {
    this.name = name;
    this.cards = new ArrayList<>();
    this.isWinner = false;
  }

  public String getName() {
    return this.name;
  }

  public ArrayList<Card> getCards() {
    return this.cards;
  }

  public int getCardSize() {
    return this.cards.size();
  }

  /*
   * Get Players card at index
   */
  public Card getCardAtIndex(int index) {
    if (index < this.getCardSize()) return this.cards.get(
        index
      ); else return null;
  }

  /*
   * Adds card to player's deck
   */
  public void addCard(Card card) {
    this.cards.add(card);
  }

  /*
   * Remove card from player's deck
   */
  public void removeCard(int index) {
    this.cards.remove(index);
  }

  /*
   * Prints player current deck of card's
   */
  public void printDeck() {
    System.out.println("Cards of player " + this.getName());
    System.out.println("-----------------------------------------------------");

    for (int i = 0; i < this.cards.size(); i++) {
      Card card = this.cards.get(i);
      System.out.println(card.suit.getSuitString() + " " + card.getRank());
    }
    System.out.println(
      "---------------------------------------------------------"
    );
  }

  /*
   * Returns array of indices consisting cards that
   * player can play onTop of current card
   */
  private List<Integer> getPlayableCardsIndices(Card ontop) {
    List<Card> playerCurrentCards = new ArrayList<>();
    List<Integer> playAbleCards = new ArrayList<>();

    playerCurrentCards = this.getCards();

    for (int i = 0; i < playerCurrentCards.size(); i++) {
      Card checkCard = playerCurrentCards.get(i);
      if (
        checkCard.getSuit() == ontop.getSuit() ||
        checkCard.rank.getRank() == ontop.getRank()
      ) playAbleCards.add(i);
    }
    return playAbleCards;
  }

  /*
   * Return index of card that player wants to play from
   * the deck
   */
  public int playCard(Card ontop) {
    List<Integer> playAbleCards = getPlayableCardsIndices(ontop);
    int choosenCard = -1;

    if (playAbleCards.size() == 0) return -1; else {
      displayPlayableCards(playAbleCards);
      choosenCard = CustomUno.sc.nextInt();
    }
    return playAbleCards.get(choosenCard);
  }

  /*
   * Return true if player has Won
   */
  public boolean hasPlayerWon() {
    return this.isWinner;
  }

  /*
   * Display what card's can player play current
   * on the card onTop
   */
  public void displayPlayableCards(List<Integer> playAbleCardIndices) {
    for (int i = 0; i < playAbleCardIndices.size(); i++) {
      Card card = this.cards.get(playAbleCardIndices.get(i));
      System.out.println(
        i + ".  " + card.suit.getSuitString() + "  " + card.getRank()
      );
    }
  }
}
