package edu.sdsu.cs160l.university.lab5.course;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import edu.sdsu.cs160l.university.lab5.course.Course;

//TODO make this singleton
public class CS340 implements Course {
    private static CS340 cs340;

    private CS340(){}

    public static CS340 getCs340() {
        if(cs340 == null){
            cs340 = new CS340();
        }
        return cs340;
    }

    @Override
    public String courseName() {
        return "CS340";
    }

    @Override
    public List<String> courseDescription() {
        return Arrays.asList("Data Structure and algorithms", "0 cost course");
    }

    @Override
    public Set<String> prerequisites() {
        return new HashSet<>(Arrays.asList("CS210", "CS330"));
    }
}
