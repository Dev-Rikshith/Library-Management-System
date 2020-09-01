package com.commandline.facultyMangement;
/**
 * @author Sohan Kotha
 * This class basically implements all the Faculty methods
 * and then processes them to add, delete, retrieve
 * Check the inTime and outTime totalFaculty and then
 * returns or prints them to the screen
 */

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
        numberOfFacultyToAdd = scannerForInts.nextInt();
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

    public void removeFaculty() {
        FacultyDetails facultyDetails1 = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the id of the faculty to delete");
        int facultyToDelete = scanner.nextInt();
        //searches the element and records its index and then breaks out of the loop
        for (int i = 0; i <= totalFaculty.length; i++) {
            if (totalFaculty[i] == null) {
                continue;
            } else if (facultyToDelete == totalFaculty[i].id) {
                facultyDetails1 = totalFaculty[i];
                totalFaculty[i] = null;
                break;
            }
        }
        System.out.println(facultyDetails1.fullName + " with the id " + facultyDetails1.id + " deleted from the system");
    }

    public void sortTotalFaculty() {
        //TODO implement a sorting algorithm to sort the faculty
    }

    public FacultyDetails getFaculty() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the id of the faculty to retrieve");
        int facultyToRetrieve = scanner.nextInt();
        //searches the element and records its index and then breaks out of the loop
        for (int i = 0; i <= totalFaculty.length; i++) {
            if (totalFaculty[i] == null) {
                continue;
            } else if (facultyToRetrieve == totalFaculty[i].id) {
                return totalFaculty[i];
            }
        }
        return null;
    }

    public int totalNumberOfFaculty() {

        return totalFacultyPresent;
    }

        public void displayAllFaculty () {
            for (int i = 0; i < totalFaculty.length; i++) {
                if (totalFaculty[i] == null) {
                    System.out.println("Slot Empty");
                } else {
                    System.out.println(totalFaculty[i]);
                }
            }
        }

        public void checkIn () {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the faculty id to check-in");
            FacultyDetails facultyDetails1 = getFaculty();
            System.out.println("Enter the time when Faculty checkedIn in hours : ");
            int timeHours = scanner.nextInt();
            System.out.println("Enter the time when Faculty checkedIn in minutes :  ");
            int timeMinutes = scanner.nextInt();
            timeHours *= 60;
            int time = timeHours + timeMinutes;
            facultyDetails1.setCheckIn(time);
            scanner.close();
        }

        public void checkOut () {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the faculty id to check-in");
            FacultyDetails facultyDetails1 = getFaculty();
            System.out.println("Enter the time when Faculty checkedOut in hours : ");
            int timeHours = scanner.nextInt();
            System.out.println("Enter the time when Faculty checkedOut in minutes :  ");
            int timeMinutes = scanner.nextInt();
            timeHours *= 60;
            int time = timeHours + timeMinutes;
            facultyDetails1.setCheckOut(time);
            scanner.close();
            completeCheckout(facultyDetails1);
        }

        public int computeTotalTime ( int startTime, int endTime){
            return (endTime - startTime);
        }

        public int computePenalty (FacultyDetails facultyDetails){
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

        public void completeCheckout (FacultyDetails facultyDetails){
            Scanner scanner = new Scanner(System.in);
            int totalPenalty = computePenalty(facultyDetails);
            int dues = facultyDetails.getOutStandingDues();
            dues = dues + totalPenalty;
            facultyDetails.setOutStandingDues(dues);
            System.out.println("Sir/Madam do you want to recommend any books to the students");
            facultyDetails.recommendedBooks.add(new Book(scanner.nextInt(), scanner.nextLine(), scanner.nextLine(), scanner.nextLine(), scanner.nextInt()));
            payDues(dues, facultyDetails);
        }

        public void payDues ( int dues, FacultyDetails facultyDetails){
            Scanner scanner = new Scanner(System.in);
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


    public void runner() {
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        while(flag){
        switch (choice) {
            case 1:
                System.out.println("1.Add a Faculty or a Faculties");
                System.out.println("2.Delete a Faculty");
                System.out.println("3.Get a Faculty");
                System.out.println("4.Display all Faculty");
                System.out.println("5.Check-In faculty");
                System.out.println("6.Check-Out faculty");
                System.out.println("7.Exit");
                System.out.println("Enter your choice");
                int choice2 = scanner.nextInt();
                FacultyManagement facultyManagement = new FacultyManagement();
                switch (choice2) {
                    case 1:
                        addFaculty();
                        break;
                    case 2:
                        removeFaculty();
                        break;
                    case 3:
                        FacultyDetails facultyDetails = facultyManagement.getFaculty();
                        System.out.println(facultyDetails.toString());
                        break;
                    case 4:
                        displayAllFaculty();
                        break;
                    case 5:
                        checkIn();
                        break;
                    case 6:
                        checkOut();
                        break;
                    case 7:
                        flag = false;
                        break;
                    default:
                        System.out.println("Enter correct choice");
                }
        }
        }
    }
}
