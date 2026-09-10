public class MyArrayList<E> {
  private Object[] list;
  private int size;
  private int capacity;

  public MyArrayList() {
    this.capacity = 10;
    this.list = new Object[capacity];
    this.size = 0;
  }

  private static Object[] copyArray(Object[] old, int size) {
    if (old.length > size)
      throw new IndexOutOfBoundsException("Can't copy a array with size smaller than original");
    Object[] newArray = new Object[size];
    for (int i = 0; i < old.length; i++) {
      newArray[i] = old[i];
    }

    return newArray;
  }

  private void ensureCapacity() {
    if (size == capacity) {
      int newCapacity = capacity * 2;
      Object[] newList = new Object[newCapacity];
      newList = copyArray(list, newCapacity);

      list = newList;
      capacity = newCapacity;
    }
  }

  public boolean add(E element) {
    ensureCapacity();

    list[size] = element;
    size++;
    return true;
  }

  public E get(int index) {
    if (index >= 0 && index < size) {
      return (E) list[index];
    }
    // exits the program
    throw new IndexOutOfBoundsException("Index is out of bounds");
  }

  public int size() {
    return size;
  }

  public void printList() {
    for (int i = 0; i < size; i++) {
      System.out.println(i + ", " + list[i]);
    }
  }
}
