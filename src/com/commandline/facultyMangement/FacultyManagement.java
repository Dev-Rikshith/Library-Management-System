package com.commandline.facultyMangement;

import com.commandline.bookmanagement.Book;
import com.commandline.bookmanagement.Book;
import com.commandline.studentmangement.StudentDetails;

import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.Scanner;

public class FacultyManagement {

    private int totalTime = 0;
    private FacultyDetails[] totalFaculty = new FacultyDetails[25];
    private int numberOfFacultyToAdd = 0;
    private int totalFacultyPresent = 0;

    public void addFaculty() {
        Scanner scannerForInts = new Scanner(System.in);
        Scanner scannerForStrings = new Scanner(System.in);
        System.out.println("Enter number of faculty to add : ");
        numberOfFacultyToAdd= scannerForInts.nextInt();
        FacultyDetails[] facultyToAdd = new FacultyDetails[numberOfFacultyToAdd];
        //Initializes the student objects by taking the inputs at the runtime
        for (int i = 0; i < numberOfFacultyToAdd; i++) {
            System.out.println("Enter the details of the faculty at position " + i);
            facultyToAdd[i] = new FacultyDetails(scannerForInts.nextInt(), scannerForStrings.nextLine(), scannerForStrings.nextLine());
        }
        totalFacultyPresent = totalFacultyPresent + numberOfFacultyToAdd;
        //copies the objects of faculty to the main array
        addToSystem(facultyToAdd);
    }


    private void addToSystem(FacultyDetails[] arrayToAdd) {
        int index = 0;
        outer:
        for (int i = 0; i < totalFaculty.length; i++) {
            if (totalFaculty[i] == null) {
                break outer;
            }
            index++;
        }
        System.arraycopy(arrayToAdd, 0, totalFaculty, index, arrayToAdd.length);
        //sort the main array after every insert
        sortTotalFaculty();
    }
    public void sortTotalFaculty() {
        //TODO implement a sorting algorithm to sort the faculty
    }


    public void displayAllStudents(){
        for (int i = 0; i < totalFaculty.length; i++) {
            if(totalFaculty[i] == null){
                System.out.println("Slot Empty");
            }else{
                System.out.println(totalFaculty[i]);
            }
        }
    }


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
        }
        else {
            System.out.println("Sir/Madam Thanks for visiting");
        }
    }

}


