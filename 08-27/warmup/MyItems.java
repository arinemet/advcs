public class MyItems<K, V> {
  K first;
  V second;

  public MyItems(K first, V second) {
    this.first = first;
    this.second = second;
  }

  public String toString() {
    return first + " : " + second;
  }
}
