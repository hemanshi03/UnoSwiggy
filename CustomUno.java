import java.util.Scanner;

public class CustomUno {

  public static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    int numOfPlayer;
    int numberOfCardsToDealInitially;
    Game newGame;

    System.out.println("Welcom to Custom Uno Game");
    System.out.println("Enter Number of Players");
    numOfPlayer = sc.nextInt();
    newGame = new Game(numOfPlayer);
    System.out.println("Enter Initial Number of cards to deal");
    numberOfCardsToDealInitially = sc.nextInt();
    newGame.startGame(numberOfCardsToDealInitially);

    while (!newGame.hasAnyPlayerWon() && !newGame.drawDeckEmpty()) {
      newGame.takeTurn();
    }

    Player whoWon = newGame.hasAnyoneWon();
    if (whoWon == null) System.out.println(
      "Match ended as Draw, since draw pile empty"
    ); else System.out.println(whoWon.getName() + " Won");
  }
}
