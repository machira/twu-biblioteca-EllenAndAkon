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
        printStream.println("Welcome to Biblioteca!");
        printStream.println("MAIN MENU");
        displayMenu();
    }

    private void displayMenu() {
        printStream.println("- List Books\n");

        printStream.println("Enter your selection");

    }

    public void listBooks() {
        for (Book book : books)
            printStream.println(book.details());
        printStream.println("");
    }

    public void selectOption(String selection) {
        printStream.println("That's not a valid option");
        if (selection.contains("list books")) {
            listBooks();
        }
    }
}
