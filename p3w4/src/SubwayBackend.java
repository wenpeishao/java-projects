// --== CS400 Fall 2022 File Header Information ==--
// Name: Wenpei Shao
// Email: Wshao33@wisc.edu
// Team: DE
// TA: April Roszkowski
// Lecturer: Florian Heimerl
// Notes to Grader: Will update to fit the AG after the intergation

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
/**
 * An implement the search and filter functionality
 * for ISubwayBackend objects.
 */
public class SubwayBackend implements ISubwayBackend {
  
  private DijkstraPath<Station, Integer> SubwaySystem;
  
  public SubwayBackend() {
    SubwaySystem = new DijkstraPath<Station, Integer>();
    
  }
  
  /**
   * Loop through the list of houses brought in from the data wrangler
   * and add them to our RBTree
   * @param houseList - A list of houses read in from the data wrangler/xml file
   * @throws FileNotFoundException 
   */
  @Override
  public void loadData() throws FileNotFoundException {
    SubwayLoader loader = new SubwayLoader();
    SubwaySystem = loader.loadStations("tokyo-metro_with_eng.dot");
    
  }

  /**
   * Removes a station by algo engineer
   */
  @Override
  public void removeStation(String station) {

    
    SubwaySystem.removeVertex(searchGraph(station));
    
    
  }
  /**
   * Adds a station by algo engineer
   * @throws Exception 
   */
  @Override
  public void addStation(Station endStation, List<Station> stations, List<Integer> weights) throws Exception {
    // TODO Auto-generated method stub
    SubwaySystem.insertVertex(endStation);
    for (int i = 0; i < stations.size(); i++) {
      if(stations.get(i).equals(endStation)) {
          throw new Exception();
      }
      SubwaySystem.insertEdge(endStation, stations.get(i), weights.get(i));
    }
  }

  
  @Override
  public Station searchGraph(String data) {
    Station rm = new Station(data);
    return rm;
  }

  public List<Station> findBestPath(Station a, int price) {
    List<Station> BP;
    BP = SubwaySystem.maxPriceAndDestinationsAvailable(a, price);
    return BP;
  }
  /**
   * Search for shortest path with specific criteria
   *
   * @param a - a node pass from FE
   * @param b - b node pass from FE
   * @return - A list of houses meeting ALL the criteria
   */
  @Override
  public List<Station> findShortestPath(Station a, Station b) {
    // TODO Auto-generated method stub
    
    List<Station> ShortestPath = SubwaySystem.shortestPath(a,b);
    return ShortestPath;
    
  }


}
