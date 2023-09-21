import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Instances of this class can be used to load book data from a CSV file.
 */
public class BookLoader implements IBookLoader {

  public BookLoader() {
  }

  /**
   * This method loads the list of books from a CSV file.
   * 
   * @param filepathToCSV path to the CSV file relative to the executable
   * @return a list of book objects
   * @throws FileNotFoundException
   */
  @Override
  public List<IBook> loadBooks(String filepathToCSV) throws FileNotFoundException {
    List<IBook> listOfBooks = new ArrayList<IBook>();
    String bookLine;
    String authors;
    String ISBN13;
    String title;
    
    Scanner input = new Scanner(new File(filepathToCSV),"UTF-8");
    input.nextLine();
    while (input.hasNextLine()) {
      bookLine = input.nextLine();
      String [] bookElement = bookLine.split(",");
      title=bookElement[1];
      authors=bookElement[2];
      ISBN13=bookElement[5];
//      title = bookLine.split(",")[1];
//      authors = bookLine.split(",")[2];
//      ISBN13 = bookLine.split(",")[5];
      IBook book= new Book(title, authors, ISBN13);
      listOfBooks.add(book);
    }
    return listOfBooks;
  }

}
