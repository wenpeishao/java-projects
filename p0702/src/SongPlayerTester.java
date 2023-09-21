import java.time.format.DateTimeFormatter;

// File header comes here
/**
 * This class implements unit test methods to check the correctness of Song,
 * LinkedNode, SongPlayer ForwardSongIterator and BackwardSongIterator classes
 * in P07 Iterable Song Player assignment.
 *
 */
public class SongPlayerTester {
	/**
	 * This method test and make use of the Song constructor, an accessor
	 * (getter) method, overridden method toString() and equal() method defined
	 * in the Song class.
	 * 
	 * @return true when this test verifies a correct functionality, and false
	 *         otherwise
	 */
	public static boolean testSong() {
		Song song1 = new Song("abc", "123", "2:30");
		boolean getter = false;
		if (song1.getArtist().equals("123") && song1.getSongName().equals("abc")
				&& song1.getDuration().equals("2:30"))
			getter = true;
		boolean toStringTest = false;
		if (song1.toString().equals("abc---123---2:30"))
			toStringTest = true;
		boolean equalTest = false;
		Song song2 = new Song("abc", "123", "3:30");
		Song song3 = new Song("abcd", "123", "3:30");
		Song song4 = new Song("abc", "1234", "3:30");
		if (song1.equals(song2) && !song1.equals(song3) && !song1.equals(song4))
			equalTest = true;
		if (getter && toStringTest && equalTest) {
			return true;
		}
		return false;
	}

	/**
	 * This method test and make use of the LinkedNode constructor, an accessor
	 * (getter) method, and a mutator (setter) method defined in the LinkedCart
	 * class.
	 * 
	 * @return true when this test verifies a correct functionality, and false
	 *         otherwise
	 */
	public static boolean testLinkedNode() {
		Song s1 = new Song("痴心绝对","李圣杰","04:21");
		Song s2 = new Song("蓝莲花","许巍","04:21");
		Song s3 = new Song("小微","Mature麻月辉","03:15");
		LinkedNode<Song> first = new LinkedNode<>(null,s1,null);
		LinkedNode<Song> second = new LinkedNode<>(first,s2,null);
		LinkedNode<Song> third = new LinkedNode<>(second,s3,null);
		first.setNext(second);
		second.setNext(third);
		ForwardSongIterator forwardSongIterator = new ForwardSongIterator(first);
		while(forwardSongIterator.hasNext()) {
			System.out.println(forwardSongIterator.next());
		}
		return false;
	}

	/**
	 * This method checks for the correctness of addFirst(), addLast() and
	 * add(int index) method in SongPlayer class
	 * 
	 * @return true when this test verifies a correct functionality, and false
	 *         otherwise
	 */
	public static boolean testSongPlayerAdd() {
		return false;
	}

	/**
	 * This method checks for the correctness of getFirst(), getLast() and
	 * get(int index) method in SongPlayer class
	 * 
	 * @return true when this test verifies a correct functionality, and false
	 *         otherwise
	 */
	public static boolean testSongPlayerGet() {
		return false;
	}

	/**
	 * This method checks for the correctness of removeFirst(), removeLast() and
	 * remove(int index) method in SongPlayer class
	 * 
	 * @return true when this test verifies a correct functionality, and false
	 *         otherwise
	 */
	public static boolean testSongPlayerRemove() {
		return false;
	}

	/**
	 * This method checks for the correctness of iterator(),
	 * switchPlayingDirection() and String play() method in SongPlayer class
	 * 
	 * @return true when this test verifies a correct functionality, and false
	 *         otherwise
	 */
	public static boolean testSongPlayerIterator() {
		return false;
	}

	/**
	 * This method checks for the correctness of contains(Object song), clear(),
	 * isEmpty()and size() method in SongPlayer class
	 * 
	 * @return true when this test verifies a correct functionality, and false
	 *         otherwise
	 */
	public static boolean testSongPlayerCommonMethod() {
		return false;
	}

	/**
	 * This method checks for the correctness of ForwardSongIterator class
	 * 
	 * @return true when this test verifies a correct functionality, and false
	 *         otherwise
	 */
	public static boolean testForwardSongIterator() {
		return false;
	}

	/**
	 * This method checks for the correctness of BackwardSongIterator class
	 * 
	 * @return true when this test verifies a correct functionality, and false
	 *         otherwise
	 */
	public static boolean testBackwardSongIterator() {
		return false;
	}

	/**
	 * This method calls all the test methods defined and implemented in your
	 * SongPlayerTester class.
	 * 
	 * @return true if all the test methods defined in this class pass, and
	 *         false otherwise.
	 */
	public static boolean runAllTests() {
		return false;
	}

	/**
	 * Driver method defined in this SongPlayerTester class
	 * 
	 * @param args
	 *            input arguments if any.
	 */
	public static void main(String[] args) {
//		if (testSong()) {
//			System.out.println("testSong() pass...");
//		} else {
//			System.out.println("testSong() nopass...");
//		}
//		
//		if (testLinkedNode()) {
//			System.out.println("testLinkedNode() pass...");
//		} else {
//			System.out.println("testLinkedNode() nopass...");
//		}
		
//		SongPlayer songList = new SongPlayer();
//		songList.addFirst​(new Song("Mojito", "Jay Chou", "3:05"));
//		songList.addFirst​(new Song("Secret", "Jay Chou", "4:56"));
//		songList.addFirst​(new Song("Clear Day", "Jay Chou", "4:59"));
//		songList.addFirst​(new Song("Dragon Fist", "Jay Chou", "4:32"));
//		songList.addFirst​(new Song("Out of Time", "The Weeknd", "3:34"));
//		songList.addLast​(new Song("StarBoy", "The Weeknd", "3:50"));
//		songList.addLast​(new Song("Save Your Tears", "The Weeknd", "3:35"));
//		songList.add​(1, new Song("Simple Love", "Jay Chou", "4:30"));
//		songList.add​(2, new Song("Superman Can’t Fly", "Jay Chou", "4:59"));
//		songList.addLast​(new Song("Oh My God", "Adele", "3:45"));
//		songList.addLast​(new Song("Levitating", "Dua Lipa", "3:23"));
//		songList.add​(6, new Song("Be Kind", "Marshmello & Halsey", "2:53"));
//		System.out.println("---------------- Play Forward -----------------");
//		System.out.println(songList.play());
//		System.out.println("------------------------------------------------");
//		System.out.println("songList.remove(6) -- Be Kind -- removed\n" + "songList.removeFirst(); -- Out of Time -- removed\n" + "songList.removeLast(); -- Levitating -- removed\n");
//		songList.remove​(6);
//		songList.removeFirst();
//		songList.removeLast();
//		System.out.println("---------------- Play Forward -----------------");
//		System.out.println(songList.play());
//		System.out.println("------------------------------------------------");
//		Song oneSong = new Song("Mojito", "Jay Chou", "3:05");
//		System.out.print("songList.contains(new Song(\"Mojito\", \"Jay Chou\", \"3:05\"): ");
//		System.out.println(songList.contains​(oneSong));
//		System.out.println();
//		System.out.println("songList.size(): " + songList.size());
//		System.out.println();
//		System.out.print("songList.contains(new Song(\"Be Kind\", \"Marshmello & Halsey\", \"2:53\"): ");
//		oneSong = new Song("Be Kind", "Marshmello & Halsey", "2:53");
//		System.out.println(songList.contains​(oneSong));
//		System.out.println();
//		System.out.println("---------------- Play Forward -----------------");
//		System.out.println(songList.play());
//		System.out.println();
//		System.out.println("---------------- Play Backward -----------------");
//		songList.switchPlayingDirection();
//		System.out.println(songList.play());
//		System.out.println("------------------------------------------------");
		
		
		String duration = "4:23";
		if(duration.matches("([0-5]?\\d):([0-5]?\\d)")) {
			System.out.println("True");
		}else{
			System.out.println("False");
		}
	}
}
