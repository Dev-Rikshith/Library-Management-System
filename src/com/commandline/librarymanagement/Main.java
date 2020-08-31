package com.commandline.librarymanagement;

import com.commandline.facultyMangement.FacultyDetails;
import com.commandline.facultyMangement.FacultyManagement;
import com.commandline.studentmangement.StudentDetails;
import com.commandline.studentmangement.StudentManagement;

public class Main {

    public static void main(String[] args) {

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
    }
}
