package edu.sdsu.cs160l.university.lab5.course;

import java.util.*;

import edu.sdsu.cs160l.university.lab5.course.Course;
//TODO make this singleton
public class CS160 implements Course{
    private static CS160 cs160;

    private CS160(){}

    public static CS160 getCs160() {
        if(cs160 == null){
            cs160 = new CS160();
        }
        return cs160;
    }

    @Override
    public String courseName() {
        return "CS160";
    }

    @Override
    public List<String> courseDescription() {
        return Arrays.asList("Intermediary Java Programming");
    }

    @Override
    public Set<String> prerequisites() {
        return new HashSet<>(Collections.singletonList("CS150"));
    }
}
