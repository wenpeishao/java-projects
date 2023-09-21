// --== CS400 Project One File Header ==--
// Name: <Wenpei Shao>
// CSL Username: <wenpei>
// Email: <wshao33@wisc.edu email address>
// Lecture #: <003 @2:25pm>
// Notes to Grader: <any optional extra notes to your grader>
import java.util.NoSuchElementException;
import java.util.LinkedList;

public class HashtableMap<KeyType, ValueType> implements MapADT<KeyType, ValueType> {
  /**
   * use exactly one protected single-dimensional array instance field.
   * 
   * Note: You cannot instantiate an array with an associated generic type in Java. So you should
   * instantiate the array for your hashtable using the raw type (without any generic
   * specifications) and then cast to the complete type that includes generics before storing this
   * reference in a protected instance field. This will produce an unchecked cast warning that can
   * either be ignored, or suppressed by adding the @SuppressWarnings("unchecked") annotation in
   * front of the line of code with the cast.
   * 
   * @author wenpeishao
   *
   * @param <KeyType>
   * @param <ValueType>
   */
  protected class HashNode<KeyType, ValueType> {
    private KeyType k;
    private ValueType v;

    public HashNode(KeyType k, ValueType v) { // CONSTRUCTOR
      this.k = k;
      this.v = v;
    }
  }

  private Object[] hashTable;
  private int tableCapacity = 15; // size of the hash table
  private double loadFactor = 0.7; // maximum factor require to double the size of the table
  private int count = 0;// number of items in the current table

  /**
   * constructors class with param capacity
   * 
   * @param capacity
   */
  public HashtableMap(int capacity) {
    tableCapacity = capacity;
    hashTable = new Object[tableCapacity];
  }

  /**
   * constructors class without param capacity with default capacity = 15
   * 
   * @param capacity
   */
  public HashtableMap() {
    tableCapacity = 15;
    hashTable = new Object[tableCapacity];
  } // with default capacity = 15

  /**
   * Inserts a new (key, value) pair into the map if the map does not contain a value mapped to key
   * yet.
   * 
   * @param key   the key of the (key, value) pair to store
   * @param value the value that the key will map to
   * @return true if the (key, value) pair was inserted into the map, false if a mapping for key
   *         already exists and the new (key, value) pair could not be inserted
   */
  @Override
  public boolean put(KeyType key, ValueType value) {
    if (key == null) {
      return false;
    }
    resize();
    int hashNum = getHashNum(key);
    if (hashTable[hashNum] == null) {
      hashTable[hashNum] = new LinkedList<HashNode>();
      ((LinkedList<HashNode>) hashTable[hashNum]).add(new HashNode<KeyType, ValueType>(key, value));
      count++;
    } else {
      if (containsKey(key)) {
        return false;
      } else {
        LinkedList<HashNode> temp = (LinkedList<HashNode>) hashTable[hashNum];
        temp.add(new HashNode<KeyType, ValueType>(key, value));
        count++;
      }
    }
    return true;
  }

  /**
   * Returns the value mapped to a key if the map contains such a mapping.
   * 
   * @param key the key for which to look up the value
   * @return the value mapped to the key
   * @throws NoSuchElementException if the map does not contain a mapping for the key
   */
  @Override
  public ValueType get(KeyType key) throws NoSuchElementException {
    int i = getHashNum(key);
    LinkedList<HashNode> tempHashList = (LinkedList<HashNode>) hashTable[i];
    if (tempHashList == null) {
      throw new NoSuchElementException("the map does not contain a mapping for the key");
    }
    for (int j = 0; j < tempHashList.size(); j++) {
      HashNode<KeyType, ValueType> tempNode = tempHashList.get(j);
      if (tempNode.k.equals(key)) {
        tempNode = tempHashList.get(j);
        return tempNode.v;
      }
    }
    throw new NoSuchElementException("the map does not contain a mapping for the key");
  }

  /**
   * Removes a key and its value from the map.
   * 
   * @param key the key for the (key, value) pair to remove
   * @return the value for the (key, value) pair that was removed, or null if the map did not
   *         contain a mapping for key
   */
  @Override
  public ValueType remove(KeyType key) {

    int i = getHashNum(key);

    LinkedList<HashNode> tempHashList = (LinkedList<HashNode>) hashTable[i];
    if (tempHashList == null) {
      return null;
    }
    for (int j = 0; j < tempHashList.size(); j++) {
      HashNode<KeyType, ValueType> tempNode = tempHashList.get(j);
      if (tempNode.k.equals(key)) {
        tempNode = tempHashList.remove(j);
        count--;
        return tempNode.v;
      }
    }
    return null;
  }

  /**
   * Checks if a key is stored in the map.
   * 
   * @param key the key to check for
   * @return true if the key is stored (mapped to a value) by the map and false otherwise
   */
  @Override
  public boolean containsKey(KeyType key) {
    int i = getHashNum(key);
    LinkedList<HashNode> tempHashList = (LinkedList<HashNode>) hashTable[i];
    if (tempHashList == null) {
      return false;
    }
    for (int j = 0; j < tempHashList.size(); j++) {
      HashNode<KeyType, ValueType> tempNode = tempHashList.get(j);
      if (tempNode.k.equals(key)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Returns the number of (key, value) pairs stored in the map.
   * 
   * @return the number of (key, value) pairs stored in the map
   */
  @Override
  public int size() {

    return count;
  }

  /**
   * Removes all (key, value) pairs from the map.
   */
  @Override
  public void clear() {
    // TODO Auto-generated method stub
    hashTable = new Object[tableCapacity];
    count = 0;
  }

  public int getCapacity() {
    return tableCapacity;
  }

  
  private int getHashNum(KeyType key) {
    int hashCode = key.hashCode();
    int hashNum = Math.abs(hashCode % tableCapacity);
    return hashNum;
  }

  private void resize() {
    double currentFactor = (count + 1.0) / tableCapacity;
    if (currentFactor >= loadFactor) {
      int newCapacity = tableCapacity * 2;
      Object newHashTable[] = new Object[newCapacity];
      for (int i = 0; i < hashTable.length; i++) {
        if (hashTable[i] == null) {
          continue;
        }
        LinkedList<HashNode> tempHashList = (LinkedList<HashNode>) hashTable[i];
        for (int j = 0; j < ((LinkedList<HashNode>) hashTable[i]).size(); j++) {
          int hashNum = Math.abs(((LinkedList<HashNode>) hashTable[i]).get(j).k.hashCode() % newCapacity);
          if (newHashTable[hashNum] == null) {
            newHashTable[hashNum] = new LinkedList<HashNode>();
            ((LinkedList<HashNode>) newHashTable[hashNum])
                .add(new HashNode(tempHashList.get(j).k, tempHashList.get(j).v));
          } else {
            tempHashList.add(new HashNode(tempHashList.get(j).k, tempHashList.get(j).v));
          }
        }
      }
      hashTable = newHashTable;
      tableCapacity = newCapacity;
    }
  }

}
