package edu.sdsu.cs160l;

import edu.sdsu.cs160l.university.lab5.application.Applicant;
import edu.sdsu.cs160l.university.lab5.application.ScholarshipApplication;
import edu.sdsu.cs160l.university.lab5.course.CS150;
import edu.sdsu.cs160l.university.lab5.course.CS160;
import edu.sdsu.cs160l.university.lab5.course.CS210;
import edu.sdsu.cs160l.university.lab5.course.CS340;
import edu.sdsu.cs160l.university.lab5.registrar.Registrar;

/**
 * TODO
 *  1) create your own template for admission with the following specs
 *     a) Create a class ScholarshipApplication in the application package.
 *     b) That class should implement UniversityApplication Interface
 *     c) submitScore should accept Applicant with score of 3.2 and above if not throw and Exception
 *     d) submitDocuments must set documents String to applicants document variable
 *     e) checkStatus must return true if applicants score is 3.2 and above and has non null document string
 *     f) uncomment line 14 on ScholarshipApplicationTest class and run tests
 *  2) make cs150, cs160, cs210 and cs340 courses a singleton class (Refer Registrar for inspiration)
 *     a) Note your code change has a cascading change in you CourseFactory class (hint you can't do a "new" Anymore, use getInstance instead)
 *
 * Remember design principle 1.
 * Program to and interface and not an Implementation.
 * <p>
 * Design principle 2
 * Prefer a has a relationship over is a relationship.
 */
public class DesignPatternsMain {
    public static void main(String[] args) {
        //write sample code here
        CS150 cs150 = CS150.getCs150();
        CS160 cs160 = CS160.getCs160();
        CS210 cs210 = CS210.getCs210();
    	CS340 cs340 = CS340.getCs340();
    	Registrar reg = Registrar.getInstance();

        ScholarshipApplication application = new ScholarshipApplication();

        Applicant applicant = new Applicant(828540265L, "Sukruti Mallesh");

        try {
            application.submitScore(applicant,3.0f);
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
            return;
        }

        application.submitDocuments(applicant, "Transcript");

        boolean admitted = application.checkStatus(applicant);
        System.out.println("Admitted: " + admitted);
    }
}
