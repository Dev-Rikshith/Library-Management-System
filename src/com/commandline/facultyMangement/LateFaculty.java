package com.commandline.facultyMangement;
/**
 * @author Sohan Kotha
 * This class basically is wrapper class to access the in and out time of faculty.
 */

public class LateFaculty {

    private int penalty;
    private FacultyDetails faculty;

    public LateFaculty(int penalty, FacultyDetails faculty) {
        this.penalty = penalty;
        this.faculty = faculty;
    }

    public int getPenalty() {
        return penalty;
    }

    public void setPenalty(int penalty) {
        this.penalty = penalty;
    }

    public FacultyDetails getFaculty() {
        return faculty;
    }

    public void setFaculty(FacultyDetails faculty) {
        this.faculty = faculty;
    }
}
