package com.commandline.facultyMangement;

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
