import java.util.ArrayList;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList list = new ArrayList();

        while (true) {
            System.out.print("\nAdd, Delete, or Quit: ");
            String choice = input.nextLine().toLowerCase();

            if (choice.equals("add")) {
                System.out.print("Task: ");
                String name = input.nextLine();
                System.out.print("Rank: ");
                int rank = Integer.parseInt(input.nextLine());
                while (rank < 1) {
                    System.out.print("Enter a rank of 1 or higher: ");
                    rank = Integer.parseInt(input.nextLine());
                }
                list.add(new Task(name, rank));
                sortList(list);
            } else if (choice.equals("delete")) {
                System.out.print("Task: ");
                String name = input.nextLine();
                for (int i = 0; i < list.size(); i++) {
                    Task task = (Task) list.get(i);
                    if (task.getTask().equals(name)) {
                        list.remove(i);
                        break;
                    }
                }
            } else if (choice.equals("quit")) {
                break;
            }

            System.out.println("To-Do List:");
            for (int i = 0; i < list.size(); i++)
                System.out.println(list.get(i));
        }

        input.close();
    }

    public static void sortList(ArrayList list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - 1; j++) {
                Task first = (Task) list.get(j);
                Task second = (Task) list.get(j + 1);

                if (first.getRank() > second.getRank()) {
                    list.set(j, second);
                    list.set(j + 1, first);
                }
            }
        }
    }
}
