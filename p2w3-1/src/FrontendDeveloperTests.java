// --== CS400 Fall 2022 File Header Information ==--
// Name: <Wenpei>
// Email: <wshao33@wisc.edu>
// Team: <DE>
// TA: <April Roszkowski>
// Lecturer: <Florian Heimerl >
// Notes to Grader: <optional extra notes>
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Stack;
import org.junit.jupiter.api.Test;

public class FrontendDeveloperTests {

  public FrontendDeveloperTests() {
  }
  
  /**
   * This method tests our frontend with input 3(exit)
   */
  @Test
  public void Jtest1() {
    // 1. Create a new TextUITester object for each test, and
    // pass the text that you'd like to simulate a user typing as only argument.
    TextUITester tester = new TextUITester("4\n");

    // 2. Run the code that you want to test here:
    Scanner scnr = new Scanner(System.in);
    HouseSearcherBackend backend = new HouseSearcherBackend();
    HouseSearcherFrontend frontend = new HouseSearcherFrontend(scnr, backend);
    frontend.runCommandLoop();

    // 3. Check whether the output printed to System.out matches your expectations.
    String output = tester.checkOutput();
    
    assertEquals("Welcome to the House Searcher Application!\n" + 
        "x+x+xx+x+xx+x+xx+x+xx+x+xx+x+xx+x+xx+x+x\n" + 
        "\n" + 
        "You are in the Main Menu:\n" + 
        "           1) Search for House\n" + 
        "           2) Add House\n" + 
        "           3) remove House\n" + 
        "           4) Exit Application\n" + 
        "\n" + 
        "Goodbye!\n", output);
  }
  /**
   * This method tests our frontend with input the price with a range
   */
  @Test
  public void Jtest2() {
    // 1. Create a new TextUITester object for each test, and
    // pass the text that you'd like to simulate a user typing as only argument.
    TextUITester tester = new TextUITester("1\n0\n1000\nno\nno\n4\n");

    // 2. Run the code that you want to test here:
    Scanner scnr = new Scanner(System.in);
    HouseSearcherBackend backend = new HouseSearcherBackend();
    HouseSearcherFrontend frontend = new HouseSearcherFrontend(scnr, backend);
    frontend.runCommandLoop();

    // 3. Check whether the output printed to System.out matches your expectations.
    String output = tester.checkOutput();
    
    assertEquals("Welcome to the House Searcher Application!\n" + 
        "x+x+xx+x+xx+x+xx+x+xx+x+xx+x+xx+x+xx+x+x\n" + 
        "\n" + 
        "You are in the Main Menu:\n" + 
        "           1) Search for House\n" + 
        "           2) Add House\n" + 
        "           3) remove House\n" + 
        "           4) Exit Application\n" + 
        "\n" + 
        "You are in the Search by House Menu:\n" + 
        "—-----------------------------------\n" + 
        "Enter minimum price: Enter maximum price: \n" + 
        "Would you also like to sort by bedrooms? (yes/no) Would you also like to sort by bathrooms? (yes/no) Nothing found\n" + 
        "You are in the Main Menu:\n" + 
        "           1) Search for House\n" + 
        "           2) Add House\n" + 
        "           3) remove House\n" + 
        "           4) Exit Application\n" + 
        "\n" + 
        "Goodbye!\n", output);
  }
  /**
   * This method tests our frontend with input the number of bathroom and bedroom
   */
  @Test
  public void Jtest3() {
    // 1. Create a new TextUITester object for each test, and
    // pass the text that you'd like to simulate a user typing as only argument.
    TextUITester tester = new TextUITester("1\n100\n200\n\ryes\n\r2\n\ryes\n\r2\n\r4\n\r");

    // 2. Run the code that you want to test here:
    Scanner scnr = new Scanner(System.in);
    HouseSearcherBackend backend = new HouseSearcherBackend();
    HouseSearcherFrontend frontend = new HouseSearcherFrontend(scnr, backend);
    frontend.runCommandLoop();

    // 3. Check whether the output printed to System.out matches your expectations.
    String output = tester.checkOutput();
    
    assertEquals("Welcome to the House Searcher Application!\n" + 
        "x+x+xx+x+xx+x+xx+x+xx+x+xx+x+xx+x+xx+x+x\n" + 
        "\n" + 
        "You are in the Main Menu:\n" + 
        "           1) Search for House\n" + 
        "           2) Add House\n" + 
        "           3) remove House\n" + 
        "           4) Exit Application\n" + 
        "\n" + 
        "You are in the Search by House Menu:\n" + 
        "—-----------------------------------\n" + 
        "Enter minimum price: Enter maximum price: \n" + 
        "Would you also like to sort by bedrooms? (yes/no) Would you also like to sort by bedrooms? (yes/no) How many bedrooms would you like your house to have? Would you also like to sort by bathrooms? (yes/no) Would you also like to sort by bathrooms? (yes/no) How many bathrooms would you like your house to have? Nothing found\n" + 
        "You are in the Main Menu:\n" + 
        "           1) Search for House\n" + 
        "           2) Add House\n" + 
        "           3) remove House\n" + 
        "           4) Exit Application\n" + 
        "\n" + 
        "Goodbye!\n"+ 
        "", output);
  }
  /**
   * This method tests our frontend with wrong input
   */
  @Test
  public void Jtest4() {
    // 1. Create a new TextUITester object for each test, and
    // pass the text that you'd like to simulate a user typing as only argument.
    TextUITester tester = new TextUITester("6\n\r1\n\r110\n\r200\n\rnoo\nno\nno\n\r4\n");

    // 2. Run the code that you want to test here:
    Scanner scnr = new Scanner(System.in);
    HouseSearcherBackend backend = new HouseSearcherBackend();
    HouseSearcherFrontend frontend = new HouseSearcherFrontend(scnr, backend);
    frontend.runCommandLoop();

    // 3. Check whether the output printed to System.out matches your expectations.
    String output = tester.checkOutput();
    
    assertEquals("Welcome to the House Searcher Application!\n" + 
        "x+x+xx+x+xx+x+xx+x+xx+x+xx+x+xx+x+xx+x+x\n" + 
        "\n" + 
        "You are in the Main Menu:\n" + 
        "           1) Search for House\n" + 
        "           2) Add House\n" + 
        "           3) remove House\n" + 
        "           4) Exit Application\n" + 
        "\n" + 
        "Please enter a valid input (a number 1-4): \n" + 
        "You are in the Main Menu:\n" + 
        "           1) Search for House\n" + 
        "           2) Add House\n" + 
        "           3) remove House\n" + 
        "           4) Exit Application\n" + 
        "\n" + 
        "You are in the Search by House Menu:\n" + 
        "—-----------------------------------\n" + 
        "Enter minimum price: Enter maximum price: \n" + 
        "Would you also like to sort by bedrooms? (yes/no) Would you also like to sort by bedrooms? (yes/no) Would you also like to sort by bedrooms? (yes/no) Would you also like to sort by bathrooms? (yes/no) Nothing found\n" + 
        "You are in the Main Menu:\n" + 
        "           1) Search for House\n" + 
        "           2) Add House\n" + 
        "           3) remove House\n" + 
        "           4) Exit Application\n" + 
        "\n" + 
        "Goodbye!\n" + 
        "", output);
  }
  /**
   * This method tests our frontend for the addhouse option
   */
  @Test
  public void Jtest5() {
    // 1. Create a new TextUITester object for each test, and
    // pass the text that you'd like to simulate a user typing as only argument.
    TextUITester tester = new TextUITester("2\n\r1000\n\r1\n\r1\n\r4\n");

    // 2. Run the code that you want to test here:
    Scanner scnr = new Scanner(System.in);
    HouseSearcherBackend backend = new HouseSearcherBackend();
    HouseSearcherFrontend frontend = new HouseSearcherFrontend(scnr, backend);
    frontend.runCommandLoop();

    // 3. Check whether the output printed to System.out matches your expectations.
    String output = tester.checkOutput();
    
    assertEquals("Welcome to the House Searcher Application!\n" + 
        "x+x+xx+x+xx+x+xx+x+xx+x+xx+x+xx+x+xx+x+x\n" + 
        "\n" + 
        "You are in the Main Menu:\n" + 
        "           1) Search for House\n" + 
        "           2) Add House\n" + 
        "           3) remove House\n" + 
        "           4) Exit Application\n" + 
        "\n" + 
        "You are in the Add House Menu: \n" + 
        "—-----------------------------------\n" + 
        "What is the price of your house? How many bedrooms does your house have? \n" + 
        "How many bathrooms does your house have? \n" + 
        "You are in the Main Menu:\n" + 
        "           1) Search for House\n" + 
        "           2) Add House\n" + 
        "           3) remove House\n" + 
        "           4) Exit Application\n" + 
        "\n" + 
        "Goodbye!\n" + 
        "", output);
  }
  /**
   * This method is the first intergation test for this project by add house and display the house 
   */
  @Test
  public void Jtest6() {
    // 1. Create a new TextUITester object for each test, and
    // pass the text that you'd like to simulate a user typing as only argument.
    TextUITester tester = new TextUITester("2\n500\n1\n1\n2\n600\n2\n2\n2\n400\n1\n1\n3\n500\n1\n1\n1\n0\n1000\nno\nno\n4\n");

    // 2. Run the code that you want to test here:
    Scanner scnr = new Scanner(System.in);
    HouseSearcherBackend backend = new HouseSearcherBackend();
    HouseSearcherFrontend frontend = new HouseSearcherFrontend(scnr, backend);
    frontend.runCommandLoop();

    // 3. Check whether the output printed to System.out matches your expectations.
    String output = tester.checkOutput();
    
    assertEquals("Welcome to the House Searcher Application!\n" + 
        "x+x+xx+x+xx+x+xx+x+xx+x+xx+x+xx+x+xx+x+x\n" + 
        "\n" + 
        "You are in the Main Menu:\n" + 
        "           1) Search for House\n" + 
        "           2) Add House\n" + 
        "           3) remove House\n" + 
        "           4) Exit Application\n" + 
        "\n" + 
        "You are in the Add House Menu: \n" + 
        "—-----------------------------------\n" + 
        "What is the price of your house? How many bedrooms does your house have? \n" + 
        "How many bathrooms does your house have? \n" + 
        "You are in the Main Menu:\n" + 
        "           1) Search for House\n" + 
        "           2) Add House\n" + 
        "           3) remove House\n" + 
        "           4) Exit Application\n" + 
        "\n" + 
        "You are in the Add House Menu: \n" + 
        "—-----------------------------------\n" + 
        "What is the price of your house? How many bedrooms does your house have? \n" + 
        "How many bathrooms does your house have? \n" + 
        "You are in the Main Menu:\n" + 
        "           1) Search for House\n" + 
        "           2) Add House\n" + 
        "           3) remove House\n" + 
        "           4) Exit Application\n" + 
        "\n" + 
        "You are in the Add House Menu: \n" + 
        "—-----------------------------------\n" + 
        "What is the price of your house? How many bedrooms does your house have? \n" + 
        "How many bathrooms does your house have? \n" + 
        "You are in the Main Menu:\n" + 
        "           1) Search for House\n" + 
        "           2) Add House\n" + 
        "           3) remove House\n" + 
        "           4) Exit Application\n" + 
        "\n" + 
        "You are in the remove House Menu: \n" + 
        "—-----------------------------------\n" + 
        "What is the price of the house? How many bedrooms does the house have? \n" + 
        "How many bathrooms does the house have? \n" + 
        "Remove Success! \n" + 
        "You are in the Main Menu:\n" + 
        "           1) Search for House\n" + 
        "           2) Add House\n" + 
        "           3) remove House\n" + 
        "           4) Exit Application\n" + 
        "\n" + 
        "You are in the Search by House Menu:\n" + 
        "—-----------------------------------\n" + 
        "Enter minimum price: Enter maximum price: \n" + 
        "Would you also like to sort by bedrooms? (yes/no) Would you also like to sort by bathrooms? (yes/no) 1. Price: $400\n" + 
        "  Bedrooms: 1\n" + 
        "  Bathrooms: 1\n" + 
        "\n" + 
        "2. Price: $600\n" + 
        "  Bedrooms: 2\n" + 
        "  Bathrooms: 2\n" + 
        "\n" + 
        "You are in the Main Menu:\n" + 
        "           1) Search for House\n" + 
        "           2) Add House\n" + 
        "           3) remove House\n" + 
        "           4) Exit Application\n" + 
        "\n" + 
        "Goodbye!\n" + 
        "", output);
  }
  /**
   * This method is the second intergation test for this project by add three house and remove one of them and display the rest
   */
  @Test
  public void Jtest7() {
    // 1. Create a new TextUITester object for each test, and
    // pass the text that you'd like to simulate a user typing as only argument.
    TextUITester tester = new TextUITester("2\n500\n1\n1\n1\n0\n1000\nno\nno\n4\n");

    // 2. Run the code that you want to test here:
    Scanner scnr = new Scanner(System.in);
    HouseSearcherBackend backend = new HouseSearcherBackend();
    HouseSearcherFrontend frontend = new HouseSearcherFrontend(scnr, backend);
    frontend.runCommandLoop();

    // 3. Check whether the output printed to System.out matches your expectations.
    String output = tester.checkOutput();
    
    assertEquals("Welcome to the House Searcher Application!\n" + 
        "x+x+xx+x+xx+x+xx+x+xx+x+xx+x+xx+x+xx+x+x\n" + 
        "\n" + 
        "You are in the Main Menu:\n" + 
        "           1) Search for House\n" + 
        "           2) Add House\n" + 
        "           3) remove House\n" + 
        "           4) Exit Application\n" + 
        "\n" + 
        "You are in the Add House Menu: \n" + 
        "—-----------------------------------\n" + 
        "What is the price of your house? How many bedrooms does your house have? \n" + 
        "How many bathrooms does your house have? \n" + 
        "You are in the Main Menu:\n" + 
        "           1) Search for House\n" + 
        "           2) Add House\n" + 
        "           3) remove House\n" + 
        "           4) Exit Application\n" + 
        "\n" + 
        "You are in the Search by House Menu:\n" + 
        "—-----------------------------------\n" + 
        "Enter minimum price: Enter maximum price: \n" + 
        "Would you also like to sort by bedrooms? (yes/no) Would you also like to sort by bathrooms? (yes/no) 1. Price: $500\n" + 
        "  Bedrooms: 1\n" + 
        "  Bathrooms: 1\n" + 
        "\n" + 
        "You are in the Main Menu:\n" + 
        "           1) Search for House\n" + 
        "           2) Add House\n" + 
        "           3) remove House\n" + 
        "           4) Exit Application\n" + 
        "\n" + 
        "Goodbye!\n" + 
        "", output);
  }
  /**
   * First Test for backend for adding houses 
   */
  @Test
  public void Jtest8() {
    House house1 = new House(1000000, 1, 1);
    House house2 = new House(1200000, 2, 2);
    HouseSearcherBackend backend = new HouseSearcherBackend();

    // Add houses
    backend.addHouse(house1);
    backend.addHouse(house2);

    // Check if houses are actually added (and can be found)
    List<House> houseList = backend.searchByPrice(0, 1000000, false, false);
    assertEquals(1, houseList.size());
  }
  /**
   * Second Test for backend
   * Test the house compareTo() so we can properly compare houses
   * This tests comparing houses with the same prices, # of baths, and # of bedrooms
   * There is a tier system to how they are compared, explained in the house compareTo method
   */
  @Test
  public void Jtest9() {
    House house1 = new House(1000000, 3, 2);
    House house2 = new House(500000, 3, 2);


    // Compare house1 and house2 (different prices)
    assertEquals(-1, house2.compareTo(house1));

    // Compare house1 and house3 (different # of bathrooms)
    House house3 = new House(1000000, 4, 2);
    assertEquals(1, house3.compareTo(house1));
    
    House house4 = new House(100000,4,3);
    assertEquals(1, house3.compareTo(house4));

    

  }
  
}
