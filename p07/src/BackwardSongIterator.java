 import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class models an iterator to play songs in the reverse backward direction from a doubly 
 * linked list of songs

 * @author wenpei
 *
 */
public class BackwardSongIterator extends java.lang.Object implements java.util.Iterator<Song> {
  private LinkedNode<Song> next; //reference to the next linked node in a list of nodes

  /**
   * Creates a new iterator which iterates through songs in back/tail to front/head order

   * @param last - reference to the tail of a doubly linked list of songs
   */
  public BackwardSongIterator(LinkedNode<Song> last) {
    next = last;
  }
  /**
   * Checks whether there are more songs to return
   * 
   * @return
   */
  public boolean hasNext() {
    if(next==null) {
    return false;
    }
    else {
      return true;
    }
  }

  /**
   * Returns the next song in the iteration
   * 
   * @return
   */
  public Song next() {
    if(next==null) {
      throw new NoSuchElementException("there are no more songs to return in the reverse order");
    }
    Song data = next.getData();
    next = next.getPrev();
    return data;

  }
}
