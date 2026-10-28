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
    // indeces 0000 -> 9999
    hashArray = new Object[10000];
    size = 0;
    keySet = new MyHashSet<>();
  }

  public V put(K key, V value) {
    V previous = null;
    if (hashArray[key.hashCode()] != null) {
      previous = (V) hashArray[key.hashCode()];
    }
    keySet.add(key);
    hashArray[key.hashCode()] = value;
    size++;
    return previous;

  }

  public V get(Object key) {
    return (V) hashArray[key.hashCode()];
  }

  public V remove(Object key) {
    V previous = null;
    if (hashArray[key.hashCode()] != null) {
      previous = (V) hashArray[key.hashCode()];
      keySet.remove(key);
      hashArray[key.hashCode()] = null;
      size--;
    }
    return previous;
  }

  public int size() {
    return size;
  }

  public MyHashSet<K> keySet() {
    return keySet;
  }
}