public class ActionRank implements Rank {

  /*
   * Defines rank of a card
   */
  int rank;

  ActionRank() {}

  ActionRank(int rank) {
    this.setRank(rank);
  }

  /*
   * Getters and Setter for rank
   */
  public void setRank(int rank) {
    this.rank = rank;
  }

  public int getRank() {
    return this.rank;
  }
}
