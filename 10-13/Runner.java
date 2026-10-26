
/*
Runner Class
Using Java's HashSet, add 5 students with different names and age.
In a loop, have options to do the following…
View all students.  Display the students by name and age.
Add a student.   It should not let you add another student with the same first letter name and age as an existing student.
Ask the user for a student's first name and age to check if it exists.  Create a student object given that age and name.  Call contains from your HashSet passing in that student object.  Print the result.
Ask the user for a student name and age to remove.
Quit
*/

import java.util.HashSet;
import java.util.Scanner;

public class Runner {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    HashSet<Student> students = new HashSet<>();
    students.add(new Student("Bob", 4));
    students.add(new Student("Carl", 5));
    students.add(new Student("John", 10));
    students.add(new Student("Jerry", 20));
    students.add(new Student("Joe", 30));

    while (true) {
      System.out.println(
          "Options: \n1. View all students\n2. Add a student\n3. Check if a student exists\n4. Remove a student\n5. Quit");
      int option = scanner.nextInt();
      scanner.nextLine();

      switch (option) {
        case 1:
          System.out.println("Students:");
          for (Student student : students) {
            System.out.println(student);
          }
          break;
        case 2:
          System.out.print("Enter students name: ");
          String name = scanner.nextLine();
          System.out.print("Enter students age: ");
          int age = scanner.nextInt();
          scanner.nextLine();
          Student newStudent = new Student(name, age);
          if (students.contains(newStudent)) {
            System.out.println("Students with that same first letter of name and age already exists");
          } else {
            students.add(newStudent);
            System.out.println("Student added");
          }
          break;
        case 3:
          System.out.print("Enter student's name to check: ");
          String checkName = scanner.nextLine();
          System.out.print("Enter student's age to check: ");
          int checkAge = scanner.nextInt();
          Student checkStudent = new Student(checkName, checkAge);
          if (students.contains(checkStudent)) {
            System.out.println("Student exists");
          } else {
            System.out.println("Student does not exist");
          }
          break;
        case 4:
          System.out.print("Enter student's name to remove: ");
          String removeName = scanner.nextLine();
          System.out.print("Enter student's age to remove: ");
          int removeAge = scanner.nextInt();
          Student removeStudent = new Student(removeName, removeAge);
          if (students.remove(removeStudent)) {
            System.out.println("Student removed");
          } else {
            System.out.println("Student not found");
          }
          break;
        case 5:
          return;
        default:
          System.out.println("bad option picked");
      }
    }
  }
}