// --== CS400 Fall 2022 File Header Information ==--
// Name: Wenpei Shao
// Email: Wshao33@wisc.edu
// Team: DE
// TA: April Roszkowski
// Lecturer: Florian Heimerl
// Notes to Grader: Will update to fit the AG after the intergation

import org.junit.Test;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class BackendDeveloperTests {
  /**
   * 
   * Test the GraphADT add method to make sure exception is throw
   * 
   * 
   */
  @Test
  public void test1() {
    try {
      String station1 = "E main Street";
      String station2 = "W main Street";
      String station3 = "M main Street";
      
    

      ArrayList<String> stations = new ArrayList<String>();
      stations.add(station2);
      stations.add(station3);
      
      
      ArrayList<Integer> weights = new ArrayList();
      weights.add(1);
      weights.add(2);

      SubwayBackend be = new SubwayBackend();
      be.addStation(station1, stations, weights);
      fail();

    }catch (Exception e) {
    assertTrue(true);

    }
  }


  /**
   * Test the GraphADT remove method to make sure exception is throw
   * This tests creating a station object as well as testing values from the expected getters
   */
  @Test
  public void test2() {
    // Check the values of our created house
    
    try {
      String station1 = "E main Street";
      String station2 = "W main Street";
      String station3 = "M main Street";
      
      

      ArrayList<String> stations = new ArrayList<String>();
      stations.add(station2);
      stations.add(station3);
      
      
      ArrayList<Integer> weights = new ArrayList();
      weights.add(1);
      weights.add(2);

    SubwayBackend be = new SubwayBackend();
    be.addStation(station1, stations, weights);
    be.removeStation(station1);
    fail();

    }catch(Exception e) {
      assertTrue(true);
    }

  }


  /**
   * Test findBestPath method by check if any exception is throw catch by the AG
   * 
   */
  @Test
  public void test3() {
    try {
    String station1 = "E main Street";
    String station2 = "W main Street";
    String station3 = "M main Street";
    
    

    ArrayList<String> stations = new ArrayList<String>();
    stations.add(station2);
    stations.add(station3);
    
    
    ArrayList<Integer> weights = new ArrayList();
    weights.add(1);
    weights.add(2);

    SubwayBackend be = new SubwayBackend();
    be.addStation(station1, stations, weights);
    be.findBestPath(station1, 1);
    fail();
    }catch(Exception e) {
      assertTrue(true);
    }
  }

  /**
   * Test adding houses through our backend class with wrong arguement by test if any Exception is catch 
   */
  @Test
  public void test4() {
    try {
    String station1 = "E main Street";
    String station2 = "W main Street";


    ArrayList<String> stations = new ArrayList<String>();
    stations.add(station1);
    stations.add(station2);
    
    ArrayList<Integer> weights = new ArrayList();
    weights.add(1);
    weights.add(2);

    SubwayBackend be = new SubwayBackend();
    be.addStation(station2, stations, weights);
     fail();
    }catch (Exception e) {
      assertTrue(true);
    }
  }

  /**
   * Test findShortestPath() method by check if exception is throw by the ae.
   */
  @Test
  public void test5() {
    try {

    String station1 = "E main Street";
    String station2 = "W main Street";
    String station3 = "M main Street";
    
    

    ArrayList<String> stations = new ArrayList<String>();
    stations.add(station2);
    stations.add(station3);
    
    
    ArrayList<Integer> weights = new ArrayList();
    weights.add(1);
    weights.add(2);

    SubwayBackend be = new SubwayBackend();
    
    be.findShortestPath(station2, station2);
    fail();

    }catch(Exception e) {
      assertTrue(true);

    }
  }
  
  /**
   * Tests Load data from through the backend interface.
   * This depends on the DW
   * @throws FileNotFoundException 
   */
  @Test
  public void firstIntegrationTest() throws FileNotFoundException {
    SubwayBackend backend = new SubwayBackend();
    try {
    backend.loadData();
    assertTrue(true);
    }catch(Exception e) {
      fail();
    }
    

  }
  /**
   * Testing backendDeveloper's code (mine) working in conjunction with
   * Algorithm Engineer's code. These tests rely on the Iterator() functionality
   * created by the Algorithm Engineer.
   * @throws FileNotFoundException 
   */
  @Test
  public void secondIntegrationTest() throws FileNotFoundException {
    SubwayBackend backend = new SubwayBackend();
    
    try {
      backend.removeStation("backend");
    }catch(Exception e) {
      fail();
    }
    
  }
  @Test
  /**
   * Additional testing for frontend for search for shortest path with invalid input
   */
  public void testingFE1() {
      try {
          TextUITester tester = new TextUITester("6\n6\n6\n5\n");
          SubwayFrontend frontend = new SubwayFrontend(new Scanner(System.in), new SubwayBackend());
          frontend.runCommandLoop();
          String output = tester.checkOutput();
          String expected = "Welcome to the Subway Stations Application!\n" + 
              "x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x\n" + 
              "\n" + 
              "You are in the Main Menu:\n" + 
              "          1) Search for shortest route\n" + 
              "          2) Search for best routes with a maximum price\n" + 
              "          3) Add Subway Station\n" + 
              "          4) Remove Subway Station\n" + 
              "          5) Exit Application\n" + 
              "\n" + 
              "You are in the Main Menu:\n" + 
              "          1) Search for shortest route\n" + 
              "          2) Search for best routes with a maximum price\n" + 
              "          3) Add Subway Station\n" + 
              "          4) Remove Subway Station\n" + 
              "          5) Exit Application\n" + 
              "\n" + 
              "You are in the Main Menu:\n" + 
              "          1) Search for shortest route\n" + 
              "          2) Search for best routes with a maximum price\n" + 
              "          3) Add Subway Station\n" + 
              "          4) Remove Subway Station\n" + 
              "          5) Exit Application\n" + 
              "\n" + 
              "You are in the Main Menu:\n" + 
              "          1) Search for shortest route\n" + 
              "          2) Search for best routes with a maximum price\n" + 
              "          3) Add Subway Station\n" + 
              "          4) Remove Subway Station\n" + 
              "          5) Exit Application\n" + 
              "\n" + 
              "Goodbye!\n";
          ;
          assertEquals(expected, output);
      } catch (Exception e) {
        fail();
      }
  }
      @Test
      /**
       * Additional testing for frontend for search for shortest path with invalid input
       */
      public void testingFE2() {
          try {
              TextUITester tester = new TextUITester("2\n2\n2\n");
              SubwayFrontend frontend = new SubwayFrontend(new Scanner(System.in), new SubwayBackend());
              frontend.runCommandLoop();
              String output = tester.checkOutput();
              
              fail();
          } catch (Exception e) {
            assertTrue(true);
          }
  }

}

