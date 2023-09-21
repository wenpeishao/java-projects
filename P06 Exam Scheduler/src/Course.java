
public class Course {
  /**
   * the name of the course,e.g.“CS300”
   */
  private String name;
  /**
   * the number of students enrolled in the course,e.g.250
   */
  private int numStudents;

  /**
   * initializes the datafields to the values of the arguments.If the provided integer is negative
   * (<0), throws an IllegalArgumentException with a descriptive error message.
   * 
   * @param name        the name of the course,e.g.“CS300”
   * @param numStudents the number of students enrolled in the course,e.g.250
   */
  public Course(String name, int numStudents) {
    if(numStudents<0) {
      throw new IllegalArgumentException("the provided integer is negative (<0)");
    }
    this.name = name;
    this.numStudents = numStudents;
    
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @return the numStudents
   */
  public int getNumStudents() {
    return numStudents;
  }

}
