public class Task {
  private String taskName;
  private int rank;

  public Task(String taskName, int rank) {
    this.taskName = taskName;
    this.rank = rank;
  }

  public String getTaskName() {
    return taskName;
  }

  public int getRank() {
    return rank;
  }

  public void setRank(int rank) {
    this.rank = rank;
  }

  @Override
  public boolean equals(Object o) {
    Task other = (Task) o;
    return this.getTaskName().equals(other.getTaskName());
  }

  @Override
  public String toString() {
    return taskName + " rank " + rank;
  }
}
