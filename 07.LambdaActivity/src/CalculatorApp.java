// --== CS400 Fall 2022 File Header Information ==--
// Name: <Wenpei>
// Email: <wshao33@wisc.edu>
// Team: <DE>
// TA: <April Roszkowski>
// Lecturer: <Florian Heimerl >
// Notes to Grader: <optional extra notes>
import java.util.ArrayList;

interface MathOperation {
    public double compute(double a, double b);
}

public class CalculatorApp {

    public static MathOperation sub() {
        // TODO: Define a class named SubtractionOperation that implements
        // MathOperation (within this java source file) and defines its 
        // compute method to return the difference of its operands (first minus 
        // second). Then return a new instance of this class from this method 
        // (on the line below): 
      class SubtractionOperation implements MathOperation{
        public double compute (double first, double second) {
          return first - second;
        }
      }
      
        return new SubtractionOperation();
    }

    public static MathOperation add() {
        // TODO:  Return a new instance of an anonymous class that implements
        // MathOperation and defines its compute method to return the 
        // sum of its operands, from this method. 
      
        return new MathOperation() {
          public double compute(double first, double second) {
            return first + second;
          }
        };
    }

    public static MathOperation mul() {
        // TODO: Use a lambda expression on the line below to create and
        // return an object with a compute method that returns the product
        // of its operands.
        return (first, second)-> first*second;
    }

    /**
     * DO NOT MAKE ANY CHANGES TO THE MAIN METHOD BELOW FOR THIS ACTIVITY.
     * 
     * This main method uses the objects returned by the methods above to
     * display the sum, difference, and product of operands between 1 and 5.
     * @param args is not used by this program
     */
    public static void main(String[] args) {
        // add all math operations to this array
        ArrayList<MathOperation> ops = new ArrayList<>();
        ops.add( add() );
        ops.add( sub() );
        ops.add( mul() );

        // display table of math operations applied to operands
        System.out.println("Operands:  add  sub  mul");
        for(int b = 1; b < 6; b++) // second operand (b) goes from 1 to 5
            for(int a = b + 1; a < 6; a++) { // first operand goes from b+1 to 5
                System.out.print("     "+a+","+b+":"); // print out operands first
                for(MathOperation op: ops)
                    if(op != null) // then print out result of operation for those available
                        System.out.printf( "%5.1f", op.compute(a,b) );
                    else // and print out a dash otherwise
                        System.out.print("    -");
                System.out.println(); // ensure that the next operands are printed to the next line
            }
    }
}
