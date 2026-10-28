/*
Instance Variables.
- hashArray : Object[ ]
- size : int
Constructor(s)
+ MyHashSet() - Instantiate the hashArray. Make sure to have an array size big 
enough to fit the hashCode numbers from the Student class. Set size to 0.
Method(s)
+ add(E) : boolean - Return true if successful.  If the element already exists, 
leave it unchanged and return false.  Don't forget to adjust the size variable.
+ clear() : void - Clear out all elements.  Don't forget to adjust the size variable.
+ contains(Object) : boolean -  Get the hashcode and check if it exists in the array 
location. Check if the element is the szpame by calling the equals method. Return true if 
successful.  
+ remove(Object) : boolean - Get the hashcode and check if it exists in the array.  Check 
if the element is the same by calling the equals method.  If all is true, remove it. (Hint: set 
it to null).  Return true if successful.  Don't forget to adjust the size variable.
+ size() : int - Return the size.
+ toDLList : DLList<E> - This will return a DLList<E> of all the items in your
MyHashSet.  (Hint: One way to approach this is to create a DLList, go through the 
hashtable, and all the non-null elements in it.  Return the DLList. ) 
*/

public class MyHashSet<E> {
  private Object[] hashArray;
  private int size;

  public MyHashSet() {
    hashArray = new Object[10000];
    size = 0;
  }

  private int getIndex(Object element) {
    return Math.abs(element.hashCode()) % hashArray.length;
  }

  public boolean add(E element) {
    if (element == null) {
      return false;
    }

    int index = getIndex(element);

    if (hashArray[index] == null) {
      hashArray[index] = element;
      size++;
      return true;
    }
    return false;
  }

  public void clear() {
    hashArray = new Object[10000];
    size = 0;
  }

  public boolean remove(Object element) {
    if (element == null) {
      return false;
    }

    int index = getIndex(element);
    if (hashArray[index] != null && hashArray[index].equals(element)) {
      hashArray[index] = null;
      size--;
      return true;
    }
    return false;
  }

  public boolean contains(Object element) {
    if (element == null) {
      return false;
    }

    int index = getIndex(element);
    return hashArray[index] != null && hashArray[index].equals(element);
  }

  public int size() {
    return size;
  }

  public DLList<E> toDLList() {
    DLList<E> list = new DLList<>();
    for (Object obj : hashArray) {
      if (obj != null) {
        list.add((E) obj);
      }
    }
    return list;
  }
}