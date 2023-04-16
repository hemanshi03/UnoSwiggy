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

  boolean testNumOfCardsDealtInitially(
    int numOfPlayer,
    int numberOfCardsToDealInitially,
    Game newGame
  ) {
    TestCustomUno test = new TestCustomUno(numOfPlayer, numOfPlayer);
    return false;
  }

  public static void main(String[] args) {

    System.out.println(
      "Negative Test to check number of players allocated correctly"
    );
    TestCustomUno testNumOfPlayersSetCorrectly = new TestCustomUno(4, 2);
    assertTest(!testNumOfPlayersSetCorrectly.testNumOfPlayersSet(3));
    testNumOfPlayersSetCorrectly = null;

    System.out.println(
      "Positive Test to check number of players allocated correctly"
    );
    testNumOfPlayersSetCorrectly = new TestCustomUno(4, 2);
    assertTest(testNumOfPlayersSetCorrectly.testNumOfPlayersSet(4));


  }
}
