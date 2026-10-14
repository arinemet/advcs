public class MyQueue<E> {
  private DLList<E> myQueue;

  public MyQueue() {
    myQueue = new DLList<E>();
  }

  public boolean add(E item) {
    return myQueue.add(item);
  }

  public E poll() {
    return myQueue.remove(0);
  }

  public E peek() {
    return myQueue.get(0);
  }

  public int size() {
    return myQueue.size();
  }

  public boolean isEmpty() {
    return myQueue.size() == 0;
  }
}
