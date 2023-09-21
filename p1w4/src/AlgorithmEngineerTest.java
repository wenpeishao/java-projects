import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class AlgorithmEngineerTest {
	/**
	 * testing last week's implementation of HashtableMap
	 * 
	 * @return true if HashtableMap passes the tests and false otherwise
	 */
	public static boolean test1() {
		// using put normally when no errors are expected
		try {
			HashtableMap hash = new HashtableMap<Integer, String>(10);
			if (!hash.put(1, "A")) {
				return false;
			}
			if (!hash.put(2, "B")) {
				return false;
			}
			if (!hash.put(3, "C")) {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		// using put with a key that already exists or if a key is null
		try {
			HashtableMap hash = new HashtableMap<Integer, String>(10);
			if (!hash.put(1, "A")) {
				return false;
			}
			if (!hash.put(2, "B")) {
				return false;
			}
			if (!(hash.containsKey(1) && hash.containsKey(2))) {
				return false;
			}
			if (hash.put(1, "C")) {
				return false;
			}
			if (hash.put(null, "X")) {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		// using put when the threshold is reached
		try {
			HashtableMap hash = new HashtableMap<Integer, String>(2);
			if (!hash.put(1, "A")) {
				return false;
			}
			if (!hash.put(2, "B")) {
				return false;
			}
			if (!hash.put(3, "C")) {
				return false;
			}
			if (!hash.put(4, "D")) {
				return false;
			}
			if (!(hash.containsKey(1) && hash.containsKey(2) && hash.containsKey(3) && hash.containsKey(4))) {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		// using get when the map does not contain the key
		try {
			HashtableMap hash = new HashtableMap<Integer, String>(10);
			hash.put(1, "A");
			hash.put(2, "B");
			hash.put(3, "C");
			hash.get(4);

			return false;
		} catch (NoSuchElementException e) {

		} catch (Exception e) {
			return false;
		}
		// using get when the key is null
		try {
			HashtableMap hash = new HashtableMap<Integer, String>(10);
			hash.put(1, "A");
			hash.put(2, "B");
			hash.put(3, "C");
			hash.get(null);
			return false;
		} catch (NoSuchElementException e) {

		} catch (Exception e) {
			return false;
		}
		// using get when the map does contain the key
		try {
			HashtableMap hash = new HashtableMap<Integer, String>(10);
			hash.put(1, "A");
			hash.put(2, "B");
			hash.put(3, "C");
			String s = (String) hash.get(2);
			if (!s.equals("B")) {
				return false;
			}
		} catch (NoSuchElementException e) {
			return false;
		} catch (Exception e) {
			return false;
		}
		// removing a key that is in the hashtable
		try {
			HashtableMap hash = new HashtableMap<Integer, String>(10);
			hash.put(1, "A");
			hash.put(2, "B");
			hash.put(3, "C");
			if (hash.remove(2) != "B" || hash.containsKey(2)) {

				return false;
			}
		} catch (Exception e) {
			return false;
		}
		// removing a non-existent key
		try {
			HashtableMap hash = new HashtableMap<Integer, String>(10);
			hash.put(1, "A");
			hash.put(2, "B");
			hash.put(3, "C");
			if (hash.remove(4) != null) {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		// checking if a key that does exist is there or not
		try {
			HashtableMap hash = new HashtableMap<Integer, String>(10);
			hash.put(1, "A");
			hash.put(2, "B");
			hash.put(3, "C");
			if (!hash.containsKey(3) || !hash.containsKey(2) || !hash.containsKey(1)) {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		// checking if a key that does not exist is there or not
		try {
			HashtableMap hash = new HashtableMap<Integer, String>(10);
			hash.put(1, "A");
			hash.put(2, "B");
			hash.put(3, "C");
			if (hash.containsKey(4)) {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		// checking size()
		try {
			HashtableMap hash = new HashtableMap<Integer, String>(4);
			// checking when empty
			if (hash.size() != 0) {

				return false;
			}
			// checking after adding two elements
			hash.put(1, "A");
			hash.put(2, "B");
			if (hash.size() != 2) {
				return false;
			}

			// checking after adding two more (it will rehash\expand)
			hash.put(3, "C");
			hash.put(4, "D");
			if (hash.size() != 4) {
				return false;
			}
			// checking after adding an already existing key\\ size should not change
			hash.put(2, "E");
			if (hash.size() != 4) {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		// checking clear()
		try {
			HashtableMap hash = new HashtableMap<Integer, String>(4);
			// checking when empty
			hash.clear();
			if (hash.size() != 0) {
				return false;
			}
			// checking after adding two elements
			hash.put(1, "A");
			hash.put(2, "B");
			hash.clear();
			if (hash.size() != 0) {
				return false;
			}
			// checking after adding 4 elements (it will rehash\expand)
			hash.put(1, "A");
			hash.put(2, "B");
			hash.put(3, "C");
			hash.put(4, "D");
			hash.clear();
			if (hash.size() != 0) {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/**
	 * testing the hasNext() method
	 * 
	 * @return true if it passes the tests and false otherwise
	 */
	public static boolean test2() {
		// testing on a hastableMap that has some elements
		try {
			IterableHashtable<String, Integer> hashtable = new IterableHashtable<String, Integer>(5);
			hashtable.put("A", 1);
			hashtable.put("B", 2);
			hashtable.put("C", 3);
			hashtable.put("D", 4);
			int sum = 0;
			Iterator iter = hashtable.iterator();
			while (iter.hasNext()) {
				iter.next();
				sum++;
			}

			if (sum != 4) {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		// testing on an empty hashtableMap
		try {
			IterableHashtable<String, Integer> hashtable = new IterableHashtable<String, Integer>();
			int sum = 0;
			Iterator iter = hashtable.iterator();
			while (iter.hasNext()) {
				iter.next();
				sum++;
			}
			if (sum != 0) {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/**
	 * testing the next() method
	 * 
	 * @return true if it passes the tests and false otherwise
	 */
	static boolean test3() {
		// testing on a hastableMap that has some elements
		try {
			IterableHashtable<String, Integer> hashtable = new IterableHashtable<String, Integer>(5);
			hashtable.put("A", 1);
			hashtable.put("B", 2);
			hashtable.put("C", 3);
			hashtable.put("D", 4);
			int sum = 0;
			Iterator iter = hashtable.iterator();
			int arr[] = new int[4];
			int origArr[] = { 1, 2, 3, 4 };
			while (iter.hasNext()) {
				arr[sum] = (int) iter.next();
				sum++;
			}
			Arrays.sort(arr);

			if (!Arrays.equals(arr, origArr)) {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		// testing on an empty hashtableMap
		try {
			IterableHashtable<String, Integer> hashtable = new IterableHashtable<String, Integer>(5);
			int sum = 0;
			Iterator iter = hashtable.iterator();
			int arr[] = {};
			while (iter.hasNext()) {
				arr[sum] = (int) iter.next();
				sum++;
			}
			if (arr.length != 0) {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public static boolean test4() {
		// testing on a hastableMap that has some elements
		try {
			IterableHashtable<String, Integer> hashtable = new IterableHashtable<String, Integer>(5);
			hashtable.put("A", 1);
			hashtable.put("B", 2);
			hashtable.put("C", 3);
			hashtable.put("D", 4);
			int sum = 0;
			Iterator iter = hashtable.iterator();
			int arr[] = new int[4];
			int origArr[] = { 1, 2, 3, 4 };
			for (Object a : hashtable) {
				arr[sum] = (int) a;
				sum++;
			}
			Arrays.sort(arr);
			if (!Arrays.equals(arr, origArr)) {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public static boolean test5() {
		// testing a valid IISBN
		try {
			String iisbn = "9780306406157";
			IISBNVal val = new IISBNVal();
			if (val.validate(iisbn) == false) {
				return false;
			}
		} catch (Exception e) {

		}
		// testing an invalid IISBN
		try {
			String iisbn = "9780306406153";
			IISBNVal val = new IISBNVal();
			if (val.validate(iisbn) == true) {
				return false;
			}
		} catch (Exception e) {

		}
		return true;
	}

	public static boolean RunAllTests() {
		return test1() && test2() && test3() && test4() && test5();
	}

	public static void main(String[] args) {
		System.out.println(RunAllTests());
	}
}
