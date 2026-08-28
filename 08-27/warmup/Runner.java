import java.util.ArrayList;

public class Runner {
  public static void main(String[] args) {
    MyItems<String, Double> a = new MyItems("banana", 1);
    MyItems<String, Double> b = new MyItems("apple", 1.5);
    MyItems<String, Double> c = new MyItems("chocolate", 4);

    ArrayList<MyItems> l = new ArrayList<>();
    l.add(a);
    l.add(b);
    l.add(c);

    for (int i = 0; i < l.size(); i++) {
      System.out.println(l.get(i));
    }

  }
}
