// --== CS400 Project Three File Header ==--
// Name: Ahmet Ahunbay
// CSL Username: ahunbay
// Email: aahunbay@wisc.edu
// Lecture #: 003
// Notes to Grader: none
import java.util.ArrayList;

public class Station implements StationADT{
  
  private String location;
  private ArrayList<EdgeADT> edgesLeaving = new ArrayList<>();
  
  public Station(String location) {
    this.location =location;
  }
  
  public void addEdge(Station location, double weight) {
    edgesLeaving.add(new Edge(this, location, weight));
  }
  
  public ArrayList<EdgeADT> getEdges(){
    return edgesLeaving;
  }
  
  public int numEdges() {
	  return edgesLeaving.size();
  }

  @Override
  public String getLocation() {
    return location;
  }
}
