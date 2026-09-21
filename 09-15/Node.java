public class Node<E> {
  private E data;
  private Node<E> next;

  public Node(E data) {
    this.data = data;
    this.next = null;
  }

  public E get() {
    return data;
  }

  public void set(E data) {
    this.data = data;
  }

  public Node<E> next() {
    return next;
  }

  public void setNext(Node<E> next) {
    this.next = next;
  }
}
