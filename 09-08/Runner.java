public class Runner {
  public static void main(String[] args) {
    MyArrayList a = new MyArrayList<Integer>();

    for (int i = 0; i < 300000000; i++) {
      int r = (int) (Math.random() * 100 + 1);
      a.add(r);
    }

    System.out.print("[");
    for (int i = 0; i < a.size(); i++) {
      System.out.print(a.get(i) + ", ");
    }
    System.out.print("]" + "\n");
  }
}
