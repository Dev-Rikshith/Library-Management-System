package com.commandline.facultyMangement;

import com.commandline.bookmanagement.Book;
import com.commandline.bookmanagement.Book;

import java.util.ArrayList;
import java.util.Scanner;

public class FacultyManagement {

    private int totalTime = 0;

    public void checkIn(FacultyDetails facultyDetails) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the time when Faculty checkedIn in hours : ");
        int timeHours = scanner.nextInt();
        System.out.println("Enter the time when Faculty checkedIn in minutes :  ");
        int timeMinutes = scanner.nextInt();
        timeHours *= 60;
        int time = timeHours + timeMinutes;
        facultyDetails.setCheckIn(time);
        scanner.close();
    }

    public void checkOut(FacultyDetails facultyDetails) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the time when Faculty checkedOut in hours : ");
        int timeHours = scanner.nextInt();
        System.out.println("Enter the time when Faculty checkedOut in minutes :  ");
        int timeMinutes = scanner.nextInt();
        timeHours *= 60;
        int time = timeHours + timeMinutes;
        facultyDetails.setCheckOut(time);
        scanner.close();
        completeCheckout(facultyDetails);
    }

    public int computeTotalTime(int startTime, int endTime) {
        return (endTime - startTime);
    }

    public int computePenalty(FacultyDetails facultyDetails) {
        totalTime = computeTotalTime(facultyDetails.getCheckIn(), facultyDetails.getCheckOut());
        if (totalTime <= 30) {
            facultyDetails.setCheckIn(0);
            facultyDetails.setCheckOut(0);
            return 0;
        } else {
            int lateTime = totalTime - 30;
            int penalty = lateTime * 1;
            return penalty;
        }
    }

    public void completeCheckout(FacultyDetails facultyDetails) {
        Scanner scanner = new Scanner(System.in);
        int totalPenalty = computePenalty(facultyDetails);
        int dues = facultyDetails.getOutStandingDues();
        dues = dues + totalPenalty;
        facultyDetails.setOutStandingDues(dues);
        System.out.println("Sir/Madam do you want to recommend any books to the students");
        facultyDetails.recommendedBooks.add(new Book(scanner.nextInt(), scanner.nextLine(), scanner.nextLine(), scanner.nextLine(), scanner.nextInt()));
        scanner.close();
    }
}


