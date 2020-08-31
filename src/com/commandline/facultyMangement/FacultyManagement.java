package com.commandline.facultyMangement;

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
        int totalPenalty = computePenalty(facultyDetails);
        int dues = facultyDetails.getOutStandingDues();
        dues = dues + totalPenalty;
        facultyDetails.setOutStandingDues(dues);
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
}


