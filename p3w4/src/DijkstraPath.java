// --== CS400 Fall 2022 File Header Information ==--
// Name: Aidan Carrig
// Email: acarrig@wisc.edu
// Team: DE
// TA: April Roszkowski
// Lecturer: Florian Heimerl
// Notes to Grader: N/A

import java.nio.file.Path;
import java.util.*;

public class DijkstraPath<NodeType,EdgeType extends Number> implements GraphADT<NodeType,EdgeType> {

  /**
   * Vertex objects group a data field with an adjacency list of weighted
   * directed edges that lead away from them.
   */
  public class Vertex {
    public NodeType data; // vertex label or application specific data
    public LinkedList<Edge> edgesLeaving;

    public Vertex(NodeType data) {
      this.data = data;
      this.edgesLeaving = new LinkedList<>();
    }
  }

  /**
   * Edge objects are stored within their source vertex, and group together
   * their target destination vertex, along with an integer weight.
   */
  public class Edge {
    public Vertex target;
    public EdgeType weight;

    public Edge(Vertex target, EdgeType weight) {
      this.target = target;
      this.weight = weight;
    }
  }

  public Hashtable<NodeType, Vertex> vertices; // holds graph vertices, key=data
  public DijkstraPath() {
    vertices = new Hashtable<>();
  }

  public Hashtable<NodeType, Vertex> getMap() {
    return vertices;
  }

  /**
   * Get all paths from a start node to all other nodes
   * that are within the price range
   *
   * @param start data item within first node in path
   * @param maxPrice int value representing the max price someone will pay
   *                 to travel from start to end nodes
   * @return the shortest path from start to end, as computed by Dijkstra's algorithm
   * @throws NoSuchElementException when no path from start to end can be found,
   *     including when no vertex containing start or end can be found
   */
  public ArrayList<NodeType> maxPriceAndDestinationsAvailable(NodeType start, double maxPrice) {
    // Check if parameters are valid
    if(start == null) throw new NoSuchElementException("Start is null");
    if(!vertices.containsKey(start)) throw new NoSuchElementException("Key not found");

    // Create path to return & priorityQueue & Hashtable
    PriorityQueue<Path> priorityQueue = new PriorityQueue<>();
    Hashtable<NodeType, Path> hashtable = new Hashtable<>();

    // Add a path from and to the start vertex
    priorityQueue.add(new Path(vertices.get(start)));

    // Loop that will find paths to each node using priorityQueue
    while(!priorityQueue.isEmpty()) {

      // Pop off min element from priorityQueue and put it in our hashtable
      Path curPath = priorityQueue.poll();
      Vertex curVertex = curPath.end;
      hashtable.put(curVertex.data, curPath); // Add the data and path to it into hashtable

      // Loop through edgesLeaving from the end of the currentVertex
      for(Edge curEdge : curVertex.edgesLeaving) {

        // Check if hashtable already contains path to this vertex
        if(!hashtable.containsKey(curEdge.target.data)) { // If hashtable doesn't contain vertex/key

          Path newPath = new Path(curPath, curEdge); // create new path to possibly add to priorityQ
          boolean inQueue = false; // boolean to see if the path we're looking for is in priorityQ

          for(Path path: priorityQueue) { // Loop through priorityQueue to check for path
            if(path.end.data == curEdge.target.data) { // If it has the path
              if(newPath.compareTo(path) < 0) { // Compare distances, possibly update path
                priorityQueue.remove(path);
                priorityQueue.add(newPath);
              }
              inQueue = true;
            }
          } if(!inQueue) { // If we looped through queue and DID NOT FIND path, add it
            priorityQueue.add(newPath);
          }
        }
      }
    }

    ArrayList<NodeType> stringList = new ArrayList<>();
    Set<NodeType> keySet = hashtable.keySet();
    Iterator<NodeType> iterator = keySet.iterator();
    while(iterator.hasNext()) {
      NodeType node = iterator.next();
      Path path = dijkstrasShortestPath(start, node);
      if(path.distance <= maxPrice) {
        if(path.end.data != start)
          stringList.add(path.end.data);
      }
    }
    return stringList;
  }

  /**
   * Uses Dijkstra's shortest path algorithm to find and return the shortest path
   *    between two vertices in this graph: start and end.
   * This path contains an ordered list of the data within each node on this path,
   *    and also the distance or cost of all edges that are a part of this path.
   *
   * @param start data item within first node in path
   * @param end data item within last node in path
   * @return the shortest path from start to end, as computed by Dijkstra's algorithm
   * @throws NoSuchElementException when no path from start to end can be found,
   *     including when no vertex containing start or end can be found
   */
  protected Path dijkstrasShortestPath(NodeType start, NodeType end) {
    // Check if parameters are valid
    if(start == null || end == null) throw new NoSuchElementException("Start or end is null");
    if(!vertices.containsKey(start)) throw new NoSuchElementException("Key not found");

    // Create path to return & priorityQueue & Hashtable
    PriorityQueue<Path> priorityQueue = new PriorityQueue<>();
    Hashtable<NodeType, Path> hashtable = new Hashtable<>();
    
    try {
      // Add a path from and to the start vertex
      priorityQueue.add(new Path(vertices.get(start)));

      // Loop that will find paths to each node using priorityQueue
      while (!priorityQueue.isEmpty()) {

        // Pop off min element from priorityQueue and put it in our hashtable
        Path curPath = priorityQueue.poll();
        Vertex curVertex = curPath.end;
        hashtable.put(curVertex.data, curPath); // Add the data and path to it into hashtable

        // Loop through edgesLeaving from the end of the currentVertex
        for (Edge curEdge : curVertex.edgesLeaving) {

          // Check if hashtable already contains path to this vertex
          if (!hashtable.containsKey(curEdge.target.data)) { // If hashtable doesn't contain vertex/key

            Path newPath = new Path(curPath, curEdge); // create new path to possibly add to priorityQ
            boolean inQueue = false; // boolean to see if the path we're looking for is in priorityQ

            for (Path path : priorityQueue) { // Loop through priorityQueue to check for path
              if (path.end.data == curEdge.target.data) { // If it has the path
                if (newPath.compareTo(path) < 0) { // Compare distances, possibly update path
                  priorityQueue.remove(path);
                  priorityQueue.add(newPath);
                }
                inQueue = true;
              }
            }
            if (!inQueue) { // If we looped through queue and DID NOT FIND path, add it
              priorityQueue.add(newPath);
            }
          }
        }
      }
    } catch (Exception e) {
      System.out.println("Exception thrown from dijkstra shortest path");
    }

    // Grab the path that matches our end node from hashtable and return
    Path shortestPath = hashtable.get(end);
    if(shortestPath == null)
      throw new NoSuchElementException("shortest path is null");

    return shortestPath;
  }

  /**
   * Returns the shortest path between startingVertex and destinationVertex.
   * Uses Dijkstra's shortest path algorithm to find the shortest path.
   *
   * @param start the data item in the starting vertex for the path
   * @param end the data item in the destination vertex for the path
   * @return list of data item in vertices in order on the shortest path
   *         between vertex with data item startingVertex and vertex with
   *         data item destinationVertex, including both startingVertex and destinationVertex
   */
  public List<NodeType> shortestPath(NodeType start, NodeType end) {
    return dijkstrasShortestPath(start,end).dataSequence;
  }

  /**
   * Insert a new vertex into the graph.
   *
   * @param data the data item stored in the new vertex
   * @return true if the data can be inserted as a new vertex, false if it is already in the graph
   * @throws NullPointerException if data is null
   */
  public boolean insertVertex(NodeType data) {
    if(data == null)
      throw new NullPointerException("Cannot add null vertex");
    if(vertices.containsKey(data)) return false; // duplicate values are not allowed
    vertices.put(data, new Vertex(data));
    return true;
  }

  /**
   * Remove a vertex from the graph.
   * Also removes all edges adjacent to the vertex from the graph
   * (all edges that have the vertex as a source or a destination vertex).
   *
   * @param data the data item stored in the vertex to remove
   * @return true if a vertex with *data* has been removed, false if it was not in the graph
   * @throws NullPointerException if data is null
   */
  public boolean removeVertex(NodeType data) {
    if(data == null) throw new NullPointerException("Cannot remove null vertex");
    Vertex removeVertex = vertices.get(data);
    if(removeVertex == null) return false; // vertex not found within graph
    // search all vertices for edges targeting removeVertex
    for(Vertex v : vertices.values()) {
      Edge removeEdge = null;
      for(Edge e : v.edgesLeaving)
        if(e.target == removeVertex)
          removeEdge = e;
      // and remove any such edges that are found
      if(removeEdge != null) v.edgesLeaving.remove(removeEdge);
    }
    // finally remove the vertex and all edges contained within it
    return vertices.remove(data) != null;
  }

  /**
   * Insert a new directed edge with a positive edges weight into the graph.
   *
   * @param source the data item contained in the source vertex for the edge
   * @param target the data item contained in the target vertex for the edge
   * @param weight the weight for the edge (has to be a positive Number)
   * @return true if the edge could be inserted or its weight updated,
   *         false if the edge with the same weight was already in the graph with the graph
   * @throws IllegalArgumentException if either sourceVertex or targetVertex or both
   *                                  are not in the graph, or weight is < 0
   * @throws NullPointerException if either sourceVertex or targetVertex or both are null
   */
  public boolean insertEdge(NodeType source, NodeType target, EdgeType weight) {
    if(source == null || target == null)
      throw new NullPointerException("Cannot add edge with null source or target");
    Vertex sourceVertex = this.vertices.get(source);
    Vertex targetVertex = this.vertices.get(target);
    if(sourceVertex == null || targetVertex == null)
      throw new IllegalArgumentException("Cannot add edge with vertices that do not exist");
    if(weight.doubleValue() < 0)
      throw new IllegalArgumentException("Cannot add edge with negative weight");
    // handle cases where edge already exists between these verticies
    for(Edge e : sourceVertex.edgesLeaving)
      if(e.target == targetVertex) {
        if(e.weight.doubleValue() == weight.doubleValue()) return false; // edge already exists
        else e.weight = weight; // otherwise update weight of existing edge
        return true;
      }
    // otherwise add new edge to sourceVertex
    sourceVertex.edgesLeaving.add(new Edge(targetVertex,weight));
    return true;
  }

  /**
   * Remove an edge from the graph.
   *
   * @param source the data item contained in the source vertex for the edge
   * @param target the data item contained in the target vertex for the edge
   * @return true if the edge could be removed, false if it was not in the graph
   * @throws IllegalArgumentException if either sourceVertex or targetVertex or
   *                                  both are not in the graph
   * @throws NullPointerException if either sourceVertex or targetVertex or both are null
   */
  public boolean removeEdge(NodeType source, NodeType target) {
    if(source == null || target == null)
      throw new NullPointerException("Cannot remove edge with null source or target");
    Vertex sourceVertex = this.vertices.get(source);
    Vertex targetVertex = this.vertices.get(target);
    if(sourceVertex == null || targetVertex == null)
      throw new IllegalArgumentException("Cannot remove edge with vertices that do not exist");
    // find edge to remove
    Edge removeEdge = null;
    for(Edge e : sourceVertex.edgesLeaving)
      if(e.target == targetVertex)
        removeEdge = e;
    if(removeEdge != null) { // remove edge that is successfully found
      sourceVertex.edgesLeaving.remove(removeEdge);
      return true;
    }
    return false; // otherwise return false to indicate failure to find
  }

  /**
   * Check if the graph contains a vertex with data item *data*.
   *
   * @param data the data item to check for
   * @return true if data item is stored in a vertex of the graph, false otherwise
   * @throws NullPointerException if *data* is null
   */
  public boolean containsVertex(NodeType data) {
    if(data == null) throw new NullPointerException("Cannot contain null data vertex");
    return vertices.containsKey(data);
  }

  /**
   * Check if edge is in the graph.
   *
   * @param source the data item contained in the source vertex for the edge
   * @param target the data item contained in the target vertex for the edge
   * @return true if the edge is in the graph, false if it is not in the graph
   * @throws NullPointerException if either sourceVertex or targetVertex or both are null
   */
  public boolean containsEdge(NodeType source, NodeType target) {
    if(source == null || target == null)
      throw new NullPointerException("Cannot contain edge adjacent to null data");
    Vertex sourceVertex = vertices.get(source);
    Vertex targetVertex = vertices.get(target);
    if(sourceVertex == null) return false;
    for(Edge e : sourceVertex.edgesLeaving)
      if(e.target == targetVertex)
        return true;
    return false;
  }

  /**
   * Return the weight of an edge.
   *
   * @param source the data item contained in the source vertex for the edge
   * @param target the data item contained in the target vertex for the edge
   * @return the weight of the edge (0 or positive integer)
   * @throws IllegalArgumentException if either sourceVertex or targetVertex or
   *                                  both are not in the graph
   * @throws NullPointerException if either sourceVertex or targetVertex or both are null
   * @throws NoSuchElementException if edge is not in the graph
   */
  public EdgeType getWeight(NodeType source, NodeType target) {
    if(source == null || target == null)
      throw new NullPointerException("Cannot contain weighted edge adjacent to null data");
    Vertex sourceVertex = vertices.get(source);
    Vertex targetVertex = vertices.get(target);
    if(sourceVertex == null || targetVertex == null)
      throw new IllegalArgumentException("Cannot retrieve weight of edge between vertices that do not exist");
    for(Edge e : sourceVertex.edgesLeaving)
      if(e.target == targetVertex)
        return e.weight;
    throw new NoSuchElementException("No directed edge found between these vertices");
  }

  /**
   * Path objects store a discovered path of vertices and the overal distance of cost
   * of the weighted directed edges along this path. Path objects can be copied and extended
   * to include new edges and verticies using the extend constructor. In comparison to a
   * predecessor table which is sometimes used to implement Dijkstra's algorithm, this
   * eliminates the need for tracing paths backwards from the destination vertex to the
   * starting vertex at the end of the algorithm.
   */
  public class Path implements Comparable<Path> {
    public Vertex start; // first vertex within path
    public double distance; // summed weight of all edges in path
    public List<NodeType> dataSequence; // ordered sequence of data from vertices in path
    public Vertex end; // last vertex within path

    /**
     * Creates a new path containing a single vertex.  Since this vertex is both
     * the start and end of the path, it's initial distance is zero.
     * @param start is the first vertex on this path
     */
    public Path(Vertex start) {
      this.start = start;
      this.distance = 0.0D;
      this.dataSequence = new LinkedList<>();
      this.dataSequence.add(start.data);
      this.end = start;
    }

    /**
     * This extension constructor makes a copy of the path passed into it as an argument
     *    without affecting the original path object (copyPath).
     * The path is then extended by the Edge object extendBy.
     * Use the doubleValue() method of extendBy's weight field
     *    to get a double representation of the edge's weight.
     * @param copyPath is the path that is being copied
     * @param extendBy is the edge the copied path is extended by
     */
    public Path(Path copyPath, Edge extendBy) {
      this(copyPath.start);
      this.dataSequence = new LinkedList<>();
      for(int i = 0; i < copyPath.dataSequence.size(); i++) {
        this.dataSequence.add(copyPath.dataSequence.get(i));
      }
      this.dataSequence.add(extendBy.target.data);
      this.end = extendBy.target;

      double edgeWeight = extendBy.weight.doubleValue();
      this.distance = edgeWeight + copyPath.distance;
    }

    /**
     * Allows the natural ordering of paths to be increasing with path distance.
     * When path distance is equal, the string comparison of end vertex data is used to break ties.
     * @param other is the other path that is being compared to this one
     * @return -1 when this path has a smaller distance than the other,
     *         +1 when this path has a larger distance than the other,
     *         and the comparison of end vertex data in string form when these distances are tied
     */
    public int compareTo(Path other) {
      int cmp = Double.compare(this.distance, other.distance);
      if(cmp != 0) return cmp; // use path distance as the natural ordering
      // when path distances are equal, break ties by comparing the string
      // representation of data in the end vertex of each path
      return this.end.data.toString().compareTo(other.end.data.toString());
    }
  }

  /**
   * Returns the cost of the path (sum over edge weights) between
   *    startingVertex and destinationVertex.
   * Uses Dijkstra's shortest path algorithm to find the shortest path.
   *
   * @param start the data item in the starting vertex for the path
   * @param end the data item in the destination vertex for the path
   * @return the cost of the shortest path between vertex with data item
   *         startingVertex and vertex with data item destinationVertex,
   *         including both startingVertex and destinationVertex
   */
  public double getPathCost(NodeType start, NodeType end) {
    return dijkstrasShortestPath(start, end).distance;
  }

  /**
   * Check if the graph is empty (does not contain any vertices or edges).
   *
   * @return true if the graph does not contain any vertices or edges, false otherwise
   */
  public boolean isEmpty() {
    return vertices.size() == 0;
  }

  /**
   * Return the number of edges in the graph.
   *
   * @return the number of edges in the graph
   */
  public int getEdgeCount() {
    int edgeCount = 0;
    for(Vertex v : vertices.values())
      edgeCount += v.edgesLeaving.size();
    return edgeCount;
  }

  /**
   * Return the number of vertices in the graph
   *
   * @return the number of vertices in the graph
   */
  public int getVertexCount() {
    return vertices.size();
  }

}

