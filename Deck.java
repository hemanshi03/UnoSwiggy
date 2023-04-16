import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Deck {

  ArrayList<Card> deck;
  ArrayList<Card> shuffledDeck;

  Deck() {
    this.deck = new ArrayList<>();
  }

  private Suit getSuit(int suit) {
    if (suit == 0) return new Club();
    if (suit == 1) return new Diamond();
    if (suit == 2) return new Heart();
    if (suit == 3) return new Spade();
    return null;
  }

  private Rank getRankForAce() {
    return new ActionRank(0);
  }

  private Rank getRankForJack() {
    return new ActionRank(11);
  }

  private Rank getRankForQueen() {
    return new ActionRank(12);
  }

  private Rank getRankForKing() {
    return new ActionRank(13);
  }

  private Rank getRankForNumber(int num) {
    return new NumberRank(num);
  }

  void initialize() {
    for (int i = 0; i < 4; i++) {
      Suit suit = getSuit(i);
      this.deck.add(new Card(getRankForAce(), suit));
      for (int j = 2; j < 11; j++) this.deck.add(
          new Card(getRankForNumber(j), suit)
        );
      this.deck.add(new Card(getRankForJack(), suit));
      this.deck.add(new Card(getRankForQueen(), suit));
      this.deck.add(new Card(getRankForKing(), suit));
    }
  }

  void shuffle() {
    this.shuffledDeck = new ArrayList<>();
    int[] initialOrdering = {
      0,
      1,
      2,
      3,
      4,
      5,
      6,
      7,
      8,
      9,
      10,
      11,
      12,
      13,
      14,
      15,
      16,
      17,
      18,
      19,
      20,
      21,
      22,
      23,
      24,
      25,
      26,
      27,
      28,
      29,
      30,
      31,
      32,
      33,
      34,
      35,
      36,
      37,
      38,
      39,
      40,
      41,
      42,
      43,
      44,
      45,
      46,
      47,
      48,
      49,
      50,
      51,
    };

    int[] shuffledArr = Arrays.copyOf(initialOrdering, initialOrdering.length);
    Random random = new Random();
    for (int i = shuffledArr.length - 1; i > 0; i--) {
      int j = random.nextInt(i + 1);
      int temp = shuffledArr[i];
      shuffledArr[i] = shuffledArr[j];
      shuffledArr[j] = temp;
    }

    for (int i = 0; i < shuffledArr.length; i++) this.shuffledDeck.add(
        this.deck.get(shuffledArr[i])
      );

    this.deck = this.shuffledDeck;
    shuffledDeck = null;
  }

  void Deal(List<Player> players, int card_to_deal) {}
}
