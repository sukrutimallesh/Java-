package edu.sdsu.cs160l.assignment.institute;

import edu.sdsu.cs160l.assignment.institute.student.Student;
import edu.sdsu.cs160l.assignment.institute.student.StudentMajor;
import edu.sdsu.cs160l.exceptions.ClassFullException;
import edu.sdsu.cs160l.exceptions.NoSuchCourseException;
import edu.sdsu.cs160l.exceptions.StudentAlreadyEnrolledException;

import java.util.*;
import java.util.stream.Collectors;

/**
 * TODO implement 4 todos below (8 points)
 */
public class Registrar {
  private final Map<String, Course> courseList;
  private final List<String> validCourseList;

  public Registrar() {
    courseList = new HashMap<>();
    courseList.put("CS210", new Course("CS210", 3));
    courseList.put("CS310", new Course("CS310", 3));
    courseList.put("BO170", new Course("BO170", 1));
    courseList.put("BO240", new Course("BO240", 3));
    courseList.put("MT144", new Course("MT144", 2));
    courseList.put("MT251", new Course("MT251", 3));
    courseList.put("CS410", new Course("CS410", 3));
    courseList.put("CS160L", new Course("CS160L", 1));
    courseList.put("CE150", new Course("CE150", 3));
    validCourseList = Collections.unmodifiableList(new ArrayList<>(courseList.keySet()));
  }

  public List<String> availableCourseNames() {
    return validCourseList;
  }

  public void enrollStudent(String courseName, Student s) throws ClassFullException, NoSuchCourseException, StudentAlreadyEnrolledException {
    if (isNotValidCourse(courseName)) {
      throw new NoSuchCourseException("No course by the name " + courseName + " present, are you sure you have the right course?");
    }

    Course course = courseList.get(courseName);
    course.addStudent(s);

  }

  public List<Student> getStudentsEnrolled(StudentMajor major, String courseNameStartWith) {
    return courseList
       .entrySet() // Map.Entry<String, Course>
       .stream() // Stream<Map.Entry<String, Course>>
       .filter(entrySet -> entrySet.getKey().startsWith(courseNameStartWith)) // Stream<Map.Entry<String, Course>>
       .map(entrySet -> entrySet.getValue().getStudentsEnrolled())// Stream<List<Student>>
       .flatMap(students -> students.stream()) // Stream<Student> Flattens List<Student> to Student so [[1,2],[3,4]] -> [1,2,3,4]
       .filter(student -> student.getMajor() == major) // Stream<Student>
       .distinct() //  Stream<Student> returns unique stream of students
       .collect(Collectors.toList()); // List<Student>
  }

  public List<Student> getStudentsEnrolled() {
    return courseList
       .entrySet() // Map.Entry<String, Course>
       .stream() // Stream<Map.Entry<String, Course>>
       .map(entrySet -> entrySet.getValue().getStudentsEnrolled())// Stream<List<Student>>
       .flatMap(students -> students.stream()) // Stream<Student> Flattens List<Student> to Student so [[1,2],[3,4]] -> [1,2,3,4]
       .distinct() //  Stream<Student> returns unique stream of students
       .collect(Collectors.toList()); // List<Student>
  }

  /**
   * TODO implement the below function
   *
   * @return a list of students gpa for a given major and a given course (Note its just startsWith Match for course)
   * hint use above implementation as a template a see what you need to do to map a student to its gpa.
   */
  public List<Double> getStudentsGpa(StudentMajor major, String courseNameStartWith) {
    return courseList
            .entrySet()
            .stream() // Stream<Map.Entry<String, Course>>
            .filter(entry -> entry.getKey().startsWith(courseNameStartWith)) // filter out courses that do not start with the given string
            .flatMap(entry -> entry.getValue().getStudentsEnrolled().stream()) // Stream<Student> of students enrolled in filtered courses
            .filter(student -> student.getMajor().equals(major)) // filter out students who do not belong to the given major
            .map(Student::getGpa) // map each student to their GPA, student -> student.getGpa()
            .collect(Collectors.toList()); // collect the resulting Double values into a list
  }

  public Double getAverageGrade(StudentMajor major, String course) {
    return courseList
       .entrySet()
       .stream()
       .filter(entrySet -> entrySet.getKey().equals(course))
       .map(entrySet -> entrySet.getValue().getStudentsEnrolled())
       .flatMap(students -> students.stream())
       .mapToDouble(student -> student.getGpa())
       .average()
       .orElse(0.0);
  }

  /**
   * TODO implement the function below such that it returns a list of redId for N students that have highest score in that course.
   */
  public List<Long> topNStudentRedIdsWithHighestScoreInEachCourse(int n) {
    return courseList.values().stream()
            .flatMap(course -> course.getStudentsEnrolled().stream()
                    .sorted(Comparator.comparingDouble(Student::getGpa).reversed())
                    .limit(n)
                    .map(Student::getRedId))
            .collect(Collectors.toList());
  }

  /**
   * TODO implement the function below such that it returns an average of gpa for all student in all courses.
   */
  public Double averageCourseUnitsByAllStudentsAcrossAllCourse() {
    return courseList
            .values()
            .stream() // Stream<Course>
            .flatMap(course -> course.getStudentsEnrolled().stream()) // Stream<Student> of students enrolled in all courses
            .mapToDouble(Student::getGpa) // map each student to their GPA
            .average() // compute the average of GPAs
            .orElse(Double.NaN); // return NaN if there are no students enrolled
  }

  /**
   * TODO implement the function below such that it returns an average of gpa for all student in all courses that are not COMP SCI or COMP Eng.
   */
  public Double averageCourseUnitsByAllStudentsAcrossAllNonComputerCourse() {
    return courseList.values().stream() // Stream<Course>
            .filter(course -> !course.getCourseName().startsWith("COMP")) // Filter out courses that start with "COMP"
            .flatMap(course -> course.getStudentsEnrolled().stream()) // Stream<Student> of all students enrolled in non-computer courses
            .mapToDouble(Student::getGpa) // Map each student to their GPA
            .average() // Compute the average of all GPAs
            .orElse(Double.NaN); // Return NaN if there are no students enrolled in non-computer courses
  }

  private boolean isNotValidCourse(String courseName) {
    return !validCourseList.contains(courseName);
  }
}
