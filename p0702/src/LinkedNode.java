
public class LinkedNode<T> {
	private T data; // data field of this linked node
	private LinkedNode<T> prev; // reference to the previous linked node in a
								// list of nodes
	private LinkedNode<T> next; // reference to the next linked node in a list
								// of nodes
	public LinkedNode(LinkedNode<T> prev,T data,LinkedNode<T> next) {
		this.prev = prev;
		this.data = data;
		this.next = next;
	}
	/**
	 * @return the data
	 */
	public T getData() {
		return data;
	}

	/**
	 * @return the prev
	 */
	public LinkedNode<T> getPrev() {
		return prev;
	}
	/**
	 * @param prev
	 *            the prev to set
	 */
	public void setPrev(LinkedNode<T> prev) {
		this.prev = prev;
	}
	/**
	 * @return the next
	 */
	public LinkedNode<T> getNext() {
		return next;
	}
	/**
	 * @param next
	 *            the next to set
	 */
	public void setNext(LinkedNode<T> next) {
		this.next = next;
	}

}
