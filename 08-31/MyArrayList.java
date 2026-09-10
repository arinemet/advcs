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
      for (int i = 0; i < size; i++) {
        newList[i] = list[i];
      }

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

  public void add(int index, E element) {
    ensureCapacity();

    for (int i = size; i > index; i--) {
      list[i] = list[i - 1];
    }
    list[index] = element;
    size++;
  }

  public E get(int index) {
    if (index >= 0 && index < size) {
      return (E) list[index];
    }
    // exits the program
    throw new IndexOutOfBoundsException("Index is out of bounds");
  }

  public E remove(int index) {
    E removed = get(index);

    for (int i = index; i < size - 1; i++) {
      list[i] = list[i + 1];
    }
    list[size - 1] = null;
    size--;
    return removed;
  }

  public boolean contains(Object o) {
    for (int i = 0; i < size; i++) {
      if (list[i].equals(o)) {
        return true;
      }
    }
    return false;
  }

  public boolean remove(Object o) {
    for (int i = 0; i < size; i++) {
      if (list[i].equals(o)) {
        remove(i);
        return true;
      }
    }
    return false;
  }

  public void set(int index, E element) {
    list[index] = element;
  }

  public String toString() {
    String result = "[";
    for (int i = 0; i < size; i++) {
      result += list[i];
      if (i < size - 1) {
        result += ", ";
      }
    }
    result += "]";
    return result;
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