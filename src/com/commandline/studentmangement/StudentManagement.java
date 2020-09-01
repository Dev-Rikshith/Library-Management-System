package com.commandline.studentmangement;

/**
 * @author Tirumanpuri Rikshith
 * This class basically implements all the student methods
 * and then processes them to add, delete, retrieve, totalstudents and then
 * returns or prints them to the screen
 */

import java.util.*;

import com.commandline.bookmanagement.Book;

public class StudentManagement {

    private StudentDetails[] totalStudents = new StudentDetails[50];
    private int numberOfStudentsToAdd = 0;
    private int totalStudentsPresent = 0;

    public void addStudents() {
        Scanner scannerForInts = new Scanner(System.in);
        Scanner scannerForStrings = new Scanner(System.in);
        System.out.println("Enter number of students to add : ");
        numberOfStudentsToAdd = scannerForInts.nextInt();
        StudentDetails[] studentsToAdd = new StudentDetails[numberOfStudentsToAdd];
        //Initializes the student objects by taking the inputs at the runtime
        for (int i = 0; i < numberOfStudentsToAdd; i++) {
            System.out.println("Enter the details of the student at position " + i);
            studentsToAdd[i] = new StudentDetails(scannerForInts.nextInt(), scannerForStrings.nextLine(), scannerForStrings.nextLine());
        }
        totalStudentsPresent = totalStudentsPresent + numberOfStudentsToAdd;
        //copies the objects of students to the main array
        addToSystem(studentsToAdd);
    }

    private void addToSystem(StudentDetails[] arrayToAdd) {
        int index = 0;
        outer:
        for (int i = 0; i < totalStudents.length; i++) {
            if (totalStudents[i] == null) {
                break outer;
            }
            index++;
        }
        System.arraycopy(arrayToAdd, 0, totalStudents, index, arrayToAdd.length);
        //sort the main array after every insert
        sortTotalStudents();
    }

    public void sortTotalStudents() {
        //TODO implement a sorting algorithm to sort the students
    }

    public void removeStudents() {
        StudentDetails studentDetails1 = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the id of the student to delete");
        int studentToDelete = scanner.nextInt();
        //searches the element and records its index and then breaks out of the loop
        for (int i = 0; i <= totalStudents.length; i++) {
            if (totalStudents[i] == null) {
                continue;
            } else if (studentToDelete == totalStudents[i].id) {
                studentDetails1 = totalStudents[i];
                totalStudents[i] = null;
                break;
            }
        }
        System.out.println(studentDetails1.fullName + " with the id " + studentDetails1.id + " deleted from the system");
    }

    public StudentDetails getStudents() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the id of the student to retrive");
        int studentToRetrive = scanner.nextInt();
        //searches the element and records its index and then breaks out of the loop
        for (int i = 0; i <= totalStudents.length; i++) {
            if (totalStudents[i] == null) {
                continue;
            } else if (studentToRetrive == totalStudents[i].id) {
                return totalStudents[i];
            }
        }
		return null;
    }
    
    public void manageBooks() {
    	StudentDetails studentToManage = getStudents();
    	Scanner scannerForInts = new Scanner(System.in);
    	Scanner scannerForStrings = new Scanner(System.in);
    	if(studentToManage == null) {
    		System.out.println("No Student found");
    	}else {
    		System.out.println("\n1.Request Books\n2.Issue Books");
    		int choice = scannerForInts.nextInt();
    		switch (choice) {
			case 1: {
				Book requestedBook = new Book(scannerForInts.nextInt(), scannerForStrings.nextLine(), scannerForStrings.nextLine(), scannerForStrings.nextLine(), scannerForInts.nextInt());
				studentToManage.requestedBooks.add(requestedBook);
			}
			break;
			case 2: {
				Book issuedBook = new Book(scannerForInts.nextInt(), scannerForStrings.nextLine(), scannerForStrings.nextLine(), scannerForStrings.nextLine(), scannerForInts.nextInt());
				studentToManage.issuedBooks.add(issuedBook);
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + choice);
			}
    	}
    }

    public int totalNumberOfStudents() {
        return totalStudentsPresent;
    }

    public void displayAllStudents() {
        for (int i = 0; i < totalStudents.length; i++) {
            if (totalStudents[i] == null) {
                System.out.println("Slot Empty");
            } else {
                System.out.println(totalStudents[i]);
            }
        }
    }

}
