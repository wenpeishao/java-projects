import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardSongIterator implements Iterator<Song>{
	private LinkedNode<Song> next; //reference to the next linked node in a list of nodes.
	
	public ForwardSongIterator(LinkedNode<Song> first) {
		next = first;
	}
	
	public boolean hasNext() {
		if(next!=null)
			return true;
		return false;
		
	}
	
	public Song next() {
		if(next == null)
			throw new NoSuchElementException(" this list is empty.");
		Song retSong = next.getData();
		next = next.getNext();		
		return retSong;
		
	}
}
