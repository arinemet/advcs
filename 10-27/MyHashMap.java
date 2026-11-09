/*
MyHashMap<K,V>
Instance Variables
- hashArray : Object[] 
- size : int
- keySet:MyHashSet<K> 
Constructor
+MyHashMap() - Sets up the instance variables.  The size of hashArray should be able to store ID numbers from 0000 to 9999.
Methods
+put(K,V) : V- Takes in a key and value. Insert into the keySet and hashArray.  Adjust the size accordingly.  Return the previous value or null if there is none.
+get(Object) : V - Returns the value given a key object if the key location exists. Otherwise return null.  
+remove(Object) : V - Takes in a key object. Remove the given key and corresponding value from the keySet and hashArray, respectively.  Adjust the size accordingly.  Return the value that was removed or null otherwise.  
+size() : int - Return the size.
+keySet() : MyHashSet<K> - Return a set of keys. 
 */

public class MyHashMap<K, V> {
  private Object[] hashArray;
  private int size;
  private MyHashSet<K> keySet;

  public MyHashMap() {
    hashArray = new Object[10000];
    size = 0;
    keySet = new MyHashSet<>();
  }

  public V put(K key, V value) {
    int index = key.hashCode();
    V previous = (V) hashArray[index];
    if (previous == null) {
      keySet.add(key);
      size++;
    }
    hashArray[index] = value;
    return previous;
  }

  public V get(Object key) {
    int index = key.hashCode();
    return (V) hashArray[index];
  }

  public V remove(Object key) {
    int index = key.hashCode();
    V previous = (V) hashArray[index];
    if (previous == null) {
      return null;
    }
    keySet.remove(key);
    hashArray[index] = null;
    size--;
    return previous;
  }

  public int size() {
    return size;
  }

  public MyHashSet<K> keySet() {
    return keySet;
  }

}