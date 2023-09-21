import java.util.Iterator;
import java.util.NoSuchElementException;

public class BackwardSongIterator implements Iterator<Song>{
	private LinkedNode<Song> next; //reference to the next linked node in a list of nodes
	public BackwardSongIterator(LinkedNode<Song> last) {
		next = last;
	}
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		if(next != null)
			return true;
		return false;
	}
	@Override
	public Song next() {
		// TODO Auto-generated method stub
		if(next == null)
			throw new NoSuchElementException(" this list is empty.");
		Song retSong = next.getData();
		next = next.getPrev();
		return retSong;
	}
}
