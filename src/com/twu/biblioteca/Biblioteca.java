package com.twu.biblioteca;

import java.io.*;
import java.util.List;

/**
 * Created by egalperi on 6/16/15.
 */
public class Biblioteca {

    private PrintStream printStream;
    private List<Book> books;
    private List<Movie> movies;

    public Biblioteca(PrintStream printStream, List<Book> books, List<Movie> movies) {
        this.printStream = printStream;
        this.books = books;
        this.movies = movies;
    }

    public void listBooks() {
        for (Book book : books) {
            if (!book.isCheckedOut()) {
                printStream.println(book.toString());
            }
        }
        printStream.println("");
    }


    public boolean checkoutBorrowableItem(BorrowableItem borrowableItem) {
        if(borrowableItem.isCheckedOut()){
            return false;
        }
        borrowableItem.isCheckedOut();
        return true;
    }

    public void checkoutBookWithTitle(String bookTitle){
        for(Book book: books){
            if(book.name().equalsIgnoreCase(bookTitle)){
                checkoutBorrowableItem(book);
            }
        }
    }

    public boolean returnBorrowableItem(BorrowableItem borrowableItem) {
        return borrowableItem.checkIn();
    }

    public boolean returnBookWithTitle(String bookTitle) {
        for (Book book : books) {
            if (book.name().equalsIgnoreCase(bookTitle)) {
                return returnBorrowableItem(book);
            }
        }
        return false;
    }


    public void listMovies() {
        for (Movie movie: movies) {
            if (!movie.isCheckedOut()) {
                printStream.println(movie.toString());
            }
        }
        printStream.println("");
    }

    public boolean isBookAvailable(String bookTitle) {
        for(Book book: books){
            if(book.name().equalsIgnoreCase(bookTitle)){
                return book.isCheckedOut();
            }
        }
        return false;
    }
}
