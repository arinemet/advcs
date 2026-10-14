// DLList<E> Class
// Instance Variables
// - head : Node<E>
// - tail : Node<E>
// - size : int
// Constructor
// + DLList - Instantiate the head and tail nodes. Connect them.  Set size to 0.
// Methods
// + add(E) : boolean - Add an element at the end of the list.  Return true.
// + get(int) : E - Return the element at a specific location. Need to utilize getNode(int).
// + remove(int) : E - Remove the element given the index.  Return the element removed. Need to utilize getNode(int).
// + size() : int - Return the size.
// - getNode(int) : Node<E> - Returns the node given an index.  Depending on the index, it will traverse forwards or backwards.

public class DLList<E> {
  private Node<E> head;
  private Node<E> tail;
  private int size;

  public DLList() {
    this.head = new Node<E>(null);
    this.tail = new Node<E>(null);
    head.setNext(tail);
    tail.setPrev(head);
    size = 0;
  }

  public boolean add(E element) {
    Node<E> newNode = new Node<E>(element);
    Node<E> oldPrev = tail.prev();
    newNode.setPrev(oldPrev);
    newNode.setNext(tail);
    oldPrev.setNext(newNode);
    tail.setPrev(newNode);
    size++;
    return true;
  }

  public E get(int index) {
    return getNode(index).get();
  }

  public E remove(int index) {
    Node<E> node = getNode(index);
    Node<E> before = node.prev();
    Node<E> after = node.next();
    before.setNext(after);
    after.setPrev(before);
    size--;
    return node.get();
  }

  public int size() {
    return size;
  }

  private Node<E> getNode(int index) {
    Node<E> current;
    if (index < size / 2) {
      current = head.next();
      for (int i = 0; i < index; i++) {
        current = current.next();
      }
    } else {
      current = tail.prev();
      for (int i = size - 1; i > index; i--) {
        current = current.prev();
      }
    }
    return current;
  }

}
