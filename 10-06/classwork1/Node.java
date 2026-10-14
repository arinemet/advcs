// Node<E> Class
// - data : E - Generic data object
// - next : Node<E> - Points to the next node within the LinkedList chain. 
// - prev: Node<E> - Points to the previous node within the LinkedList chain. 
// Constructor
// + Node(E) - Takes in a generic object.  Sets data to what is passed in. Set next and prev to null.
// Methods
// + get() : E - Returns data.
// + next() : Node<E> - Returns the next node.
// + prev() : Node<E> - Returns the prev node.
// + setNext(Node<E>) : void - Sets the next node to what is passed in.
// + setPrev(Node<E>) : void - Sets the prev node to what is passed in.
// + set(E) : void - Replace the data with the given data.

public class Node<E> {
  private E data;
  private Node<E> next;
  private Node<E> prev;

  public Node(E data) {
    this.data = data;
    this.next = null;
    this.prev = null;
  }

  public E get() {
    return (E) this.data;
  }

  public Node<E> next() {
    return this.next;
  }

  public Node<E> prev() {
    return this.prev;
  }

  public void setNext(Node<E> next) {
    this.next = next;
  }

  public void setPrev(Node<E> prev) {
    this.prev = prev;
  }

  public void set(E data) {
    this.data = data;
  }

}