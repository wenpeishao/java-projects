


public class Traveler {
  private String name;
  private String email;

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }



  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }



  /**
   * @return the email
   */
  public String getEmail() {
    return email;
  }



  /**
   * @param email the email to set
   */
  public void setEmail(String email) {
    this.email = email;
  }



  /**
   * a constructor that expects two String arguments, containing the name and email respectively,
   * and sets the data fields of the object accordingly.
   * 
   * @param name  set the name of the traveler
   * @param email set the email of the traveker
   */
  public Traveler(String name, String email) {
    this.name = name;
    this.email = email;
  }



  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
