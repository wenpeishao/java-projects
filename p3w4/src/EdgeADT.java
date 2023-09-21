// --== CS400 Project Three File Header ==--
// Name: Spencer Ball / Ahmet Ahunbay
// CSL Username: sball / ahunbay
// Email: sjball@wisc.edu / aahunbay@wisc.edu
// Lecture #: 003
// Notes to Grader: none

/**
 * Abstract class for an Edge object.
 * Edges can be the edgeType of a GraphADT instance with nodeType Station.
 * Edge implementations must extend the Number abstract class.
 *
 */
abstract class EdgeADT extends Number{
  
  private StationADT startStation;
  private StationADT endStation;
  private double weight;
  private double price;
  
  public EdgeADT(Station start, Station end, double weight) {
    startStation = start;
    endStation = end;
    this.weight = weight;
    this.price = weight;
  }
  
  /**
   * @return the station at the beginning of this edge; the source.
   */
  public StationADT getStartStation() {
    return startStation;
  }
  
  /**
   * @return the station at the end of this edge; the destination the source leads to.
   */
  public StationADT getEndStation() {
    return endStation;
  }
  
  @Override
  /**
   * @return the speed of the trip from the source to the destination; this is a weight for the edge.
   */
  public double doubleValue() {
    return weight;
  }
  
  /**
   * @return the price of the trip from the source to the destination; this is an alternative weight for the edge.
   */
  public double price() {
    return price;
  }

}
