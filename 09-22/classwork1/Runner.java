// Runner Class
// Create a DLList of Integers.
// In a loop that runs 3000 times.
// 	Add a random number from 1 to 999 from a random index 0 to and including the size. 
// Display them using the toString method.
// Scramble and display using the toString method.
// In a loop that runs 3000 times.
// Randomly select an index location from 0 and up to the size but not including.  Call remove with that index.  Print the number removed. 
// Print the list with the toString method.  This should be an empty list.

import java.util.Random;

public class Runner {

  public static void main(String[] args) {
    Random rand = new Random();
    DLList<Integer> list = new DLList<Integer>();

    for (int i = 0; i < 3000; i++) {
      int value = rand.nextInt(999) + 1;
      int index = rand.nextInt(list.size() + 1);
      list.add(index, value);
    }

    System.out.println(list);

    for (int i = list.size() - 1; i > 0; i--) {
      int j = rand.nextInt(i + 1);
      Integer temp = list.get(i);
      list.set(i, list.get(j));
      list.set(j, temp);
    }

    System.out.println(list);

    for (int i = 0; i < 3000; i++) {
      int index = rand.nextInt(list.size());
      Integer removed = list.remove(index);
      System.out.println(removed);
    }

    System.out.println(list);
  }

}
