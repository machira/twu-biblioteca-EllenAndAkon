package com.twu.biblioteca;

import java.io.PrintStream;

/**
 * Created by egalperi on 6/16/15.
 */
public class Book {
    private String name;
    private String author;
    private String yearPublished;

    public Book(String name, String author, String yearPublished) {
        this.name = name;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    public String getTitle() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getYearPublished() {
        return yearPublished;
    }

    public void printDetails(PrintStream printStream) {
        printStream.format("%20s %20s %20s\n", name, author, yearPublished);
    }
}
