import java.util.ArrayList;
import java.util.List;

public class Game {

  /*
   * Indicate player's turn
   */
  int turn;

  /*
   * Reference of Deck Class
   */
  Deck deck;

  /*
   * Array of players
   */
  Player players[];

  /*
   * Discarded / Played Cards
   */
  List<Card> discardedCards;

  /*
   * return true Should next turn be reversed?
   */
  boolean reverse;

  Game(int numOfPlayer) {
    this.deck = new Deck();
    this.players = new Player[numOfPlayer];
    this.turn = 0;
    this.discardedCards = new ArrayList<>();
    this.reverse = false;
  }

  /*
   * Return true if turns reversed
   */
  boolean isTurnReversed() {
    return this.reverse;
  }

  /*
   * setReverse to value
   * Remove played card from Player's deck
   */
  void setReverse(boolean val, Card playedCard, int index) {
    Player currentPlayer = this.getCurrrentPlayer();
    currentPlayer.removeCard(index);

    System.out.println("Turns are reversed");
    this.addToDeck(playedCard);
    this.reverse = val;
  }

  /*
   * Sets turn
   */
  void setTurn(int turn) {
    this.turn = turn % this.getNumberOfPlayer();
  }

  /*
   * Gets turn
   */
  int getTurn() {
    return this.turn % this.getNumberOfPlayer();
  }

  /*
   * Gets next turn
   * also return valid if reverse = true
   */
  int getNextTurn() {
    if (isTurnReversed()) return (
      (this.getTurn() - 1) % this.getNumberOfPlayer()
    ); else return (this.getTurn() + 1) % this.getNumberOfPlayer();
  }

  /*
   * Return true if reverse == true
   */
  boolean getReverse() {
    return this.reverse;
  }

  /*
   * Action to do when player play skipCard/Ace
   */
  void skipTurn(Card cardPlayed, int index, boolean withRemoval) {
    if (withRemoval) {
      Player currentPlayer = this.getCurrrentPlayer();
      currentPlayer.removeCard(index);
    }
    this.addToDeck(cardPlayed);

    if (isTurnReversed()) System.out.println(
      "Skipped player " + (this.getTurn() - 1) % this.getNumberOfPlayer()
    ); else System.out.println(
      "Skipped player " + (this.getTurn() + 1) % this.getNumberOfPlayer()
    );

    if (isTurnReversed()) this.setTurn(this.getTurn() - 2); else this.setTurn(
        this.getTurn() + 2
      );
  }

  /*
   * Set turn to next
   */
  void nextTurn() {
    if (isTurnReversed()) this.setTurn(this.getTurn() - 1); else this.setTurn(
        this.getTurn() + 1
      );
  }

  /*
   * Action to do when player plays plusTwoCard/Queen
   */
  void plusTwo(Card cardPlayed, int index) {
    Player currentPlayer = this.getCurrrentPlayer();
    currentPlayer.removeCard(index);

    int playerNextToPlay = this.getNextTurn();

    Card one = this.drawTop();
    Card two = this.drawTop();

    this.getPlayerAtIndex(playerNextToPlay).addCard(one);
    this.getPlayerAtIndex(playerNextToPlay).addCard(two);

    System.out.println(
      "Added four card to player " + playerNextToPlay + "'s deck"
    );
    breakLine();
    this.printPlayerDeck(playerNextToPlay);
    breakLine();

    this.skipTurn(cardPlayed, index, false);
  }

  /*
   * Action to do when player plays plusFourCard/Jack
   */
  void plusFour(Card cardPlayed, int index) {
    Player currentPlayer = this.getCurrrentPlayer();
    currentPlayer.removeCard(index);

    int playerNextToPlay = this.getNextTurn();

    Card one = this.drawTop();
    Card two = this.drawTop();
    Card three = this.drawTop();
    Card four = this.drawTop();

    this.getPlayerAtIndex(playerNextToPlay).addCard(one);
    this.getPlayerAtIndex(playerNextToPlay).addCard(two);
    this.getPlayerAtIndex(playerNextToPlay).addCard(three);
    this.getPlayerAtIndex(playerNextToPlay).addCard(four);

    System.out.println(
      "Added four card to player " + playerNextToPlay + "'s deck"
    );
    breakLine();
    this.printPlayerDeck(playerNextToPlay);
    breakLine();
    this.skipTurn(cardPlayed, index, false);
  }

  /*
   * Prints player's deck
   * FIXME: Maybe redundant remove if so
   */
  void printPlayerDeck(int index) {
    Player p = this.getPlayerAtIndex(index);
    List<Card> playersCards = p.getCards();

    for (int i = 0; i < playersCards.size(); i++) {
      System.out.println(playersCards.get(i).toString());
    }
  }

  /*
   * Returns true if any player has won
   */
  boolean hasAnyPlayerWon() {
    for (int i = 0; i < this.players.length; i++) {
      if (this.players[i].hasPlayerWon()) return true;
    }
    return false;
  }

  /*
   * Returns number of players in the game
   */
  public int getNumberOfPlayer() {
    return this.players.length;
  }

  /*
   * Returns player at index
   */
  public Player getPlayerAtIndex(int index) {
    if (
      index >= 0 && index < this.getNumberOfPlayer()
    ) return this.players[index];

    return null;
  }

  /*
   * Returns true if draw Deck pile Empty
   */
  boolean drawDeckEmpty() {
    return this.deck.deck.size() == 0 ? true : false;
  }

  /*
   * Executes untill any player has won or Draw Card pile
   * empty
   */
  void takeTurn() {
    int index;
    System.out.println("Current turn " + getPlayerAtIndex(turn).getName());
    System.out.println("Card on top is " + peekDeck().toString());
    getPlayerAtIndex(this.getTurn()).printDeck();
    index = getPlayerAtIndex(this.getTurn()).playCard(peekDeck());

    if (index == -1) {
      System.out.println(
        "Player " + turn + " doesn't have any cards to play so he drew one card"
      );
      System.out.println("Card added ");
      breakLine();
      getPlayerAtIndex(this.getTurn()).addCard(drawTop());
      this.printPlayerDeck(this.getTurn());
      breakLine();
      this.nextTurn();
    } else doActionForCard(index);
  }

  public Player getCurrrentPlayer() {
    return this.getPlayerAtIndex(this.getTurn());
  }

  private void doActionForCard(int index) {
    Card cardPlayed = getPlayerAtIndex(this.getTurn()).getCardAtIndex(index);
    Player currentPlayer = this.getCurrrentPlayer();

    if (cardPlayed.cardIsActionCard()) {
      if (cardPlayed.isCardAce(cardPlayed)) this.skipTurn(
          cardPlayed,
          index,
          true
        );
      if (cardPlayed.isCardKing(cardPlayed)) {
        this.setReverse(!this.getReverse(), cardPlayed, index);
        this.nextTurn();
      }
      if (cardPlayed.isCardQueen(cardPlayed)) this.plusTwo(cardPlayed, index);
      if (cardPlayed.isCardJack(cardPlayed)) this.plusFour(cardPlayed, index);
    } else {
      this.addToDeck(currentPlayer.getCardAtIndex(index));
      currentPlayer.removeCard(index);
      this.nextTurn();
      this.players[turn].printDeck();
    }
  }

  void startGame(int numberOfCardsToDealInitially) {
    this.deck.initialize();
    this.deck.shuffle();

    for (int i = 0; i < this.players.length; i++) {
      Player newPlayer = new Player("Player" + i);
      this.players[i] = newPlayer;
    }

    initialDeal(numberOfCardsToDealInitially);
    this.discardedCards.add(drawTop());
  }

  void printCurrentDeck() {
    for (int i = 0; i < this.deck.deck.size(); i++) {
      Card curr = this.deck.deck.get(i);
      System.out.println(curr.suit.getSuitString() + " " + curr.rank.getRank());
    }
  }

  void initialDeal(int numberOfCardsToDealInitially) {
    for (
      int i = 0;
      i < (this.players.length * numberOfCardsToDealInitially);
      i++
    ) {
      int cardIndex = 51 - i;
      this.players[i % this.players.length].addCard(
          this.deck.deck.get(cardIndex)
        );
      this.deck.deck.remove(cardIndex);
    }
  }

  void printPlayerInitialDeck() {
    for (int i = 0; i < this.players.length; i++) {
      Player curr = this.players[i];
      ArrayList<Card> playerCards = curr.getCards();
      System.out.println(curr.getName());
      for (int j = 0; j < playerCards.size(); j++) {
        Card playerCard = playerCards.get(j);
        System.out.println(
          playerCard.suit.getSuitString() + " " + playerCard.rank.getRank()
        );
      }
      breakLine();
    }
    printCurrentDeck();
  }

  private void breakLine() {
    System.out.println(
      "-------------------------------------------------------------"
    );
  }

  public Card peekDeck() {
    if (this.discardedCards.isEmpty()) {
      return null;
    }
    return this.discardedCards.get(this.discardedCards.size() - 1);
  }

  public void addToDeck(Card newCard) {
    this.discardedCards.add(newCard);
  }

  public Card drawTop() {
    if (this.deck.deck.isEmpty()) {
      return null;
    }
    Card onTop = this.deck.deck.get(this.deck.deck.size() - 1);
    this.deck.deck.remove(this.deck.deck.size() - 1);
    return onTop;
  }

  Player hasAnyoneWon() {
    for (int i = 0; i < this.getNumberOfPlayer(); i++) if (
      this.getPlayerAtIndex(i).hasPlayerWon()
    ) return this.getPlayerAtIndex(i);

    return null;
  }
}
