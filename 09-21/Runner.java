import java.util.Scanner;

// Runner
// Instantiate a node called Head and have data be null.   
// (e.g.  Node<String> head = new Node<String>(null); )
// Instantiate a node called Tail and have data be null.  
// Create 5 Nodes of Strings with Animal names as follows… (cow, cat, dog, bird, and bear).
// Connect each node to the head and tail nodes in the order given above. You will need to use setNext and setPrev for each node.  For example:
// head.setNext( cow );
// cow.setPrev( head );
// etc…

// How many nodes do we have in the example above? 7 nodes (2 for the head and tail, and 5 for the animals)

// In a loop, cycle through and print the data of each node, starting from the head

// In another loop, cycle through and print the data of each node backward, starting from the tail.

// Ask the user for an animal name, and add that node to the end.

// In a loop, cycle through and print the data of each node, starting from the head

public class Runner {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    Node<String> head = new Node<>(null);
    Node<String> cow = new Node<>("cow");
    Node<String> cat = new Node<>("cat");
    Node<String> dog = new Node<>("dog");
    Node<String> bird = new Node<>("bird");
    Node<String> bear = new Node<>("bear");
    Node<String> tail = new Node<>(null);

    head.setNext(cow);
    cow.setNext(cat);
    cow.setPrev(head);
    cat.setNext(dog);
    cat.setPrev(cow);
    dog.setNext(bird);
    dog.setPrev(cat);
    bird.setNext(bear);
    bird.setPrev(dog);
    bear.setNext(tail);
    bear.setPrev(bird);
    tail.setPrev(bear);

    // loop 1
    for (Node<String> current = head.next(); current != tail; current = current.next()) {
      System.out.println(current.get());
    }
    System.out.println();
    System.out.println();
    System.out.println();

    // loop 2
    for (Node<String> current = tail.prev(); current != head; current = current.prev()) {
      System.out.println(current.get());
    }
    System.out.println();
    System.out.println();
    System.out.println();

    // loop 3
    System.out.println("Enter what to add: ");
    String in = s.nextLine();
    Node<String> g = new Node<String>(in);
    bear.setNext(g);
    g.setPrev(bear);
    g.setNext(tail);
    tail.setPrev(g);

    System.out.println();
    System.out.println();
    System.out.println();

    // loop 4
    for (Node<String> current = head.next(); current != tail; current = current.next()) {
      System.out.println(current.get());
    }
    System.out.println();
    System.out.println();
    System.out.println();

  }
}
