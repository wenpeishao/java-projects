// --== CS400 Project One File Header ==--
// Name: <Wenpei Shao>
// CSL Username: <wenpei>
// Email: <wshao33@wisc.edu email address>
// Lecture #: <003 @2:25pm>
// Notes to Grader: <any optional extra notes to your grader>
/**
 * This class defines getter methods for each book's data attributes
 * and is implemented by classes that represent a book and its associated
 * data.
 */
public class Book implements IBook{
  String title;
  String authors;
  String ISBN13;
  /**
   * Creates the Book class from the provided String. Each book class have title, author and ISBN13
   * @param title
   * @param authors
   * @param ISBN13
   */
  public Book(String title, String authors, String ISBN13) {
    
    this.title=title;
    this.authors=authors;
    this.ISBN13=ISBN13;

  }
  
  /**
   * Returns the title of the book.
   * @return title of the book
   */
  @Override
  public String getTitle() {
    return title;
  }
  /**
   * Returns a string that contains the authors of the book
   * as a single string with different authors separated by /.
   * @return author names as single string
   */
  @Override
  public String getAuthors() {
    return authors;
  }
  
  /**
   * Returns the 13 digit ISBN (ISBN13) that uniquely identifies this book.
   * @return ISBN number of book
   */
  @Override
  public String getISBN13() {
    return ISBN13;
  }

}
