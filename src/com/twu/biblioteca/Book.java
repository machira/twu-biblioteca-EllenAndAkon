package com.twu.biblioteca;

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

    public String details() {
        return name + " - " + author + " - " + yearPublished;
    }
}
