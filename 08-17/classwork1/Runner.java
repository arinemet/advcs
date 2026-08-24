import java.util.Scanner;

public class Runner {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    String names[] = { "Ava", "Liam", "Mia", "Noah", "Emma", "Ethan", "Sofia", "Lucas", "Chloe", "Mason" };
    int ages[] = { 18, 25, 16, 31, 22, 19, 28, 17, 24, 21 };

    System.out.println("profiles");
    for (int i = 0; i < names.length; i++) {
      System.out.println("name: " + names[i] + " age: " + ages[i]);
    }

    System.out.println("\n1-sort by age smallest to biggest");
    System.out.println("2-scramble them");
    System.out.println("3-sort by name alphabetically");
    System.out.print("chose 1, 2, or 3: ");
    int pick = scan.nextInt();

    if (pick == 1) {
      for (int i = 0; i < ages.length; i++) {
        for (int j = i + 1; j < ages.length; j++) {
          if (ages[i] > ages[j]) {
            int temp = ages[i];
            ages[i] = ages[j];
            ages[j] = temp;

            String temp2 = names[i];
            names[i] = names[j];
            names[j] = temp2;
          }
        }
      }
    }
    if (pick == 2) {
      for (int i = 0; i < names.length; i++) {
        int r = (int) (Math.random() * names.length);

        String x = names[i];
        names[i] = names[r];
        names[r] = x;

        int y = ages[i];
        ages[i] = ages[r];
        ages[r] = y;
      }
    }
    if (pick == 3) {
      for (int i = 0; i < names.length; i++) {
        for (int j = i + 1; j < names.length; j++) {
          if (names[i].compareTo(names[j]) > 0) {
            String temp = names[i];
            names[i] = names[j];
            names[j] = temp;

            int temp2 = ages[i];
            ages[i] = ages[j];
            ages[j] = temp2;
          }
        }
      }
    }

    System.out.println("\nnew list:");
    for (int i = 0; i < names.length; i++) {
      System.out.println("name: " + names[i] + " age: " + ages[i]);
    }
  }
}
