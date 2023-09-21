import java.util.NoSuchElementException;

// --== CS400 Project One File Header ==--
// Name: <Wenpei Shao>
// CSL Username: <wenpei>
// Email: <wshao33@wisc.edu email address>
// Lecture #: <003 @2:25pm>
// Notes to Grader: <any optional extra notes to your grader>
/**
 * Tester class for the class HashtableMap
 * 
 * @author wenpeishao
 *
 */
public class HashtableMapTests {
  /**
   * First tester class for the primary test case. only test the basic function for the class
   * 
   * @return the resulet for the test class
   */
  public static boolean test1() {
    HashtableMap<Integer, String> hashtableMap = new HashtableMap<>();
    boolean flag1 = false, flag2 = false, flag3 = false, flag4 = false, flag5 = false,
        flag6 = false;
    if (hashtableMap.size() == 0) {
      flag1 = true;
    }
    hashtableMap.put(12, "zhangsan");
    hashtableMap.put(125, "lisi");
    hashtableMap.put(56, "wangwu");
    hashtableMap.put(26, "zhaoliu");
    hashtableMap.put(456, "Tom");
    if (hashtableMap.get(56).equals("wangwu")) {
      flag2 = true;
    }

    if (hashtableMap.containsKey(12)) {
      flag3 = true;
    }

    if (!hashtableMap.containsKey(123)) {
      flag4 = true;
    }

    if (hashtableMap.remove(456).equals("Tom")) {
      flag5 = true;
    }
    if (hashtableMap.size() == 4) {
      flag6 = true;
    }
    return flag1 && flag2 && flag3 && flag4 && flag5 && flag6;
  }

  /**
   * The second test case, for testing the number of hash tables that exceed the storage limit,
   * tests whether the hash table will automatically expand its capacity.
   * 
   * @return the resulet for the test class
   */
  public static boolean test2() {
    boolean flag1 = false, flag2 = false, flag3 = false, flag4 = false, flag5 = false,
        flag6 = false;
    HashtableMap<Integer, String> hashtableMap = new HashtableMap<>();
    hashtableMap.put(1, "zhangsan");
    hashtableMap.put(2, "lisi");
    hashtableMap.put(3, "wangwu");
    hashtableMap.put(4, "zhaoliu");
    hashtableMap.put(5, "Tom");
    hashtableMap.put(6, "zhangsan");
    hashtableMap.put(7, "lisi");
    hashtableMap.put(8, "wangwu");
    hashtableMap.put(9, "zhaoliu");
    hashtableMap.put(10, "Tom");
    if (hashtableMap.size() == 10) {
      flag1 = true;
    }
    if (hashtableMap.getCapacity() == 15) {
      flag2 = true;
    }
    hashtableMap.put(11, "zhangsan");
    hashtableMap.put(12, "lisi");
    hashtableMap.put(13, "wangwu");
    hashtableMap.put(14, "zhaoliu");
    hashtableMap.put(15, "Tom");
    if (hashtableMap.size() == 15) {
      flag3 = true;
    }
    if (hashtableMap.getCapacity() == 30) {
      flag4 = true;
    }

    if (hashtableMap.put(12, "lisi") == false) {
      flag5 = true;
    }

    return flag1 && flag2 && flag3 && flag4 && flag5;
  }

  /**
   * The third test case, used to test the performance of the hash table when the hash key is
   * non-numeric
   * 
   * @return the resulet for the test class
   */
  public static boolean test3() {

    boolean flag1 = false, flag2 = false, flag3 = false, flag4 = false, flag5 = false,
        flag6 = false;
    HashtableMap<String, String> hashtableMap = new HashtableMap<>();
    hashtableMap.put("Aa", "zhangsan");
    hashtableMap.put("BB", "lisi");
    hashtableMap.put("Ba", "wangwu");
    hashtableMap.put("CB", "zhaoliu");
    if ("Aa".hashCode() == "BB".hashCode()) {
      flag1 = true;
    }
    if (hashtableMap.get("BB").equals("lisi")) {
      flag2 = true;
    }

    if (hashtableMap.containsKey("Ba")) {
      flag3 = true;
    }

    if (hashtableMap.remove("Aa").equals("zhangsan")) {
      flag5 = true;
    }
    if (hashtableMap.size() == 3) {
      flag6 = true;
    }

    return flag1 && flag2 && flag3 && flag5 && flag6;
  }

  /**
   * The forth test case, Test the effect of the clear method
   * 
   * @return
   */
  public static boolean test4() {
    boolean flag1 = false, flag2 = false, flag3 = false, flag4 = false, flag5 = false,
        flag6 = false;
    HashtableMap<Integer, String> hashtableMap = new HashtableMap<>();
    hashtableMap.put(1, "zhangsan");
    hashtableMap.put(2, "lisi");
    hashtableMap.put(3, "wangwu");
    hashtableMap.put(4, "zhaoliu");
    hashtableMap.put(5, "Tom");
    hashtableMap.put(6, "zhangsan");
    hashtableMap.put(7, "lisi");
    hashtableMap.put(8, "wangwu");
    hashtableMap.put(9, "zhaoliu");
    hashtableMap.put(10, "Tom");
    if (hashtableMap.size() == 10) {
      flag1 = true;
    }
    if (hashtableMap.getCapacity() == 15) {
      flag2 = true;
    }
    hashtableMap.put(11, "zhangsan");
    hashtableMap.put(12, "lisi");
    hashtableMap.put(13, "wangwu");
    hashtableMap.put(14, "zhaoliu");
    hashtableMap.put(15, "Tom");
    if (hashtableMap.size() == 15) {
      flag3 = true;
    }
    if (hashtableMap.getCapacity() == 30) {
      flag4 = true;
    }

    if (hashtableMap.put(12, "lisi") == false) {
      flag5 = true;
    }
    hashtableMap.clear();
    try {
      hashtableMap.get(3);
    } catch (NoSuchElementException e) {
      flag6 = true;
    }

    return flag1 && flag2 && flag3 && flag4 && flag5 && flag6;
  }

  /**
   * The Fifth test case, Test methods for testing getcapacitity
   * 
   * @return
   */
  public static boolean test5() {
    boolean flag1 = false, flag2 = false, flag3 = false, flag4 = false, flag5 = false,
        flag6 = false;
    HashtableMap<Integer, String> hashtableMap = new HashtableMap<>();
    hashtableMap.put(1, "zhangsan");
    hashtableMap.put(2, "lisi");
    hashtableMap.put(3, "wangwu");
    hashtableMap.put(4, "zhaoliu");
    hashtableMap.put(5, "Tom");
    hashtableMap.put(6, "zhangsan");
    hashtableMap.put(7, "lisi");
    hashtableMap.put(8, "wangwu");
    hashtableMap.put(9, "zhaoliu");
    hashtableMap.put(10, "Tom");
    if (hashtableMap.size() == 10) {
      flag1 = true;
    }
    if (hashtableMap.getCapacity() == 15) {
      flag2 = true;
    }
    hashtableMap.put(11, "zhangsan");
    hashtableMap.put(12, "lisi");
    hashtableMap.put(13, "wangwu");
    hashtableMap.put(14, "zhaoliu");
    hashtableMap.put(15, "Tom");
    if (hashtableMap.size() == 15) {
      flag3 = true;
    }
    if (hashtableMap.getCapacity() == 30) {
      flag4 = true;
    }

    if (hashtableMap.put(12, "lisi") == false) {
      flag5 = true;
    }
    hashtableMap.clear();

    if (hashtableMap.getCapacity() == 30) {
      flag6 = true;
    }


    return flag1 && flag2 && flag3 && flag4 && flag5 && flag6;
  }

  /**
   * Run the main program of the test case
   * 
   * @param args
   */
  public static void main(String[] args) {
    if (test1()) {
      System.out.println("test1 pass");
    } else {
      System.out.println("test1 nopass");
    }

    if (test2()) {
      System.out.println("test2 pass");
    } else {
      System.out.println("test2 nopass");
    }
    if (test3()) {
      System.out.println("test3 pass");
    } else {
      System.out.println("test3 nopass");
    }

    if (test4()) {
      System.out.println("test4 pass");
    } else {
      System.out.println("test4 nopass");
    }
    if (test5()) {
      System.out.println("test5 pass");
    } else {
      System.out.println("test5 nopass");
    }
  }
}
