package com.commandline.facultyMangement;

import com.commandline.bookmanagement.Book;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FacultyDetails {
    protected int id;
    protected String fullName;
    protected String branch;
    protected int checkIn;
    protected int checkOut;
    protected ArrayList<Book> recommendedBooks;
    private int outStandingDues;

    public FacultyDetails(int id, String fullName, String branch) {
        this.id = id;
        this.fullName = fullName;
        this.branch = branch;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public int getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(int checkIn) {
        this.checkIn = checkIn;
    }

    public int getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(int checkOut) {
        this.checkOut = checkOut;
    }

    public int getOutStandingDues() {
        return outStandingDues;
    }

    public void setOutStandingDues(int outStandingDues) {
        this.outStandingDues = outStandingDues;
    }

    @Override
    public String toString() {
        return "FacultyDetails{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", branch='" + branch + '\'' +
                '}';
    }

    public void facultyDetails(FacultyDetails facultyDetails) {
        facultyDetails.toString();
        int book_pos = 0;
        System.out.println("The Faculty has the following outstanding Book Recommendations : ");
        for (Book book : recommendedBooks) {
            book_pos++;
            System.out.println(book_pos + "." + book);
        }
        book_pos = 0;
    }
}
