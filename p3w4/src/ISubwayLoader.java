// --== CS400 Project Three File Header ==--
// Name: Spencer Ball / Ahmet Ahunbay
// CSL Username: sball / ahunbay
// Email: sjball@wisc.edu / aahunbay@wisc.edu
// Lecture #: 003
// Notes to Grader: none

import java.io.FileNotFoundException;
import java.util.List;

/**
 * Instances of this interface can be used to load graph data from a DOT formatted file
 * into a List of EdgeADT objects.
 */
public interface ISubwayLoader {
  /**
   * Loads the List of EdgeADTs from a DOT file.
   * @param pathToDotFile, the path to the DOT file relative to the executable
   * @return a list of EdgeADT objects representing the graph in the provided file
   * @throws FileNotFoundException if the file in pathToDotFile cannot be found
   */
  GraphADT loadStations(String pathToDotFile) throws FileNotFoundException;
}
