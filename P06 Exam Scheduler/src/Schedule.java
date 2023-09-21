import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Schedule {
  private Room[] rooms; // Array of room objects available for exams
  private Course[] courses;// Array of course subjects that require an examination room
  private int[] assignments;// An array where the integers with index N are the indices of the rooms
                            // to which the course [N] has been assigned. Course[N] has been
                            // assigned to

  /**
   * Initialize the room and course arrays to the values provided and create an assignment array of
   * the correct length, where all values are -1, indicating that the corresponding course has not
   * yet been assigned to a room.
   * 
   * @param rooms
   * @param course
   */
  public Schedule(Room[] rooms, Course[] courses) {
    this.rooms = rooms;
    this.courses = courses;
    assignments = new int[courses.length];
    for (int i = 0; i < assignments.length; i++) {
      assignments[i] = -1;
    }
  }

  /**
   * Initialize the rooms and courses arrays to the values provided and the assignments array to the
   * assignments provided. It can be assumed that the length of the assignments array is correct
   * (equal to the length of the courses array).
   * 
   * @param rooms
   * @param course
   * @param assignment
   */
  private Schedule(Room[] rooms, Course[] courses, int[] assignment) {
    this.rooms = rooms;
    this.courses = courses;
    this.assignments = assignment;

  }
  
  public int getNumRooms() {
    return rooms.length;
  }

  public Room getRoom(int idx) {
    if (idx<0||idx>=rooms.length) {
      throw new IndexOutOfBoundsException("the given index is invalid");
    }
    return rooms[idx];
  }

  public int getNumCourses() {
    return courses.length;
  }

  public Course getCourse(int idx) {
    if (idx<0||idx>=courses.length) {
      throw new IndexOutOfBoundsException("the given index is invalid");
    }
    return courses[idx];
  }

  public boolean isAssigned(int idx) {
    if (assignments[idx] != -1) {
      return true;
    }
    return false;
  }

  public Room getAssignment(int idx) {
    if (idx < 0 || idx >= courses.length) {
      throw new IndexOutOfBoundsException("the given course index is invalid");
    }
    if (!(isAssigned(idx))) {
      throw new IllegalArgumentException("the course has not been assigned a room");
    }

    return rooms[assignments[idx]];
  }

  public boolean isComplete() {
    for (int i = 0; i < assignments.length; i++) {
      if (assignments[i] == -1) {
        return false;
      }
    }
    return true;
  }

  /**
   * returns a NEW Schedule object with the course at the first argument index assigned to the room
   * at the second argument index; throws an IndexOutOfBoundsException with a descriptive error
   * message if the given course or room index is invalid, or an IllegalArgumentException with a
   * descriptive error message if the given course has already been assigned a room, or if the room
   * does not have sufficient capacity.
   * 
   * @param idxCourse
   * @param idxRoom
   * @return
   */
  public Schedule assignCourse(int idxCourse, int idxRoom) {
    Room[] newRooms = Arrays.copyOf(rooms, rooms.length);
    Course[] newCourses = Arrays.copyOf(courses, courses.length);
    int[] newAssignments = Arrays.copyOf(assignments, assignments.length);
    if (idxCourse<0||idxCourse>=courses.length||idxRoom<0||idxRoom>=rooms.length) {
      throw new IndexOutOfBoundsException("the given index is invalid");
    }
    if (isAssigned(idxCourse)) {
      throw new IllegalArgumentException("the course has not been assigned a room");
    }
    try {
      newRooms[idxRoom] = newRooms[idxRoom].reduceCapacity(newCourses[idxCourse].getNumStudents());
    } catch (IllegalArgumentException e) {
      throw e;
    }
    
    newAssignments[idxCourse] = idxRoom;
    return new Schedule(newRooms, newCourses, newAssignments);
  }

  /**
   * override the toString() method to create a String representation, formatted as follows: {CS300:
   * AG 125, CS200: HUM 3650, CS400: Unassigned} where the courses were named ["CS300", "CS200",
   * "CS400"], and the rooms had locations ["SCI 180", "HUM 3650", "AG 125"]. Note that CS400 has
   * not yet been assigned a room, so the corresponding assignments array contains the values [2, 1,
   * -1] at this time.
   */
  public String toString() {
    String str = "{";
    for(int i=0; i<courses.length;i++) {
      str += courses[i].getName();
      str += ": ";
      if(assignments[i]==-1) {
        str += "Unassigned";
      }
      else {str += rooms[assignments[i]].getLocation();
      }
      str +=", ";
    }
    str = str.substring(0,str.length()-2);
    str += "}";
    return str;

  }
}
