import java.util.ArrayList;
import java.util.List;

public class Player {

  public String name;
  public boolean isWinner;
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

  public Card getCardAtIndex(int index) {
    if (index < this.getCardSize()) return this.cards.get(
        index
      ); else return null;
  }

  public void addCard(Card card) {
    this.cards.add(card);
  }

  public void removeCard(int index) {
    this.cards.remove(index);
  }

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

  public int playCard(Card ontop) {
    List<Integer> playAbleCards = getPlayableCardsIndices(ontop);
    int choosenCard = -1;

    if (playAbleCards.size() == 0) return -1; else {
      displayPlayableCards(playAbleCards);
      choosenCard = CustomUno.sc.nextInt();
    }
    return playAbleCards.get(choosenCard);
  }

  public boolean hasPlayerWon() {
    return this.isWinner;
  }

  public void displayPlayableCards(List<Integer> playAbleCardIndices) {
    for (int i = 0; i < playAbleCardIndices.size(); i++) {
      Card card = this.cards.get(playAbleCardIndices.get(i));
      System.out.println(
        i + ".  " + card.suit.getSuitString() + "  " + card.getRank()
      );
    }
  }
}
