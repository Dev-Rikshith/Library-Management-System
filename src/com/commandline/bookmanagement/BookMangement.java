package com.commandline.bookmanagement;

import com.commandline.studentmangement.StudentDetails;
import jdk.internal.util.xml.impl.Pair;
import org.w3c.dom.ls.LSOutput;

import javax.crypto.spec.PSource;
import java.lang.reflect.Array;
import java.util.*;

public class BookMangement {
    private Book[] totalBooks = new Book[100];
    private int numberOfBookToAdd = 0;
    private int totalBookPresent = 0;

    public void addStudents() {
        Scanner scannerForInts = new Scanner(System.in);
        Scanner scannerForStrings = new Scanner(System.in);
        System.out.println("Enter number of Book to add : ");
        numberOfBookToAdd = scannerForInts.nextInt();
        Book[] bookToAdd = new Book[numberOfBookToAdd];
        //Initializes the Book objects by taking the inputs at the runtime
        for (int i = 0; i < numberOfBookToAdd; i++) {
            System.out.println("Enter the details of the book at position " + i);
            bookToAdd[i] = new Book(scannerForInts.nextInt(), scannerForStrings.nextLine(), scannerForStrings.nextLine(),scannerForStrings.nextLine(),scannerForInts.nextInt());
        }
        totalBookPresent = totalBookPresent + numberOfBookToAdd;
        //copies the objects of students to the main array
        addToSystem(bookToAdd);
    }

    public void addToSystem(Book[] arrayToAdd) {
        int index = -1;
        outer:
        for (int i = 0; i < totalBooks.length; i++) {
            if (totalBooks[i] == null) {
                break outer;
            }
            index++;
        }
        System.arraycopy(arrayToAdd, 0, totalBooks, index, arrayToAdd.length);
        //sort the main array after every insert
        sortTotalBook();
    }
    public void sortTotalBook(){
        //TODO implement a sorting algorithm to sort the Book
    }

    public ArrayList<Book> removeBook(){
     int index=-1;
     ArrayList<Book> removedBook = new ArrayList<>();
     Scanner scanner = new Scanner(System.in);
     System.out.print("Enter the number of books to remove");
     int numberOfBooksToremove = scanner.nextInt();
        List<Book> listOfBooks = Arrays.asList(totalBooks.clone());
     for(int i=0;i<=numberOfBooksToremove;i++){
         System.out.println("Enter the book id to remove");
         int id = scanner.nextInt();
         outer:
         for(Book bookdetails :listOfBooks){
             if(id==bookdetails.id){
                 break outer;
             }
             index ++;
         }
         removedBook.add(listOfBooks.get(index));
         listOfBooks.remove(index);
     }
     for(int i=0;i<totalBooks.length;i++){
         ListIterator<Book> listIterator = listOfBooks.listIterator();
         while (listIterator.hasNext()) {
             totalBooks[i] = listIterator.next();
         }
         break;
     }
        scanner.close();
        return removedBook;
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
        return totalBooks.length;
    }

}




