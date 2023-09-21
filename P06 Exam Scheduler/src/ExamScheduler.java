import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class ExamScheduler {


  public static Schedule findSchedule(Room[] room, Course[] course) {

    Schedule schedule = new Schedule(room, course);

    if (schedule == null)
      throw new IllegalStateException("no such element exist");
    schedule = findScheduleHelper(schedule, 0);

    return schedule;
  }


  /**
   * a private, recursive method that assigns all unassigned courses in a Schedule beginning from
   * the index provided as an argument: ○ If the provided index is equal to the number of courses,
   * check to see if the Schedule is complete. If so, return the schedule; otherwise throw an
   * IllegalStateException indicating that this Schedule is invalid. ○ If the provided index
   * corresponds to a course that has already been assigned to a room, recursively assign the
   * courses at the following indexes and return the resulting schedule. ○ If the provided index
   * corresponds to a course that has NOT already been assigned to a room, iteratively try to assign
   * it to each possible valid Room and recursively assign the courses at the following indexes. If
   * this course cannot be assigned to that room, try the next one; return the resulting schedule.
   * 
   * @param sch
   * @param number
   * @return
   */
  private static Schedule findScheduleHelper(Schedule sch, int number) {

    if (number == sch.getNumCourses()) {
      if (sch.isComplete()) {
        return sch;
      }
      throw new IllegalStateException("this Schedule is invalid");
    }
    if (sch.isAssigned(number)) {
      number++;
      return findScheduleHelper(sch, number);
    }
    int flag = -1;
    int capcity = -1;
    for (int i = 0; i < sch.getNumRooms(); i++) {
      int coursesLen = sch.getNumCourses();
      for (int j = 0; j < coursesLen; j++) {
        if (sch.isAssigned(j)) { // 如果课程已经分配了房间，则分配的房间是遍历的房间则跳出循环
          continue;
        } else {// 否则，看一下当前的房间是否满足待分配课程的需求
          int roomICap = sch.getRoom(i).getCapacity();
          int numStudents = sch.getCourse(number).getNumStudents();
          if (roomICap >= numStudents) {
            if (flag == -1 || capcity > roomICap) {// 如果满足分配需求，则用capcity记录该房间能容纳的人数，并且这个capcity是最小的
              flag = i;
              capcity = roomICap;
            }
          }
        }
      }
    }
    if (flag != -1) {
      return findScheduleHelper(sch.assignCourse(number, flag), ++number);
    }
    return findScheduleHelper(sch, ++number);

  }



  public static ArrayList findAllSchedules(Room[] room, Course[] course) {
    Schedule schedule = new Schedule(room, course);
    ArrayList<Schedule> allpossibleSch = findAllSchedulesHelper(schedule, 0);

    return allpossibleSch;


  }



  private static ArrayList findAllSchedulesHelper(Schedule sch, int number) {
    ArrayList<Schedule> allpossibleSch = new ArrayList<Schedule>();
    if (number == sch.getNumCourses()) {
      if (sch.isComplete()) {
        allpossibleSch.add(sch);
        for (int i = 0; i < allpossibleSch.size() - 1; i++) {
          for (int j = i + 1; j < allpossibleSch.size(); j++) {
            if (allpossibleSch.get(i).toString().equals((allpossibleSch.get(j).toString()))) {
              allpossibleSch.remove(j);
            }
          }
        }
        return allpossibleSch;
      } else {
        for (int i = 0; i < allpossibleSch.size() - 1; i++) {
          for (int j = i + 1; j < allpossibleSch.size(); j++) {
            if (allpossibleSch.get(i).toString().equals((allpossibleSch.get(j).toString()))) {
              allpossibleSch.remove(j);
            }
          }
        }
        return null;
      }
    }
    if (sch.isAssigned(number)) {
      number++;
      ArrayList<Schedule> temp = findAllSchedulesHelper(sch, number);
      for (int i = 0; i < temp.size() - 1; i++) {
        for (int j = i + 1; j < temp.size(); j++) {
          if (temp.get(i).toString().equals((temp.get(j).toString()))) {
            temp.remove(j);
          }
        }
      }
      return temp;
    }
    int flag = -1;
    int capcity = -1;
    for (int i = 0; i < sch.getNumRooms(); i++) {
      int coursesLen = sch.getNumCourses();
      for (int j = 0; j < coursesLen; j++) {
        if (sch.isAssigned(j)) { // 如果课程已经分配了房间，则分配的房间是遍历的房间则跳出循环
          continue;
        } else {// 否则，看一下当前的房间是否满足待分配课程的需求
          int roomICap = sch.getRoom(i).getCapacity();
          int numStudents = sch.getCourse(number).getNumStudents();
          if (roomICap >= numStudents) {
            if (flag == -1 || capcity > roomICap) {// 如果满足分配需求，则用capcity记录该房间能容纳的人数，并且这个capcity是最小的
              // flag = i;
              // capcity = roomICap;
              ArrayList<Schedule> temp =
                  findAllSchedulesHelper(sch.assignCourse(number, i), number + 1);
              if (temp != null) {
                allpossibleSch.addAll(temp);
                for (int x = 0; x < allpossibleSch.size() - 1; x++) {
                  for (int y = x + 1; y < allpossibleSch.size(); y++) {
                    if (allpossibleSch.get(x).toString()
                        .equals((allpossibleSch.get(y).toString()))) {
                      allpossibleSch.remove(y);
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    // if (flag != -1) {
    // return findAllSchedulesHelper(sch.assignCourse(number, flag), ++number);
    // }
    for (int i = 0; i < allpossibleSch.size() - 1; i++) {
      for (int j = i + 1; j < allpossibleSch.size(); j++) {
        if (allpossibleSch.get(i).toString().equals((allpossibleSch.get(j).toString()))) {
          allpossibleSch.remove(j);
        }
      }
    }
    return allpossibleSch;
  }
}
