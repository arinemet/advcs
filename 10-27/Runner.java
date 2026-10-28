/*Runner
Create a MyHashMap<Integer, String> called studentMap.  The key is the ID, and the value is the name. 

Do the following…

Add 3 students with different IDs and names.
Print all the student IDs and their corresponding name.  Print the size.
Add a student with an existing ID and a different name. It should replace a student.
Print all the student IDs and their corresponding name.  Print the size.
Remove a student given an existing ID. 
Print all the student IDs and their corresponding name.  Print the size.
Remove a student given an ID that does not exist.
Print all the student IDs and their corresponding name.  Print the size.
 */

public class Runner {
  public static void main(String[] args) {
    MyHashMap<Integer, String> studentMap = new MyHashMap<>();

    studentMap.put(12, "bob");
    studentMap.put(34, "jeffery");
    studentMap.put(56, "brian");

    System.out.println("Student IDs and Names: ");
    
    for (Node current =  : studentMap.keySet()) {
      System.out.println("ID: " + id + ", Name: " + studentMap.get(id));
    }
    System.out.println("Size: " + studentMap.size());

    studentMap.put(34, "james");
    System.out.println("\n\n\n\n\nStudent IDs and Names after replacing ID 34: ");
    for (Integer id : studentMap.keySet()) {
      System.out.println("ID: " + id + ", Name: " + studentMap.get(id));
    }
    System.out.println("Size: " + studentMap.size());

    studentMap.remove(12);
    System.out.println("\n\n\n\n\nStudent IDs and Names after removing ID 12: ");
    for (Integer id : studentMap.keySet()) {
      System.out.println("ID: " + id + ", Name: " + studentMap.get(id));
    }
    System.out.println("Size: " + studentMap.size());

    studentMap.remove(99);
    System.out.println("\n\n\n\n\nStudent IDs and Names after trying to remove ID 99: ");
    for (Integer id : studentMap.keySet()) {
      System.out.println("ID: " + id + ", Name: " + studentMap.get(id));
    }
    System.out.println("Size: " + studentMap.size());

  }
}
