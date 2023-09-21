// --== CS400 Fall 2022 File Header Information ==--
// Name: wenpei shao
// Email: wshao33@wisc.edu
// Team: DE
// TA: April Roszkowski
// Lecturer: Florian Heimerl
// Notes to Grader: N/A

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * An interface to implement the search and filter functionality
 * for ISubwayBackend objects.
 */
public interface ISubwayBackend {

  /**
   * Removes a station by algo engineer
   */
  public void removeStation(String station);

  /**
   * Adds a station by algo engineer
   * @throws Exception 
   */
  public void addStation(Station endStation, List<Station> stations, List<Integer> weights) throws Exception;

  public Station searchGraph(String data);

  /**
   * Search for shortest path with specific criteria
   *
   * @param a - a node pass from FE
   * @return - A list of houses meeting ALL the criteria
   */
  public List<Station> findBestPath(Station a, int price);

  public List<Station> findShortestPath(Station a, Station b);

  /**
   * Loop through the list of houses brought in from the data wrangler
   * and add them to our RBTree
   * @param houseList - A list of houses read in from the data wrangler/xml file
   * @throws FileNotFoundException 
   */
  void loadData() throws FileNotFoundException;
}
