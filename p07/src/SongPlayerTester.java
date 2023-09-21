import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class implements unit test methods to check the correctness of Song, LinkedNode, SongPlayer
 * ForwardSongIterator and BackwardSongIterator classes in P07 Iterable Song Player assignment.
 *
 */
public class SongPlayerTester {
  /**
   * This method test and make use of the Song constructor, an accessor (getter) method,
   * overridden method toString() and equal() method defined in the Song class.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testSong() {
    Song a=new Song("a","aa","1:06");
    Song b=new Song("aa","aaa","1:16");
    if(!a.getSongName().equals("a"))
      return false;
    if(!a.getArtist().equals("aa"))
      return false;
    if(!a.getDuration().equals("1:06"))
      return false;
    if(!a.toString().equals("a---aa---1:06"))
      return false;
    if(a.equals(b))
      return false;
    return true;

  }

  /**
   * This method test and make use of the LinkedNode constructor, an accessor
   * (getter) method, and a mutator (setter) method defined in the LinkedCart class.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testLinkedNode() {



    LinkedNode<Integer> n1 = new LinkedNode<>(null, 1, null);
    LinkedNode<Integer> n2 = new LinkedNode<>(n1, 3, null);
    n1.setNext(n2);


    LinkedNode a=new LinkedNode(n1,2,n2);
    Integer expPrev=new Integer("1");
    Integer expNext=new Integer("3");
    if(!a.getPrev().getData().equals(expPrev))
      return false;
    if(!a.getNext().getData().equals(expNext))
      return false;

    LinkedNode<Integer> x1 = new LinkedNode<>(null, 9, null);
    LinkedNode<Integer> x2 = new LinkedNode<>(x1, 7, null);
    x1.setNext(x2);

    a.setPrev(x1) ;
    Integer xPrev=new Integer("9");
    if(!a.getPrev().getData().equals(xPrev))
      return false;
    a.setNext(x2);
    Integer xNext=new Integer("7");
    if(!a.getNext().getData().equals(xNext))
      return false;


    return true;



  }

  /**
   * This method checks for the correctness of addFirst(), addLast() and add(int index)
   * method in SongPlayer class
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testSongPlayerAdd(){
    //System.out.print("1");
    //check exceptions
    SongPlayer a=new SongPlayer();
    // System.out.print("1");
    Song b=new Song("aa","aaa","1:06");
    Song c=new Song("aab","aaab","1:07");
    // System.out.print("1");
    Song d=new Song("aad","aaad","1:08");
    //System.out.print("1");
    Song wrong=null;
    //  System.out.print("1");
    System.out.println(a.size());
    a.add​(0,b);
    System.out.println(a.getFirst());
    a.addFirst​(c);
   // System.out.print("1");
    System.out.println(a.size());
    System.out.println(a.getFirst());
    a.addLast​(d);
    System.out.println(a.getLast());
    System.out.println(a.size());
    System.out.println(a.getFirst());
    System.out.print("122");
    //cbd
    try{
      a.add​(0,wrong);
      return false;
    }catch(NullPointerException e) {

    }catch(Exception e1) {
      return false;
    }

    try{
      a.addFirst​(wrong);
      return false;
    }catch(NullPointerException e) {

    }catch(Exception e1) {
      return false;
    }
    System.out.print("122");

    try{
      a.addLast​(wrong);
      return false;
    }catch(NullPointerException e) {

    }catch(Exception e1) {
      return false;
    }

    if(!a.getFirst().equals(c)) {
      System.out.println("size"+a.getFirst());
      return false;
    }
    if(!a.getLast().equals(d)) {
      return false;
    }
    if(!a.get​(1).equals(b)) {
      return false;
    }


    return true;
  }

  /**
   * This method checks for the correctness of getFirst(), getLast() and get(int index)
   * method in SongPlayer class
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testSongPlayerGet() {

    //check exceptions
    SongPlayer a=new SongPlayer();
    Song b=new Song("aa","aaa","1:06");
    Song c=new Song("aab","aaab","1:07");
    Song d=new Song("aad","aaad","1:08");
    a.add​(0,b);
    a.addFirst​(c);
    a.addLast​(d);
    if(!a.getFirst().equals(c)) {
      return false;
    }
    if(!a.getLast().equals(d)) {
      return false;
    }
    if(!a.get​(2).equals(d)) {
      return false;
    }

    try {
      a.get​(-1);
      return false;
    }catch(IndexOutOfBoundsException e) {

    }catch(Exception e1) {
      return false;
    }

    
   

    return true;
  }

  /**
   * This method checks for the correctness of removeFirst(), removeLast() and remove(int index)
   * method in SongPlayer class
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testSongPlayerRemove() {

    SongPlayer a=new SongPlayer();
    Song b=new Song("aa","aaa","1:06");
    Song c=new Song("aab","aaab","1:07");
    Song d=new Song("aad","aaad","1:08");
    a.addLast​(b);
    a.addLast​(c);
    a.addLast​(d);

    try {a.remove​(-1);
    return false;
    }catch(IndexOutOfBoundsException e1) {

    }catch(Exception e2) {
      return false;
    }

    a.removeFirst();
    System.out.print(a.size());
    a.remove​(0);
    System.out.print(a.size());
    a.removeLast();
    System.out.print(a.size());

    if(a.size()!=0) {
      System.out.print(a.size());
      return false;}


    return true;
  }

  /**
   * This method checks for the correctness of iterator(), switchPlayingDirection() and String
   *  play()
   * method in SongPlayer class
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testSongPlayerIterator() {


    SongPlayer a=new SongPlayer();


    Song b=new Song("aa","aaa","1:06");
    Song c=new Song("aab","aaab","1:07");
    a.addLast​(b);
    a.addLast​(c);






    a.iterator();
    String check=a.play();
    if(!check.equals("aa---aaa---1:06"+"\n"+"aab---aaab---1:07"+"\n")) {

      return false;}







    a.switchPlayingDirection();
    a.iterator();
    String check2=a.play();

    if(!check2.equals("aab---aaab---1:07"+"\n"+"aa---aaa---1:06"+"\n")){
      System.out.println(check2);
      return false;
    }

    return true;


  }

  /**
   * This method checks for the correctness of contains(Object song), clear(),
   * isEmpty()and size() method in SongPlayer class
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testSongPlayerCommonMethod() {
    SongPlayer a=new SongPlayer();
    Song b=new Song("aa","aaa","1:06");
    Song c=new Song("aab","aaab","1:07");
    Song d=new Song("aad","aaad","1:08");
    a.addLast​(b);
    a.addLast​(c);
    a.addLast​(d);
    if(a.size()!=3)
      return false;
    if(a.contains​(b)==false)
      return false;
    a.clear();
    if(a.size()!=0)
      return false;
    if(a.isEmpty()==false)
      return false;
    return true;



  }

  /**
   * This method checks for the correctness of ForwardSongIterator class
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testForwardSongIterator() {

    LinkedNode<Song> first=new LinkedNode<Song>(null,null,null);
    ForwardSongIterator a=new ForwardSongIterator(first);
    if(a.hasNext()==false) {
      //    System.out.print("1");
      return false;}
    Song song=null;
    song=a.next();
    if(first.getData()!=song) {
      //   System.out.print("1");
      return false;
    }

    LinkedNode<Song> next=null;
    ForwardSongIterator ab=new ForwardSongIterator(next);
    try {
      ab.next();
      //  System.out.print("1");
      return false;
    }catch(NoSuchElementException e) {

    }catch(Exception e1) {
      //  System.out.print("1");
      return false;
    }

    return true;
  }

  /**
   * This method checks for the correctness of BackwardSongIterator class
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testBackwardSongIterator() {
    LinkedNode<Song> first=new LinkedNode<Song>(null,null,null);
    ForwardSongIterator a=new ForwardSongIterator(first);
    if(a.hasNext()==false)
      return false;
    Song song=null;
    song=a.next();
    if(first.getData()!=song)
      return false;


    LinkedNode<Song> next=null;
    ForwardSongIterator ab=new ForwardSongIterator(next);
    try {
      ab.next();
      return false;
    }catch(NoSuchElementException e) {

    }catch(Exception e1) {
      return false;
    }

    return true;
  }

  /**
   * This method calls all the test methods defined and implemented in your SongPlayerTester
   * class.
   * 
   * @return true if all the test methods defined in this class pass, and false otherwise.
   */
  public static boolean runAllTests() {
    return testSong()&&testLinkedNode() &&testSongPlayerAdd()&& testSongPlayerGet() 
        &&testSongPlayerRemove()
        &&testSongPlayerIterator()&& testSongPlayerCommonMethod() && testForwardSongIterator()
        &&testBackwardSongIterator();
  }

  /**
   * Driver method defined in this SongPlayerTester class
   * 
   * @param args input arguments if any.
   */
  public static void main(String[] args) {

    System.out.println( runAllTests() );
  }
}