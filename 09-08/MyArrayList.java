// This is a practice quiz for the quiz next class

public class MyArrayList<E> {
  private Object[] list;
  private int size;
  private int capacity;

  public MyArrayList() {
    this.size = 0;
    this.capacity = 10;
    this.list = new Object[capacity];
  }

  public boolean add(E element) {
    if (size + 1 > capacity) {
      capacity *= 2;
      Object[] newArray = new Object[capacity];
      for (int i = 0; i < list.length; i++) {
        newArray[i] = list[i];
      }
      list = newArray;
    }

    list[size] = element;
    size++;
    return true;
  }

  public E get(int index) {
    return (E) list[index];
  }

  public int size() {
    return size;
  }

}
