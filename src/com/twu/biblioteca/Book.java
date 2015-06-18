package com.twu.biblioteca;

import java.io.PrintStream;

/**
 * Created by egalperi on 6/16/15.
 */
public class Book {
    private String title;
    private String author;
    private String yearPublished;
    private boolean checkedOut;

    public Book(String title, String author, String yearPublished) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        checkedOut = false;
    }

    public String title() {
        return title;
    }

    public void printDetails(PrintStream printStream) {
        printStream.format("%20s %20s %20s\n", title, author, yearPublished);
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void checkOut() {
        checkedOut = true;
    }
}
