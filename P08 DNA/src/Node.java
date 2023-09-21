/**
 * A generic class specifying the basics of a singly-linked node for a linked queue.
 * 
 * @author wenpeishao
 *
 * @param <T> - the type of data to be contained in this node
 */
public class Node<T> extends Object {
  private T data;// The data contained in the Node
  private Node<T> next;// The Node following this one

  /**
   * Basic constructor; creates a node that contains the provided data and no linkages.
   * 
   * @param data - the information to put inside the node
   * 
   */
  public Node(T data) {
    this.data=data;
  }

  /**
   * A constructor that allows specification of the next node in the chain
   * 
   * @param data - the information to put inside the Node
   * 
   * @param next - the next node, must contain the same type of data as this node
   * 
   */
  public Node(T data, Node<T> next) {
    //TODO the next node, must contain the same type of data as this node
    this.data=data;
    this.next=next;

  }

  /**
   * @return the next
   */
  public Node<T> getNext() {
    return next;
  }

  /**
   * @param next the next to set
   */
  public void setNext(Node<T> next) {
    this.next = next;
  }

  /**
   * @return the data
   */
  public T getData() {
    return data;
  }

}
