package com.commandline.bookmanagement;

import org.w3c.dom.ls.LSOutput;

import javax.crypto.spec.PSource;
import java.util.Scanner;

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
}
