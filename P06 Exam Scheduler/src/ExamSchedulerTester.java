import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class ExamSchedulerTester {

	public static void main(String[] args) {

		System.out.println(testFindAllSchedules());
	}
	public static boolean alltest() {
		return testCourse() && testRoom() && testScheduleAccessors()
				&& testAssignCourse() && testFindAllSchedules()
				&& testFindSchedule();
	}

	public static boolean testCourse() {

		Course course = new Course("cs", 100);
		if (!course.getName().equals("cs"))
			return false;
		if (course.getNumStudents() != 100)
			return false;

		try {
			Course courses = new Course("cs", -10);
			return false;

		} catch (IllegalArgumentException e) {

		} catch (Exception e) {
			return false;
		}

		return true;

	}

	public static boolean testRoom() {

		Room room = new Room("Ingram hall", 100);
		if (!room.getLocation().equals("Ingram hall"))
			return false;
		if (room.getCapacity() != 100)
			return false;

		room.reduceCapacity(10);
		if (room.getCapacity() != 90)
			return false;

		try {
			Room rooms = new Room("Ingram hall", -1);
			return false;
		} catch (IllegalArgumentException e) {

		} catch (Exception e) {
			return false;
		}

		return true;

	}

	public static boolean testScheduleAccessors() {

		Room[] room = new Room[5];
		Course[] course = new Course[5];
		Schedule schedule = new Schedule(room, course);
		if (schedule.getNumRooms() != 5)
			return false;
		if (schedule.getRoom(1) != room[1])
			return false;

		try {
			schedule.getRoom(-1);
			return false;
		} catch (IndexOutOfBoundsException e) {

		} catch (Exception e) {
			return false;
		}

		if (schedule.getNumCourses() != 5)
			return false;
		if (schedule.getCourse(1) != course[1])
			return false;

		try {
			schedule.getCourse(-1);
			return false;
		} catch (IndexOutOfBoundsException e) {

		} catch (Exception e) {
			return false;
		}

		if (schedule.isAssigned(1) == true)
			return false;

		int[] assignment = new int[5];
		schedule.assignCourse(1, 3);

		if (schedule.getAssignment(1) != room[3])
			return false;

		if (schedule.isComplete() == true)
			return false;

		return true;

	}

	public static boolean testAssignCourse() {

		Room[] room = new Room[2];
		room[0] = new Room("Ingram hall", 100);
		room[1] = new Room("Basom hall", 110);
		Course[] course = new Course[2];
		course[0] = new Course("math", 100);
		Schedule sch = new Schedule(room, course);
		sch.assignCourse(0, 1);
		if (sch.getAssignment(0) != room[1])
			return false;
		return true;

	}

	public static boolean testFindAllSchedules() {
	 Room[] roomes = {new Room("R0", 75), new Room("L1", 100),
             new Room("R2", 15)};
     Course[] course = {new Course("C0", 15), new Course("C1", 80),
             new Course("C2", 70)};
     ArrayList <Schedule> allpossibleSch =ExamScheduler.findAllSchedules(roomes, course);
	 System.out.println(allpossibleSch);
		return false;
	}

	public static boolean testFindSchedule() {
		Room[] roomes = {new Room("R0", 75), new Room("L1", 100),
				new Room("R2", 15)};
		Course[] course = {new Course("C0", 15), new Course("C1", 90),
				new Course("C2", 70)};
		Schedule sch = ExamScheduler.findSchedule(roomes, course);
		System.out.println(sch);
		
		if (sch.getAssignment(0).getLocation().equals(roomes[2].getLocation())
				&& sch.getAssignment(1).getLocation().equals(roomes[1].getLocation())
				&& sch.getAssignment(2).getLocation().equals(roomes[0].getLocation())) {
			return true;
		}
		return false;
	}

}
