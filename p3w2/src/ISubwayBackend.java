// --== CS400 Fall 2022 File Header Information ==--
// Name: wenpei shao
// Email: wshao33@wisc.edu
// Team: DE
// TA: April Roszkowski
// Lecturer: Florian Heimerl
// Notes to Grader: N/A

import java.util.List;

/**
 * An interface to implement the search and filter functionality
 * for ISubwayBackend objects.
 */
public interface ISubwayBackend {

  /**
   * Loop through the list of subwayList brought in from the data wrangler
   * and give it to Algorithm Engineer
   * @param subwayList - A list of subway read in from the data wrangler/xml file
   */
  public void loadData(List<Subway> subwayList);

  /**
   * Removes a station by algo engineer
   */
  public void removeStation(Station station);

  /**
   * Adds a station by algo engineer
   */
  public void addStation(Station station);

  /**
   * insert a edge
   */
  public void insertEdge (int distance, node a, node b);



  /**
   * Search for shortest path with specific criteria
   *
   * @param a - a node pass from FE
   * @param b - b node pass from FE
   * @return - A list of houses meeting ALL the criteria
   */
  public List<subwayList> findShortestPath(node a, node b);

}

