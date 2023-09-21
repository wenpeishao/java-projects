import java.util.NoSuchElementException;

/**
 * A generic implementation of a linked queue
 * 
 * @author wenpeishao
 *
 * @param <T> T - The type of data to be contained in the queue
 * 
 */
public class LinkedQueue<T> extends Object implements QueueADT<T> {
  private int n;// The number of elements in the queue

  protected Node<T> front;// The node at the front of the queue, added LEAST recently

  protected Node<T> back;// The node at the back of the queue, added MOST recently

  /**
   * Adds the given data to this queue; every addition to a queue is made at the back
   * 
   * @param data - the data to add
   * 
   */
  @Override
  public void enqueue(T element) {
    if(element==null) {
      return;
    }
    if (isEmpty()) {
      front = new Node<T>(element);
      back = front;
    } else {
      back.setNext(new Node<T>(element, back));
      back = back.getNext();
    }
    n++;
  }

  /**
   * Removes and returns the item from this queue that was least recently added
   */
  @Override
  public T dequeue() {
    if (isEmpty()) {
      throw new NoSuchElementException("this queue is empty");
    }
    Node<T> item;
    item = front;
    front = front.getNext();
    n--;
    return item.getData();
  }

  /**
   * Returns the item least recently added to this queue without removing it
   */
  @Override
  public T peek() {
    if (isEmpty()) {
      throw new NoSuchElementException("this queue is empty");
    }
    return back.getData();
  }

  /**
   * Checks whether the queue contains any elements
   * 
   */
  @Override
  public boolean isEmpty() {
    
    if (front==null||back==null||n == 0) {
      return true;
    }
    else {
      return false;
    }
  }

  /**
   * Returns the number of items in this queue
   * 
   */
  @Override
  public int size() {
    if(isEmpty()) {
      return 0;
    }
    return n;
  }

  @Override
  public String toString() {
    String fullQueue = "";
    if (isEmpty()) {
      return fullQueue;
    }
    Node<T> current = front;
    for (int i = 0; i < size(); i++) {
      fullQueue += current.getData() + " ";
      current = current.getNext();
    }
    return fullQueue.substring(0, fullQueue.length()-1);
  }



}


