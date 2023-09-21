import java.util.NoSuchElementException;

/**
 * Test methods to verify your implementation of the methods for P08.
 */
public class DNATester {
  
  /**
   * Tests the testEnqueueDequeue() method
   * @return true if and only if the method works correctly
   */
    public static boolean testEnqueueDequeue(){
      try {
    LinkedQueue<String> testSample = new LinkedQueue<String>();
    testSample.enqueue("00");
    testSample.enqueue("01");
    testSample.enqueue("02");
    testSample.enqueue("03");
    testSample.dequeue();
    //System.out.print(testSample.toString());
    if(testSample.toString().replaceAll(" ", "").equals("010203")) {
      
    }else
      return false;
    testSample.dequeue();
    testSample.dequeue();
    testSample.dequeue();
    if(!testSample.isEmpty()) {
      return false;
    }

    try {
      testSample.dequeue();

    }catch(NoSuchElementException e) {
      
    }catch(Exception e) {
      return false;
    }
      }catch(Exception e) {
        return false;
      }

    
    return true;
  }
  
  
  /**
   * Tests the transcribeDNA() method
   * @return true if and only if the method works correctly
   */
  public static boolean testTranscribeDNA() {
    DNA testDNA = new DNA("GGAGTCAGTTAAGCGACCGGGACATACTGTCTTGGTAATCTCCGAGCTAGAAAGTCTCTG");
    String mRNA = "CCUCAGUCAAUUCGCUGGCCCUGUAUGACAGAACCAUUAGAGGCUCGAUCUUUCAGAGAC";
    System.out.println(testDNA.transcribeDNA().toString());
    if (testDNA.transcribeDNA().toString().replaceAll(" ", "").equals(mRNA)) {
      return true;
    }
    return false;
  }
  
  /**
   * Tests the translateDNA() method
   * @return true if and only if the method works correctly
   */
  public static boolean testTranslateDNA() {
    DNA testDNA = new DNA("GGAGTCAGTTAAGCGACCGGGACATACTGTCTTGGTAATCTCCGAGCTAGAAAGTCTCTG");
    System.out.println(testDNA.translateDNA().toString());
    if (testDNA.translateDNA().toString().replaceAll(" ", "").equals("PQSIRWPCMTEPLEARSFRD")) {
      return true;
    }
    return false;
  }
  
  /**
   * Tests the testMRNATranslate() method
   * @return true if and only if the method works correctly
   */
  public static boolean testMRNATranslate() {
    try {
    DNA testDNA = new DNA("GGA");
    System.out.println(testDNA.mRNATranslate​(testDNA.transcribeDNA()).toString());
    if (!testDNA.mRNATranslate​(testDNA.transcribeDNA()).toString().replaceAll(" ", "").equals("P")) {
      return false;
    }
     testDNA = new DNA("GATTACA");
    System.out.println(testDNA.mRNATranslate​(testDNA.transcribeDNA()).toString());
    if (!testDNA.mRNATranslate​(testDNA.transcribeDNA()).toString().replaceAll(" ", "").equals("LM")) {
      return false;
    }
     testDNA = new DNA("CCGGCCCTCCGGTGGATCCAA");
    System.out.println(testDNA.mRNATranslate​(testDNA.transcribeDNA()).toString());
    if (!testDNA.mRNATranslate​(testDNA.transcribeDNA()).toString().replaceAll(" ", "").equals("GREAT")) {
      return false;
    }
    }catch(Exception e) {
      return false;
    }
    return true;
    
  }
/**
 * test the queue’s size and is Empty methods
 * @return true if and only if the method works correctly
 */
  public static boolean testQueueSize() {
    try {

    LinkedQueue<String> testSample = new LinkedQueue<String>();
    if(testSample.size()!=0) {
      return false;
    }
    testSample.enqueue("00");
    if(testSample.size()!=1) {
      return false;
    }
    testSample.enqueue("01");
    testSample.enqueue("02");
    testSample.enqueue("03");
    testSample.dequeue();
    if(testSample.size()!=3) {
      return false;
    }
    }catch(Exception e) {
      return false;
    }
    
    return true;
    
  }
  /**
   * Main method - use this to run your test methods and output the results (ungraded)
   * @param args unused
   */
  public static void main(String[] args) {
    System.out.println("testEnqueueDequeue: "+testEnqueueDequeue());
    System.out.println("testMRNATranslate: "+testMRNATranslate());
    System.out.println("testTranscribeDNA: "+testTranscribeDNA());
    System.out.println("testTranslateDNA: "+testTranslateDNA());
    System.out.println("testQueueSize: "+ testQueueSize());
  }

}
