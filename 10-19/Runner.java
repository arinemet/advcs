/*
n your Runner, have options for the following.
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
    HashMap<String, Student> studentMap = new HashMap<>();
    Student student1 = new Student("Alice", "alice@example.com", "XYZ University");
    studentMap.put(student1.getEmail(), student1);

    Student student2 = new Student("Bob", "bob@example.com", "ABC University");
    studentMap.put(student2.getEmail(), student2);

    Student student3 = new Student("Charlie", "charlie@exmaple.com", "LMN University");
    studentMap.put(student3.getEmail(), student3);

    Student student4 = new Student("David", "david@example.com", "PQR University");
    studentMap.put(student4.getEmail(), student4);

    Student student5 = new Student("David", "david2@example.com", "UVW University");
    studentMap.put(student5.getEmail(), student5);

    while (true) {
      System.out.println(
          "1. View All Students. (Show ID, Names, email, and School\n2. Add a new student. (If an ID already exists, it will replace that student)\n3. Ask the user for an ID, and check to see if it exists.\n4. Display all student info by ID.\n5. Remove a student given an ID.\n6. Search for a student by name, and display all the students with that name.\n0. Exit.");

      int option = scanner.nextInt();
      scanner.nextLine();

      switch (option) {
        case (0):
          return;
        case (1):
          for (Student s : studentMap.values()) {
            System.out.println(s);
          }
          break;
        case (2):
          System.out.println("Enter student name: ");
          String name = scanner.nextLine();
          System.out.println("Enter student email: ");
          String email = scanner.nextLine();
          System.out.println("Enter student school: ");
          String school = scanner.nextLine();
          Student newStudent = new Student(name, email, school);
          studentMap.put(email, newStudent);
          System.out.println("Student added.");
          break;
        case (3):
          System.out.println("Enter student email (ID) to check: ");
          String emailToCheck = scanner.nextLine();
          if (studentMap.containsKey(emailToCheck)) {
            System.out.println("Student exists.");
          } else {
            System.out.println("Student does not exist.");
          }
          break;

        case (4):
          System.out.println("Enter student email (ID) to display info: ");
          String emailToDisplay = scanner.nextLine();
          Student studentToDisplay = studentMap.get(emailToDisplay);
          if (studentToDisplay != null) {
            System.out.println(studentToDisplay);
          } else {
            System.out.println("Student not found.");
          }
          break;
        case (5):
          System.out.println("Enter student email (ID) to remove: ");
          String emailToRemove = scanner.nextLine();
          if (studentMap.remove(emailToRemove) != null) {
            // .remove returns previous value in it
            // Null: if key means not there
            System.out.println("Student removed.");
          } else {
            System.out.println("Student not found.");
          }
          break;
        case (6):
          System.out.println("Enter student name to search: ");
          String nameToSearch = scanner.nextLine();

          for (Student s : studentMap.values()) {
            if (s.getName().equals(nameToSearch)) {
              System.out.println(s);
            }
          }
          break;
        default:
          System.out.println("Invalid option.");
      }
    }
  }

}
