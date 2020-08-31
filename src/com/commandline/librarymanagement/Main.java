package com.commandline.librarymanagement;

import com.commandline.bookmanagement.Book;
import com.commandline.studentmangement.StudentDetails;
import com.commandline.studentmangement.StudentManagement;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        class ComplaintBox{
            protected ArrayList<Book> recommendedBooks;
            protected String studentComplaints;
            Pr

        }

        StudentManagement studentManagement = new StudentManagement();
        studentManagement.addStudents();
//        StudentDetails studentDetails = studentManagement.removeStudents();
//        System.out.println(studentDetails);
//       studentManagement.displayAllStudents();
        System.out.println(studentManagement.totalNumberOfStudents());
//
//        studentManagement.addStudents();
//        studentManagement.displayAllStudents();
//        studentManagement.getstudents();
    }
}
