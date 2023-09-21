import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class HashIterator<KeyType, ValueType> implements Iterator<ValueType> {
	private LinkedList<Node<KeyType, ValueType>>[] hashtableArray;
	private int currIndx1 = 0, currIndx2 = 0;

	public HashIterator(LinkedList<Node<KeyType, ValueType>>[] hashtableArray) {
		this.hashtableArray = hashtableArray;
		currIndx1 = 0;
		currIndx2 = -1;
	}

	@Override
	public boolean hasNext() {
		int aci1 = currIndx1, aci2 = currIndx2;
		if (aci1 == hashtableArray.length) {
			return false;
		}
		while (hashtableArray[aci1] == null || aci2 + 1 >= hashtableArray[aci1].size()) {
			aci1++;
			aci2 = -1;
			if (aci1 == hashtableArray.length) {
				return false;
			}
		}
		aci2++;
		return true;

	}

	@Override
	public ValueType next() {
		if (!hasNext()) {
			throw new NoSuchElementException("");
		}
		while (hashtableArray[currIndx1] == null || currIndx2 + 1 >= hashtableArray[currIndx1].size()) {
			currIndx1++;
			currIndx2 = -1;
		}
		currIndx2++;
		return hashtableArray[currIndx1].get(currIndx2).getValue();
	}
}
