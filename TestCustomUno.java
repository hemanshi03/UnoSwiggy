public class TestCustomUno {

  int numOfPlayer;
  int numberOfCardsToDealInitially;
  Game newGame;

  public static void assertTest(boolean result) {
    if (result) System.out.println("Passed"); else System.out.println("Failed");
  }

  TestCustomUno(int numOfPlayer, int numberOfCardsToDealInitially) {
    this.newGame = new Game(numOfPlayer);
    this.newGame.startGame(numberOfCardsToDealInitially);
  }

  int numberOfPlayersAllocated() {
    return this.newGame.getNumberOfPlayer();
  }

  /* 
    while (!newGame.hasAnyPlayerWon() && !newGame.drawDeckEmpty()) {
      newGame.takeTurn();
    }

    Player whoWon = newGame.hasAnyoneWon();
    if (whoWon == null) System.out.println(
      "Match ended as Draw, since draw pile empty"
    ); else System.out.println(whoWon.getName() + " Won");
  }

  */

  boolean testNumOfPlayersSet(int numOfPlayer) {
    if (this.numberOfPlayersAllocated() == numOfPlayer) {
      return true;
    }
    return false;
  }

  boolean testNumOfCardsDealtInitially(int numberOfCardsToDealInitially) {
    for (int i = 0; i < this.newGame.players.length; i++) {
      Player p = this.newGame.players[i];
      if (p.getCardSize() != numberOfCardsToDealInitially) return false;
    }
    return true;
  }

  boolean testDeckContainsCorrectNumberOfCards(
    int numOfPlayer,
    int numberOfCardsToDealInitially
  ) {
    int expected_number_of_cards_after_dealing =
      52 - (numOfPlayer * numberOfCardsToDealInitially);
    this.newGame.deck.initialize();
    this.newGame.deck.shuffle();
    this.newGame.initialDeal(numberOfCardsToDealInitially);
    return (
        this.newGame.deck.deck.size() == expected_number_of_cards_after_dealing
      )
      ? true
      : false;
  }

  public static void main(String[] args) {
    /*
     * Test 1
     * Negative Test to check number of players allocated correctly
     */
    System.out.println(
      "Negative Test to check number of players allocated correctly"
    );
    TestCustomUno testNumOfPlayersSetCorrectly = new TestCustomUno(4, 2);
    assertTest(!testNumOfPlayersSetCorrectly.testNumOfPlayersSet(3));
    testNumOfPlayersSetCorrectly = null;

    /*
     * Test 2
     * Positive Test to check number of players allocated correctly
     */
    System.out.println(
      "Positive Test to check number of players allocated correctly"
    );
    testNumOfPlayersSetCorrectly = new TestCustomUno(4, 2);
    assertTest(testNumOfPlayersSetCorrectly.testNumOfPlayersSet(4));
    testNumOfPlayersSetCorrectly = null;

    /*
     *
     * Test 3
     * Test to check Every player is dealt x cards"
     */
    System.out.println("Test to check Every player is dealt x cards");
    testNumOfPlayersSetCorrectly = new TestCustomUno(4, 2);
    assertTest(testNumOfPlayersSetCorrectly.testNumOfCardsDealtInitially(2));
    testNumOfPlayersSetCorrectly = null;

    /*
     *
     * Test 4
     * Test to check deck contains correct number of cards after dealing
     * to players
     */
    System.out.println(
      "Test to check deck contains correct number of cards after dealing to players"
    );
    testNumOfPlayersSetCorrectly = new TestCustomUno(4, 2);
    assertTest(
      testNumOfPlayersSetCorrectly.testDeckContainsCorrectNumberOfCards(4, 2)
    );
    /*
     *
     *
     */
  }
}
