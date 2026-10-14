public class DLList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public DLList() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {

        return size;

    }

    public boolean isEmpty() {

        return size == 0;

    }

    // adds to the end of the list
    public void add(E data) {
        Node<E> n = new Node<E>(data);
        if (head == null) {
            head = n;
            tail = n;
        } else {
            tail.setNext(n);
            n.setPrev(tail);
            tail = n;
        }
        size++;
    }

    public E get(int index) {
        return getNode(index).getData();
    }

    private Node<E> getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<E> cur;
        if (index < size / 2) {
            cur = head;
            for (int i = 0; i < index; i++) {
                cur = cur.getNext();
            }
        } else {
            cur = tail;
            for (int i = size - 1; i > index; i--) {
                cur = cur.getPrev();
            }
        }
        return cur;
    }

    public E remove(int index) {
        Node<E> n = getNode(index);
        if (n.getPrev() == null) {
            head = n.getNext();
        } else {
            n.getPrev().setNext(n.getNext());
        }
        if (n.getNext() == null) {
            tail = n.getPrev();
        } else {
            n.getNext().setPrev(n.getPrev());
        }
        size--;
        return n.getData();
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }
}
