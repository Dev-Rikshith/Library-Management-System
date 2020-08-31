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

    public void addStudents() {
        Scanner scanner = new Scanner(System.in);
        int numberOfStudentsToAdd = scanner.nextInt();
        StudentDetails[] studentsToAdd = new StudentDetails[numberOfStudentsToAdd];
        //Initializes the student objects by taking the inputs at the runtime
        for (int i = 0; i < numberOfStudentsToAdd; i++) {
            System.out.println("Enter the details of the student at position " + i);
            studentsToAdd[i] = new StudentDetails(scanner.nextInt(), scanner.nextLine(), scanner.nextLine());
        }
        scanner.close();
        //copies the objects of students to the main array
        addToSystem(studentsToAdd);
    }

    public void addToSystem(StudentDetails[] arrayToAdd) {
        int index = -1;
        outer:
        for (int i = 0; i < totalStudents.length; i++) {
            if (totalStudents == null) {
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

    public ArrayList<StudentDetails> removeStudents() {
        int index = -1;
        ArrayList<StudentDetails> removedStudents = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of students to remove");
        int numberOfStudentsToRemove = scanner.nextInt();
        List<StudentDetails> listOfStudents = Arrays.asList(totalStudents.clone());
        //searches the element and records its index and then breaks out of the loop
        for (int i = 0; i <= numberOfStudentsToRemove; i++) {
            System.out.println("Enter the student id to remove");
            int id = scanner.nextInt();
            outer:
            for (StudentDetails studentDetails : listOfStudents) {
                if (id == studentDetails.id) {
                    break outer;
                }
                index++;
            }
            //Adds to the list and returns it
            removedStudents.add(listOfStudents.get(index));
            listOfStudents.remove(index);
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
        return removedStudents;
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
        return totalStudents.length;
    }

}
