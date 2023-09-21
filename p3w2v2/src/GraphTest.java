// --== CS400 Fall 2022 File Header Information ==--
// Name: <Wenpei>
// Email: <wshao33@wisc.edu>
// Team: <DE>
// TA: <April Roszkowski>
// Lecturer: <Florian Heimerl >
// Notes to Grader: <optional extra notes>
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Tests the implementation of CS400Graph for the individual component of
 * Project Three: the implementation of Dijsktra's Shortest Path algorithm.
 */
public class GraphTest {

    private CS400Graph<String,Integer> graph;
    
    /**
     * Instantiate graph.
     */
    @BeforeEach
    public void createGraph() {
        graph = new CS400Graph<>();
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
     * Checks the distance/total weight cost from the vertex A to F.
     */
    @Test
    public void testPathCostAtoF() {
        assertTrue(graph.getPathCost("A", "F") == 3);
    }

    /**
     * Checks the distance/total weight cost from the vertex A to D.
     */
    @Test
    public void testPathCostAtoD() {
        assertTrue(graph.getPathCost("A", "D") == 4);
    }
    /**
     * Checks the distance/total weight cost from the vertex A to E.
     */
    @Test
    public void testPathCostAtoE() {
        assertTrue(graph.getPathCost("A", "E") == 6.0);
    }
    /**
     * Checks the ordered sequence of data within vertices from the vertex 
     * A to D.
     */
    @Test
    public void testPathAtoD() {
        assertTrue(graph.shortestPath("A", "D").toString().equals(
            "[A, C, F, D]"
        ));
    }

    /**
     * Checks the ordered sequence of data within vertices from the vertex 
     * A to F.
     */
    @Test
    public void testPathAtoF() {
        assertTrue(graph.shortestPath("A", "F").toString().equals(
            "[A, C, F]"
        ));
    }
    /**
     * Checks the ordered sequence of data within vertices from the vertex 
     * B to F.
     */
    @Test
    public void testPathBtoF() {

        assertTrue(graph.shortestPath("B", "F").toString().equals(
            "[B, C, F]"
        ));
    }
    /**
     * Checks the ordered sequence of data within vertices from the vertex 
     * A to .
     */
    @Test
    public void testPathAtoG() {
     graph.insertVertex("G");
     graph.insertEdge("G", "E", 2);
  try {
        String a = graph.shortestPath("A", "G").toString();
        fail("Expected NoSuchElementException to be thrown");
  }catch(NoSuchElementException e) {
   assertTrue(e.getMessage().equals("no path from start to end can be found,including when no vertex containing start or end can be found"));
  }

  
    }

}
