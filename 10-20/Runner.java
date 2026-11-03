import java.util.Scanner;

public class Runner {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    MyHashMap<State, Info> map = new MyHashMap<State, Info>();

    map.put(new State("ca"), new Info("California", "Sacramento", 39000000));
    map.put(new State("ny"), new Info("New York", "Albany", 19500000));
    map.put(new State("tx"), new Info("Texas", "Austin", 30000000));
    map.put(new State("fl"), new Info("Florida", "Tallahassee", 22600000));
    map.put(new State("wa"), new Info("Washington", "Olympia", 7700000));

    int choice = 0;
    while (choice != 5) {
      System.out.println();
      System.out.println("1. View all state abbreviations");
      System.out.println("2. View state info");
      System.out.println("3. Add a state");
      System.out.println("4. Remove a state");
      System.out.println("5. Quit");
      choice = Integer.parseInt(in.nextLine());

      if (choice == 1) {
        DLList<State> list = map.keySet().toDLList();
        System.out.println(list);
      } else if (choice == 2) {
        System.out.print("Abbreviation: ");
        State s = new State(in.nextLine());
        Info info = map.get(s);
        if (info == null) {
          System.out.println("State not found");
        } else {
          System.out.println(info);
        }
      } else if (choice == 3) {
        System.out.print("Abbreviation: ");
        State s = new State(in.nextLine());
        System.out.print("Name: ");
        String name = in.nextLine();
        System.out.print("Capital: ");
        String capital = in.nextLine();
        System.out.print("Population: ");
        int population = Integer.parseInt(in.nextLine());
        map.put(s, new Info(name, capital, population));
      } else if (choice == 4) {
        System.out.print("Abbreviation: ");
        State s = new State(in.nextLine());
        if (map.remove(s) == null) {
          System.out.println("State not found");
        } else {
          System.out.println("Removed");
        }
      }
    }
  }
}
