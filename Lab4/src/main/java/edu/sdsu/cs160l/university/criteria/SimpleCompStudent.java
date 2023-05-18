package edu.sdsu.cs160l.university.criteria;

import edu.sdsu.cs160l.university.course.Course;
import edu.sdsu.cs160l.university.student.Student;
import edu.sdsu.cs160l.university.student.StudentMajor;

//TODO Implement a advanced validity criteria with the specs below
// remove the false value returned and refer to SimpleCompScienceStudent for inspiration

/**
 * Advanced student strategy is a student strategy
 * A student has
 * at least 3 course and
 * at least 1 course with 2xx level and
 * at least 1 course with 3xx level and
 * student is from compsci or compengineering major
 */
public class SimpleCompStudent implements StudentStrategy {
    @Override
    public boolean isValid(Student student) {
        boolean satisfiesCourseCount = student.getCoursesEnrolled().size() >= 3;
        boolean satisfiesCourseLevel = false;
        boolean satisfiesMajor = student.getStudentMajor() == StudentMajor.computersci || student.getStudentMajor() == StudentMajor.computereng;
        for (Course course : student.getCoursesEnrolled()) {
            if (course.courseName().contains("2") && course.courseName().contains("3")) {
                satisfiesCourseLevel = true;
                break;
            }
        }
        return satisfiesCourseCount && satisfiesCourseLevel && satisfiesMajor;
    }
}
