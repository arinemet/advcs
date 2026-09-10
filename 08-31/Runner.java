import java.util.Scanner;

public class Runner {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    MyArrayList<Task> tasksList = new MyArrayList<>();

    int numberOfTasks = 100;
    for (int i = 1; i <= numberOfTasks; i++) {
      String taskName = "task" + i;

      int rank = (int) (Math.random() * 30) + 1;

      Task newTask = new Task(taskName, rank);

      tasksList.add(newTask);
    }

    sortByRank(tasksList);

    System.out.println("Sorted task list:");
    tasksList.printList();

    boolean quit = false;
    while (!quit) {
      System.out.println();
      System.out.println("1. View Task List");
      System.out.println("2. Add a Task");
      System.out.println("3. Remove a Task by Name");
      System.out.println("4. Add a Task at Index");
      System.out.println("5. Remove a Task by Index");
      System.out.println("6. Replace a Task by Index");
      System.out.println("7. Test Removal at Random");
      System.out.println("8. Quit");
      System.out.print("Enter choice: ");
      int choice = Integer.parseInt(scan.nextLine());

      if (choice == 1) {
        tasksList.printList();
      } else if (choice == 2) {
        System.out.print("Enter task name: ");
        String name = scan.nextLine();
        System.out.print("Enter rank: ");
        int rank = Integer.parseInt(scan.nextLine());
        Task newTask = new Task(name, rank);
        if (tasksList.contains(newTask)) {
          System.out.println("Duplicate task name, not adding.");
        } else {
          tasksList.add(newTask);
          System.out.println("Task added.");
        }
      } else if (choice == 3) {
        System.out.print("Enter task name to remove: ");
        String name = scan.nextLine();
        Task temp = new Task(name, 0);
        boolean removed = tasksList.remove(temp);
        if (removed) {
          System.out.println("Task removed.");
        } else {
          System.out.println("Task not found.");
        }
      } else if (choice == 4) {
        System.out.print("Enter task name: ");
        String name = scan.nextLine();
        System.out.print("Enter rank: ");
        int rank = Integer.parseInt(scan.nextLine());
        System.out.print("Enter index: ");
        int index = Integer.parseInt(scan.nextLine());
        tasksList.add(index, new Task(name, rank));
        System.out.println("Task added at index " + index);
      } else if (choice == 5) {
        System.out.print("Enter index to remove: ");
        int index = Integer.parseInt(scan.nextLine());
        Task removed = tasksList.remove(index);
        System.out.println("Removed: " + removed);
      } else if (choice == 6) {
        System.out.print("Enter index to replace: ");
        int index = Integer.parseInt(scan.nextLine());
        System.out.print("Enter new task name: ");
        String name = scan.nextLine();
        System.out.print("Enter new rank: ");
        int rank = Integer.parseInt(scan.nextLine());
        tasksList.set(index, new Task(name, rank));
        System.out.println("Task replaced.");
      } else if (choice == 7) {
        while (tasksList.size() > 0) {
          int index = (int) (Math.random() * tasksList.size());
          Task removed = tasksList.remove(index);
          System.out.println("Removed at index " + index + ": " + removed);
        }
      } else if (choice == 8) {
        quit = true;
      } else {
        System.out.println("Invalid choice.");
      }
    }

    scan.close();
  }

  public static void sortByRank(MyArrayList<Task> tasksList) {
    for (int i = 0; i < tasksList.size() - 1; i++) {
      for (int j = 0; j < tasksList.size() - 1 - i; j++) {
        if (tasksList.get(j).getRank() > tasksList.get(j + 1).getRank()) {
          Task temp = tasksList.get(j);
          tasksList.set(j, tasksList.get(j + 1));
          tasksList.set(j + 1, temp);
        }
      }
    }
  }
}
