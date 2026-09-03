public class MyArrayList<E> {
  private Object[] list;
  private int size;
  private int capacity;

  public MyArrayList() {
    this.capacity = 10;
    this.list = new Object[capacity];
    this.size = 0;
  }

  private void ensureCapacity() {
    if (size == capacity) {
      // Double the capacity
      int newCapacity = capacity * 2;
      Object[] newList = new Object[newCapacity];

      // Copy existing elements over
      System.arraycopy(list, 0, newList, 0, size);

      // Update references
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
