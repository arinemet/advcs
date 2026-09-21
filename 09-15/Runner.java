import java.util.Scanner;
import java.util.Random;

public class Runner {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    Random rand = new Random();

    SLList<Student> students = new SLList<Student>();
    students.add(new Student("Alice", 101));
    students.add(new Student("Bob", 102));
    students.add(new Student("Carla", 103));
    students.add(new Student("David", 104));
    students.add(new Student("Emma", 105));

    boolean done = false;
    while (!done) {
      System.out.println(students);
      System.out.println("1. Add  2. Remove by index  3. Remove by id  4. Sort  5. Scramble  6. Quit");
      System.out.print("Choice: ");
      int choice = input.nextInt();

      if (choice == 1) {
        System.out.print("Index: ");
        int index = input.nextInt();
        input.nextLine();
        System.out.print("Name: ");
        String name = input.nextLine();
        System.out.print("ID: ");
        int id = input.nextInt();

        Student newStudent = new Student(name, id);
        if (!students.contains(newStudent)) {
          students.add(index, newStudent);
        } else {
          System.out.println("A student with that id already exists.");
        }
      } else if (choice == 2) {
        System.out.print("Index: ");
        int index = input.nextInt();
        students.remove(index);
      } else if (choice == 3) {
        System.out.print("ID: ");
        int id = input.nextInt();
        Student toRemove = new Student("", id);
        boolean removed = students.remove(toRemove);
        if (!removed) {
          System.out.println("No student with that id was found.");
        }
      } else if (choice == 4) {
        sortByName(students);
      } else if (choice == 5) {
        scramble(students, rand);
      } else if (choice == 6) {
        done = true;
      } else {
        System.out.println("Invalid choice.");
      }
    }

    input.close();
  }

  public static void sortByName(SLList<Student> students) {
    for (int i = 0; i < students.size() - 1; i++) {
      for (int j = 0; j < students.size() - 1 - i; j++) {
        Student first = students.get(j);
        Student second = students.get(j + 1);
        if (first.getName().compareTo(second.getName()) > 0) {
          students.set(j, second);
          students.set(j + 1, first);
        }
      }
    }
  }

  public static void scramble(SLList<Student> students, Random rand) {
    for (int i = students.size() - 1; i > 0; i--) {
      int j = rand.nextInt(i + 1);
      Student temp = students.get(i);
      students.set(i, students.get(j));
      students.set(j, temp);
    }
  }
}
