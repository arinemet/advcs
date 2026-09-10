public class MyArrayList<E> {
    private Object[] data;
    private int size;

    public MyArrayList() {
        data = new Object[10];
        size = 0;
    }

    public boolean add(E element) {
        if (size == data.length) {
            grow();
        }
        data[size] = element;
        size++;
        return true;
    }

    // adds at a specific spot, shifts everything else over
    public void add(int index, E element) {
        if (size == data.length) {
            grow();
        }
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = element;
        size++;
    }

    public E get(int index) {
        return (E) data[index];
    }

    // removes by index, shifts everything else back
    public E remove(int index) {
        E removed = (E) data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[size - 1] = null;
        size--;
        return removed;
    }

    // removes by matching object, uses equals
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(o)) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    public void set(int index, E element) {
        data[index] = element;
    }

    public int size() {
        return size;
    }

    // makes a bigger array when full
    private void grow() {
        Object[] bigger = new Object[data.length * 2];
        for (int i = 0; i < data.length; i++) {
            bigger[i] = data[i];
        }
        data = bigger;
    }

    // builds a string of all the elements
    public String toString() {
        String result = "";
        for (int i = 0; i < size; i++) {
            result = result + data[i] + "\n";
        }
        return result;
    }
}
