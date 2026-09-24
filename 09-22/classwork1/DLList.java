// DLList<E> Class
// Instance Variables
// - head : Node<E>
// - tail: Node<E>
// - size : int
// Constructor
// + DLList - Sets up the head node, tail node, and size.
// Methods
// + add(E) :boolean - Add an element to the end of the list. Return true.
// + add(int,E) : void - Add an element to a specific location in the list.
// + get(int) : E - Return the element at a specific location.
// + contains(Object) : boolean - Return true if the specified element exists and false otherwise.
// + remove(int) : E - Remove an element at a specific location.  Return the element removed.
// + size() : int - Return the size.
// + set(int,E) : E - Replace an element at specific location.  Return the element previously replaced.
// + toString() : String - Return a string of all the elements within the list.
// - getNode(int) : Node<E> - Get the node given an index. Traverse forwards or
// backwards, depending on where the index is.  This will be used in your set(int,E),
// add(int,E), remove(int), and get(int).

public class DLList<E> {
  private Node<E> head;
  private Node<E> tail;
  private int size;

  public DLList() {
    head = new Node<E>(null);
    tail = new Node<E>(null);
    head.setNext(tail);
    tail.setPrev(head);
    size = 0;
  }

  public boolean add(E element) {
    Node<E> n = new Node<E>(element);
    Node<E> last = tail.prev();

    n.setPrev(last);
    n.setNext(tail);
    last.setNext(n);
    tail.setPrev(n);

    size += 1;
    return true;
  }

  public void add(int pos, E element) {
    Node<E> after = getNode(pos);
    Node<E> before = after.prev();

    Node<E> n = new Node<E>(element);
    n.setPrev(before);
    n.setNext(after);
    before.setNext(n);
    after.setPrev(n);

    size += 1;
  }

  public E get(int index) {
    return getNode(index).get();
  }

  public boolean contains(Object e) {
    Node<E> current = head.next();
    while (current != tail) {
      if (current.get().equals(e)) {
        return true;
      }
      current = current.next();
    }
    return false;
  }

  public E remove(int index) {
    Node<E> n = getNode(index);
    Node<E> before = n.prev();
    Node<E> after = n.next();

    before.setNext(after);
    after.setPrev(before);

    size -= 1;
    return n.get();
  }

  public int size() {
    return size;
  }

  public E set(int index, E element) {
    Node<E> n = getNode(index);
    E oldData = n.get();
    Node<E> replacement = new Node<E>(element);

    Node<E> before = n.prev();
    Node<E> after = n.next();

    before.setNext(replacement);
    replacement.setPrev(before);
    replacement.setNext(after);
    after.setPrev(replacement);

    return oldData;
  }

  public String toString() {
    String result = "[";
    Node<E> current = head.next();

    while (current != tail) {
      result += current.get();
      if (current.next() != tail) {
        result += ", ";
      }
      current = current.next();
    }

    result += "]";
    return result;
  }

  private Node<E> getNode(int index) {
    Node<E> current;

    if (index < size / 2) {
      current = head.next();
      for (int i = 0; i < index; i++) {
        current = current.next();
      }
    } else {
      current = tail;
      for (int i = size; i > index; i--) {
        current = current.prev();
      }
    }

    return current;
  }

}
