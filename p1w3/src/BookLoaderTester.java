import java.io.FileNotFoundException;
import java.util.List;

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
