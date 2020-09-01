package com.commandline.bookmanagement;
/**
 * @author Anisha Shendkar
 * This class basically implements all the book methods
 * and then processes them to add, delete, retrieve, totalbooks and then
 * returns or prints them to the screen
 */

//import jdk.internal.util.xml.impl.Pair;

import java.util.*;

public class BookManagement {
    private Book[] totalBooks = new Book[100];
    private int numberOfBookToAdd = 0;
    private int totalBookPresent = 0;
    private int id;

    public void initArray() {
        for (int i = 0; i < totalBooks.length; i++) {
            totalBooks[i] = new Book(0, "", "", "", 0);
        }
    }

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


    public Book searchBook() {
        Book[] arrayToSort = totalBooks.clone();
        for (int i = 0; i < arrayToSort.length; i++) {
            System.out.println(arrayToSort[i]);
        }
        Scanner scanner = new Scanner(System.in);
        int low = 0, high = arrayToSort.length - 1, mid = (low + high) / 2;
        System.out.println("Enter id to search");
        id = scanner.nextInt();
        while (low <= high) {
            if (id == arrayToSort[mid].id) {
                return arrayToSort[mid];
            } else if (id < arrayToSort[mid].id) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
            mid = (low + high) / 2;
        }

        return null;
    }

    public ArrayList<Book> removeBook() {
        int index = -1;
        ArrayList<Book> removedBook = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of books to remove");
        int numberOfBooksToRemove = scanner.nextInt();
        List<Book> listOfBooks = Arrays.asList(totalBooks.clone());
        for (int i = 0; i <= numberOfBooksToRemove; i++) {
            System.out.println("Enter the book id to remove");
            int id = scanner.nextInt();
            outer:
            for (Book bookDetails : listOfBooks) {
                if (id == bookDetails.id) {
                    break outer;
                }
                index++;
            }
            removedBook.add(listOfBooks.get(index));
            listOfBooks.remove(index);
        }
        for (int i = 0; i < totalBooks.length; i++) {
            ListIterator<Book> listIterator = listOfBooks.listIterator();
            while (listIterator.hasNext()) {
                totalBooks[i] = listIterator.next();
            }
            break;
        }
        scanner.close();
        return removedBook;
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
<<<<<<< HEAD
        public void displayAllBooks(){
            for (int i = 0; i < totalBooks.length; i++) {
                if(totalBooks[i] == null){
                    System.out.println("Book Slot  is Empty");
                }else{
                    System.out.println(totalBooks[i]);
                }
=======

    public void displayAllBooks() {
        for (int i = 0; i < totalBooks.length; i++) {
            if (totalBooks[i] == null) {
                System.out.println("Slot Empty");
            } else {
                System.out.println(totalBooks[i]);
>>>>>>> 13c98e1d9c29f3beb48aa3c1f23543d96b278c37
            }
        }
    }

}




