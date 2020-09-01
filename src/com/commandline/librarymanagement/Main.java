package com.commandline.librarymanagement;

<<<<<<< HEAD
import com.commandline.bookmanagement.Book;
=======
import com.commandline.facultyMangement.FacultyDetails;
import com.commandline.facultyMangement.FacultyManagement;
>>>>>>> 5ea20f9bc4acf9a8fbd71ecd6b99cd7f39c51311
import com.commandline.studentmangement.StudentDetails;
import com.commandline.studentmangement.StudentManagement;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        class ComplaintBox{
            protected ArrayList<Book> recommendedBooks;
            protected String studentComplaints;
            Pr

<<<<<<< HEAD
        FacultyManagement facultyManagement = new FacultyManagement();
//        facultyManagement.addFaculty();
//        facultyManagement.displayAllStudents();
//        facultyManagement.addFaculty();
//        facultyManagement.displayAllStudents();
        FacultyDetails employee = new FacultyDetails(123,"john","wick");
        facultyManagement.checkIn(employee);
        facultyManagement.checkIn(employee);


//
//        StudentManagement studentManagement = new StudentManagement();
//        studentManagement.addStudents();
////        StudentDetails studentDetails = studentManagement.removeStudents();
////        System.out.println(studentDetails);
////       studentManagement.displayAllStudents();
//        System.out.println(studentManagement.totalNumberOfStudents());
////
////        studentManagement.addStudents();
////        studentManagement.displayAllStudents();
////        studentManagement.getstudents();
=======
        }

//        StudentManagement studentManagement = new StudentManagement();
//        studentManagement.addStudents();
//        studentManagement.removeStudents();
//        studentManagement.displayAllStudents();
//        studentManagement.getstudents();

        StudentDetails studentDetails = new StudentDetails(1,"sohan", "cse");
  //      studentDetails.getReport(studentDetails);
>>>>>>> 1f08cd8f2da6c20b37baeba6f8cce9adef420e8d
    }
}
