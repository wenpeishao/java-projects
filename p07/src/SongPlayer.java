import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class models an iterable collection of songs. Songs can be played in the forward or reverse
 * order.
 * 
 * @author wenpei
 *
 */
public class SongPlayer extends java.lang.Object implements java.lang.Iterable<Song> {
  private int size; //size of the list
  private LinkedNode<Song> head; //head of this doubly linked list
  private LinkedNode<Song> tail; //tail of this doubly linked list
  private boolean playingBackward; //true if this song player is reading the list backward
  /**
   *  Creates a new instance of song player which contains zero songs and set by default to play songs in the forward direction. [Implementing this constructor is optional since it will be added by default by the compiler]
   */
  public SongPlayer() {
    playingBackward=false;
  }
  /**
   * Adds a Song as Last Song

   * @param oneSong - the song that is going to be added to the tail of this doubly linked list of songs
   */
  public void addLast​(Song oneSong) {
    if(oneSong==null) {
      throw new NullPointerException("the passed oneSong is null");
    }
    LinkedNode<Song> newNode = new LinkedNode<Song>(tail,oneSong,null);
    if(size==0) {
      head=newNode;
      tail=newNode;
      
    }else {
      tail.setNext(newNode);
      tail = newNode;
    }
    size++;
  }
  /**
   * add Song as First Song

   * @param oneSong - the song that is going to be added to the head of this doubly linked list of songs
   */
  public void addFirst​(Song oneSong) {
    if(oneSong==null) {
      throw new NullPointerException("the passed oneSong is null");
    }
    LinkedNode<Song> newNode = new LinkedNode<Song>(null,oneSong,head);
    
    if(size==0) {
      head=newNode;
      tail=newNode;
    }else {
      head.setPrev(newNode);
      head = newNode;
    }
    size++;
  }
  /**
   * adds Song at a given position/order within this collection of songs

   * @param index - the given index where the new song will be added
   * @param oneSong - the song that is going to be added
   */
  public void add​(int index,
      Song oneSong) {
    if(oneSong==null) {
      throw new NullPointerException("the passed oneSong is null");
      
    }
    if(index>size||index<0) {
      throw new IndexOutOfBoundsException("index is out of the 0 .. size() range");
    }
    if(size==0) {
      addFirst​(oneSong);
    }
    else {
      LinkedNode<Song> temp = head;
      for(int i=0;i<index;i++ ) {
        temp = temp.getNext();
        
      }
      LinkedNode<Song> newNode = new LinkedNode<Song>(temp,oneSong,temp.getNext());
      temp.getNext().setPrev(newNode);
      temp.setNext(newNode);
      size++;
    }
  }
  /**
   * Returns the first Song in this list.
   * @return the Song at the head of this list

   */
  public Song getFirst() {
    if(size==0) {
      throw new NoSuchElementException ("this list is empty");
      
    }
    return head.getData();
  }
  /**
   * Returns the last Song in this list.

   * @return the Song at the tail of this list

   */
  public Song get​(int index) {

    if (index < 0 || index >=size()) { // index out of bounds
      throw new IndexOutOfBoundsException(
          "\nWARNING: Index " + "should be from 0 to " + (size() - 1) + "!");
    }
    LinkedNode<Song>current=head;
    int count=0;

    if(index==0)
      return current.getData();

    //LinkedNode<Song>node=head;

    while(current!=null) {
      current=current.getNext();
      count++;
      if(count==index) {
        return current.getData();
      }
    }

    return null;
  }

  /**
   * Removes and returns the first song from this list.

   * @return the first song from this list

   */
  public Song removeFirst(){
    if(size==0) {
      throw new NoSuchElementException ("this list is empty");
    }
    head.getNext().setPrev(null);
    LinkedNode<Song> temp =head;
    head = head.getNext();
    size--;
    temp.setNext(null);
    return head.getData();
  }
  /**
   * Removes and returns the last song from this list.

   * @return the last song from this list

   */
  public Song removeLast() {
    if(size==0) {
      throw new NoSuchElementException ("this list is empty");
    }
    tail.getPrev().setNext(null);
    LinkedNode<Song> temp =tail;
    tail = tail.getPrev();
    size--;
    return tail.getData();
  }

  /**
   * Removes the song at the specified position in this list and returns the song that was removed 
   * from the list.
   * @param index the index of the song to be removed
   * @return the song previously at the specified position
   */
  public Song remove​(int index) {
    if (index < 0 || index >= size()) {
      throw new IndexOutOfBoundsException(
          "\nWARNING: Index " + "should be from 0 to " + (size() - 1) + "!");

    }
    int count=0;
    LinkedNode<Song>current=head;
    Song a=null;
    while(current!=null) {
      current=current.getNext();
      count++;
      if(count==index) {
        a=new Song(current.getData().getSongName(),current.getData().getArtist(),current.getData()
            .getDuration());
        current.setPrev(new LinkedNode<Song>(current.getPrev().getPrev(),current.getPrev().
            getData(),current.getNext()));

      }


    }
    size--;
    return a;
  }
  /**
   * Returns true if this list contains a match with the specified song.
   * @param o  song whose presence in this list is to be tested
   * @return true if this list contains the specified song
   */
  public boolean contains​(Song o) {
    if (isEmpty()) // empty list
      return false;
    LinkedNode<Song>current=head;
    while(current!=null) {

      if(current.getData().equals(o)) {
        return true;
      }
      current=current.getNext();
    }
    return false;
  }

  /**
   * Removes all of the songs from this list. The list will be empty after this call returns.
   */
  public void clear() {
    for(int i=0;i<size;i++) {
      remove​(i);
    }
    head = null;
    tail = null;
    size = 0;
   }
  /**
   * Returns true if this list is empty.


   * @return true if this list is empty

   */
  public boolean isEmpty() {
    if(size==0) {
      return true;
    }
    return false;
  }
  public int size() {
    return size;
  }

  @Override
  public Iterator<Song> iterator() {
    if(playingBackward==true) {
      return new BackwardSongIterator(tail);
    }
    else {
      //ForwardSongIterator temp = new ForwardSongIterator(head);
      return new ForwardSongIterator(head);
    }
  }
  /**
   * Mutator of the playingDirection of this song player. It switches the playing direction by setting playingBackward to its opposite value.

   */
  public void switchPlayingDirection() {
    playingBackward = !playingBackward;
  }
  /**
   * Plays the songs in this song player in the current playing direction. This method MUST be implemented using an enhanced for-each loop.

   * @return a String representation of the songs in this song player. String representations of each song are separated by a newline. If this song player is empty, this method returns an empty string.

   */
  public java.lang.String play(){
    String list="";
    Iterator<Song> iter=iterator();

    while(iter.hasNext()) {
      list+=iter.next().toString()+"\n";
    }
    return list;
    
  }

  /**
   * Returns the last Song in this list.

   * @return the Song at the tail of this list

   */
  public Song getLast() {
    if(size==0) {
      throw new NoSuchElementException ("this list is empty");
    }
    return tail.getData();
  }
}
