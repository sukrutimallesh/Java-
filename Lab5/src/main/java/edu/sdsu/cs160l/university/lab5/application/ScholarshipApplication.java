package edu.sdsu.cs160l.university.lab5.application;

public class ScholarshipApplication implements UniversityApplication{
    @Override
    public void submitScore(Applicant applicant, float score) throws UnsupportedOperationException {
            if(score >= 3.2){
                applicant.setAdmitted(true);
            }
            else{
                throw new UnsupportedOperationException("Student is not eligible for scholarship as the score " + score + " is less than 3.2");
            }
    }

    @Override
    public void submitDocuments(Applicant applicant, String documents) {
        if(applicant.isAdmitted()) {
            applicant.setApplicantDocuments(documents);
        }else{
            throw new UnsupportedOperationException("Cannot submit documents until you are admitted");
        }
    }

    @Override
    public boolean checkStatus(Applicant applicant) {
        return applicant.isAdmitted() && applicant.getApplicantDocuments() != null;
    }
}
