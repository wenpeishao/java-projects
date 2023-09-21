///////////////////////// CUMULATIVE QUIZ FILE HEADER //////////////////////////
// Full Name:Wenpei Shao
// Campus ID:9083215211
// WiscEmail:wshao33@wisc.edu
////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////////
//
// This file contains ONE class. You will need to complete the implementation
// this class with respect to the provided requirements in the TODO tags for
// full credit.
//
// When creating new exception objects, including messages within these objects
// is optional.
////////////////////////////////////////////////////////////////////////////////

// MAKE SURE TO SAVE your source file before uploading it to gradescope.

import java.util.ArrayList;

/**
 * This class models a generator of the growth chart of the number of leaves of a specific plant in
 * a given number of weeks. Starting from an initial number of leaves, the plant multiplies its
 * number of leaves by a specific rate. For instance, a plant may double or triple its total number
 * of leaves weekly.
 *
 * NOTE: You may NOT add any additional data fields to this class. You may NOT add any additional
 * methods to this class
 */
public class PlantLeavesCountGenerator {

  // instance fields
  private String name; // name of the plant whose leaves count growth chart will be generated
  private final int INITIAL_LEAVES_COUNT; // the initial number of leaves of the plant at week ONE.
  private int growthRate; // weekly growth rate of the leaves count
  private ArrayList<Integer> chart; // list of total number of leaves of the plant starting from
                                    // week ONE.


  /**
   * Creates a new plant leaves count generator.
   * 
   * @param name         name of the specific plant
   * @param initialCount initial total number of leaves of the plant
   * @param growthRate   weekly growth rate of the number of leaves of the plant
   */
  public PlantLeavesCountGenerator(String name, int initialCount, int growthRate) {
    this.name = name;
    this.INITIAL_LEAVES_COUNT = initialCount;
    this.growthRate = growthRate;
    chart = new ArrayList<Integer>();
    // TODO initialize chart to an empty arraylist of Integers
    

  }

  /**
   * Returns the size of the generated chart
   * 
   * @return the size of the generated chart
   */
  public int size() {
    // TODO returns the size of the chart
    return chart.size(); // default return statement added to avoid compiler errors. Feel free to change it.
  }

// MAKE SURE TO SAVE your source file before uploading it to gradescope.

  /**
   * Generates the growth chart of a specific plant in the last weeksCount weeks.
   * 
   * @param weeksCount the number of days in the chart to generate
   * @throws IllegalStateException if weeksCount is less or equal to zero
   */
  public void generateLeavesCountChart(int weeksCount) {
    // TODO
    // 1. throw an IllegalStateException if weeksCount is less or equal to zero
    if(weeksCount<=0) {
      throw new IllegalStateException();
    }
    
    
    chart.clear(); // empty chart
    

    // 2. Make a call to generateGrowthChartHelper with the correct list of input arguments
    // to generate the growth chart of the number of leaves of the plant starting from its initial
    // leaves count. At week ONE, the plant has INITIAL_LEAVES_COUNT leaves, and this count will
    // increase by growthRate on each of the remaining weeks (until 0 weeks remain).
    generateGrowthChartHelper(INITIAL_LEAVES_COUNT,weeksCount);

  }

  /**
   * Recursive Helper method. Generates the sequence of the total number of leaves of the plant in
   * the last weeksCount starting from currentCount and adds these counts to this chart.
   * 
   * @param currentCount current number of leaves of the plant
   * @param weeksRemaining number of weeks left to add to the chart
   */
  public void generateGrowthChartHelper(int currentCount, int weeksRemaining) {
    // base case -- provided in the next commented line
     if (weeksRemaining == 0) return;
    

    
    // TODO implement recursive case
    // 1. define the recursive case
    // 2. add the current total number of leaves to the chart
    // 3. make a correct recursive call with the correct updates to BOTH arguments
     chart.add(currentCount);
     generateGrowthChartHelper(currentCount*growthRate,weeksRemaining-1);

   

  }


  /**
   * Returns a String representation of the contents of the chart (each element is separated by a
   * single space)
   * 
   * @return a String representation of the chart
   */
  @Override
  public String toString() {
    String s = "";
    // TODO
    // Traverse the chart list and add its content to s
    // (elements stored in the chart must be separated by a single space).
    for(int i=0;i<chart.size();i++) {
      s += chart.get(i);
      s += " ";
    }

    
    return s.trim();

  }

// MAKE SURE TO SAVE your source file before uploading it to gradescope.

  /**
   * Checks the correctness of the implementation of generateChart() method
   * 
   * @return true if no bug is detected by this tester method, false otherwise
   */
  public static boolean testGenerateLeavesCountChart() {
    try {
      // create a new plant leaves count generator
      PlantLeavesCountGenerator mintChart = new PlantLeavesCountGenerator("mint", 5, 3);

      // test base case
      mintChart.generateLeavesCountChart(1);
      String expectedChart = "5";

      if (mintChart.size() != 1)
        return false;
      if (mintChart.toString() == null || !mintChart.toString().trim().equals(expectedChart))
        return false;

      // test recursive case
      mintChart.generateLeavesCountChart(4);
      expectedChart = "5 15 45 135";
      if (mintChart.size() != 4)
        return false;
      if (mintChart.toString() == null || !mintChart.toString().trim().equals(expectedChart))
        return false;

    } catch (Exception e1) {
      e1.printStackTrace();
      return false;

    } catch (StackOverflowError e2) {
      System.out.println("StackOverflowError thrown!");
      return false;
    }
    return true;
  }

  /**
   * Implements a demo of this program
   */
  public static void demo() {
    PlantLeavesCountGenerator mintChart = new PlantLeavesCountGenerator("mint", 5, 3);
    mintChart.generateLeavesCountChart(1);
    System.out.print(
        "Number of leaves of " + mintChart.name + " in the first week: ");

    System.out.println(mintChart);
    mintChart.generateLeavesCountChart(5);
    System.out.print(
        "Number of leaves of " + mintChart.name + " in the last " + mintChart.size() + " weeks: ");
    System.out.println(mintChart);
    mintChart.generateLeavesCountChart(7);
    System.out.print(
        "Number of leaves of " + mintChart.name + " in the last " + mintChart.size() + " weeks: ");
    System.out.println(mintChart);
  }

  /**
   * Main method
   * 
   * @param args input arguments if any
   */
  public static void main(String[] args) {
    demo();
    System.out.println("testGeneratePlantGrowthChart(): " + testGenerateLeavesCountChart());

  }

// MAKE SURE TO SAVE your source file before uploading it to gradescope.

}
