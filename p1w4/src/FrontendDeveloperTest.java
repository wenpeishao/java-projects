import java.util.Scanner;

public class FrontendDeveloperTest {

  public static void main(String[] args) {
    if(test1() && test2() && test3() && test4() && test5() && test6() && test7() && test8() && test9()) {
      System.out.println("All tests passed! Hooray!");
    } else {
      if(!test1()) System.out.println("Test 1: failed");

      if(!test2()) System.out.println("Test 2: failed");

      if(!test3()) System.out.println("Test 3: failed");

      if(!test4()) System.out.println("Test 4: failed");

      if(!test5()) System.out.println("Test 5: failed");

      if(!test6()) System.out.println("Test 6: failed");

      if(!test7()) System.out.println("Test 7: failed");

      if(!test8()) System.out.println("Test 8: failed");

      if(!test9()) System.out.println("Test 9: failed");
    }
  }

  /**
   * This method tests our frontend
   *
   * @return - true if test passes, false otherwise
   */
  public static boolean test1() {
    // 1. Create a new TextUITester object for each test, and
    // pass the text that you'd like to simulate a user typing as only argument.
    TextUITester tester = new TextUITester("4\n");

    // 2. Run the code that you want to test here:
    Scanner scnr = new Scanner(System.in);
    BookMapperBackend backend = new BookMapperBackend();
    IISBNVal validator = new IISBNVal();
    BookMapperFrontend frontend = new BookMapperFrontend(scnr, backend, validator);
    frontend.runCommandLoop();

    // 3. Check whether the output printed to System.out matches your expectations.
    String output = tester.checkOutput();

    if(!output.startsWith("Welcome to the Book Mapper Application!") &&
        !output.contains("Goodbye!"))
      return false;

    return true;
  }

  /**
   * Test our frontend to ensure that a user can search by isbn and
   *    that the proper book is printed out when the user searches for an isbn
   *
   * @return - true if test passes, false otherwise
   */
  public static boolean test2() {
    TextUITester tester = new TextUITester("1\n9780330491198\n4");

    Scanner scnr = new Scanner(System.in);
    BookMapperBackend backend = new BookMapperBackend();
    IISBNVal validator = new IISBNVal();
    BookMapperFrontend frontend = new BookMapperFrontend(scnr, backend, validator);
    frontend.runCommandLoop();

    String output = tester.checkOutput();

    if(!output.contains("You are in the Lookup ISBN Menu:") &&
        !output.contains("9780330491198"))
      return false;

    return true;
  }

  /**
   * This tester checks to see whether a user is able to use the key word search menu
   *    It also tests the displayBooks() method because that is called when outputting
   *    to the console
   *
   * @return - true if test passes, false otherwise
   */
  public static boolean test3() {
    TextUITester tester = new TextUITester("2\nhitchhiker\n4");

    Scanner scnr = new Scanner(System.in);
    BookMapperBackend backend = new BookMapperBackend();
    IISBNVal validator = new IISBNVal();
    BookMapperFrontend frontend = new BookMapperFrontend(scnr, backend, validator);
    frontend.runCommandLoop();

    String output = tester.checkOutput();

    if(!output.contains("1. \"The Hitchhiker's Guide to the Galaxy (Hitchhiker's Guide to the Galaxy  #1)\" by Douglas Adams, ISBN: 9780671746063\n" +
        "2. \"Life  the Universe and Everything (Hitchhiker's Guide to the Galaxy  #3)\" by Douglas Adams, ISBN: 9780345418906\n" +
        "3.  \"The Ultimate Hitchhiker's Guide to the Galaxy (Hitchhiker's Guide to the Galaxy  #1-5)\" by Douglas Adams, ISBN: 9780345453747\n" +
        "4. \"So Long  and Thanks for All the Fish (Hitchhiker's Guide to the Galaxy  #4)\" by Douglas Adams, ISBN: 9780330491235\n" +
        "5. \"The More Than Complete Hitchhiker's Guide (Hitchhiker's Guide  #1-4 + short story)\" by Douglas Adams, ISBN: 9780681403222\n" +
        "6. \"The Hitchhiker's Guide to the Galaxy (Hitchhiker's Guide to the Galaxy  #1)\" by Douglas Adams, ISBN: 9780330491198\n" +
        "7. \"The Ultimate Hitchhiker's Guide: Five Complete Novels and One Story (Hitchhiker's Guide to the Galaxy  #1-5)\" by Douglas Adams, ISBN: 9780517226957\n" +
        "8. \"The Hitchhiker's Guide to the Galaxy: The Quintessential Phase (Hitchhiker's Guide: Radio Play  #5)\" by Douglas Adams/Dirk Maggs/Simon  Jones/Geoffrey McGivern/Mark Wing-Davey/Susan  Sheridan/Sandra Dickinson/Stephen  Moore/William Franklyn/Rula Lenska/Sam  Burke, ISBN: 9780563504078\n" +
        "9. \"The Restaurant at the End of the Universe (The Hitchhiker's Guide to the Galaxy  #2)\" by Douglas Adams/Martin  Freeman, ISBN: 9780739332078\n" +
        "10. \"The Hitchhiker's Guide to the Galaxy (Hitchhiker's Guide to the Galaxy  #1)\" by Douglas Adams/Stephen Fry, ISBN: 9780739322208\n" +
        "11. \"The Hitchhiker's Guide to the Galaxy (Hitchhiker's Guide  #1)\" by Douglas Adams, ISBN: 9781400052936\n" +
        "12. \"The Hitchhiker's Guide to the Galaxy (Hitchhiker's Guide to the Galaxy  #1)\" by Douglas Adams, ISBN: 9781400052929\n" +
        "13. \"The Ultimate Hitchhiker's Guide (Hitchhiker's Guide to the Galaxy  #1-5)\" by Douglas Adams, ISBN: 9780517149256\n" +
        "14. \"The Illustrated Hitchhiker's Guide To The Galaxy\" by Douglas Adams, ISBN: 9780517599242\n" +
        "Matches (any author) 14 of 11124"))
      return false;

    return true;
  }

  /**
   * This test simulates a user wanting to set an author filter
   *    Through this test, the program goes to menu option 3 (making sure it works)
   *    Then creates an author filter as a user may do using the frontend interface.
   *    We are then able to call the backend method to make sure an author filter can
   *    actually be set from our frontend class/user input.
   *
   * @return - true if test passes, false otherwise
   */
  public static boolean test4() {
    Scanner scnr = new Scanner("3\nDouglas Adams\n4");
    BookMapperBackend backend = new BookMapperBackend();
    IISBNVal validator = new IISBNVal();
    BookMapperFrontend frontend = new BookMapperFrontend(scnr, backend, validator);

    frontend.runCommandLoop();

    if(!backend.getAuthorFilter().equals("Douglas Adams")) {
      System.out.println("Author filter was not properly set in our user interface");
      return false;
    }


    return true;
  }

  /**
   * This tester tests displayMainMenu() and ensures the user is able to properly navigate
   *    our 'main' menu. This tester also makes sure that the user is entering a number 1-4.
   *
   * @return - true if test passes, false otherwise
   */
  public static boolean test5() {
    TextUITester tester = new TextUITester("5\n104\n4\n");

    Scanner scnr = new Scanner(System.in);
    BookMapperBackend backend = new BookMapperBackend();
    IISBNVal validator = new IISBNVal();
    BookMapperFrontend frontend = new BookMapperFrontend(scnr, backend, validator);
    frontend.runCommandLoop();

    String output = tester.checkOutput();

    if(!output.contains("Please enter a valid input (a number 1-4):") &&
        !output.contains("You are in the Main Menu:"))
      return false;

    return true;
  }

  /**
   * Test #1 of using other team members' code
   * @return - true if test passes, false otherwise
   */
  public static boolean test6() {
    // Testing my code's correctness when running with teammates' code #1
    TextUITester tester = new TextUITester("2\nSteam\n4\n");
    Scanner scnr = new Scanner(System.in);
    BookMapperBackend backend = new BookMapperBackend();
    IISBNVal validator = new IISBNVal();
    BookMapperFrontend frontend = new BookMapperFrontend(scnr, backend, validator);

    frontend.runCommandLoop();
    String output = tester.checkOutput();
    if(!output.contains("Full Steam Ahead!")) {
      System.out.println(output);
      return false;
    }

    return true;
  }

  /**
   * Test #2 of using other team members' code
   * @return - true if test passes, false otherwise
   */
  public static boolean test7() {
    // Testing my code's correctness when running with teammates' code #2

    TextUITester tester = new TextUITester("1\n10010\n9780439785969\n4\n");
    Scanner scnr = new Scanner(System.in);
    BookMapperBackend backend = new BookMapperBackend();
    IISBNVal validator = new IISBNVal();
    BookMapperFrontend frontend = new BookMapperFrontend(scnr, backend, validator);

    frontend.runCommandLoop();
    String output = tester.checkOutput();

    // Make sure it recognized the first input was not a valid ISBN
    if(!output.contains("Please enter a valid ISBN")) {
      return false;
    }

    // Make sure it recognized the next input WAS a valid ISBN
    if(!output.contains("Harry Potter and the Half-Blood Prince")) {
      return false;
    }

    return true;
  }

  /**
   * Test #1 of testing partner's (data wrangler's) code
    * @return - true if test passes, false otherwise
   */
  public static boolean test8() {
    // Test getISBN (subsequently confirms books were properly loaded in)
    IBook book = new Book("Title", "Jack Jones", "1010101010101");

    if(!book.getISBN13().equals("1010101010101")) {
      return false;
    }

    return true;
  }

  /**
   * Test #2 of testing partners' (data wrangler's) code
   * @return - true if test passes, false otherwise
   */
  public static boolean test9() {
    // Test getAuthor (subsequently confirms books were properly loaded in)
    IBook book = new Book("Zeke and Luther's wacky and fun skating adventure!",
        "DisneyXD", "5837298765432");

    if(!book.getAuthors().equals("DisneyXD")) {
      return false;
    }

    return true;
  }

}
