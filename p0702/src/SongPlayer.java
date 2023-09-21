import java.util.Iterator;
import java.util.NoSuchElementException;

public class SongPlayer implements Iterable<Song> {
  private int size; // size of the list
  private LinkedNode<Song> head; // head of this doubly linked list
  private LinkedNode<Song> tail; // tail of this doubly linked list
  private boolean playingBackward; // true if this song player is reading the
                                   // list backward

  @Override
  public Iterator<Song> iterator() {
    // TODO Auto-generated method stub
    Iterator<Song> is = null;
    if (playingBackward)
      is = new BackwardSongIterator(tail);
    else
      is = new ForwardSongIterator(head);
    return is;
  }

  /**
   * Creates a new instance of song player which contains zero songs and set by default to play
   * songs in the forward direction. [Implementing this constructor is optional since it will be
   * added by default by the compiler]
   */
  public SongPlayer() {
    playingBackward = false;
  }

  /**
   * Adds a Song as Last Song
   * 
   * @param oneSong - the song that is going to be added to the tail of this doubly linked list of
   *                songs
   */
  public void addLast​(Song oneSong) {
    if (oneSong == null) {
      throw new NullPointerException("the passed oneSong is null");
    }
    LinkedNode<Song> newSongNode = null;
    if (tail == null) {
      newSongNode = new LinkedNode<>(null, oneSong, null);
      head = newSongNode;
    } else {
      newSongNode = new LinkedNode<>(tail, oneSong, null);
      tail.setNext(newSongNode);
    }
    tail = newSongNode;
    size++;
  }

  /**
   * add Song as First Song
   * 
   * @param oneSong - the song that is going to be added to the head of this doubly linked list of
   *                songs
   */
  public void addFirst​(Song oneSong) {
    if (oneSong == null) {
      throw new NullPointerException("the passed oneSong is null");
    }
    LinkedNode<Song> newSongNode = null;
    if (head == null) {
      newSongNode = new LinkedNode<>(null, oneSong, null);
      tail = newSongNode;
    } else {
      newSongNode = new LinkedNode<>(head.getPrev(), oneSong, head);
      head.setPrev(newSongNode);
    }
    head = newSongNode;
    size++;
  }

  /**
   * adds Song at a given position/order within this collection of songs
   * 
   * @param index   - the given index where the new song will be added
   * @param oneSong - the song that is going to be added
   */
  public void add​(int index, Song oneSong) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException("index is out of the 0 .. size() range");
    }
    if (oneSong == null) {
      throw new NullPointerException("the passed oneSong is null");
    }

    if (size == 0) {
      addFirst​(oneSong);
      return;
    }
    LinkedNode<Song> currentNode = head;
    for (int i = 0; i < index; i++) {
      currentNode = currentNode.getNext();
    }
    LinkedNode<Song> newNode = new LinkedNode<>(currentNode.getPrev(), oneSong, currentNode);
    currentNode.getPrev().setNext(newNode);
    currentNode.setPrev(newNode);

    size++;

  }

  /**
   * Returns the first Song in this list.
   * 
   * @return the Song at the head of this list
   * 
   */
  public Song getFirst() {
    return head.getData();
  }

  /**
   * Returns the last Song in this list.
   * 
   * @return the Song at the tail of this list
   * 
   */
  public Song getLast() {
    return tail.getData();
  }

  public Song get​(int index) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException("index is out of the 0 .. size() range");
    }
    LinkedNode<Song> currentNode = head;
    for (int i = 0; i < index; i++) {
      currentNode = currentNode.getNext();
    }
    return currentNode.getData();
  }

  /**
   * Removes and returns the first song from this list.
   * 
   * @return the first song from this list
   * 
   */
  public Song removeFirst() {
    if (size == 0 || head == null || tail == null) {
      throw new NoSuchElementException("this list is empty");
    }
    Song retSong = head.getData();
    LinkedNode<Song> tmp = head;
    head = head.getNext();
    head.setPrev(null);
    tmp.setNext(null);
    size--;
    return retSong;
  }

  /**
   * Removes and returns the last song from this list.
   * 
   * @return the last song from this list
   * 
   */
  public Song removeLast() {
    if (size == 0 || head == null || tail == null) {
      throw new NoSuchElementException("this list is empty");
    }
    Song retSong = tail.getData();
    LinkedNode<Song> tmp = tail;
    tail = tail.getPrev();
    tail.setNext(null);
    tmp.setPrev(null);
    size--;
    return retSong;
  }

  /**
   * Removes the song at the specified position in this list and returns the song that was removed
   * from the list.
   * 
   * @param index the index of the song to be removed
   * @return the song previously at the specified position
   */
  public Song remove​(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("index is out of the 0 .. size() range");
    }
    if (index == 0) {
      return removeFirst();
    }
    if (index == size - 1) {
      return removeLast();
    }
    LinkedNode<Song> tmp = head;
    for (int i = 0; i < index; i++) {
      tmp = tmp.getNext();
    }
    Song retSong = tmp.getData();

    tmp.getPrev().setNext(tmp.getNext());
    tmp.getNext().setPrev(tmp.getPrev());
    tmp.setNext(null);
    tmp.setPrev(null);
    size--;
    return retSong;
  }

  /**
   * Returns true if this list contains a match with the specified song.
   * 
   * @param o song whose presence in this list is to be tested
   * @return true if this list contains the specified song
   */
  public boolean contains​(Song o) {
    ForwardSongIterator fsi = new ForwardSongIterator(head);
    while (fsi.hasNext()) {
      if (fsi.next().equals(o))
        return true;
    }
    return false;
  }

  /**
   * Removes all of the songs from this list. The list will be empty after this call returns.
   */
  public void clear() {
    for (int i = 0; i < size; i++)
      removeFirst();
  }

  /**
   * Returns true if this list is empty.
   * 
   * 
   * @return true if this list is empty
   * 
   */
  public boolean isEmpty() {
    if (size == 0)
      return true;
    return false;
  }

  public int size() {
    return size;
  }

  /**
   * Mutator of the playingDirection of this song player. It switches the playing direction by
   * setting playingBackward to its opposite value.
   * 
   */
  public void switchPlayingDirection() {
    playingBackward = !playingBackward;
  }

  /**
   * Plays the songs in this song player in the current playing direction. This method MUST be
   * implemented using an enhanced for-each loop.
   * 
   * @return a String representation of the songs in this song player. String representations of
   *         each song are separated by a newline. If this song player is empty, this method returns
   *         an empty string.
   * 
   */
  public String play() {
    String ret = "";
    Iterator<Song> is = iterator();
    while (is.hasNext()) {
      ret += is.next() + "\n";
    }
    return ret;
  }
}
