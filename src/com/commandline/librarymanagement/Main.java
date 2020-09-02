package com.commandline.librarymanagement;


import com.commandline.bookmanagement.Book;
import com.commandline.bookmanagement.BookManagement;
import com.commandline.facultyMangement.FacultyDetails;
import com.commandline.facultyMangement.FacultyManagement;
//>>>>>>> 5ea20f9bc4acf9a8fbd71ecd6b99cd7f39c51311
import com.commandline.studentmangement.StudentDetails;
import com.commandline.studentmangement.StudentManagement;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static boolean flag = true;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (flag) {
            System.out.println("1.Book Management\n" + "2.Faculty Management\n" + "3.Student Management\n" + "4.Complaint Box\n" + "5.Exit");
            System.out.println("Enter your choice");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("1.Add a Book or Books");
                    System.out.println("2.Delete a Book");
                    System.out.println("3.Get a Book");
                    System.out.println("4.Display all Books");
                    System.out.println("Enter your choice");
                    int choice1 = scanner.nextInt();
                    BookManagement bookManagement = new BookManagement();
                    switch (choice1) {
                        case 1:
                            bookManagement.addBooks();
                            break;
                        case 2:
                            bookManagement.removeBook();
                            break;
                        case 3:
                            Book book1 = bookManagement.getBook();
                            System.out.println(book1.toString());
                        case 4:
                            bookManagement.displayAllBooks();
                            break;
                        default:
                            System.out.println("Enter correct choice");
                            break;
                    }
                case 2:
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
                            facultyManagement.addFaculty();
                            break;
                        case 2:
                            facultyManagement.removeFaculty();
                            break;
                        case 3:
                            FacultyDetails facultyDetails = facultyManagement.getFaculty();
                            System.out.println(facultyDetails.toString());

                            break;
                        case 4:
                            facultyManagement.displayAllFaculty();
                            break;
                        case 5:
                            facultyManagement.checkIn();
                            break;
                        case 6:
                            facultyManagement.checkOut();
                            break;
                        case 7:
                            flag = false;
                            break;
                        default:
                            System.out.println("Enter correct choice");
                    }
                case 3:
                    System.out.println("1.Add a Student or Students");
                    System.out.println("2.Delete a Student");
                    System.out.println("3.Get a Student");
                    System.out.println("4. Display all Students");
                    System.out.println("5.Manage Student Books");
                    System.out.println("6.Get Student Details");
                    System.out.println("7.Exit");
                    System.out.println("Enter your choice");
                    int choice3 = scanner.nextInt();
                    StudentManagement studentManagement = new StudentManagement();
                    switch (choice3) {
                        case 1:
                            studentManagement.addStudents();
                            break;
                        case 2:
                            studentManagement.removeStudents();
                            break;
                        case 3:
                            StudentDetails studentDetails = studentManagement.getStudents();
                            System.out.println(studentDetails.toString());
                            break;
                        case 4:
                            studentManagement.displayAllStudents();
                            break;
                        case 5:
                            studentManagement.manageBooks();
                        case 6:
                            StudentDetails studentDetails1 = studentManagement.getStudents();
                            studentDetails1.getDetails(studentDetails1);
                        case 7:
                            flag = false;
                            break;
                        default:
                            System.out.println("Enter correct choice");
                    }
                case 4:
                    System.out.println("1.Register a Complaint");
                    System.out.println("2.Exit");
                    int choice4 = scanner.nextInt();
                    ComplaintBox complaintBox = new ComplaintBox();
                    switch (choice4) {
                        case 1:
                            complaintBox.studentFacultyComplaint();
                            break;
                        case 2:
                            flag = false;
                            break;
                        default:
                            System.out.println("Enter correct choice");
                    }
                case 5:
                    flag = false;
                    break;
                default:
                    throw new IllegalArgumentException("Enter the correct choice");
            }
        }
    }
}

class ComplaintBox {
    public void bookDamage() {
        BookManagement bookManagement = new BookManagement();
        bookManagement.getBook();
        bookManagement.removeBook();
        System.out.println("Thanks for reporting your issue has been sorted");
        System.out.println("Please visit again :)");

    }

    public void infrastructure() {
        System.out.println("Thanks for providing your info we will surely improve our infrastructure ");
        System.out.println("Please visit again :)");

    }

    public void others() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You can write down your complaint below");
        String complaint = scanner.nextLine().toLowerCase();
        System.out.println("Thanks for reporting your issue it will be sorted");
        System.out.println("Please visit again :)");
    }

    public void studentFacultyComplaint() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("If you have any complaints please press Y/N");
        String response = scanner.nextLine().toLowerCase();
        if (response == "y") {
            System.out.println("Please choose the complains from below options");
            System.out.println("1.Book Damage");
            System.out.println("2.Infrastructure of Library");
            System.out.println("3.Others");
            int response1 = scanner.nextInt();
            switch (response1) {
                case 1:
                    bookDamage();
                    break;
                case 2:
                    infrastructure();
                    break;
                case 3:
                    others();
                    break;
                default:
                    System.out.println("Wrong Option");
            }
        } else if (response == "n") {
            System.out.println("Thanks for visiting :)");
        } else {
            System.out.println("Please enter Y/N");
        }
    }
}
