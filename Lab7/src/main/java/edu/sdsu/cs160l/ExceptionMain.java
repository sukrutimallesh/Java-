package edu.sdsu.cs160l;

import edu.sdsu.cs160l.university.lab7.exceptions.ClassFullException;
import edu.sdsu.cs160l.university.lab7.exceptions.NoSuchCourseException;
import edu.sdsu.cs160l.university.lab7.exceptions.StudentAlreadyEnrolledException;
import edu.sdsu.cs160l.university.lab7.registrar.Registrar;
import edu.sdsu.cs160l.university.lab7.student.Student;
import edu.sdsu.cs160l.university.lab7.student.StudentType;

/**
 * Exceptions are of 2 types, Checked and Unchecked
 * They are a powerful way of knowing what if something goes wrong with our code.
 *
 * Fix 2 todos in your code
 * 1) in registrar class
 * 2) in course class
 */
public class ExceptionMain {
    public static void main(String[] args) {
        //write sample code here
        Student student = new Student() {
            @Override
            public StudentType studentType() {
                return null;
            }
        };

        // Get the registrar instance
        Registrar registrar = Registrar.getInstance();

        try {
            // Try to enroll the student in a course
            registrar.enrollStudentToClass(student, "CS150");
        } catch (NoSuchCourseException e) {
            // Handle the case where the course doesn't exist
            System.err.println(e.getMessage());
        } catch (ClassFullException e) {
            // Handle the case where the course is already full
            System.err.println(e.getMessage());
        } catch (StudentAlreadyEnrolledException e) {
            // Handle the case where the student is already enrolled in the course
            System.err.println(e.getMessage());
        }

    }
}
