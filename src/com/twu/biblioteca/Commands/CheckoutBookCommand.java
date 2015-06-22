package com.twu.biblioteca.Commands;

import com.twu.biblioteca.Biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by machira on Jun/22/15.
 */
public class CheckoutBookCommand {
    private Biblioteca biblioteca;
    private BufferedReader bufferedReader;
    private PrintStream printStream;

    public CheckoutBookCommand(Biblioteca biblioteca, BufferedReader bufferedReader, PrintStream printStream) {
        this.biblioteca = biblioteca;
        this.bufferedReader = bufferedReader;
        this.printStream = printStream;
    }

    public void execute() {
        biblioteca.listBooks();
    }

    public String getUserBookSelection() {
        String userSelection = "";
        try {
            userSelection = bufferedReader.readLine();
        }
        catch (IOException e) {
        }
        return userSelection;
    }

    public void checkoutBook(String title) {
        if(biblioteca.isBookAvailable(title)){
            biblioteca.checkoutBookWithTitle(title);
            printStream.println("Success! Enjoy your book.");
        }else{
            printStream.println("Could not check out that book at this time.");
        }

    }
}
