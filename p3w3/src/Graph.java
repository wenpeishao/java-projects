import java.util.Hashtable;
import java.util.List;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.NoSuchElementException;
public class Graph<NodeType,EdgeType extends Number> implements GraphADT<NodeType, EdgeType> {

  @Override
  public void setStartVertex(NodeType data) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public boolean insertVertex(NodeType data) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean removeVertex(NodeType data) {
    // TODO Auto-generated method stub
    return true;
  }

  @Override
  public boolean insertEdge(NodeType source, NodeType target, EdgeType weight) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean removeEdge(NodeType source, NodeType target) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean containsVertex(NodeType data) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean containsEdge(NodeType source, NodeType target) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public EdgeType getWeight(NodeType source, NodeType target) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<NodeType> shortestPath(NodeType start, NodeType end) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public double getPathCost(NodeType start, NodeType end) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public boolean isEmpty() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public int getEdgeCount() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int getVertexCount() {
    // TODO Auto-generated method stub
    return 0;
  }
  
  @Override
  /**
   * This method will take in a maxprice and also a starting node and end node that will give all
   * possible paths to that location that is less then that price
   *
   * @param start the starting node
   * @param maxPrice the max price
   * @param end the ending node
   * @return a list of paths that work and are within the maxprice range
   */
  public List<NodeType> maxPriceAndDestinationsAvailable(Object start, Object end, int maxPrice) {
      return null;
  }
  
}
