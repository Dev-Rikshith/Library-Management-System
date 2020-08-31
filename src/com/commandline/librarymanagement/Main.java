package com.commandline.librarymanagement;

import com.commandline.studentmangement.StudentDetails;
import com.commandline.studentmangement.StudentManagement;

public class Main {

    public static void main(String[] args) {
        class ComplaintBox{

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
