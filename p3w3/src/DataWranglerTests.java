// --== CS400 Project Three File Header ==--
// Name: Ahmet Ahunbay
// CSL Username: ahunbay
// Email: aahunbay@wisc.edu
// Lecture #: 003
// Notes to Grader: none
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Hashtable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class DataWranglerTests {
  private DijkstraPath map;
  
  
  @BeforeEach
  public void load() {
    SubwayLoader loader = new SubwayLoader();
    try {
      map = loader.loadStations("tokyo-metro_with_eng.dot");
    } catch (FileNotFoundException e) {
      fail();
    }
  }
  
  /**
   * Tests to see if all locations have been added
   */
  @Test
  public void test1() {
    assertEquals(map.getVertexCount(),245);    
  }
  
  @Test
  public void test2() {
    assertEquals(map.getEdgeCount(),615);    
  }
  
  /**
   * checks if 3 specific nodes exist
   */
  @Test
  public void test3() {
    
    assertTrue(map.containsVertex("Yoyogi-Uehara"));
    assertTrue(map.containsVertex("Shibuya"));
    assertTrue(map.containsVertex("Meguro"));
    
  }
  
  /**
   * checks if specific path exists both ways
   */
  @Test
  public void test4() {
    assertTrue(map.containsEdge("Yoyogi-Uehara", "Yoyogi-Koen"));
    assertTrue(map.containsEdge("Yoyogi-Koen", "Yoyogi-Uehara"));

  }
  
  /**
   * Tests a path costs
   */
  @Test
  public void test5() {
    
    assertEquals((int)map.getPathCost("Yoyogi-Uehara", "Yoyogi-Koen"),(int)6);


  }

}
