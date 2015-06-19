package com.twu.biblioteca;

/**
 * Created by egalperi on 6/16/15.
 */
public class Book implements BorrowableItem {
    private String author;
    private String yearPublished;

    public Book(String name, String author, String yearPublished) {
        this.name = name;
        this.author = author;
        this.yearPublished = yearPublished;
        this.checkedOut = false;
    }


    public String toString() {
        return String.format("%-20s %-20s %-20s\n", name, author, yearPublished);
    }

    boolean checkedOut;
    String name;

    @Override
    public boolean isCheckedOut(){
        return checkedOut;
    }

    @Override
    public boolean checkout(){
        if(!checkedOut){
            checkedOut = true;
            return checkedOut;
        }
        return false;
    }

    public String name() {
        return name;
    }

    @Override
    public boolean checkIn() {
        if (isCheckedOut()) {
            checkedOut = false;
            return true;
        }
        return false;
    }
}
