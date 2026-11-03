/*
In your Runner, have options for the following.
1. View All Students. (Show ID, Names, email, and School)
2. Add a new student. (If an ID already exists, it will replace that student)
3. Ask the user for an ID, and check to see if it exists.
4. Display all student info by ID.
5. Remove a student given an ID.
6. Search for a student by name, and display all the students with that name.
*/

import java.util.Scanner;
import java.util.HashMap;

public class Runner {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    HashMap<Integer, Student> studentMap = new HashMap<>();

    studentMap.put(1001, new Student("Alice", "100057394@mvla.net", "LAHS"));
    studentMap.put(1002, new Student("Bob", "100037284@mvla.net", "AVHS"));
    studentMap.put(1003, new Student("Charlie", "1000577228@mvla.net", "MVHS"));
    studentMap.put(1004, new Student("David", "100039284@mvla.net", "LAHS"));
    studentMap.put(1005, new Student("David", "100037384@mvla.net", "AVHS"));

    while (true) {
      System.out.println("\n1. View All Students");
      System.out.println("2. Add a new student");
      System.out.println("3. Check if an ID exists");
      System.out.println("4. Display student info by ID");
      System.out.println("5. Remove a student by ID");
      System.out.println("6. Search for students by name");
      System.out.println("0. Exit");

      int option = scanner.nextInt();
      scanner.nextLine();

      if (option == 0) {
        return;
      } else if (option == 1) {
        for (Integer id : studentMap.keySet()) {
          Student s = studentMap.get(id);
          System.out.println("ID: " + id + " " + s);
        }
      } else if (option == 2) {
        System.out.println("Enter student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter student name: ");
        String name = scanner.nextLine();
        System.out.println("Enter student email: ");
        String email = scanner.nextLine();
        System.out.println("Enter student school (LAHS, AVHS, MVHS): ");
        String school = scanner.nextLine();
        if (school.equals("LAHS") || school.equals("AVHS") || school.equals("MVHS")) {
          studentMap.put(id, new Student(name, email, school));
          System.out.println("Student added");
        } else {
          System.out.println("Invalid school");
        }
      } else if (option == 3) {
        System.out.println("Enter student ID to check: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        if (studentMap.containsKey(id)) {
          System.out.println("Student exists");
        } else {
          System.out.println("Student does not exist");
        }
      } else if (option == 4) {
        System.out.println("Enter student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Student s = studentMap.get(id);
        if (s != null) {
          System.out.println("ID: " + id + " " + s);
        } else {
          System.out.println("Student not found");
        }
      } else if (option == 5) {
        System.out.println("Enter student ID to remove: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        if (studentMap.remove(id) != null) {
          System.out.println("Student removed");
        } else {
          System.out.println("Student not found");
        }
      } else if (option == 6) {
        System.out.println("Enter student name to search: ");
        String nameToSearch = scanner.nextLine();
        boolean found = false;
        for (Integer id : studentMap.keySet()) {
          Student s = studentMap.get(id);
          if (s.getName().equals(nameToSearch)) {
            System.out.println("ID: " + id + " " + s);
            found = true;
          }
        }
        if (!found) {
          System.out.println("No students found");
        }
      } else {
        System.out.println("Invalid option");
      }
    }
  }
}
