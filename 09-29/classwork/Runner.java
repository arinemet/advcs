// Runner Class
// Instantiate the DLList class.
// Add the numbers 1 through 9 in that order.
// Print the numbers using get(int) all on one line, separated by commas.
// Add 100 random integers from 1 to 999.
// Print the numbers using get(int) all on one line, separated by commas.
// In a while loop with the condition of the size being greater than 0, select a random index from zero up to but not including the size.
// Call remove(int) passing the random index, and print the number removed on one line separated by commas.
// Print the word "size: " and size().  This should be zero.

import java.util.Random;

public class Runner {

  public static void main(String[] args) {
    DLList<Integer> list = new DLList<Integer>();
    Random rand = new Random();

    for (int i = 1; i <= 9; i++) {
      list.add(i);
    }

    printList(list);

    for (int i = 0; i < 100; i++) {
      list.add(rand.nextInt(999) + 1);
    }

    printList(list);

    boolean first = true;
    while (list.size() > 0) {
      int index = rand.nextInt(list.size());
      int removed = list.remove(index);
      if (!first) {
        System.out.print(",");
      }
      System.out.print(removed);
      first = false;
    }
    System.out.println();

    System.out.println("size: " + list.size());
  }

  private static void printList(DLList<Integer> list) {
    for (int i = 0; i < list.size(); i++) {
      if (i > 0) {
        System.out.print(",");
      }
      System.out.print(list.get(i));
    }
    System.out.println();
  }

}
