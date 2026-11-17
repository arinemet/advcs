/*MyHashMap<K,V>
Instance Variables
- hashArray : Object[]
- size : int
- keySet : MyHashSet<K>
Constructor
	+MyHashMap() - Sets up the instance variables.
Methods
+put(K,V) : V- Takes in a key and value. Insert into the keySet and hashArray.  Adjust the size accordingly.  Return the previous value or null if there is none.  Return the previous value or null if there is none.
+get(Object) : V - Returns the value given a key object.  Because you will be casting an array to generic, you may want to add the @SuppressWarnings("unchecked").
+remove(Object) : V - Takes in a key object. Remove the key-value pair from the hashArray and keySet.  Adjust the size. Return the value that was removed.  You may want to add the @SuppressWarnings("unchecked").
+size() : int - Return the size.
+keySet() : MyHashSet<K> - Return a set of keys.
*/

public class MyHashMap<K, V> {

  private Object[] hashArray;
  private int size;
  private MyHashSet<K> keySet;

  public MyHashMap() {
    this.hashArray = new Object[676];
    this.size = 0;
    this.keySet = new MyHashSet<>();
  }

  public V put(K key, V value) {
    int index = key.hashCode();
    V previous = (V) hashArray[index];
    if (previous == null) {
      size++;
    }
    hashArray[index] = value;
    keySet.add(key);
    return previous;
  }

  public V get(Object key) {
    int index = key.hashCode();
    return (V) hashArray[index];
  }

  public V remove(Object key) {
    int index = key.hashCode();
    V previous = (V) hashArray[index];
    if (previous != null) {
      size--;
      hashArray[index] = null;
    }
    keySet.remove(key);
    return previous;
  }

  public int size() {
    return size;
  }

  public MyHashSet<K> keySet() {
    return keySet;
  }
}
