public class ActionRank implements Rank {

  int rank;

  ActionRank() {}

  ActionRank(int rank) {
    this.setRank(rank);
  }

  public void setRank(int rank) {
    this.rank = rank;
  }

  public int getRank() {
    return this.rank;
  }
}
