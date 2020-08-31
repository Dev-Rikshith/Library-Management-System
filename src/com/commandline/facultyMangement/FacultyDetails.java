package com.commandline.facultyMangement;
import com.commandline.bookmanagement.Book;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FacultyDetails {
    protected int id;
    protected String fullName;
    protected String branch;
    protected int checkIn;
    protected int checkOut;
    protected Book[] recommendedBooks;

    public FacultyDetails(int id, String fullName, String branch) {
        this.id = id;
        this.fullName = fullName;
        this.branch = branch;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getFullName() { return fullName; }

    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getBranch() { return branch; }

    public void setBranch(String branch) { this.branch = branch; }

    @Override
    public String toString() {
        return "FacultyDetails{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", branch='" + branch + '\'' +
                '}';
    }
    public int checkIn(int timeHours,int timeMinutes){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the time when Faculty checkedIn in hours : ");
        timeHours = scanner.nextInt();
        System.out.println("Enter the time when Faculty checkedIn in minutes :  ");
        timeMinutes = scanner.nextInt();
        timeHours *= 60;
        int time = timeHours + timeMinutes;
//            int lastDigit,reversedNumber=0;
//            while(timeHours!=0) {
//                lastDigit = timeHours % 10;
//                reversedNumber = (reversedNumber*10) + lastDigit;
//                timeHours = timeHours / 10;
        return time;
    }
    public int checkOut(int timeHours,int timeMinutes){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the time when Faculty checkedOut in hours : ");
        timeHours = scanner.nextInt();
        System.out.println("Enter the time when Faculty checkedOut in minutes :  ");
        timeMinutes = scanner.nextInt();
        timeHours *= 60;
        int time = timeHours + timeMinutes;
        return time;
    }
    public void facultyDetails(FacultyDetails facultyDetails){
       facultyDetails.toString();
       int book_pos = 0;
       System.out.println("The Faculty has the following outstanding Book Recommendations : ");
       for(Book recommendedBooks : recommendedBooks) {
           book_pos++;
           System.out.println(book_pos + "." + recommendedBooks);
       }
    }
}
