// --== CS400 Project One File Header ==--
// Name: <Wenpei Shao>
// CSL Username: <wenpei>
// Email: <wshao33@wisc.edu email address>
// Lecture #: <003 @2:25pm>
// Notes to Grader: <any optional extra notes to your grader>
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class BookLoaderTester {

  public BookLoaderTester() {    
  }
  //Fist tester class test the Book.java class basic function test 
  public static boolean test1() {
    boolean flag1 = false, flag2 = false, flag3 = false;

    String authors="J.K. Rowling/Mary GrandPré";
    String ISBN13="9780439785969";
    String title="Harry Potter and the Half-Blood Prince (Harry Potter  #6)";
    IBook book= new Book(title, authors, ISBN13);
    
    if(book.getISBN13().equals(ISBN13)) {
      flag1=true;
    }
    if(book.getAuthors().equals(authors)) {
      
      flag2=true;
    }
    if(book.getTitle().equals(title)) {
      flag3=true;
    }
    return flag1 && flag2 && flag3;
  }
  
  //Second tester class test the Book.java class with false information given
  public static boolean test2() {
    boolean flag1 = false, flag2 = false, flag3 = false;

    String authors="J.K.";
    String ISBN13="39785969";
    String title="Harry ce (Harry Potter  #6)";
    IBook book= new Book(title, authors, ISBN13);
    
    if(!book.getISBN13().equals("9780439785969")) {
      flag1=true;
    }
    if(!book.getAuthors().equals("J.K. Rowling/Mary GrandPré")) {
      flag2=true;
    }
    if(!book.getTitle().equals("Harry Potter and the Half-Blood Prince (Harry Potter  #6)")) {
      flag3=true;
    }
    return flag1 && flag2 && flag3;
  }
  //Third tester class test the BookLoader.java class with false information given
  public static boolean test3() {
    boolean flag1 = false, flag2 = false, flag3 = false,flag=false;

    String authors="J.K. Rowling/Mary GrandPré";
    String ISBN13="9780439785969";
    String title="Harry Potter and the Half-Blood Prince (Harry Potter  #6)";
    IBook book= new Book(title, authors, ISBN13);
    String filepathToCSV = "books.csv";
    IBookLoader bookLoader = new BookLoader(); // new BookLoader();
    try {
    List<IBook> bookList = bookLoader.loadBooks(filepathToCSV); // bookLoader.loadBooks("books.csv");
    IBook Bookcase = bookList.get(10);

    
    if(!Bookcase.getISBN13().equals(ISBN13)) {
      flag1=true;
    }
    if(!Bookcase.getAuthors().equals(authors)) {
      flag2=true;
    }
    if(!Bookcase.getTitle().equals(title)) {
      flag3=true;
    }
    }catch (FileNotFoundException e) {
      return false;
    }
    return flag1 && flag2 && flag3;
  }
  //Forth tester class test the BookLoader.java class with false filepath information given
  public static boolean test4() {

    String authors="J.K. Rowling/Mary GrandPré";
    String ISBN13="9780439785969";
    String title="Harry Potter and the Half-Blood Prince (Harry Potter  #6)";
    IBook book= new Book(title, authors, ISBN13);
    String filepathToCSV = "books.csv2";
    IBookLoader bookLoader = new BookLoader(); // new BookLoader();
    try {
    List<IBook> bookList = bookLoader.loadBooks(filepathToCSV); // bookLoader.loadBooks("books.csv");
    }catch (FileNotFoundException e) {
      return true;
    }
    return false;
  }
  //Fifth tester class test the BookLoader.java class with correct information given
  public static boolean test5() {
    boolean flag1 = false, flag2 = false, flag3 = false,flag=false;

    String authors="J.K. Rowling/Mary GrandPré";
    String ISBN13="9780439785969";
    String title="Harry Potter and the Half-Blood Prince (Harry Potter  #6)";
    IBook book= new Book(title, authors, ISBN13);
    String filepathToCSV = "books.csv";
    IBookLoader bookLoader = new BookLoader(); // new BookLoader();
    try {
    List<IBook> bookList = bookLoader.loadBooks(filepathToCSV); // bookLoader.loadBooks("books.csv");
    IBook Bookcase = bookList.get(0);

    
    if(Bookcase.getISBN13().equals(ISBN13)) {
      flag1=true;
    }
    if(Bookcase.getAuthors().equals(authors)) {
      flag2=true;
    }
    if(Bookcase.getTitle().equals(title)) {
      flag3=true;
    }
    }catch (FileNotFoundException e) {
      return false;
    }
    return flag1 && flag2 && flag3;
  }
  /**
   * Test #1 of using other team members' code
   * @return - true if test passes, false otherwise
   */
  public static boolean test6() {
    // Testing my code's correctness when running with teammates' code #1

    String authors="J.K. Rowling/Mary GrandPré";
    String ISBN13="9780439785969";
    String title="Harry Potter and the Half-Blood Prince (Harry Potter  #6)";
    IBook book= new Book(title, authors, ISBN13);
    String filepathToCSV = "books.csv";
    IBookLoader bookLoader = new BookLoader(); // new BookLoader();
      try {
          String iisbn = "9780439785969";
          IISBNVal val = new IISBNVal();
          if (val.validate(iisbn) == false) {
              return false;
          }
      } catch (Exception e) {

      }
      return true;
  }

  /**
   * Test #2 of using other team members' code
   * @return - true if test passes, false otherwise
   */
  public static boolean test7() {
    // Testing my code's correctness when running with teammates' code #2
    // testing an invalid IISBN
    try {
        String iisbn = "9780306406153";
        IISBNVal val = new IISBNVal();
        if (val.validate(iisbn) == true) {
            return false;
        }
    } catch (Exception e) {

    }
    return true;
  }
  /**
   * Test #1 of testing partner's (Frontend Developer's) code
    * @return - true if test passes, false otherwise
   */
  public static boolean test8() {
    TextUITester tester = new TextUITester("6\n104\n4\n");

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
   * Test #2 of testing partner's (Frontend Developer's) code
    * @return - true if test passes, false otherwise
   */
  public static boolean test9() {
    try {
    Scanner scnr = new Scanner("3\nJ.K. Rowling/Mary GrandPré\n4");
    BookMapperBackend backend = new BookMapperBackend();
    IISBNVal validator = new IISBNVal();
    BookMapperFrontend frontend = new BookMapperFrontend(scnr, backend, validator);

    frontend.runCommandLoop();

    if(!backend.getAuthorFilter().equals("J.K. Rowling/Mary GrandPré")) {
      System.out.println("Author filter was not properly set in our user interface");
      return false;
    }
    }catch(Exception e){
      return false;
    }

    return true;
  }
  /**
   * Run the main program of the test case
   * 
   * @param args
   */
  public static void main(String[] args) {
    if (test1()) {
      System.out.println("Data Wrangler Individual Test 1: passed");
    } else {
      System.out.println("Data Wrangler Individual Test 1: failed");
    }
    if (test2()) {
      System.out.println("Data Wrangler Individual Test 2: passed");
    } else {
      System.out.println("Data Wrangler Individual Test 2: failed");
    }
    if (test3()) {
      System.out.println("Data Wrangler Individual Test 3: passed");
    } else {
      System.out.println("Data Wrangler Individual Test 3: failed");
    }
    if (test4()) {
      System.out.println("Data Wrangler Individual Test 4: passed");
    } else {
      System.out.println("Data Wrangler Individual Test 4: failed");
    }
    if (test5()) {
      System.out.println("Data Wrangler Individual Test 5: passed");
    } else {
      System.out.println("Data Wrangler Individual Test 5: failed");
    }
    if(test6()) {
      System.out.println("Data Wrangler Integration Test 1: passed");
    }else {
      System.out.println("Data Wrangler Integration Test 1: failed");

    }
    if(test7()) {
      System.out.println("Data Wrangler Integration Test 2: passed");
    }else {
      System.out.println("Data Wrangler Integration Test 2: failed");
    }
    if(test8()) {
      System.out.println("Data Wrangler Partner (Frontend Developer) Test 1: passed");
    }else {
      System.out.println("Data Wrangler Partner (Frontend Developer) Test 1: failed");
    }
    if(test9()) {
      System.out.println("Data Wrangler Partner (Frontend Developer) Test 2: passed");
    }else {
      System.out.println("Data Wrangler Partner (Frontend Developer) Test 2: failed");
    }
  }
}
