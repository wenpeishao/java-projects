import java.util.ArrayList;
import java.util.List;

public class BackendDeveloperTest {
  
  //tests addBook
  public static boolean test1() { 
      BookMapperBackend test1 = new BookMapperBackend();
      IBook AGOT = new IBook("AGOT","GRRM", "1");
      IBook ACOK = new IBook("ACOK","GRRM","2");
      IBook ASOS = new IBook("ASOS","GRRM","3");
      IBook AFFC = new IBook("AFFC","GRRM","4");
      IBook ADOD = new IBook("ADOD","GRRM","5");
      
      
      test1.addBook(AGOT);
      if(!(test1.getByISBN("1").equals(AGOT) && test1.getNumberOfBooks() == 1)) {
        return false;
      }
      
      test1.addBook(ACOK);
      if(!(test1.getByISBN("2").equals(ACOK) && test1.getNumberOfBooks() == 2)) {
        return false;
      }
      
      test1.addBook(ASOS);
      if(!(test1.getByISBN("3").equals(ASOS) && test1.getNumberOfBooks() == 3)) {
        return false;
      }

      return true;
  }
  
  //Tests getNumberOfBooks
  public static boolean test2() { 
    BookMapperBackend test2 = new BookMapperBackend();
    IBook AGOT = new IBook("AGOT","GRRM", "1");


    if(test2.getNumberOfBooks() != 0) {
      return false;
    }
    test2.addBook(AGOT);
    if(test2.getNumberOfBooks() != 1) {
      return false;
    }
    test2.addBook(AGOT);
    if(test2.getNumberOfBooks() != 2) {
      return false;
    }
    test2.addBook(AGOT);
    if(test2.getNumberOfBooks() != 3) {
      return false;
    } 
    
    return true;
  }
  
  //tests Author Filter
  public static boolean test3() { 
    BookMapperBackend test3 = new BookMapperBackend(); 
    if(test3.getAuthorFilter() != null) {
      return false;
    }
    
    test3.setAuthorFilter("him");
    if(!(test3.getAuthorFilter().equals("him"))) {
      return false;
    }
    
    test3.resetAuthorFilter();
    if(test3.getAuthorFilter() != null) {
      return false;
    }
 
    return true;   
  }
  
  //tests search function
  public static boolean test4() {
    BookMapperBackend test3 = new BookMapperBackend();
    IBook AGOT = new IBook("a game of thrones","GRRM", "1");
    IBook ACOK = new IBook("a clash of kings","GRRM","2");
    IBook ASOS = new IBook("a storm of swords","GRRM","3");
    IBook AFFC = new IBook("a feast for crows","George RR Martin","4");
    IBook ADOD = new IBook("a dance of dragons","Martin","5");
    List<IBook> list = new ArrayList<IBook>();
    
    
    //searches for book in list
    test3.addBook(AGOT);
    test3.addBook(ACOK);
    test3.addBook(ASOS);
    test3.addBook(AFFC);
    test3.addBook(ADOD);
    list = test3.searchByTitleWord("game");
    if(!(list.get(0).getISBN13().equals("1"))) {
      return false;
    }
    
    list = test3.searchByTitleWord("feast");
    if(!(list.get(0).getISBN13().equals("4"))) {
      return false;
    }
    
    
    //searches for book not in list
    list = test3.searchByTitleWord("amory");
    if(list.size() != 0) {
      return false;
    }
    
    //searches for key term w several books
    list = test3.searchByTitleWord("of");
    if(!(list.size() == 4 && list.get(0).getISBN13().equals("1") && list.get(1).getISBN13().equals("2") 
        && list.get(2).getISBN13().equals("3") && list.get(3).getISBN13().equals("5"))){
      return false;
    }
    
    //searches by author filter
    test3.setAuthorFilter("GRRM");
    list = test3.searchByTitleWord("of");
    if(!(list.size() == 3 && list.get(0).getISBN13().equals("1") && list.get(1).getISBN13().equals("2") 
        && list.get(2).getISBN13().equals("3"))) {
      return false;
    }
    
    test3.setAuthorFilter("Martin");
    list = test3.searchByTitleWord("of");
    if(!(list.size() == 1 && list.get(0).getISBN13().equals("5"))) {
      return false;
    }
    
    //satisfies author but not key term
    test3.setAuthorFilter("Martin");
    list = test3.searchByTitleWord("ate");
    if(!(list.size() == 0)) {
      return false;
    }
 
    //satisfies key term but not author
    list = test3.searchByTitleWord("storm");
    if(!(list.size() == 0)) {
      return false;
    }
    
    
       return true;
  }
  
  //tests getByISBN
  public static boolean test5() {
    BookMapperBackend test4 = new BookMapperBackend();
    IBook AGOT = new IBook("a game of thrones","GRRM", "1");
    IBook ACOK = new IBook("a clash of kings","GRRM","2");
    IBook ASOS = new IBook("a storm of swords","GRRM","3");
    IBook AFFC = new IBook("a feast for crows","George RR Martin","4");
    IBook ADOD = new IBook("a dance of dragons","Martin","5");
    
    
    test4.addBook(AGOT);
    test4.addBook(ACOK);
    test4.addBook(ASOS);
    test4.addBook(AFFC);
    test4.addBook(ADOD);
    
    if(!(test4.getByISBN("3").getTitle().equals("a storm of swords"))) {
      return false;
    }
    
    if(!(test4.getByISBN("6") == null)) {
      return false;
    }
    
    return true;
  }
  
  public static void main(String args[]) {
    System.out.println(test1());
    System.out.println(test2());
    System.out.println(test3());
    System.out.println(test4());
    System.out.println(test5());
    
    
  }
}
