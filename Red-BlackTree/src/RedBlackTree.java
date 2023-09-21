// --== CS400 Fall 2022 File Header Information ==--
// Name: <Wenpei>
// Email: <wshao33@wisc.edu>
// Team: <DE>
// TA: <April Roszkowski>
// Lecturer: <Florian Heimerl >
// Notes to Grader: <optional extra notes>
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Stack;
import org.junit.jupiter.api.Test;

/**
 * Red-Black Tree implementation with a Node inner class for representing the nodes of the tree.
 * Currently, this implements a Binary Search Tree that we will turn into a red black tree by
 * modifying the insert functionality. In this activity, we will start with implementing rotations
 * for the binary search tree insert algorithm. You can use this class' insert method to build a
 * regular binary search tree, and its toString method to display a level-order traversal of the
 * tree.
 */
public class RedBlackTree<T extends Comparable<T>> {

  /**
   * This class represents a node holding a single value within a binary tree the parent, left, and
   * right child references are always maintained.
   */
  protected static class Node<T> {
    public T data;
    public Node<T> parent; // null for root node
    public Node<T> leftChild;
    public Node<T> rightChild;
    public int blackHeight = 0;// 0 = red, 1 = black, and 2 = double-black blackHeight of 0 (aka
                               // red) by default

    public Node(T data) {
      this.data = data;
    }

    /**
     * @return true when this node has a parent and is the left child of that parent, otherwise
     *         return false
     */
    public boolean isLeftChild() {
      return parent != null && parent.leftChild == this;
    }

  }

  protected Node<T> root; // reference to root node of tree, null when empty
  protected int size = 0; // the number of values in the tree


  /**
   * Performs a naive insertion into a binary search tree: adding the input data value to a new node
   * in a leaf position within the tree. After this insertion, no attempt is made to restructure or
   * balance the tree. This tree will not hold null references, nor duplicate data values.
   * 
   * @param data to be added into this binary search tree
   * @return true if the value was inserted, false if not
   * @throws NullPointerException     when the provided data argument is null
   * @throws IllegalArgumentException when the newNode and subtree contain equal data references
   */
  public boolean insert(T data) throws NullPointerException, IllegalArgumentException {
    // null references cannot be stored within this tree
    if (data == null)
      throw new NullPointerException("This RedBlackTree cannot store null references.");

    Node<T> newNode = new Node<>(data);
    if (root == null) {
      root = newNode;
      size++;
      root.blackHeight = 1;
      return true;
    } // add first node to an empty tree
    else {
      boolean returnValue = insertHelper(newNode, root); // recursively insert into subtree
      if (returnValue)
        size++;
      else
        throw new IllegalArgumentException("This RedBlackTree already contains that value.");
      return returnValue;
    }

  }

  /**
   * The job of this enforceRBTreePropertiesAfterInsert method is to resolve any red-black tree
   * property violations that are introduced by inserting each new new node into a red-black tree.
   */
  protected void enforceRBTreePropertiesAfterInsert(Node<T> newNode) {
    if (newNode == root) {
      newNode.blackHeight = 1;
//      if (this.root != null) {
//        LinkedList<Node<T>> q = new LinkedList<>();
//        q.add(this.root);
//        while (!q.isEmpty()) {
//          Node<T> next = q.removeFirst();
//          if (next.leftChild != null)
//            q.add(next.leftChild);
//          if (next.rightChild != null)
//            q.add(next.rightChild);
//          if(next.parent != null && next.parent.blackHeight == 1 && next.blackHeight == 1){
//            next.blackHeight = 2;
//          }
//        }
//      }

      return;
    }
    if (newNode.parent.blackHeight != 0) {
//      if (this.root != null) {
//        LinkedList<Node<T>> q = new LinkedList<>();
//        q.add(this.root);
//        while (!q.isEmpty()) {
//          Node<T> next = q.removeFirst();
//          if (next.leftChild != null)
//            q.add(next.leftChild);
//          if (next.rightChild != null)
//            q.add(next.rightChild);
//          if(next.parent != null && next.parent.blackHeight == 1 && next.blackHeight == 1){
//            next.blackHeight = 2;
//          }
//        }
//      }
      return;
    }
    // when father is black or node is root node
    Node<T> parent = newNode.parent;
    Node<T> grand;
    Node<T> uncle;

    // set grand
    grand = parent.parent;
    if (grand != null) {
      // grand leftchild is parent
      if (grand.leftChild == parent) {
        uncle = grand.rightChild;
      } else {// grand rightchild is parent
        uncle = grand.leftChild;
      }
    } else {// parent is root node
      uncle = null;
    }
    // uncle is black
    if (uncle == null||uncle.blackHeight == 1 ) {
      if(!parent.isLeftChild()) { 
      //current parent node is right 
      if (newNode == parent.rightChild) {
        //current node is right child
        rotate(parent, grand);
        parent.blackHeight = 1;
        grand.blackHeight = 0;
        //enforceRBTreePropertiesAfterInsert(newNode);
        return;
      }
      else {
        //current is left
        newNode.blackHeight = 1;
        grand.blackHeight = 0;
        rotate(newNode, parent);
        rotate(newNode,grand);
        //enforceRBTreePropertiesAfterInsert(newNode);
        return;
      }
      }else {
        //current parent node is left 
        if (newNode == parent.leftChild) {
          //current node is left child
          rotate(parent, grand);
          parent.blackHeight = 1;
          grand.blackHeight = 0;
          //enforceRBTreePropertiesAfterInsert(newNode);
          return;
        }
        else {
          //current is right
          newNode.blackHeight = 1;
          grand.blackHeight = 0;
          rotate(newNode, parent);
          rotate(newNode,grand);
          //enforceRBTreePropertiesAfterInsert(newNode);
          return;
        }
      }
    }
    else if (uncle.blackHeight == 0) {
      //uncle is red
      parent.blackHeight = 1;
      uncle.blackHeight = 1;
      grand.blackHeight = 0;
      enforceRBTreePropertiesAfterInsert(grand);
      return;
    } 



  }

  /**
   * Recursive helper method to find the subtree with a null reference in the position that the
   * newNode should be inserted, and then extend this tree by the newNode in that position.
   * 
   * @param newNode is the new node that is being added to this tree
   * @param subtree is the reference to a node within this tree which the newNode should be inserted
   *                as a descenedent beneath
   * @return true is the value was inserted in subtree, false if not
   */
  private boolean insertHelper(Node<T> newNode, Node<T> subtree) {
    int compare = newNode.data.compareTo(subtree.data);
    // do not allow duplicate values to be stored within this tree
    if (compare == 0)
      return false;

    // store newNode within left subtree of subtree
    else if (compare < 0) {
      if (subtree.leftChild == null) { // left subtree empty, add here
        subtree.leftChild = newNode;
        newNode.parent = subtree;
        enforceRBTreePropertiesAfterInsert(newNode);
        return true;
        // otherwise continue recursive search for location to insert
      } else

        return insertHelper(newNode, subtree.leftChild);
    }

    // store newNode within the right subtree of subtree
    else {
      if (subtree.rightChild == null) { // right subtree empty, add here
        subtree.rightChild = newNode;
        newNode.parent = subtree;
        enforceRBTreePropertiesAfterInsert(newNode);

        return true;
        // otherwise continue recursive search for location to insert
      } else
        return insertHelper(newNode, subtree.rightChild);
    }
  }

  /**
   * Performs the rotation operation on the provided nodes within this tree. When the provided child
   * is a leftChild of the provided parent, this method will perform a right rotation. When the
   * provided child is a rightChild of the provided parent, this method will perform a left
   * rotation. When the provided nodes are not related in one of these ways, this method will throw
   * an IllegalArgumentException.
   * 
   * @param child  is the node being rotated from child to parent position (between these two node
   *               arguments)
   * @param parent is the node being rotated from parent to child position (between these two node
   *               arguments)
   * @throws IllegalArgumentException when the provided child and parent node references are not
   *                                  initially (pre-rotation) related that way
   */
  private void rotate(Node<T> child, Node<T> parent) throws IllegalArgumentException {
    if (child == null || parent == null || child.parent != parent
        || (parent.rightChild != child && parent.leftChild != child)) {
      throw new IllegalArgumentException(
          "the provided child and parent node references are not initially (pre-rotation) related that way");
    }
    // right rotation
    if (parent.leftChild == child) {
      //if parent is root
      if (parent.parent == null) {
        child.parent = null;
        parent.parent = child;
        parent.leftChild = child.rightChild;
        child.rightChild = parent;
        root = child;
        if(parent.leftChild!=null) {
          parent.leftChild.parent=parent;
        }
      } else {
        //parent is not root
        child.parent = parent.parent;
        //parent is a left child
        if (parent.isLeftChild()) {
          parent.parent.leftChild = child;
        } else {
          //parent is right child
          parent.parent.rightChild = child;
        }
        parent.parent = child;
        parent.leftChild = child.rightChild;
        child.rightChild = parent;
        if(parent.leftChild!=null) {
          parent.leftChild.parent=parent;
        }
        //parent.leftChild.parent = parent;//?
      }
    }
    // left rotation
    else if (parent.rightChild.equals(child)) {
      //root
      if (parent.parent == null) {
        child.parent = null;
        parent.parent = child;
        parent.rightChild = child.leftChild;
        child.leftChild = parent;
        root = child;
        if(parent.rightChild!=null) {
          parent.rightChild.parent=parent;
        }
      }
      //not root
      else {
        //parent is not root
        child.parent = parent.parent;
        //parent is a left child
        if (parent.isLeftChild()) {
          parent.parent.leftChild = child;
        } else {
          //parent is right child
          parent.parent.rightChild = child;
        }
        parent.parent=child;
        parent.rightChild=child.leftChild;
        child.leftChild=parent;
        if(parent.rightChild!=null) {
          parent.rightChild.parent=parent;
        }
        //parent.rightChild.parent=parent;//?
        
      }

    }
  }

  public void rotateTester(Node<T> child, Node<T> parent) {
    rotate(child, parent);
    return;
  }

  /**
   * Get the size of the tree (its number of nodes).
   * 
   * @return the number of nodes in the tree
   */
  public int size() {
    return size;
  }

  /**
   * Method to check if the tree is empty (does not contain any node).
   * 
   * @return true of this.size() return 0, false if this.size() > 0
   */
  public boolean isEmpty() {
    return this.size() == 0;
  }

  /**
   * Checks whether the tree contains the value *data*.
   * 
   * @param data the data value to test for
   * @return true if *data* is in the tree, false if it is not in the tree
   */
  public boolean contains(T data) {
    // null references will not be stored within this tree
    if (data == null)
      throw new NullPointerException("This RedBlackTree cannot store null references.");
    return this.containsHelper(data, root);
  }

  /**
   * Recursive helper method that recurses through the tree and looks for the value *data*.
   * 
   * @param data    the data value to look for
   * @param subtree the subtree to search through
   * @return true of the value is in the subtree, false if not
   */
  private boolean containsHelper(T data, Node<T> subtree) {
    if (subtree == null) {
      // we are at a null child, value is not in tree
      return false;
    } else {
      int compare = data.compareTo(subtree.data);
      if (compare < 0) {
        // go left in the tree
        return containsHelper(data, subtree.leftChild);
      } else if (compare > 0) {
        // go right in the tree
        return containsHelper(data, subtree.rightChild);
      } else {
        // we found it :)
        return true;
      }
    }
  }


  /**
   * This method performs an inorder traversal of the tree. The string representations of each data
   * value within this tree are assembled into a comma separated string within brackets (similar to
   * many implementations of java.util.Collection, like java.util.ArrayList, LinkedList, etc). Note
   * that this RedBlackTree class implementation of toString generates an inorder traversal. The
   * toString of the Node class class above produces a level order traversal of the nodes / values
   * of the tree.
   * 
   * @return string containing the ordered values of this tree (in-order traversal)
   */
  public String toInOrderString() {
    // generate a string of all values of the tree in (ordered) in-order
    // traversal sequence
    StringBuffer sb = new StringBuffer();
    sb.append("[ ");
    sb.append(toInOrderStringHelper("", this.root));
    if (this.root != null) {
      sb.setLength(sb.length() - 2);
    }
    sb.append(" ]");
    return sb.toString();
  }

  private String toInOrderStringHelper(String str, Node<T> node) {
    if (node == null) {
      return str;
    }
    str = toInOrderStringHelper(str, node.leftChild);
    str += (node.data.toString() + ", ");
    //str += (node.data.toString() + "(" + node.blackHeight + ")" + ", ");
    str = toInOrderStringHelper(str, node.rightChild);
    return str;
  }

  /**
   * This method performs a level order traversal of the tree rooted at the current node. The string
   * representations of each data value within this tree are assembled into a comma separated string
   * within brackets (similar to many implementations of java.util.Collection). Note that the Node's
   * implementation of toString generates a level order traversal. The toString of the RedBlackTree
   * class below produces an inorder traversal of the nodes / values of the tree. This method will
   * be helpful as a helper for the debugging and testing of your rotation implementation.
   * 
   * @return string containing the values of this tree in level order
   */
  public String toLevelOrderString() {
    String output = "[ ";
    if (this.root != null) {
      LinkedList<Node<T>> q = new LinkedList<>();
      q.add(this.root);
      while (!q.isEmpty()) {
        Node<T> next = q.removeFirst();
        if (next.leftChild != null)
          q.add(next.leftChild);
        if (next.rightChild != null)
          q.add(next.rightChild);
        output += next.data.toString();
        //output += next.data.toString() + "(" + next.blackHeight +")";
        if (!q.isEmpty())
          output += ", ";
      }
    }
    return output + " ]";
  }

  public String toString() {
    return "level order: " + this.toLevelOrderString() + "\nin order: " + this.toInOrderString();
  }

  // Implement at least 3 boolean test methods by using the method signatures below,
  // removing the comments around them and addind your testing code to them. You can
  // use your notes from lecture for ideas on concrete examples of rotation to test for.
  // Make sure to include rotations within and at the root of a tree in your test cases.
  // If you are adding additional tests, then name the method similar to the ones given below.
  // Eg: public static boolean test4() {}
  // Do not change the method name or return type of the existing tests.
  // You can run your tests by commenting in the calls to the test methods

  /**
   * First tester class test Basic red-black tree structure (including red uncle color change)
   * 
   * @return test result
   */
  @Test
  public void test1() {

      RedBlackTree<Integer> RBT = new RedBlackTree<Integer>();
      RBT.insert(4);
      RBT.insert(2);
      RBT.insert(6);
      RBT.insert(1);
      RBT.insert(3);
      RBT.insert(5);
      RBT.insert(7);
      assertEquals("[ 4, 2, 6, 1, 3, 5, 7 ]", RBT.toLevelOrderString());
      
  }

  /**
   * second tester class test Used to test the red-black tree in the case of inserting small nodes
   * mixed with large nodes (requires rotation as well as recursive color change)
   * 
   * @return test result
   */
  @Test
  public void test2() {

    RedBlackTree<Integer> RBT = new RedBlackTree<Integer>();
    RBT.insert(4);
    RBT.insert(2);
    RBT.insert(13);
    RBT.insert(15);
    RBT.insert(14);
    RBT.insert(12);
    RBT.insert(11);
    RBT.insert(23);
    RBT.insert(9);
    RBT.insert(8);
    RBT.insert(6);
    RBT.insert(7);
    RBT.insert(5);
    RBT.insert(3);

    assertEquals("[ 12, 7, 14, 4, 9, 13, 15, 2, 6, 8, 11, 23, 3, 5 ]", RBT.toLevelOrderString());

  }


  /**
   * Third tester class test Test if the tree works properly if you keep adding large nodes (larger than the largest node)
   * 
   * @return test result
   */
  @Test
  public void test3() {

      RedBlackTree<Integer> RBT2 = new RedBlackTree<Integer>();
      RBT2.insert(1);
      RBT2.insert(2);
      RBT2.insert(3);
      RBT2.insert(4);
      RBT2.insert(5);
      RBT2.insert(6);
      RBT2.insert(7);
      RBT2.insert(8);
      RBT2.insert(9);
      RBT2.insert(10);
      RBT2.insert(11);
      RBT2.insert(12);
      RBT2.insert(13);
      RBT2.insert(14);
      RBT2.insert(15);
      RBT2.insert(16);
      RBT2.insert(17);
      RBT2.insert(18);
      //System.out.println(RBT2.toLevelOrderString());
      assertEquals("[ 8, 4, 12, 2, 6, 10, 14, 1, 3, 5, 7, 9, 11, 13, 16, 15, 17, 18 ]", RBT2.toLevelOrderString());


  }
}


