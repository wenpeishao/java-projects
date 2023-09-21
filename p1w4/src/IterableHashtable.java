import java.util.Iterator;

public class IterableHashtable<KeyType, ValueType> extends HashtableMap implements IterableMapADT {
	
	public IterableHashtable(int capacity) {
		super(capacity);
	}

	public IterableHashtable() {
		super();
	}
	@Override
	public Iterator iterator() {
		return new HashIterator<KeyType, ValueType>(array);
	}

}

