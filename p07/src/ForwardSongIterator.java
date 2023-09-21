import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class models an iterator to play songs in the rforward direction from a doubly linked list
 * of songs
 * 
 * @author wenpei
 *
 */
public class ForwardSongIterator extends java.lang.Object implements java.util.Iterator<Song> {
  
  private LinkedNode<Song> next; // reference to the next linked node in a list of nodes.

  /**
   * Creates a new iterator which iterates through songs in front/head to back/tail order
   * 
   * 
   * @param first - reference to the head of a doubly linked list of songs
   */
  public ForwardSongIterator(LinkedNode<Song> first) {
    next=first;

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
    next = next.getNext();
    return data;
  }
}

