/*Runner
Create a MyHashMap<Integer, String> called studentMap.  The key is the ID, and the value is the name. 

Do the following…

Add 3 students with different IDs and names.
Print all the student IDs and their corresponding name. Get the DLList of keys and go through it using a for loop.  Print the size.
Add a student with an existing ID and a different name. It should replace a student.
Print all the student IDs and their corresponding name.  Print the size.
Remove a student given an existing ID. 
Print all the student IDs and their corresponding name.  Print the size.
Remove a student given an ID that does not exist.
Print all the student IDs and their corresponding name.  Print the size.
 */

public class Runner {
  public static void printAll(MyHashMap<Integer, String> studentMap) {
    DLList<Integer> ids = studentMap.keySet().toDLList();
    for (int i = 0; i < ids.size(); i++) {
      Integer id = ids.get(i);
      System.out.println("ID: " + id + ", Name: " + studentMap.get(id));
    }
    System.out.println("Size: " + studentMap.size());
  }

  public static void main(String[] args) {
    MyHashMap<Integer, String> studentMap = new MyHashMap<>();

    studentMap.put(12, "bob");
    studentMap.put(34, "jeffery");
    studentMap.put(56, "brian");

    System.out.println("Student IDs and Names:");
    printAll(studentMap);

    studentMap.put(34, "james");
    System.out.println("\nAfter replacing ID 34:");
    printAll(studentMap);

    studentMap.remove(12);
    System.out.println("\nAfter removing ID 12:");
    printAll(studentMap);

    studentMap.remove(99);
    System.out.println("\nAfter trying to remove ID 99:");
    printAll(studentMap);
  }
}
