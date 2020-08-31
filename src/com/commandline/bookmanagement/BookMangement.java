package com.commandline.bookmanagement;

import com.commandline.studentmangement.StudentDetails;
import org.w3c.dom.ls.LSOutput;

import javax.crypto.spec.PSource;
import java.lang.reflect.Array;
import java.util.*;

public class BookMangement {
    private Book[] totalBooks = new Book[100];

    public void addBooks() {
        Scanner scanner = new Scanner(System.in);
        int numberOfBooksToAdd = scanner.nextInt();
        Book[] booksToAdd = new Book[numberOfBooksToAdd];
        for (int i = 0; i < numberOfBooksToAdd; i++) {
            System.out.println("Enter the details of the books " + 1);
            booksToAdd[i] = new Book(scanner.nextInt(), scanner.nextLine(), scanner.nextLine(), scanner.nextLine(), scanner.nextInt());
        }
        scanner.close();
        addToSystem(booksToAdd);

    }

    public void addToSystem(Book[] arrayToAdd) {
        int index = -1;
        outer:
        for (int i = 0; i < totalBooks.length; i++) {
            if (totalBooks == null) {
                break outer;
            }
            index++;
        }
        System.arraycopy(arrayToAdd, 0, totalBooks, index, arrayToAdd.length);
        //TODO should sorted method also be added?
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

    }

