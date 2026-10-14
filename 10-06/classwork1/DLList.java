public class DLList<E> {
  private Node<E> head;
  private Node<E> tail;
  private int size;

  public DLList() {
    head = new Node<>(null);
    tail = new Node<>(null);

    head.setNext(tail);
    tail.setPrev(head);

    size = 0;
  }

  public boolean add(E element) {
    Node<E> newNode = new Node<>(element);
    Node<E> before = tail.prev();

    before.setNext(newNode);
    newNode.setPrev(before);
    newNode.setNext(tail);
    tail.setPrev(newNode);

    size++;
    return true;
  }

  public E get(int loc) {
    Node<E> current = getNode(loc);
    return current.get();
  }

  public E remove(int loc) {
    Node<E> current = getNode(loc);

    current.prev().setNext(current.next());
    current.next().setPrev(current.prev());

    size--;
    return current.get();
  }

  public int size() {
    return size;
  }

  private Node<E> getNode(int loc) {
    Node<E> current;

    if (loc < size / 2) {
      current = head.next();

      for (int i = 0; i < loc; i++) {
        current = current.next();
      }
    } else {
      current = tail.prev();

      for (int i = size - 1; i > loc; i--) {
        current = current.prev();
      }
    }

    return current;
  }

}
