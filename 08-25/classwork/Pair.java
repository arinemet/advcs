public class Pair<K, V> {
  private K first;
  private V second;

  public Pair(K first, V second) {
    this.first = first;
    this.second = second;
  }

  public K getFirst() {
    return first;
  }

  public V getSecond() {
    return second;
  }

  public void setSecond(V second) {
    this.second = second;
  }

  public String toString() {
    return first + " : " + second;
  }
}
