package edu.sdsu.cs160l.university.lab5.course;

import java.util.*;

public class CS150 implements Course{
    private static CS150 cs150;

    private CS150(){}

    public static CS150 getCs150(){
        //TODO implement a single
        if(cs150 == null){
            cs150 = new CS150();
        }
        return cs150;
    }
    @Override
    public String courseName() {
        return "CS150";
    }

    @Override
    public List<String> courseDescription() {
        return Arrays.asList("Java Programming", "ZyBooks");
    }

    @Override
    public Set<String> prerequisites() {
        return new HashSet<>();
    }
}
