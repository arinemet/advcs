public class SLList<E> {
  private Node<E> head;
  private int size;

  public SLList() {
    this.head = null;
    this.size = 0;
  }

  public E get(int i) {
    Node<E> current = head;
    for (int index = 0; index < i; index++) {
      current = current.next();
    }
    return current.get();
  }

  public boolean contains(Object o) {
    Node<E> current = head;
    while (current != null) {
      if (current.get().equals(o)) {
        return true;
      }
      current = current.next();
    }
    return false;
  }

  public boolean add(E e) {
    Node<E> newNode = new Node<E>(e);
    if (head == null) {
      head = newNode;
    } else {
      Node<E> current = head;
      while (current.next() != null) {
        current = current.next();
      }
      current.setNext(newNode);
    }
    size++;
    return true;
  }

  public String toString() {
    StringBuilder sb = new StringBuilder("[");
    Node<E> current = head;
    while (current != null) {
      sb.append(current.get().toString());
      if (current.next() != null) {
        sb.append(", ");
      }
      current = current.next();
    }
    sb.append("]");
    return sb.toString();
  }

  public void add(int i, E e) {
    Node<E> newNode = new Node<E>(e);
    if (i == 0) {
      newNode.setNext(head);
      head = newNode;
    } else {
      Node<E> current = head;
      for (int index = 0; index < i - 1; index++) {
        current = current.next();
      }
      newNode.setNext(current.next());
      current.setNext(newNode);
    }
    size++;
  }

  public E remove(int i) {
    E removed;
    if (i == 0) {
      removed = head.get();
      head = head.next();
    } else {
      Node<E> current = head;
      for (int index = 0; index < i - 1; index++) {
        current = current.next();
      }
      removed = current.next().get();
      current.setNext(current.next().next());
    }
    size--;
    return removed;
  }

  public boolean remove(Object o) {
    if (head == null) {
      return false;
    }
    if (head.get().equals(o)) {
      head = head.next();
      size--;
      return true;
    }
    Node<E> current = head;
    while (current.next() != null) {
      if (current.next().get().equals(o)) {
        current.setNext(current.next().next());
        size--;
        return true;
      }
      current = current.next();
    }
    return false;
  }

  public E set(int i, E e) {
    Node<E> current = head;
    for (int index = 0; index < i; index++) {
      current = current.next();
    }
    E previous = current.get();
    current.set(e);
    return previous;
  }

  public int size() {
    return size;
  }
}
