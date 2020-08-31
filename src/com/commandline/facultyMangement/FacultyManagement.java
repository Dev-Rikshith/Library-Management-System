package com.commandline.facultyMangement;

import com.commandline.bookmanagement.Book;
import com.commandline.bookmanagement.Book;

import java.util.ArrayList;
import java.util.Scanner;

public class FacultyManagement {

    private int totalTime = 0;
    private boolean yes;

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

        System.out.println("Sir/Madam you have an OutstandingDue of : Rs." + facultyDetails.getOutStandingDues() + " would you like to pay this amount?");
        System.out.println("Press Y for yes and N for no");
        String response = scanner.nextLine().toLowerCase();
        if (response == "y") {
            System.out.println("How much amount would you like to pay Sir/Madam");
            int facultyMoney = scanner.nextInt();
            if (facultyMoney < dues) {
                dues = facultyMoney - dues;
                System.out.println("Sir/Madam after paying your dues you are still left with a due of : Rs." + dues);
                scanner.close();
            } else if (facultyMoney == dues) {
                dues = 0;
                System.out.println("Sir/Madam thanks for clearing your total due");
            } else {
                facultyMoney = facultyMoney - dues;
                System.out.println("Sir/Madam thanks for clearing your total due,After paying you are left with a change of : Rs." + facultyMoney);
            }
        } else {
            System.out.println("Sir/Madam Thanks for visiting");
        }
    }
}


