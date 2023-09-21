// --== CS400 Project Three File Header ==--
// Name: Ahmet Ahunbay
// CSL Username: ahunbay
// Email: aahunbay@wisc.edu
// Lecture #: 003
// Notes to Grader: received help from Spencer Ball (other DW) on sanitize method
import java.io.BufferedWriter;
import java.io.File;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.text.Normalizer;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

public class SubwayLoader implements ISubwayLoader{

		/**
	   * Loads the List of EdgeADTs from a DOT file.
	   * @param pathToDotFile, the path to the DOT file relative to the executable
	   * @return a list of EdgeADT objects representing the graph in the provided file
	   * @throws FileNotFoundException if the file in pathToDotFile cannot be found
	   */
	@Override
	public DijkstraPath loadStations(String pathToDotFile) throws FileNotFoundException {
		Scanner input = new Scanner(new File(pathToDotFile), "UTF-8");
		String currLine;
		DijkstraPath map = new DijkstraPath();
		
//		File fout = new File(pathToDotFile, "UTF-8");
//		BufferedWriter writer = new BufferedWriter(
//				new OutputStreamWriter(new FileOutputStream(fout)));	
				
		Hashtable<String, String> locationID = new Hashtable<String, String>();		
		while(input.hasNextLine()) {
			currLine = input.nextLine();
			//node case
			if(currLine.contains(" [label=")) {
			    
				String ID = currLine.substring(0, currLine.indexOf('[')).trim();
				  
				String location = sanitize(currLine.substring(currLine.indexOf('\\') + 2,
				currLine.indexOf('"', currLine.indexOf('\\') + 2)));				
				locationID.put(ID,location);					  
									
				map.insertVertex(location) ;

			}
			
			//edge case
			if(currLine.contains("edge [color=")) {			
				String ID2 = input.next();
				
				while (true) {
					 String ID1 = ID2;
					 if(!input.hasNext() || !input.next().equals("--")) {
						 break;
					 }
					 ID2 = input.next();				 
					 map.insertEdge(locationID.get(ID1), locationID.get(ID2),(double)( ID1.length() +ID2.length()));
					 map.insertEdge(locationID.get(ID2), locationID.get(ID1), (double)( ID1.length() +ID2.length()));
				}
			}				
		}
		return map;
	}
	
	/**
	   * Helper method to sanitize a string.
	   * @param str, the string to handle
	   * @return str with all whitespace, accents/diacritics, and special characters removed.
	   */
	  public String sanitize(String str) {
	    str = str.replaceAll("\\s", ""); //remove whitespace
	    str = str.replaceAll("Å", "o"); //special case, normalizer interprets ō as Å and thus converts to A instead of o
	    //normalize accents/diacritics:
	    str = Normalizer.normalize(str, Normalizer.Form.NFD);
	    str = str.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
	    //remove special characters
	    str = str.replaceAll("[^\\p{ASCII}]", "");
	    return str;
	  }
	
	
	
}
