package com.commandline.studentmangement;

import com.commandline.bookmanagement.Book;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class StudentDetails {

    protected int id;
    protected String fullName;
    protected String branch;
    protected Book[] requestedBooks;
    protected Book[] issuedBooks;

    public StudentDetails(int id, String fullName, String branch) {
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

    @Override
    public String toString() {
        return "StudentDetails{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", branch='" + branch + '\'' +
                '}';
    }

    public void getDetails(StudentDetails studentDetails) {
        studentDetails.toString();
        int pos = 0;
        System.out.println("The student has the following outstanding requests :");
        for (Book book : requestedBooks) {
            pos++;
            System.out.println(pos + " . " + book);
        }
        pos = 0;
        System.out.println("The student has the following outstanding issues :");
        for (Book book : issuedBooks) {
            pos++;
            System.out.println(pos + " . " + book);
        }
    }

    public void getReport(StudentDetails studentDetails) throws IOException {
        String reportToGet = studentDetails.getFullName();
        FileWriter fileWriter = new FileWriter(reportToGet);
        fileWriter.write(studentDetails.toString());
        int pos = 0;
        fileWriter.write("The student has the following outstanding requests :");
        for (Book book : requestedBooks) {
            pos++;
            fileWriter.write(pos + " . " + book);
        }
        pos = 0;
        fileWriter.write("The student has the following outstanding issues :");
        for (Book book : issuedBooks) {
            pos++;
            fileWriter.write(pos + " . " + book);
        }
        fileWriter.close();
    }
}
