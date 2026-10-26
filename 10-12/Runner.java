import java.util.HashSet;

public class Runner {
  public static void main(String[] args) {
    HashSet<String> set1 = new HashSet<>();
    String[] og1 = "a b c d e f g h a b c d e f g h i j k".split(" ");
    HashSet<String> dup1 = new HashSet<>();
    for (String s : og1) {
      if (!set1.add(s)) {
        dup1.add(s);
      }
    }
    System.out.println("Uniques: " + set1);
    System.out.println("Duplicates: " + dup1);

        HashSet<String> set2 = new HashSet<>();
        String[] og2 = "one two three one two three six seven one two".split(" ");
        HashSet<String> dup2 = new HashSet<>();
        for (String s : og2) {
          if (!set2.add(s)) {
            dup2.add(s);
          }
        }
        System.out.println("Uniques: " + set2);
        System.out.println("Duplicates: " + dup2);

        HashSet<String> odds = new HashSet<>();
        String[] og3 = "3 5 4 7 5 17 29 17 4 6 56 72 6".split(" ");
        HashSet<String> evens = new HashSet<>();
        for (String s : og3) {
          if (Integer.parseInt(s) % 2 == 0) {
            evens.add(s);
          } else {
            odds.add(s);
          }
        }
        System.out.println("Odds: " + odds);
        System.out.println("Evens: " + evens);

        HashSet<String> set4 = new HashSet<>();
        HashSet<String> set5 = new HashSet<>();
        String[] og4 = "1 5 9 4 6 8 12 1".split(" ");
        String[] og5 = "6 5 8 9 11 7 10 11".split(" ");
        HashSet<String> dup4 = new HashSet<>();
        for (String s : og4) {
          set4.add(s);
        }

        for (String s : og5) {
          set5.add(s);
        }

        HashSet<String> set6 = new HashSet<>();
        for (String s : set4) {
          if (!set6.add(s)) {
            dup4.add(s);
          }
        }
        for (String s : set5) {
          if (!set6.add(s)) {
            dup4.add(s);
          }
        }

        System.out.println("Duplicates: " + dup4);
      }
}