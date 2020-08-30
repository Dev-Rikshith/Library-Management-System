package com.commandline.studentmangement;

import java.util.*;

public class StudentManagement {

    private StudentDetails[] totalStudents = new StudentDetails[50];

    public void addStudents() {
        Scanner scanner = new Scanner(System.in);
        int numberOfStudentsToAdd = scanner.nextInt();
        StudentDetails[] studentsToAdd = new StudentDetails[numberOfStudentsToAdd];
        for (int i = 0; i < numberOfStudentsToAdd; i++) {
            System.out.println("Enter the details of the student at position " + i);
            studentsToAdd[i] = new StudentDetails(scanner.nextInt(), scanner.nextLine(), scanner.nextLine());
        }
        scanner.close();
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
        sortTotalStudents();
    }

    public void sortTotalStudents() {
        //TODO implement a sorting algorithm to sort the students
    }

    public ArrayList<StudentDetails> removeStudents() {
        int index = -1;
        ArrayList<StudentDetails> removedStudents = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int numberOfStudentsToRemove = scanner.nextInt();
        List<StudentDetails> listOfStudents = Arrays.asList(totalStudents.clone());
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
            removedStudents.add(listOfStudents.get(index));
            listOfStudents.remove(index);
        }
        for (int i = 0; i < totalStudents.length; i++) {
            ListIterator<StudentDetails> listIterator = listOfStudents.listIterator();
            while (listIterator.hasNext()) {
                totalStudents[i] = listIterator.next();
            }
            break;
        }
        return removedStudents;
    }


    public int totalNumberOfStudents() {
        return totalStudents.length;
    }

}
