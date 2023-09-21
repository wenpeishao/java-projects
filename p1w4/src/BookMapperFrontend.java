// --== CS400 Project One Role Code ==--
// Name: Aidan Carrig
// CSL Username: carrig
// Email: acarrig@wisc.edu
// Lecture #: 003 @2:25pm
// Notes to Grader: N/A

import java.util.List;
import java.util.Scanner;

/**
 * The class that controls how the user will interact with the code
 */
public class BookMapperFrontend implements IBookMapperFrontend {

  Scanner userInputScanner;
  IBookMapperBackend backend;
  IISBNValidator validator;

  // Constructor
  public BookMapperFrontend(Scanner userInputScanner, IBookMapperBackend backend,
                       IISBNValidator validator) {
    this.userInputScanner = userInputScanner;
    this.backend = backend;
    this.validator = validator;
  }

  /**
   * The main command loop which calls other methods and
   *    controls the users interactions with the program
   */
  @Override
  public void runCommandLoop() {
    System.out.println("Welcome to the Book Mapper Application!");
    System.out.println("x+x+xx+x+xx+x+xx+x+xx+x+xx+x+xx+x+xx+x+x");
    System.out.println();

    displayMainMenu();

    String userSelection = userInputScanner.next().trim();

    while(!userSelection.equals("4")) {

      if(userSelection.equals("1")) { // When user inputs 1 from Main Menu:
        isbnLookup();
      } else if(userSelection.equals("2")) { // When user inputs 2 from Main Menu:
        titleSearch();
      } else if(userSelection.equals("3")) { // When user inputs 3 from Main menu:
        authorFilterMenu();
      } else { // If input is something else, it is invalid
        System.out.println("Please enter a valid input (a number 1-4): ");
      }

      displayMainMenu();
      if(userInputScanner.hasNext())
        userSelection = userInputScanner.next(); // Get next userInput for each while-loop cycle
    } // end of while loop that waits for input '4'

    System.out.println("Goodbye!");
  }

  /**
   * Displays the default menu which provides the user
   *    with four choices
   */
  @Override
  public void displayMainMenu() {
    System.out.println("You are in the Main Menu:");
    System.out.println("           1) Lookup ISBN");
    System.out.println("           2) Search by Title Word");
    System.out.println("           3) Set Author Name Filter");
    System.out.println("           4) Exit Application");
    System.out.println();
  }

  /**
   * Displays a list of books
   * @param books - list of books
   */
  @Override
  public void displayBooks(List<IBook> books) {
    for(int i = 0; i < books.size(); i++) {
      IBook curBook = books.get(i);
      System.out.println(i+1 + ". " + curBook.getTitle() + " by " + curBook.getAuthors() +
          ", ISBN: " + curBook.getISBN13());
      System.out.println();
    }
  }

  /**
   * Looksup books by their ISBN number, and prints them out
   */
  @Override
  public void isbnLookup() {
    System.out.println("You are in the Lookup ISBN Menu:");
    System.out.print("        Enter ISBN to look up: ");

    userInputScanner.nextLine();
    String ISBNToCheck = userInputScanner.nextLine();

    if(!validator.validate(ISBNToCheck)) { // Get valid isbn
      while(!validator.validate(ISBNToCheck)) {
        System.out.print("      Please enter a valid ISBN: ");
        ISBNToCheck = userInputScanner.next();
      }
    }

    IBook book = backend.getByISBN(ISBNToCheck);
    System.out.println("1. " + book.getTitle() + " by " + book.getAuthors() + ", ISBN: " +
        book.getISBN13());

  }

  /**
   * Prints books that have relevant words in title
   */
  @Override
  public void titleSearch() {
    System.out.println("You are in the Search for Title Word Menu: ");
    System.out.print("      Enter a word to search for in book titles (empty for all books): ");

    userInputScanner.nextLine();
    String keyWord = userInputScanner.nextLine().trim();
    List<IBook> booksWithKeyWord = backend.searchByTitleWord(keyWord);

    // Print out number of books found with whatever conditions before listing
    if(backend.getAuthorFilter() == null) {
      System.out.println("Matches (any author) " + booksWithKeyWord.size() + " of " +
          backend.getNumberOfBooks());
    } else {
      System.out.println("Matches (author filter: " + backend.getAuthorFilter() + ") " +
          booksWithKeyWord.size() + " of " + backend.getNumberOfBooks());
    }

    displayBooks(booksWithKeyWord);

    // Print out number of books found with whatever conditions after listing
    if(backend.getAuthorFilter() == null) {
      System.out.println("Matches (any author) " + booksWithKeyWord.size() + " of " +
          backend.getNumberOfBooks());
    } else {
      System.out.println("Matches (author filter: " + backend.getAuthorFilter() + ") " +
          booksWithKeyWord.size() + " of " + backend.getNumberOfBooks());
    }
  }

  /**
   * Author filter menu to simplify code for when user hits 3
   */
  public void authorFilterMenu() {
    System.out.println("You are in the Set Author Filter Menu: ");
    System.out.print("      Author name must currently contain: ");

    // Display the current author name filter
    if(backend.getAuthorFilter() == null)
      System.out.println("none");
    else
      System.out.println(backend.getAuthorFilter());

    // Reset the author filter once user is in this menu again
    backend.resetAuthorFilter();

    // Get / Set the author filter
    System.out.print("      Enter a new string for author names to contain (empty for any): ");
    userInputScanner.nextLine();
    String authorFilter = userInputScanner.nextLine();
    backend.setAuthorFilter(authorFilter);
  }

  /**
   * Main method to test runCommandLoop()
   * @param args - unused
   */
  public static void main(String[] args) {
    Scanner scnr = new Scanner(System.in);
    BookMapperBackend backend = new BookMapperBackend();
    IISBNVal validator = new IISBNVal();
    BookMapperFrontend frontend = new BookMapperFrontend(scnr, backend, validator);
    frontend.runCommandLoop();
  }

}

