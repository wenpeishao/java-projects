// --== CS400 Fall 2022 File Header Information ==--
// Name: Aidan Carrig
// Email: acarrig@wisc.edu
// Team: DE
// TA: April Roszkowski
// Lecturer: Florian Heimerl
// Notes to Grader: N/A

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AlgorithmEngineerTests {

  private DijkstraPath<String, Integer> graph;

  /**
   * Instantiate graph.
   */
  @BeforeEach
  public void createGraph() {
    graph = new DijkstraPath<>();
    // insert vertices A-F
    graph.insertVertex("A");
    graph.insertVertex("B");
    graph.insertVertex("C");
    graph.insertVertex("D");
    graph.insertVertex("E");
    graph.insertVertex("F");
    // insert edges
    graph.insertEdge("A","B",6);
    graph.insertEdge("A","C",2);
    graph.insertEdge("A","D",5);
    graph.insertEdge("B","E",1);
    graph.insertEdge("B","C",2);
    graph.insertEdge("C","B",3);
    graph.insertEdge("C","F",1);
    graph.insertEdge("D","E",3);
    graph.insertEdge("E","A",4);
    graph.insertEdge("F","A",1);
    graph.insertEdge("F","D",1);
  }

  /**
   * Check cost for node E
   */
  @Test
  public void testPathCostAtoE() {
    assertTrue(graph.getPathCost("A", "E") == 6);
  }

  /**
   * Confirm the sequence of nodes from A to E
   */
  @Test
  public void testSequenceAtoE() {
    assertTrue(graph.shortestPath("A", "E").toString().equals("[A, C, B, E]"));
  }

  /**
   * Test the removeEdge() method in DijkstraPath.java
   */
  @Test
  public void testRemoveEdge() {
    assertEquals(true, graph.removeEdge("C", "F"));
    assertEquals(false, graph.containsEdge("C", "F"));
  }

  /**
   * Test the removeVertext() method in DijkstraPath.java
   */
  @Test
  public void testRemoveVertex() {
    assertEquals(true, graph.removeVertex("F"));
    assertEquals(false, graph.containsVertex("F"));
  }

  /**
   * Show different routes we can take from A -> wherever else with a set budget
   */
  @Test
  public void testBudgetPathsFromA() {
    assertEquals(graph.maxPriceAndDestinationsAvailable("A", 4).toString(), "[F, D, C]");
  }

//    String startingStation = "A";
//    int maxPrice = 4;
//    ArrayList<String> stringList = graph.maxPriceAndDestinationsAvailable(startingStation, maxPrice);
//    //System.out.println(stringList);
//    System.out.print("From station " + startingStation + ", you can go to stations: ");
//    for(int i = 0; i < stringList.size(); i++) {
//      System.out.print(stringList.get(i) + ", ");
//    }
//    System.out.println("with your budget of " + maxPrice + " dollars");
//    System.out.println("(destinations sorted by cheapest --> most expensive within your budget)");
//    assertEquals(stringList.toString(), "[F, D, C]");

}

