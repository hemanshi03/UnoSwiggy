public class NumberRank implements Rank {

  int rank;

  NumberRank(int rank) {
    this.setRank(rank);
  }

  public void setRank(int rank) {
    this.rank = rank;
  }

  public int getRank() {
    return this.rank;
  }
}
