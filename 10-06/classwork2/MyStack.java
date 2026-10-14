public class MyStack<E> {
  private DLList<E> myStack;

  public MyStack() {
    myStack = new DLList<E>();
  }

  public E push(E item) {
    myStack.add(item);
    return item;
  }

  public E pop() {
    return myStack.remove(myStack.size() - 1);
  }

  public E peek() {
    return myStack.get(myStack.size() - 1);
  }

  public int size() {
    return myStack.size();
  }

  public boolean empty() {
    return myStack.size() == 0;
  }
}
