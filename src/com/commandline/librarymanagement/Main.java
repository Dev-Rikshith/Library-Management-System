package com.commandline.librarymanagement;

//<<<<<<< HEAD
//import com.com fr4rmandline.bookmanagement.Book;
//=======
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
        while(flag){
            System.out.println("1.Book Management\n" + "2.Faculty Management\n" +"3.Student Management\n" +"4.Complaint Box");
            System.out.println("Enter your choice");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.println("1.Add a Book or Books");
                    System.out.println("2.Delete a Book");
                    System.out.println("3.Get a Book");
                    System.out.println("4. Display all Books");
                    System.out.println("Enter your choice");
                    int choice1 = scanner.nextInt();
                    BookManagement bookManagement = new BookManagement();
                    switch (choice1){
                        case 1: bookManagement.addBooks();
                            break;
                        case 2: bookManagement.removeBook();
                            break;
                        case 3:bookManagement.getBook();
                            break;
                        case 4:bookManagement.displayAllBooks();
                            break;
                        default:
                            System.out.println("Enter correct choice");
                    }

            }

        }




    }
}
class ComplaintBox {
   public void bookDamage(){
       BookManagement bookManagement = new BookManagement();
       bookManagement.searchBook();
       bookManagement.removeBook();
       System.out.println("Thanks for reporting your issue has been sorted");
       System.out.println("Please visit again :)");

   }
   public void infrastructure(){
       System.out.println("Thanks for providing your info we will surely improve our infrastructure ");
       System.out.println("Please visit again :)");
   }
   public void others(){
       Scanner scanner = new Scanner(System.in);
       System.out.println("You can write down your complaint below");
       String complaint = scanner.nextLine().toLowerCase();
       System.out.println("Thanks for reporting your issue it will be sorted");
       System.out.println("Please visit again :)");
   }

    public void studentFacultyComplaint(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("If you have any complaints please press Y/N");
        String response = scanner.nextLine().toLowerCase();
        if(response == "y"){
            System.out.println("Please choose the complains from below options");
            System.out.println("0.Book Damage");
            System.out.println("1.Infrastructure of Library");
            System.out.println("2.Others");
            int response1 = scanner.nextInt();
            switch (response1){
                case 0: bookDamage();
                        break;
                case 1: infrastructure();
                        break;
                case 2: others();
                        break;
                default:
                    System.out.println("Wrong Option");
            }
        }
        else if(response == "n"){
            System.out.println("Thanks for visiting :)");
        }
        else{
            System.out.println("Please enter Y/N");
        }
    }
}
