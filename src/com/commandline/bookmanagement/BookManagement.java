package com.commandline.bookmanagement;
/**
 * @author Anisha Shendkar
 * This class basically implements all the book methods
 * and then processes them to add, delete, retrieve, totalbooks and then
 * returns or prints them to the screen
 */

//import jdk.internal.util.xml.impl.Pair;

import com.commandline.studentmangement.StudentDetails;

import java.util.*;

public class BookManagement {
    private Book[] totalBooks = new Book[100];
    private int numberOfBookToAdd = 0;
    private int totalBookPresent = 0;
    private int id;


    public void addBooks() {
        Scanner scannerForInts = new Scanner(System.in);
        Scanner scannerForStrings = new Scanner(System.in);
        System.out.println("Enter number of Book to add : ");
        numberOfBookToAdd = scannerForInts.nextInt();
        Book[] bookToAdd = new Book[numberOfBookToAdd];
        //Initializes the Book objects by taking the inputs at the runtime
        for (int i = 0; i < numberOfBookToAdd; i++) {
            System.out.println("Enter the details of the book at position " + i);
            bookToAdd[i] = new Book(scannerForInts.nextInt(), scannerForStrings.nextLine(), scannerForStrings.nextLine(), scannerForStrings.nextLine(), scannerForInts.nextInt());
        }
        totalBookPresent = totalBookPresent + numberOfBookToAdd;
        //copies the objects of students to the main array
        addToSystem(bookToAdd);
    }

    private void addToSystem(Book[] arrayToAdd) {
        int index = 0;
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

    public void sortTotalBook() {
        //TODO implement a sorting algorithm to sort the Book
    }

    public void removeBook() {
        Book book1 = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the id of the book to delete");
        int studentToDelete = scanner.nextInt();
        //searches the element and records its index and then breaks out of the loop
        for (int i = 0; i <= totalBooks.length; i++) {
            if (totalBooks[i] == null) {
                continue;
            } else if (studentToDelete == totalBooks[i].id) {
                book1 = totalBooks[i];
                totalBooks[i] = null;
                break;
            }
        }
        System.out.println(book1.name + " with the id " + book1.id + " deleted from the system");
    }


    public Book getBook() {
        int index = -1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Book id to remove");
        int idToSearch = scanner.nextInt();
        //converts the list to array and then assigns it to the main array
        for (int i = 0; i < totalBooks.length; i++) {
            if(totalBooks[i]==null){
                continue;
            }
            else if(idToSearch==totalBooks[i].id){
                return totalBooks[i];
            }
            }
        return null;
        }


    public int totalNumberOfBooks() {
        return totalBooks.length;
    }

        public void displayAllBooks(){
            for (int i = 0; i < totalBooks.length; i++) {
                if(totalBooks[i] == null){
                    System.out.println("Book Slot  is Empty");
                }else{
                    System.out.println(totalBooks[i]);

            }
        }
    }

}




