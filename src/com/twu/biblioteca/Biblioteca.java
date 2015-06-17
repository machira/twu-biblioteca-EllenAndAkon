package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.List;

/**
 * Created by egalperi on 6/16/15.
 */
public class Biblioteca {

    private PrintStream printStream;
    private List<Book> books;

    public Biblioteca(PrintStream printStream, List<Book> books) {
        this.printStream = printStream;
        this.books = books;
    }

    public void start() {
        printStream.println("Welcome to Biblioteca! Here is a list of all library books:");
        printStream.println("");
        listBooks();
    }

    public void listBooks() {
        for (Book book : books)
            printStream.println(book.details());
        printStream.println("");
    }
}
