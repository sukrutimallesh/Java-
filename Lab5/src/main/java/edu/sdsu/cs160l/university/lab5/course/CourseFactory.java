package edu.sdsu.cs160l.university.lab5.course;

import edu.sdsu.cs160l.university.lab5.student.StudentLevel;

public class CourseFactory {
    /**
     * A factory method is typically static and hides creation complexity form end user
     */
    public static Course getCourse(String courseName){
        switch (courseName){
            case "CS150":
                return CS150.getCs150();
            case "CS160":
                return CS160.getCs160();
            case "CS210":
                return CS210.getCs210();
            case "CS340":
                return CS340.getCs340();
            default:
                throw new UnsupportedOperationException("No course of the name "+ courseName +" found.");
        }
    }

    public static Course getRecommendedCourseByLevel(StudentLevel level){
        switch (level){
            case FRESHMAN:
                return CS150.getCs150();
            case SOPHOMORE:
                return CS160.getCs160();
            case JUNIOR:
                return CS210.getCs210();
            case SENIOR:
                return CS340.getCs340();
            default:
                throw new UnsupportedOperationException("No course recommendation for level "+ level +" found.");
        }
    }
}
