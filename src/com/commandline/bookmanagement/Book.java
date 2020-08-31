package com.commandline.bookmanagement;

public class Book {
    public int id;
    public String name;
    public String authorName;
    public String review;
    public int bookCount;

    public Book(int id, String name, String authorName, String review, int bookCount) {
        this.id = id;
        this.name = name;
        this.authorName = authorName;
        this.review = review;
        this.bookCount = bookCount;
    }



        public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public int getBookCount() {
        return bookCount;
    }

    public void setBookCount(int bookCount) {
        this.bookCount = bookCount;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", authorName='" + authorName + '\'' +
                ", review='" + review + '\'' +
                ", bookCount=" + bookCount +
                '}';
    }
    public void bookDetails(Book bookDetails){
        bookDetails.toString();
    }

}
