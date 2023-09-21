// --== CS400 Project One File Header ==--
// Name: Abdullah Aljohani 
// CSL Username: aljohani
// Email: aaljohani@wisc.edu
// Lecture #: 003
// Notes to Grader: <any optional extra notes to your grader>
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * A class that serves as a container for the key and value elements
 * @author Abdullah Aljohani
 * @param KeyTyper
 * @param ValueType
 */
class Node<KeyType, ValueType> {
    public KeyType key;
    public ValueType value;

    public Node(KeyType key, ValueType value) {
        this.key = key;
        this.value = value;
    }

    KeyType getKey() {
        return key;
    }

    ValueType getValue() {
        return value;
    }
}

/**
 * A class for Hashtable Map data structure
 * 
 * @author Abdullah Aljohani
 * @param KeyType
 * @param ValueType
 */
public class HashtableMap<KeyType, ValueType> implements MapADT<KeyType, ValueType> {
    private int capacity;
    protected LinkedList<Node<KeyType, ValueType>>[] array;

    public HashtableMap(int capacity) {
        this.capacity = capacity;
        array = new LinkedList[capacity];
    }

    public HashtableMap() {
        this.capacity = 15;
        array = new LinkedList[capacity];
    } // with default capacity = 15

    private void expand() {
        LinkedList<Node<KeyType, ValueType>>[] newArray;
        newArray = new LinkedList[capacity * 2];
        for (int i = 0; i < capacity; i++) {
            if (array[i] == null) {
                continue;
            }
            for (int j = 0; j < array[i].size(); j++) {
                Node<KeyType, ValueType> current = array[i].get(j);
                int index = Math.abs(current.getKey().hashCode()) % (capacity * 2);
                if (newArray[index] == null) {
                    newArray[index] = new LinkedList<Node<KeyType, ValueType>>();
                }
                newArray[index].add(current);
            }
        }
        array = newArray;
        capacity = capacity * 2;
    }

    /**
     * Inserts a new (key, value) pair into the map if the map does not
     * contain a value mapped to key yet.
     * 
     * @param key   the key of the (key, value) pair to store
     * @param value the value that the key will map to
     * @return true if the (key, value) pair was inserted into the map,
     *         false if a mapping for key already exists and the
     *         new (key, value) pair could not be inserted
     */
    @Override
    public boolean put(KeyType key, ValueType value) {
        if (key == null || containsKey(key)) {
            return false;
        }
        Node<KeyType, ValueType> newpair = new Node(key, value);
        int index = Math.abs(key.hashCode()) % capacity;
        if (array[index] == null) {
            array[index] = new LinkedList<Node<KeyType, ValueType>>();
        }
        array[index].add(newpair);
        if (((double) this.size() / (double) capacity) - 0.7 >= 0) {
            expand();
        }
        return true;
    }

    /**
     * Returns the value mapped to a key if the map contains such a mapping.
     * 
     * @param key the key for which to look up the value
     * @return the value mapped to the key
     * @throws NoSuchElementException if the map does not contain a mapping
     *                                for the key
     */
    @Override
    public ValueType get(KeyType key) throws NoSuchElementException {
        if(key==null){
            throw new NoSuchElementException("key is null");
        }
        int index = Math.abs(key.hashCode()) % capacity;
        if(!containsKey(key)) {
            throw new NoSuchElementException("the map does not contain the key");
        }
        ValueType result = (ValueType) array[index].get(0).getValue();
        for (int i = 0; i < array[index].size(); i++) {
            Node current = array[index].get(i);
            if (key.equals(current.getKey())) {
                result = (ValueType) current.getValue();
                break;
            }
        }
        return result;
    }

    /**
     * Removes a key and its value from the map.
     * 
     * @param key the key for the (key, value) pair to remove
     * @return the value for the (key, value) pair that was removed,
     *         or null if the map did not contain a mapping for key
     */
    @Override
    public ValueType remove(KeyType key) {
        int index = Math.abs(key.hashCode()) % capacity;
        if (!containsKey(key)) {
            return null;
        }
        Node<KeyType, ValueType> current = array[index].get(0);
        ValueType result = (ValueType) current.getValue();
        for (int i = 0; i < array[index].size(); i++) {
            current = array[index].get(i);
            if (key.equals(current.getKey())) {
                result = (ValueType) current.getValue();
                array[index].remove(i);
                break;
            }
        }
        return result;
    }

    /**
     * Checks if a key is stored in the map.
     * 
     * @param key the key to check for
     * @return true if the key is stored (mapped to a value) by the map
     *         and false otherwise
     */
    @Override
    public boolean containsKey(KeyType key) {
        int index = Math.abs(key.hashCode()) % capacity;
        if (array[index] == null) {
            return false;
        }
        for (int i = 0; i < array[index].size(); i++) {
            Node<KeyType, ValueType> current = array[index].get(i);
            if (key.equals(current.getKey())) {
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
        int count = 0;
        for (int i = 0; i < capacity; i++) {
            if (array[i] == null)
                continue;
            count += array[i].size();
        }
        return count;
    }

    /**
     * Removes all (key, value) pairs from the map.
     */
    @Override
    public void clear() {
        array = new LinkedList[capacity];
    }

}
