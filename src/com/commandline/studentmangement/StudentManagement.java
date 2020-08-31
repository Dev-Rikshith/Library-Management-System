package com.commandline.studentmangement;

/**
 * @author Tirumanpuri Rikshith
 * This class basically implements all the student methods
 * and then processes them to add, delete, retrieve, totalstudents and then
 * returns or prints them to the screen
 */

import java.util.*;

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

    public StudentDetails removeStudents() {
        StudentDetails studentDetails1 = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the student to delete");
        String studentToDelete = scanner.nextLine();
        //searches the element and records its index and then breaks out of the loop
        for (int i = 0; i <= totalStudents.length; i++) {
            outer:
            if (studentToDelete.equals(totalStudents[i].fullName)) {
                studentDetails1 = totalStudents[i];
                totalStudents[i] = null;
            }
        }
        return studentDetails1;
    }

    public StudentDetails getstudents() {
        int index = -1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the student id to remove");
        int idToSearch = scanner.nextInt();
        List<StudentDetails> listOfStudents = Arrays.asList(totalStudents.clone());
        outer:
        for (StudentDetails studentDetails : listOfStudents) {
            if (idToSearch == studentDetails.id) {
                break outer;
            }
            index++;
        }
        //converts the list to array and then assigns it to the main array
        for (int i = 0; i < totalStudents.length; i++) {
            ListIterator<StudentDetails> listIterator = listOfStudents.listIterator();
            while (listIterator.hasNext()) {
                totalStudents[i] = listIterator.next();
            }

            break;
        }
        scanner.close();
        return listOfStudents.get(index);
    }

    public int totalNumberOfStudents() {
        return totalStudentsPresent;
    }

    public void displayAllStudents(){
        for (int i = 0; i < totalStudents.length; i++) {
            if(totalStudents[i] == null){
                System.out.println("Slot Empty");
            }else{
                System.out.println(totalStudents[i]);
            }
        }
    }

}
