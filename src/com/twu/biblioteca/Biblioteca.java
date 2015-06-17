package com.twu.biblioteca;

import java.io.*;
import java.nio.Buffer;
import java.util.List;
import java.util.Scanner;

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

    public void listBooks() {
        for (Book book : books) {
            book.printDetails(printStream);
        }
        printStream.println("");
    }


}
