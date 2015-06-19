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


    public boolean checkout(Book book) {
        if(book.isCheckedOut()){
            return false;
        }
        book.isCheckedOut();
        return true;
    }

    public boolean checkout(String bookTitle){
        for(Book book: books){
            if(book.name().equalsIgnoreCase(bookTitle)){
                return checkout(book);
            }
        }
        return false;
    }

    public boolean returnBook(Book book) {
        return book.checkIn();
    }

    public boolean returnBook(String bookTitle) {
        for (Book book : books) {
            if (book.name().equalsIgnoreCase(bookTitle)) {
                return returnBook(book);
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
}
