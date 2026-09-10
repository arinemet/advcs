
public class Runner {
  public static void main(String[] args) {
    MyArrayList<Task> tasksList = new MyArrayList<>();

    int numberOfTasks = 100;
    for (int i = 1; i <= numberOfTasks; i++) {
      String taskName = "task" + i;

      int rank = (int) (Math.random() * 30) + 1;

      Task newTask = new Task(taskName, rank);

      tasksList.add(newTask);
    }

    tasksList.printList();
  }
}
