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

  @Override
  public String toString() {
    return taskName + " rank " + rank;
  }
}
