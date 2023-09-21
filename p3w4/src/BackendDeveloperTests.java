// --== CS400 Fall 2022 File Header Information ==--
// Name: Wenpei Shao
// Email: Wshao33@wisc.edu
// Team: DE
// TA: April Roszkowski
// Lecturer: Florian Heimerl
// Notes to Grader: Will update to fit the AG after the intergation

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class BackendDeveloperTests {
  /**
   * 
   * Test the GraphADT add method to make sure no exception is throw
   * 
   * 
   */
  @Test
  public void test1() {
    try {
      String station1 = "E main Street";
      String station2 = "W main Street";
      String station3 = "M main Street";
      
      Station s1 = new Station(station1);
      Station s2 = new Station(station2);
      Station s3 = new Station(station3);
      

      ArrayList<Station> stations = new ArrayList<Station>();
      stations.add(s2);
      stations.add(s3);
      
      
      ArrayList<Integer> weights = new ArrayList();
      weights.add(1);
      weights.add(2);

      SubwayBackend be = new SubwayBackend();
      be.addStation(s1, stations, weights);
    assertTrue(true);

    }catch (Exception e) {
    fail();
    }
  }


  /**
   * Test the GraphADT remove method to make sure no exception is throw
   * This tests creating a station object as well as testing values from the expected getters
   */
  @Test
  public void test2() {
    // Check the values of our created house
    
    try {
      String station1 = "E main Street";
      String station2 = "W main Street";
      String station3 = "M main Street";
      
      Station s1 = new Station(station1);
      Station s2 = new Station(station2);
      Station s3 = new Station(station3);
      

      ArrayList<Station> stations = new ArrayList<Station>();
      stations.add(s2);
      stations.add(s3);
      
      
      ArrayList<Integer> weights = new ArrayList();
      weights.add(1);
      weights.add(2);

    SubwayBackend be = new SubwayBackend();
    be.addStation(s1, stations, weights);
    be.removeStation(station1);
    assertTrue(true);
    }catch(Exception e) {
      fail();
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
    
    Station s1 = new Station(station1);
    Station s2 = new Station(station2);
    Station s3 = new Station(station3);
    

    ArrayList<Station> stations = new ArrayList<Station>();
    stations.add(s2);
    stations.add(s3);
    
    
    ArrayList<Integer> weights = new ArrayList();
    weights.add(1);
    weights.add(2);

    SubwayBackend be = new SubwayBackend();
    be.addStation(s1, stations, weights);
    be.findBestPath(s1, 1);
    assertTrue(true);
    }catch(Exception e) {
      fail();
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
    Station s1 = new Station(station1);
    Station s2 = new Station(station2);

    ArrayList<Station> stations = new ArrayList<Station>();
    stations.add(s1);
    stations.add(s2);
    
    ArrayList<Integer> weights = new ArrayList();
    weights.add(1);
    weights.add(2);

    SubwayBackend be = new SubwayBackend();
    be.addStation(s2, stations, weights);
     fail();
    }catch (Exception e) {
      assertTrue(true);
    }
  }

  /**
   * Test findShortestPath() method by check if any exception is throw by the ae.
   */
  @Test
  public void test5() {
    try {

    String station1 = "E main Street";
    String station2 = "W main Street";
    String station3 = "M main Street";
    
    Station s1 = new Station(station1);
    Station s2 = new Station(station2);
    Station s3 = new Station(station3);
    

    ArrayList<Station> stations = new ArrayList<Station>();
    stations.add(s2);
    stations.add(s3);
    
    
    ArrayList<Integer> weights = new ArrayList();
    weights.add(1);
    weights.add(2);

    SubwayBackend be = new SubwayBackend();
    
    be.findShortestPath(s2, s3);
    assertTrue(true);

    }catch(Exception e) {
      fail();
    }
  }


}

